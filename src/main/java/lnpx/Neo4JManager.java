package lnpx;

import java.text.*;
import java.util.*;
import java.util.Map.*;
import java.util.logging.Level;
import org.neo4j.driver.v1.*;

public class Neo4JManager {

    private static Driver driver;

    public static void connectToDB(String uri, String user, String password) {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    public static void closeDB() {
        driver.close();
    }

    public static void clearDB() {
        try (Session session = driver.session()) {
            session.writeTransaction((Transaction tx) -> {
                String query = "MATCH (n) DETACH DELETE n";
                tx.run(query);
                return 1;
            });
        }
    }

    public static void createTestDB() {

        insertUser(new User("admin", "admin", 1, "admin", "admin", 999999, "admin@neo4j.com"));
        insertUser(new User("ciccio", "ciccio", 0, "Ciccio", "Graziano", 131313, "ciccio@neo4j.com"));
        insertUser(new User("dario", "dario", 0, "Dario", "Lorenzoni", 111111, "dario@neo4j.com"));
        insertUser(new User("raffaele", "raffaele", 0, "Raffaele", "Nocerino", 222222, "raffaele@neo4j.com"));
        insertUser(new User("marco", "marco", 0, "Marco", "Pettorali", 333333, "marco@neo4j.com"));
        insertUser(new User("riccardo", "riccardo", 0, "Riccardo", "Xefraj", 444444, "riccardo@neo4j.com"));
        insertUser(new User("ciro", "ciro", 0, "Ciro", "Immobile", 555555, "ciro@neo4j.com"));
        insertUser(new User("memphis", "memphis", 0, "Memphis", "Depay", 666666, "memphis@neo4j.com"));
        insertUser(new User("cristiano", "cristiano", 0, "Cristiano", "Ronaldo", 777777, "cristiano@neo4j.com"));
        insertUser(new User("timo", "timo", 0, "Timo", "Werner", 888888, "timo@neo4j.com"));
        insertUser(new User("sergio", "sergio", 0, "Sergio", "Ramos", 999999, "sergio@neo4j.com"));
        insertUser(new User("paul", "paul", 0, "Paul", "Pogba", 101010, "paul@neo4j.com"));
        insertUser(new User("romelu", "romelu", 0, "Romelu", "Lukaku", 121212, "romelu@neo4j.com"));

        insertWorkingGroup(new WorkingGroup(0, "Best squad 4ever", "2020-01-10", "2020-10-01", 11, false), "c.ronaldo");
        insertWorkingGroup(new WorkingGroup(1, "DB project", "2020-01-10", "2020-10-01", 11, false), "c.graziano");
        insertWorkingGroup(new WorkingGroup(2, "Champions League", "2020-01-10", "2020-10-01", 11, false), "c.ronaldo");
        insertWorkingGroup(new WorkingGroup(3, "Serie A", "2020-01-10", "2020-10-01", 6, false), "c.immobile");
        insertWorkingGroup(new WorkingGroup(4, "Best Friends", "2020-01-10", "2020-10-01", 11, false), "m.depay");

        insertApplication(new ApplicationWorkingGroup("c.graziano", "2020-03-03", 0));
        insertApplication(new ApplicationWorkingGroup("c.graziano", "2020-03-03", 2));
        insertApplication(new ApplicationWorkingGroup("c.graziano", "2020-03-03", 4));
        insertApplication(new ApplicationWorkingGroup("c.graziano", "2020-03-05", 3));
        insertApplication(new ApplicationWorkingGroup("c.immobile", "2020-03-05", 2));
        insertApplication(new ApplicationWorkingGroup("c.ronaldo", "2020-03-07", 3));
        insertApplication(new ApplicationWorkingGroup("d.lorenzoni", "2020-03-01", 3));
        insertApplication(new ApplicationWorkingGroup("m.pettorali", "2020-03-02", 2));
        insertApplication(new ApplicationWorkingGroup("m.pettorali", "2020-03-05", 4));
        insertApplication(new ApplicationWorkingGroup("m.pettorali", "2020-03-06", 1));
        insertApplication(new ApplicationWorkingGroup("m.pettorali", "2020-03-06", 3));
        insertApplication(new ApplicationWorkingGroup("m.depay", "2020-03-10", 0));
        insertApplication(new ApplicationWorkingGroup("m.depay", "2020-03-10", 2));
        insertApplication(new ApplicationWorkingGroup("p.pogba", "2020-03-07", 0));
        insertApplication(new ApplicationWorkingGroup("p.pogba", "2020-03-07", 4));
        insertApplication(new ApplicationWorkingGroup("p.pogba", "2020-03-10", 2));
        insertApplication(new ApplicationWorkingGroup("r.nocerino", "2020-03-02", 0));
        insertApplication(new ApplicationWorkingGroup("r.nocerino", "2020-03-03", 3));
        insertApplication(new ApplicationWorkingGroup("r.nocerino", "2020-03-11", 2));
        insertApplication(new ApplicationWorkingGroup("r.nocerino", "2020-03-11", 4));
        insertApplication(new ApplicationWorkingGroup("r.xefraj", "2020-03-03", 4));
        insertApplication(new ApplicationWorkingGroup("s.ramos", "2020-03-06", 2));
        insertApplication(new ApplicationWorkingGroup("t.werner", "2020-03-02", 2));
        insertApplication(new ApplicationWorkingGroup("t.werner", "2020-03-03", 3));
        insertApplication(new ApplicationWorkingGroup("t.werner", "2020-03-03", 4));

        /*if you un comment this code please correct the usernames observing the function above
        
        acceptApplication(new ApplicationWorkingGroup("ciccio", "2020-03-03", 0));
        acceptApplication(new ApplicationWorkingGroup("ciccio", "2020-03-03", 2));
        acceptApplication(new ApplicationWorkingGroup("ciccio", "2020-03-04", 4));
        acceptApplication(new ApplicationWorkingGroup("ciccio", "2020-03-05", 3));
        acceptApplication(new ApplicationWorkingGroup("ciro", "2020-03-05", 2));
        acceptApplication(new ApplicationWorkingGroup("cristiano", "2020-03-07", 3));
        acceptApplication(new ApplicationWorkingGroup("dario", "2020-03-01", 3));
        acceptApplication(new ApplicationWorkingGroup("marco", "2020-03-02", 2));
        acceptApplication(new ApplicationWorkingGroup("marco", "2020-03-05", 4));
        acceptApplication(new ApplicationWorkingGroup("marco", "2020-03-06", 3));
        acceptApplication(new ApplicationWorkingGroup("memphis", "2020-03-02", 2));
        acceptApplication(new ApplicationWorkingGroup("memphis", "2020-03-08", 0));
        acceptApplication(new ApplicationWorkingGroup("raffaele", "2020-03-02", 0));
        acceptApplication(new ApplicationWorkingGroup("raffaele", "2020-03-03", 3));
        acceptApplication(new ApplicationWorkingGroup("raffaele", "2020-03-11", 4));
        acceptApplication(new ApplicationWorkingGroup("timo", "2020-03-02", 2));
        acceptApplication(new ApplicationWorkingGroup("timo", "2020-03-03", 4));*/
    }

    public static void insertApplication(ApplicationWorkingGroup application) {
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
                        + "MATCH (u:User)-[wi:WORKS_IN]->(w:WorkingGroup) "
                        + "WHERE u.username = $name "
                        + "RETURN w.id, w.description, w.startDate, w.deadlineDate, w.usersRequired, wi.completed";
                Map<String, Object> params = new HashMap<>();
                params.put("name", user);
                StatementResult sr = tx.run(query, params);

                while (sr.hasNext()) {
                    Record next = sr.next();
                    try {
                        ret.add(new WorkingGroup(
                                next.get(0).asInt(),
                                next.get(1).asString(),
                                next.get(2).asLocalDate().toString(),
                                next.get(3).asLocalDate().toString(),
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
                        + "RETURN u.username, u.password, u.adminLvl, u.firstName, u.lastName, u.matriculationNum, u.email";
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
                        + "RETURN u.username, u.password, u.adminLvl, u.firstName, u.lastName, u.matriculationNum, u.email";
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
                                next.get(2).asLocalDate().toString(),
                                next.get(3).asLocalDate().toString(),
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

    public static List<ApplicationWorkingGroup> loadApplications(int workingGroupID) {
        try (Session session = driver.session()) {
            List<ApplicationWorkingGroup> ret = new ArrayList<>();
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
                    ret.add(new ApplicationWorkingGroup(
                            next.get(0).asString(),
                            next.get(1).asString(),
                            workingGroupID
                    ));
                }
                return 1;
            });
            return ret;
        }
    }

    public static boolean acceptApplication(ApplicationWorkingGroup application) {
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
                        + "CREATE (u)-[:WORKS_IN{since: $timestamp, completed:false}]->(w)";
                Map<String, Object> params2 = new HashMap<>();
                params2.put("id", application.getWorkingGroupID());
                params2.put("user", application.getUsername());
                params2.put("timestamp", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                
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
                                next.get(2).asString(),
                                next.get(3).asString(),
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
                while (sr.hasNext()) {
                    Record rec = sr.next();

                        int id = rec.get(0).asInt();
                        String descr = rec.get(1).asString();
                        String d1 = rec.get(2).asLocalDate().toString();
                        String d2 = rec.get(3).asLocalDate().toString();
                        int userReq = rec.get(4).asInt();
                        boolean compl = rec.get(5).asBoolean();

                    ret.add(new WorkingGroup(id, descr, d1, d2, userReq, compl));

                }

                return 1;
            });

            return ret;
        }

    }
    
    private static int checkIncrementalUsername(User u){
        
        try (Session session = driver.session()) {
            
            List<String> names = new ArrayList<>();
            
            session.readTransaction((Transaction tx) -> {

                Map<String, Object> params = new HashMap<>();
                
                String query = "MATCH (u:User) WHERE u.lastName=$lastName "
                             + "RETURN DISTINCT u.firstName";
                
                params.put("lastName",u.getLastName());
                
                StatementResult sr = tx.run(query,params);
                
                while(sr.hasNext()){
                    
                    Record rec = sr.next();
                    names.add(rec.get(0).asString());
                }
        
                return 1;
            });
            
           char initial_new = u.getFirstName().toLowerCase().charAt(0);
           int count = 0;
           
           for(int i=0; i<names.size();i++){
           
               if(initial_new == names.get(i).toLowerCase().charAt(0) ){
                   count++;
               }
           
           }
           
           return count;
        }
    }
    
    
    public static void insertUser(User u) {

        try (Session session = driver.session()) {
            
            session.writeTransaction((Transaction tx) -> {

                Map<String, Object> params = new HashMap<>();
                
                int count = checkIncrementalUsername(u);
                
                char first = u.getFirstName().toLowerCase().charAt(0);
                String username = first +"."+u.getLastName().toLowerCase();
                if(count >= 1){
                    username = username + count;
                }
                
                String query = "CREATE (u:User {"
                        + " username:$username, password:$password, adminLvl:$adminLvl, firstName:$firstName,"
                        + "lastName:$lastName, matriculationNum:$matr, email:$email})";
                params.clear();
                params.put("username", username);
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

    private static int checkIdWorkingGroup(){
        
        try (Session session = driver.session()) {
            
            List<Integer> ret = new ArrayList<>();
            session.readTransaction((Transaction tx) -> {
                
                Map<String, Object> params = new HashMap<>();
                String query = "MATCH (w:WorkingGroup) RETURN max(w.id)";
                StatementResult sr = tx.run(query);
                if(sr.hasNext()){
                    Record rec = sr.next();
                    if(rec.get(0).isNull()){
                        ret.add(0);
                    }else{
                    ret.add(rec.get(0).asInt());
                    }
                  }
            return 1;    
            });
            System.out.println(ret.get(0));
            return ret.get(0);
        }
        
    }
            
    
    public static void insertWorkingGroup(WorkingGroup wg, String user) {

        try (Session session = driver.session()) {
            
            
            session.writeTransaction((Transaction tx) -> {
                
                Map<String, Object> params = new HashMap<>();
                
                
               int id = checkIdWorkingGroup() + 1 ;
                String query = "CREATE (w:WorkingGroup{"
                        + "id:$id, description:$description, startDate:date($startDate),"
                        + " deadlineDate:date($deadlineDate), usersRequired:$usersRequired, completed:$completed })";

                params.put("id",id );
                params.put("description", wg.getDescription());
                params.put("startDate", wg.getStartDate());
                params.put("deadlineDate", wg.getDeadlineDate());
                params.put("usersRequired", wg.getUsersRequired());
                params.put("completed", wg.isCompleted());

                tx.run(query, params);

                String query2 = "MATCH (u:User) WHERE u.username=$username "
                        + "MATCH (w:WorkingGroup) WHERE w.id=$id "
                        + "CREATE (u)-[:LEADER_OF]->(w),"
                        + "(u)-[:WORKS_IN{since: date($startDate), completed: false}]->(w) ";

                params.clear();
                params.put("username", user);
                params.put("id",id);
                params.put("startDate", wg.getStartDate());

                tx.run(query2, params);

                return 1;
            });
           
        }
    }

    public static List<User> loadUsers() {

        try (Session session = driver.session()) {
            List<User> ret = new ArrayList<>();
            session.readTransaction((Transaction tx) -> {

                String query = "MATCH (u:User) "
                        + "RETURN DISTINCT u.username,u.password,u.adminLvl,u.firstName,u.lastName, "
                        + "u.matriculationNum, u.email";

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

    public static void deleteUser(User u) {

        try (Session session = driver.session()) {

            session.writeTransaction((Transaction tx) -> {
                
                Map<String, Object> param = new HashMap<>();
                
                String query0 = "MATCH (u:User)-[wi:WORKS_IN]->(w:WorkingGroup)"
                             + "WHERE u.username=$username "
                             + "DELETE wi";
                
                param.put("username", u.getUsername());
                StatementResult sr0 = tx.run(query0,param);
                
                String query1 = "MATCH (u:User)-[l:LEADER_OF]->(w:WorkingGroup)"
                             + "WHERE u.username=$username "
                             + "DELETE l";
                
                param.clear();
                param.put("username", u.getUsername());
                StatementResult sr1 = tx.run(query1,param);
                
                String query2 = "MATCH (u:User)-[a:APPLYED_FOR]->(w:WorkingGroup)"
                             + "WHERE u.username=$username "
                             + "DELETE a";
                
                param.clear();
                param.put("username", u.getUsername());
                StatementResult sr2 = tx.run(query2,param);
                
                String query3 = " MATCH (u:User)"
                        + "WHERE u.username=$username "
                        + "DELETE u ";
                param.clear();        
                param.put("username", u.getUsername());
                StatementResult sr3 = tx.run(query3, param);
                return 1;

            });

        }

    }

    public static Map<User, Double> loadLeadersRanking() {

        try (Session session = driver.session()) {
            
            Map<User, Double> ret = new HashMap<>();

            Map<User, List<WorkingGroup>> user_group = new HashMap<>();
            Map<Integer, Double> group_percentage = new HashMap<>();
            Map<String, Object> params = new HashMap<>();
            session.readTransaction((Transaction tx) -> {

                String query = "MATCH (u:User)-[:LEADER_OF]->(w:WorkingGroup) "
                        + "RETURN DISTINCT u.username,u.password,u.adminLvl,u.firstName,u.lastName, "
                        + "u.matriculationNum, u.email "
                        + ",w.id,w.description,w.startDate,w.deadlineDate,w.usersRequired,w.completed ";

                StatementResult sr = tx.run(query);
                while (sr.hasNext()) {

                    Record rec = sr.next();
                    
                        int id = rec.get(7).asInt();
                        String descr = rec.get(8).asString();
                        String d1 = rec.get(9).asLocalDate().toString();
                        String d2 = rec.get(10).asLocalDate().toString();
                        int userReq = rec.get(11).asInt();
                        boolean compl = rec.get(12).asBoolean();

                        WorkingGroup temp = new WorkingGroup(id, descr, d1, d2, userReq, compl);

                        String usern = rec.get(0).asString();
                        String passw = rec.get(1).asString();
                        int adminLvl = rec.get(2).asInt();
                        String first = rec.get(3).asString();
                        String last = rec.get(4).asString();
                        int matr = rec.get(5).asInt();
                        String email = rec.get(6).asString();

                        User u = new User(usern, passw, adminLvl, first, last, matr, email);
                        
                        boolean b=false;
                        
                        for (Map.Entry<User, List<WorkingGroup>> entry : user_group.entrySet()) {
                            
                            if(entry.getKey().getUsername().equals(u.getUsername())){
                                b = true;
                                entry.getValue().add(temp);
                                break;
                            }
                        }
                        if(!b){
                            user_group.put(u,new ArrayList<WorkingGroup>());
                            user_group.get(u).add(temp);
                        }
                        

                }

                String query2 = "MATCH (u:User)-[wi:WORKS_IN]->(w:WorkingGroup) "
                        + "RETURN DISTINCT w.id,w.usersRequired,count(wi) ";

                StatementResult sr1 = tx.run(query2);
                while (sr1.hasNext()) {
                    
                    Record rec = sr1.next();
                    int id = rec.get(0).asInt();
                    double req = rec.get(1).asDouble();
                    double count = rec.get(2).asDouble();
                    double percentage = (count / req) * 100;

                    
                    group_percentage.put(id, percentage);
                    
                }
                return 1;
            });
            
            
            
            for (Map.Entry<User, List<WorkingGroup>> entry : user_group.entrySet()) {

                double somma = 0;
                List<WorkingGroup> appoggio = entry.getValue();
                for (int i = 0; i < appoggio.size(); i++) {
                    somma += group_percentage.get(appoggio.get(i).getId());
                }
                somma = somma / appoggio.size();               
                if (somma != 100) {
                    ret.put(entry.getKey(), somma);
                }
            }
            List<Entry<User, Double>> list = new ArrayList<>(ret.entrySet());
            list.sort(Entry.comparingByValue());

            Map<User, Double> result = new LinkedHashMap<>();

            for (Entry<User, Double> entry : list) {
                result.put(entry.getKey(), entry.getValue());
            }
            return result;

        }

    }

    public static void markWorkAsCompleted(String username, WorkingGroup wg) {

        try (Session session = driver.session()) {
            Map<String, Object> params = new HashMap<>();
            session.writeTransaction((Transaction tx) -> {

                String query = "MATCH (u:User)-[wi:WORKS_IN]->(w:WorkingGroup) "
                        + "WHERE u.username=$username and w.id=$id "
                        + "Set wi.completed=true ";
                params.put("username", username);
                params.put("id", wg.getId());

                tx.run(query, params);
                boolean b = checkCompletedWork(wg);
                
                if (b) {

                    String query2 = "MATCH (w:WorkingGroup) WHERE w.id=$id "
                            + "Set w.completed=true";
                    params.clear();
                    params.put("id", wg.getId());

                    tx.run(query2, params);

                }

                return 1;

            });
        }
    }

    public static boolean checkCompletedWork(WorkingGroup wg) {

        try (Session session = driver.session()) {
            Map<String, Object> params = new HashMap<>();
            List<Boolean> ret = new ArrayList<>();
            session.readTransaction((Transaction tx) -> {

                String query = "MATCH ()-[wi:WORKS_IN]->(w:WorkingGroup) "
                        + "WHERE w.id=$id and wi.completed=true "
                        + "RETURN w.usersRequired,count(wi)";

                params.put("id", wg.getId());
                StatementResult sr = tx.run(query, params);
                if (sr.hasNext()) {

                    Record rec = sr.next();
                    int req = rec.get(0).asInt();
                    int count = rec.get(1).asInt();
           
                    if (req == count+1) {
                        ret.add(true);
                    } else {
                        ret.add(false);
                    }
                     

                }else{
                    ret.add(false);
                }
                return 1;

            });
            return ret.get(0);
        }
    }

}
