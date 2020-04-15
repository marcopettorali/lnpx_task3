package lnpx;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static lnpx.Neo4JManager.insertUser;
import static lnpx.Neo4JManager.insertWorkingGroup;

public class MainApp extends Application {
    private static Stage LoginStage;
    private static Stage SignUpStage;
    private static Stage AdminStage;
    private static Stage UserStage;
    private static AdminPaneGUI adminPane;
    private static UserPaneGUI userPane;
    private static String userLogged;
    
    /***************************** LOGIN STAGE ********************************/
    private static void loadLoginStage()
    {
        SignUpStage.close();
        AdminStage.close();
        UserStage.close();

        LoginStage.setTitle("Login");
        LoginStage.setResizable(false);
        LoginStage.setScene(new Scene(new Group(new LoginPaneGUI())));
        LoginStage.sizeToScene();
        LoginStage.show();
    }
    /********************** END LOGIN STAGE ***********************************/
    
    /************************** ADMIN STAGE ***********************************/
    private static void loadAdminStage()
    {
        adminPane=new AdminPaneGUI();
        /* Getting users informations */
        List<User> userList= Neo4JManager.loadUsers();
        System.out.println(userList.size());
        adminPane.addUsersList(userList);
        /************************************ /
        
        /* Getting ranking and converting in Table*/
        updateLeadersTable();
        
        /********************************************/
        
        /* Getting working groups */
        List<WorkingGroup> workingGroups=Neo4JManager.loadWorkingGroup();
        adminPane.addWorkingGroups(workingGroups);
        /******************************************/
        
        
        SignUpStage.close();
        UserStage.close();
        LoginStage.close();
        
        AdminStage=new Stage();
        AdminStage.setTitle("Admin");
        AdminStage.setResizable(false);
        AdminStage.setScene(new Scene(new Group(adminPane)));
        AdminStage.sizeToScene();
        AdminStage.show();
    }
    
    public static void deleteUserFormDB(User u)
    {
        Neo4JManager.deleteUser(u);
        updateAdminUserInterface();
        
    }
    
    public static void insertUserInDB(User u)
    {
        Neo4JManager.insertUser(u);
        updateAdminUserInterface();
    }
    
    public static void createWorkingGroup(WorkingGroup wg,String u)
    {
        Neo4JManager.insertWorkingGroup(wg, u);
        updateAdminWorkingGroupInterface();
        updateLeadersTable();
    }
    
    private static void updateAdminUserInterface()
    {
        List<User> userList= Neo4JManager.loadUsers();
        System.out.println(userList.size());
        adminPane.addUsersList(userList);
        
        //updating the ranking
        updateLeadersTable();
        
    }
    
    private static void updateLeadersTable()
    {
        List<UserRanking> userRanking=new ArrayList<>();
        Map<User,Double> rank=Neo4JManager.loadLeadersRanking();
        for(Map.Entry<User, Double> entry: rank.entrySet())
        {
            User keyUser=entry.getKey();
            Double ValueRank=entry.getValue();
            UserRanking ur=new UserRanking(keyUser.getUsername(),ValueRank);
            userRanking.add(ur);
        }
        adminPane.addRank(userRanking);
    }
    
    private static void updateAdminWorkingGroupInterface()
    {
       List<WorkingGroup> workingGroups=Neo4JManager.loadWorkingGroup();
       adminPane.addWorkingGroups(workingGroups);
    }
    
    /****************************** END ADMIN STAGE ***************************/
    
