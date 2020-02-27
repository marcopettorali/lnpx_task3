package lnpx.provaneo4j;

import java.util.*;
import org.neo4j.driver.v1.*;

public class Neo4JTest {

    private static Driver driver;

    private static void connectToDB(String uri, String user, String password) {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    private static void closeDB() {
        driver.close();
    }

    private static void clearDB() {
        try (Session session = driver.session()) {
            session.writeTransaction((Transaction tx) -> {
                String query = "MATCH (n) DETACH DELETE n";
                tx.run(query);
                return 1;
            });
        }
    }

    private static void createPerson(String name, int age, String country) {
        try (Session session = driver.session()) {
            session.writeTransaction((Transaction tx) -> {
                String query = "CREATE (a:Person {name: $name, age: $age, from: $country})";
                Map<String, Object> params = new HashMap<>();
                params.put("name", name);
                params.put("age", age);
                params.put("country", country);
                tx.run(query, params);
                return 1;
            });
        }
    }

    private static void createRelationship(String user1, String user2) {
        try (Session session = driver.session()) {
            session.writeTransaction((Transaction tx) -> {
                String query = ""
                        + "MATCH (u1:Person) WHERE u1.name = $user1 "
                        + "MATCH (u2:Person) WHERE u2.name = $user2 "
                        + "CREATE (u1)-[:KNOWS]->(u2)";
                Map<String, Object> params = new HashMap<>();
                params.put("user1", user1);
                params.put("user2", user2);
                tx.run(query, params);
                return 1;
            });
        }
    }

    private static List<String> retrieveFriends(String user) {
        try (Session session = driver.session()) {
            List<String> ret = new ArrayList<>();
            session.readTransaction((Transaction tx) -> {
                String query = ""
                        + "MATCH (u1:Person)-[:KNOWS]->(u2:Person) "
                        + "MATCH (u2:Person)-[:KNOWS]->(u1:Person) "
                        + "WHERE u1.name = $name "
                        + "RETURN DISTINCT u2.name";
                Map<String, Object> params = new HashMap<>();
                params.put("name", user);
                StatementResult sr = tx.run(query, params);

                while (sr.hasNext()) {
                    ret.add(sr.next().get(0).asString());
                }
                return 1;
            });
            return ret;
        }
    }

    private static List<String> recommendFriends(String user) {
        try (Session session = driver.session()) {
            List<String> ret = new ArrayList<>();
            session.readTransaction((Transaction tx) -> {
                String query = ""
                        + "MATCH (u1:Person)-[:KNOWS]->(u2:Person)-[:KNOWS]->(u3:Person) "
                        + "MATCH (u3:Person)-[:KNOWS]->(u2:Person)-[:KNOWS]->(u1:Person) "
                        + "WHERE u1.name = $name "
                        + "AND NOT (u1 = u3) "
                        + "RETURN DISTINCT u3.name";
                Map<String, Object> params = new HashMap<>();
                params.put("name", user);
                StatementResult sr = tx.run(query, params);

                while (sr.hasNext()) {
                    ret.add(sr.next().get(0).asString());
                }
                return 1;
            });
            return ret;
        }
    }

    public static void main(String[] args) {
        connectToDB("bolt://localhost:7687", "Prova", "");

        clearDB();

        createPerson("Marco", 22, "Italy");
        createPerson("Harry", 26, "England");
        createPerson("Antoine", 28, "France");
        createPerson("Timo", 23, "Germany");
        createPerson("Ciro", 29, "Italy");
        createPerson("Sergio", 33, "Spain");
        createPerson("Memphis", 26, "Netherlands");

        createRelationship("Marco", "Geeno");
        createRelationship("Marco", "Timo");
        createRelationship("Geeno", "Marco");
        createRelationship("Timo", "Marco");
        createRelationship("Marco", "Charles");
        createRelationship("Sergio", "Geeno");
        createRelationship("Sergio", "Marco");
        createRelationship("John", "Timo");
        createRelationship("Memphis", "Sergio");
        createRelationship("John", "Marco");
        createRelationship("Timo", "Memphis");
        createRelationship("Memphis", "Geeno");

        System.out.println("Marco's friends are " + retrieveFriends("Marco"));
        System.out.println("Recommended friends for Timo are " + recommendFriends("Timo"));

        closeDB();
    }
}
