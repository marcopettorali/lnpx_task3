package lnpx;

import java.text.SimpleDateFormat;
import java.util.*;
import org.neo4j.driver.v1.*;

public class Neo4JManager {

    private static Driver driver;

    private static void connectToDB(String uri, String user, String password) {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    private static void closeDB() {
        driver.close();
    }

    private static void insertApplication(Application application) {
        try (Session session = driver.session()) {
            session.writeTransaction((Transaction tx) -> {
                String query = ""
                        + "MATCH (u:User) WHERE u.username = $user "
                        + "MATCH (w:WorkingGroup) WHERE w.id = $id "
                        + "CREATE (u)-[:APPLYED_FOR{since: $timestamp}]->(w)";
                Map<String, Object> params = new HashMap<>();
                params.put("user", application.getUsername());
                params.put("id", application.getWorkingGroupID());
                params.put("timestamp", application.getTimestamp());
                tx.run(query, params);
                return 1;
            });
        }
    }

    private static List<WorkingGroup> loadWorkingGroups(String user) {
        try (Session session = driver.session()) {
            List<WorkingGroup> ret = new ArrayList<>();
            session.readTransaction((Transaction tx) -> {
                String query = ""
                        + "MATCH (u:User)-[:WORKS_IN]->(w:WorkingGroup) "
                        + "WHERE u.username = $name "
                        + "RETURN w.id, w.description, w.startDate, w.deadlineDate, w.usersRequired, w.completed";
                Map<String, Object> params = new HashMap<>();
                params.put("name", user);
                StatementResult sr = tx.run(query, params);

                while (sr.hasNext()) {
                    try {
                        ret.add(new WorkingGroup(
                                sr.next().get(0).asInt(),
                                sr.next().get(1).asString(),
                                new SimpleDateFormat().parse(sr.next().get(2).asString()),
                                new SimpleDateFormat().parse(sr.next().get(3).asString()),
                                sr.next().get(4).asInt(),
                                sr.next().get(5).asBoolean()
                        ));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                return 1;
            });
            return ret;
        }
    }

    private static List<User> loadUsersInWorkingGroup(int workingGroupID) {
        try (Session session = driver.session()) {
            List<User> ret = new ArrayList<>();
            session.readTransaction((Transaction tx) -> {
                String query = ""
                        + "MATCH (u:User)-[:WORKS_IN]->(w:WorkingGroup) "
                        + "WHERE w.id = $id "
                        + "RETURN u.username, u.password, u.adminLvl, u.firstName, u.lastName, u.matriculationName, u.email";
                Map<String, Object> params = new HashMap<>();
                params.put("id", workingGroupID);
                StatementResult sr = tx.run(query, params);

                while (sr.hasNext()) {
                    try {
                        ret.add(new User(
                                sr.next().get(0).asString(),
                                sr.next().get(1).asString(),
                                sr.next().get(2).asInt(),
                                sr.next().get(3).asString(),
                                sr.next().get(4).asString(),
                                sr.next().get(5).asInt(),
                                sr.next().get(6).asString()
                        ));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                return 1;
            });
            return ret;
        }
    }

    private static List<User> loadWorkingGroupLeader(int workingGroupID) {
        try (Session session = driver.session()) {
            List<User> ret = new ArrayList<>();
            session.readTransaction((Transaction tx) -> {
                String query = ""
                        + "MATCH (u:User)-[:LEADER_OF]->(w:WorkingGroup) "
                        + "WHERE w.id = $id "
                        + "RETURN u.username, u.password, u.adminLvl, u.firstName, u.lastName, u.matriculationName, u.email";
                Map<String, Object> params = new HashMap<>();
                params.put("id", workingGroupID);
                StatementResult sr = tx.run(query, params);

                while (sr.hasNext()) {
                    try {
                        ret.add(new User(
                                sr.next().get(0).asString(),
                                sr.next().get(1).asString(),
                                sr.next().get(2).asInt(),
                                sr.next().get(3).asString(),
                                sr.next().get(4).asString(),
                                sr.next().get(5).asInt(),
                                sr.next().get(6).asString()
                        ));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                return 1;
            });
            return ret;
        }
    }

    private static List<WorkingGroup> loadLeadedWorkingGroups(String user) {
        try (Session session = driver.session()) {
            List<WorkingGroup> ret = new ArrayList<>();
            session.readTransaction((Transaction tx) -> {
                String query = ""
                        + "MATCH (u:User)-[:LEADER_OF]->(w:WorkingGroup) "
                        + "WHERE u.username = $name "
                        + "RETURN w.id, w.description, w.startDate, w.deadlineDate, w.usersRequired, w.completed";
                Map<String, Object> params = new HashMap<>();
                params.put("name", user);
                StatementResult sr = tx.run(query, params);

                while (sr.hasNext()) {
                    try {
                        ret.add(new WorkingGroup(
                                sr.next().get(0).asInt(),
                                sr.next().get(1).asString(),
                                new SimpleDateFormat().parse(sr.next().get(2).asString()),
                                new SimpleDateFormat().parse(sr.next().get(3).asString()),
                                sr.next().get(4).asInt(),
                                sr.next().get(5).asBoolean()
                        ));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                return 1;
            });
            return ret;
        }
    }
    
    private static List<Application> loadApplications(int workingGroupID) {
        try (Session session = driver.session()) {
            List<Application> ret = new ArrayList<>();
            session.readTransaction((Transaction tx) -> {
                String query = ""
                        + "MATCH (u:User)-[a:APPLYED_FOR]->(w:WorkingGroup) "
                        + "WHERE w.id = $id "
                        + "RETURN u.username, a.timestamp";
                Map<String, Object> params = new HashMap<>();
                params.put("id", workingGroupID);
                StatementResult sr = tx.run(query, params);

                while (sr.hasNext()) {
                    try {
                        ret.add(new Application(
                                sr.next().get(0).asString(),
                                new SimpleDateFormat().parse(sr.next().get(1).asString()),
                                workingGroupID     
                        ));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                return 1;
            });
            return ret;
        }
    }
}