    /***************************** USER STAGE *********************************/
    public static void loadUserStage()
    {
        List<WorkingGroup> completed=new ArrayList<>();
        List<WorkingGroup> notCompleted=new ArrayList<>();
        
        userPane=new UserPaneGUI();
        List<WorkingGroup> wgs=Neo4JManager.loadWorkingGroupsForUser(userLogged);
        for (WorkingGroup wg : wgs) {
            if(wg.isCompleted())
                completed.add(wg);
            else
                notCompleted.add(wg);
        }
        userPane.addCurrent(notCompleted);
        userPane.addCompleted(completed);
        userPane.addLeaded(Neo4JManager.loadLeadedWorkingGroups(userLogged));
        
        List<SuggestedWorkingGroups> swg=new ArrayList<>();
        Map<WorkingGroup,Double> wgDouble=Neo4JManager.loadSuggestedWorkingGroups(userLogged);
        for(Map.Entry<WorkingGroup,Double> entry: wgDouble.entrySet())
        {
            swg.add(new SuggestedWorkingGroups(entry.getKey().getId(),entry.getValue()));
        }
        userPane.addSuggested(swg);
        
        
        //userPane.addSuggested(Neo4JManager.loadSuggestedWorkingGroups(userLogged));
        SignUpStage.close();
        AdminStage.close();
        LoginStage.close();
        
        UserStage=new Stage();
        UserStage.setTitle("User");
        UserStage.setResizable(false);
        UserStage.setScene(new Scene(new Group(userPane)));
        UserStage.sizeToScene();
        UserStage.show();
        
    }
    
    public static void updateAboutWorkingGroup(){
        //this function should update all the labels in the right
        //each time an element is selects
    }
    
    public static void markWorkAsComplited(WorkingGroup wg){
        System.out.println("Mark as completed");
        Neo4JManager.markWorkAsCompleted(userLogged, wg);
        List<WorkingGroup> completed=new ArrayList<>();
        List<WorkingGroup> notCompleted=new ArrayList<>();
        List<WorkingGroup> wgs=Neo4JManager.loadWorkingGroupsForUser(userLogged);
        for (WorkingGroup wgi : wgs) {
            if(wgi.isCompleted())
                completed.add(wgi);
            else
                notCompleted.add(wgi);
        }
        userPane.addCurrent(notCompleted);
        userPane.addCompleted(completed);
        //to be sure to check if all the members ended their job
        userPane.addLeaded(Neo4JManager.loadLeadedWorkingGroups(userLogged));
    }
    
    public static void acceptApplication(ApplicationWorkingGroup a){
        Neo4JManager.acceptApplication(a);
    }
    
    public static void sendApplication(int wg){
        Date d=new Date();
        ApplicationWorkingGroup a;
        a = new ApplicationWorkingGroup(userLogged,d.toString(),wg);
        Neo4JManager.insertApplication(a);
        
        //we update the suggested working groups (to remove the one we applied for)
        List<SuggestedWorkingGroups> swg=new ArrayList<>();
        Map<WorkingGroup,Double> wgDouble=Neo4JManager.loadSuggestedWorkingGroups(userLogged);
        for(Map.Entry<WorkingGroup,Double> entry: wgDouble.entrySet())
        {
            swg.add(new SuggestedWorkingGroups(entry.getKey().getId(),entry.getValue()));
        }
        userPane.addSuggested(swg);
    }
    
    public static void loadApplicationsForWorkingGroup(WorkingGroup wg){
        List<ApplicationWorkingGroup> awg=Neo4JManager.loadApplications(wg.getId());
        userPane.addApplications(awg);
        
    }
    
    public static void updateCurrentWorkingGroups()
    {
        
    }
    
    /***************************** END USER STAGE *****************************/
   
    public static int login(String username, String password)
    {
        int loginValue =Neo4JManager.login(username, password);
        if(loginValue == 1)
        {
            loadAdminStage();
        }
        if(loginValue == 0)
        {
            userLogged=username;
            loadUserStage();
        }
        
        return loginValue;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        LoginStage =  new Stage();
        SignUpStage=  new Stage();
        AdminStage =  new Stage();
        UserStage  =  new Stage();
        loadLoginStage();
        /*Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();*/
    }

    public static void main(String[] args) {
        
        
        Neo4JManager.connectToDB("bolt://localhost:7687","Graph","");
        System.out.println("Connessione riuscita");
        //Neo4JManager.clearDB();
        //Neo4JManager.createTestDB();
        launch(args);
        System.out.println("Creazione DB riuscita");
        Neo4JManager.closeDB();
    }

}
