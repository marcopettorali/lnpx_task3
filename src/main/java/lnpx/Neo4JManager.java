package lnpx;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.neo4j.driver.v1.*;

public class Neo4JManager {

    private static Driver driver;

    public static void connectToDB(String uri, String user, String password) {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    public static void closeDB() {
        driver.close();
    }

    public static void insertApplication(Application application) {
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

    public static List<WorkingGroup> loadWorkingGroupsForUser(String user) {
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
                    Record next = sr.next();
                    try {
                        ret.add(new WorkingGroup(
                                next.get(0).asInt(),
                                next.get(1).asString(),
                                new SimpleDateFormat().parse(next.get(2).asString()),
                                new SimpleDateFormat().parse(next.get(3).asString()),
                                next.get(4).asInt(),
                                next.get(5).asBoolean()
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

    public static List<User> loadUsersInWorkingGroup(int workingGroupID) {
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
                    Record next = sr.next();
                    try {
                        ret.add(new User(
                                next.get(0).asString(),
                                next.get(1).asString(),
                                next.get(2).asInt(),
                                next.get(3).asString(),
                                next.get(4).asString(),
                                next.get(5).asInt(),
                                next.get(6).asString()
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

    public static List<User> loadWorkingGroupLeader(int workingGroupID) {
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
                    Record next = sr.next();
                    try {
                        ret.add(new User(
                                next.get(0).asString(),
                                next.get(1).asString(),
                                next.get(2).asInt(),
                                next.get(3).asString(),
                                next.get(4).asString(),
                                next.get(5).asInt(),
                                next.get(6).asString()
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

    public static List<WorkingGroup> loadLeadedWorkingGroups(String user) {
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
                    Record next = sr.next();
                    try {
                        ret.add(new WorkingGroup(
                                next.get(0).asInt(),
                                next.get(1).asString(),
                                new SimpleDateFormat().parse(next.get(2).asString()),
                                new SimpleDateFormat().parse(next.get(3).asString()),
                                next.get(4).asInt(),
                                next.get(5).asBoolean()
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

    public static List<Application> loadApplications(int workingGroupID) {
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
                    Record next = sr.next();
                    try {
                        ret.add(new Application(
                                next.get(0).asString(),
                                new SimpleDateFormat().parse(next.get(1).asString()),
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

    public static boolean acceptApplication(Application application) {
        try (Session session = driver.session()) {
            List<Boolean> ret = new ArrayList<>();
            session.writeTransaction((Transaction tx) -> {

                String query = ""
                        + "MATCH (w:WorkingGroup) WHERE w.id = $id "
                        + "RETURN w.usersRequired";
                Map<String, Object> params = new HashMap<>();
                params.put("id", application.getWorkingGroupID());
                StatementResult sr = tx.run(query, params);

                List<User> users = loadUsersInWorkingGroup(application.getWorkingGroupID());
                if (users.size() == sr.next().get(0).asInt()) {
                    ret.add(false);
                    return 1;
                }

                String query1 = ""
                        + "MATCH (u:User)-[a:APPLYED_FOR]->(w:WorkingGroup) "
                        + "WHERE w.id = $id AND u.username = $user "
                        + "DELETE a";
                Map<String, Object> params1 = new HashMap<>();
                params1.put("id", application.getWorkingGroupID());
                params1.put("user", application.getUsername());
                StatementResult sr1 = tx.run(query1, params1);

                String query2 = ""
                        + "MATCH (u:User) WHERE u.username = $user "
                        + "MATCH (w:WorkingGroup) WHERE w.id = $id "
                        + "CREATE (u)-[:WORKS_IN{since: $timestamp}]->(w)";
                Map<String, Object> params2 = new HashMap<>();
                params2.put("id", application.getWorkingGroupID());
                params2.put("user", application.getUsername());
                params2.put("timestamp", new SimpleDateFormat().format(new Date()));
                StatementResult sr2 = tx.run(query2, params2);
                ret.add(true);
                return 1;
            });
            return ret.get(0);
        }
    }

    public static Map<WorkingGroup, Double> loadSuggestedWorkingGroups(String user) {
        try (Session session = driver.session()) {
            Map<WorkingGroup, Double> ret = new HashMap<>();
            session.readTransaction((Transaction tx) -> {
                String query = ""
                        + "MATCH (u1:User)-[:WORKS_IN]->(w1:WorkingGroup)<-[:WORKS_IN]-(u2:User)-[:WORKS_IN]->(w2:WorkingGroup) "
                        + "WHERE u1.name = $name "
                        + "AND NOT (w1 = w2) "
                        + "RETURN DISTINCT w2.id, w2.description, w2.startDate, w2.deadlineDate, w2.usersRequired, w2.completed, count(w2.id)";
                Map<String, Object> params = new HashMap<>();
                params.put("name", user);
                StatementResult sr = tx.run(query, params);

                while (sr.hasNext()) {
                    Record next = sr.next();
                    try {
                        ret.put(new WorkingGroup(
                                next.get(0).asInt(),
                                next.get(1).asString(),
                                new SimpleDateFormat().parse(next.get(2).asString()),
                                new SimpleDateFormat().parse(next.get(3).asString()),
                                next.get(4).asInt(),
                                next.get(5).asBoolean()
                        ),
                                next.get(6).asDouble()
                        );
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                return 1;
            });
            return ret;
        }
    }

    public static int login(String username, String password) {

        try (Session session = driver.session()) {

            Map<String, Object> controls = new HashMap<>();
            session.readTransaction((Transaction tx) -> {

                String query = " MATCH (u:User) "
                        + " WHERE u.username=$username"
                        + " RETURN u.password,u.adminLvl";

                Map<String, Object> param = new HashMap<>();
                param.put("username", username);
                StatementResult sr = tx.run(query, param);

                if (sr.hasNext()) {
                    Record next = sr.next();
                    controls.put("password", next.get(0).asString());
                    controls.put("adminLvl", next.get(1).asInt());
                }

                return 1;

            });

            if (controls.isEmpty()) {
                return -1;
            }
            if (!controls.get("password").equals(password)) {
                return -1;
            }
            if ((int) controls.get("adminLvl") == 1) {
                return 1;
            } else {
                return 0;
            }

        }
    }

    public static List<WorkingGroup> loadWorkingGroup() {

        try (Session session = driver.session()) {
            List<WorkingGroup> ret = new ArrayList<>();

            session.readTransaction((Transaction tx) -> {

                String query = " MATCH (w:WorkingGroup)"
                        + " RETURN DISTINCT w.id,w.description,w.startDate,w.deadlineDate,w.usersRequired,w.completed";

                StatementResult sr = tx.run(query);
                if (sr.hasNext()) {
                    Record rec = sr.next();
                    try {

                        int id = rec.get(0).asInt();
                        String descr = rec.get(1).asString();
                        Date d1 = new SimpleDateFormat().parse(rec.get(2).asString());
                        Date d2 = new SimpleDateFormat().parse(rec.get(3).asString());
                        int userReq = rec.get(4).asInt();
                        boolean compl = rec.get(4).asBoolean();

                        ret.add(new WorkingGroup(id, descr, d1, d2, userReq, compl));

                    } catch (ParseException pe) {
                        System.out.println("There was an error during the parsing of the string");
                    }

                }

                return 1;
            });

            return ret;
        }

    }

    public static void insertUser(User u) {

        try (Session session = driver.session()) {

            session.writeTransaction((Transaction tx) -> {

                Map<String, Object> params = new HashMap<>();
                String query = "CREATE (u:User {"
                        + " username=$username, password=$password, adminLvl=$adminLvl, firstName=$firstName,"
                        + "lastName=$lastName, matriculationNumber=$matr, email=$email";

                params.put("username", u.getUsername());
                params.put("password", u.getPassword());
                params.put("adminLvl", u.getAdminLvl());
                params.put("firstName", u.getFirstName());
                params.put("lastName", u.getLastName());
                params.put("matr", u.getMatriculationNum());
                params.put("email", u.getEmail());

                tx.run(query, params);
                return 1;
            });

        }
    }

    public static void insertWorkinGroup(WorkingGroup wg) {

        try (Session session = driver.session()) {
            session.writeTransaction((Transaction tx) -> {

                Map<String, Object> params = new HashMap<>();
                String query = "CREATE (w:WorkingGroup{"
                        + "id=$id, description=$description, startDate=$startDate,"
                        + " deadlineDate=$deadlineDate, usersRequired=$usersRequired, completed=$completed ";

                params.put("id", wg.getId());
                params.put("description", wg.getDescription());
                params.put("startDate", wg.getStartDate());
                params.put("deadlineDate", wg.getDeadlineDate());
                params.put("usersRequired", wg.getUsersRequired());
                params.put("completed", wg.isCompleted());

                tx.run(query, params);
                return 1;
            });

        }
    }

    public static List<User> loadUsers() {

        try (Session session = driver.session()) {
            List<User> ret = new ArrayList<>();
            session.readTransaction((Transaction tx) -> {

                String query = "MATCH (u:User) "
                        + "RETURN DISTINCT u";

                StatementResult sr = tx.run(query);

                while (sr.hasNext()) {

                    Record rec = sr.next();
                    String usern = rec.get(0).asString();
                    String passw = rec.get(1).asString();
                    int adminLvl = rec.get(2).asInt();
                    String first = rec.get(3).asString();
                    String last = rec.get(4).asString();
                    int matr = rec.get(5).asInt();
                    String email = rec.get(6).asString();

                    ret.add(new User(usern, passw, adminLvl, first, last, matr, email));

                }

                return 1;
            });
            return ret;
        }
    }

}
