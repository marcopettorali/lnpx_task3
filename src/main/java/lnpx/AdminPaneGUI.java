package lnpx;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AdminPaneGUI extends AnchorPane {

    protected final TabPane tabPane;
    protected final Tab tab;
    protected final AnchorPane anchorPane;
    protected final UserOverviewTable TBUsers;
    protected final Label label;
    protected final Button ButtonDeleteUser;
    protected final Tab tab0;
    protected final AnchorPane anchorPane0;
    protected final Label label0;
    protected final TextField TFFirstName;
    protected final TextField TFLastName;
    protected final TextField TFEmail;
    protected final ChoiceBox CBAdminLevel;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final Button ButtonSignUp;
    protected final Label LabelOperationEsit;
    protected final TextField TFPassword;
    protected final Label label5;
    protected final Tab tab1;
    protected final AnchorPane anchorPane1;
    protected final RankingTable TBRanking;
    protected final Button ButtonCreateWorkingGroup;
    protected final TextField TFDescription;
    protected final TextField TFGroupID;
    protected final Label label6;
    protected final Label label7;
    protected final WorkingGroupTable TBWorkingGroups;
    protected final Label label8;
    protected final UserOverviewTable TBMembers;
    protected final Label label9;
    protected final TextField TFLeader;
    protected final Label label10;
    protected final Label LabelErrorMsg;
    protected final TextField TFNumbOfUsers;
    protected final Label label11;
    protected final Label label12;
    protected final DatePicker datePicker;

    public AdminPaneGUI() {

        tabPane = new TabPane();
        tab = new Tab();
        anchorPane = new AnchorPane();
        TBUsers = new UserOverviewTable();
        label = new Label();
        ButtonDeleteUser = new Button();
        tab0 = new Tab();
        anchorPane0 = new AnchorPane();
        label0 = new Label();
        TFFirstName = new TextField();
        TFLastName = new TextField();
        TFEmail = new TextField();
        CBAdminLevel = new ChoiceBox();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        ButtonSignUp = new Button();
        LabelOperationEsit = new Label();
        TFPassword = new TextField();
        label5 = new Label();
        tab1 = new Tab();
        anchorPane1 = new AnchorPane();
        TBRanking = new RankingTable();
        ButtonCreateWorkingGroup = new Button();
        TFDescription = new TextField();
        TFGroupID = new TextField();
        label6 = new Label();
        label7 = new Label();
        TBWorkingGroups = new WorkingGroupTable();
        label8 = new Label();
        TBMembers = new UserOverviewTable();
        label9 = new Label();
        TFLeader = new TextField();
        label10 = new Label();
        LabelErrorMsg = new Label();
        TFNumbOfUsers = new TextField();
        label11 = new Label();
        label12 = new Label();
        datePicker = new DatePicker();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(465.0);
        setPrefWidth(706.0);

        tabPane.setPrefHeight(465.0);
        tabPane.setPrefWidth(264.0);
        tabPane.setTabClosingPolicy(javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE);

        tab.setText("Users");

        anchorPane.setMinHeight(0.0);
        anchorPane.setMinWidth(0.0);
        anchorPane.setPrefHeight(180.0);
        anchorPane.setPrefWidth(200.0);

        TBUsers.setAccessibleText("TBUsers");
        TBUsers.setId("TBUsers");
        TBUsers.setLayoutX(14.0);
        TBUsers.setLayoutY(34.0);
        TBUsers.setPrefHeight(357.0);
        TBUsers.setPrefWidth(240.0);

        label.setLayoutX(14.0);
        label.setLayoutY(6.0);
        label.setText("Users");

        ButtonDeleteUser.setAccessibleText("ButtonDeleteUser");
        ButtonDeleteUser.setLayoutX(93.0);
        ButtonDeleteUser.setLayoutY(397.0);
        ButtonDeleteUser.setMnemonicParsing(false);
        ButtonDeleteUser.setText("Delete User");
        tab.setContent(anchorPane);

        tab0.setText("Sign Up");

        anchorPane0.setMinHeight(0.0);
        anchorPane0.setMinWidth(0.0);
        anchorPane0.setPrefHeight(180.0);
        anchorPane0.setPrefWidth(200.0);

        label0.setLayoutX(27.0);
        label0.setLayoutY(14.0);
        label0.setText("Register user");

        TFFirstName.setAccessibleText("TFFirstName");
        TFFirstName.setId("TFFirstName");
        TFFirstName.setLayoutX(27.0);
        TFFirstName.setLayoutY(56.0);

        TFLastName.setAccessibleText("TFLastName");
        TFLastName.setId("TFLastName");
        TFLastName.setLayoutX(27.0);
        TFLastName.setLayoutY(98.0);

        TFEmail.setAccessibleText("TFEmail");
        TFEmail.setId("TFEmail");
        TFEmail.setLayoutX(27.0);
        TFEmail.setLayoutY(182.0);

        CBAdminLevel.getItems().addAll(0,1);
        CBAdminLevel.setAccessibleText("AdminLevel");
        CBAdminLevel.setId("AdminLevel");
        CBAdminLevel.setLayoutX(27.0);
        CBAdminLevel.setLayoutY(140.0);
        CBAdminLevel.setPrefWidth(150.0);

        label1.setLayoutX(28.0);
        label1.setLayoutY(39.0);
        label1.setText("First Name");

        label2.setLayoutX(27.0);
        label2.setLayoutY(81.0);
        label2.setText("Last Name");

        label3.setLayoutX(28.0);
        label3.setLayoutY(123.0);
        label3.setText("Admin Level");

        label4.setLayoutX(27.0);
        label4.setLayoutY(165.0);
        label4.setText("Email");

        ButtonSignUp.setAccessibleText("ButtonSignUp");
        ButtonSignUp.setId("ButtonSignUp");
        ButtonSignUp.setLayoutX(67.0);
        ButtonSignUp.setLayoutY(272.0);
        ButtonSignUp.setMnemonicParsing(false);
        ButtonSignUp.setText("Sign Up");

        LabelOperationEsit.setId("TFOperationEsit");
        LabelOperationEsit.setLayoutX(20.0);
        LabelOperationEsit.setLayoutY(316.0);
        LabelOperationEsit.setText("");

        TFPassword.setLayoutX(27.0);
        TFPassword.setLayoutY(227.0);

        label5.setLayoutX(27.0);
        label5.setLayoutY(210.0);
        label5.setText("Password");
        tab0.setContent(anchorPane0);

        tab1.setText("Ranking");

        anchorPane1.setMinHeight(0.0);
        anchorPane1.setMinWidth(0.0);
        anchorPane1.setPrefHeight(180.0);
        anchorPane1.setPrefWidth(200.0);

        TBRanking.setAccessibleText("TBRanking");
        TBRanking.setId("TBRanking");
        TBRanking.setLayoutX(14.0);
        TBRanking.setLayoutY(22.0);
        TBRanking.setPrefHeight(402.0);
        TBRanking.setPrefWidth(224.0);
        tab1.setContent(anchorPane1);

        ButtonCreateWorkingGroup.setAccessibleText("ButtonCreateWorkingGroup");
        ButtonCreateWorkingGroup.setId("ButtonCreateWorkingGroup");
        ButtonCreateWorkingGroup.setLayoutX(634.0);
        ButtonCreateWorkingGroup.setLayoutY(37.0);
        ButtonCreateWorkingGroup.setMnemonicParsing(false);
        ButtonCreateWorkingGroup.setPrefHeight(68.0);
        ButtonCreateWorkingGroup.setPrefWidth(51.0);
        ButtonCreateWorkingGroup.setText("Create");

        TFDescription.setAccessibleText("TFNumberOfMembers");
        TFDescription.setId("TFNumberOfMembers");
        TFDescription.setLayoutX(279.0);
        TFDescription.setLayoutY(80.0);
        TFDescription.setPrefHeight(25.0);
        TFDescription.setPrefWidth(211.0);

        TFGroupID.setAccessibleText("TFTeamName");
        TFGroupID.setId("TFTeamName");
        TFGroupID.setLayoutX(277.0);
        TFGroupID.setLayoutY(36.0);
        TFGroupID.setPrefHeight(25.0);
        TFGroupID.setPrefWidth(103.0);

        label6.setLayoutX(277.0);
        label6.setLayoutY(15.0);
        label6.setText("Working Group ID");

        label7.setLayoutX(280.0);
        label7.setLayoutY(63.0);
        label7.setText("Description");

        TBWorkingGroups.setAccessibleText("TBWorkingGroups");
        TBWorkingGroups.setId("TBWorkingGroups");
        TBWorkingGroups.setLayoutX(261.0);
        TBWorkingGroups.setLayoutY(130.0);
        TBWorkingGroups.setPrefHeight(168.0);
        TBWorkingGroups.setPrefWidth(431.0);

        label8.setLayoutX(259.0);
        label8.setLayoutY(113.0);
        label8.setText("Working Groups");

        TBMembers.setAccessibleText("TBMembers");
        TBMembers.setId("TBMembers");
        TBMembers.setLayoutX(261.0);
        TBMembers.setLayoutY(315.0);
        TBMembers.setPrefHeight(112.0);
        TBMembers.setPrefWidth(431.0);

        label9.setLayoutX(261.0);
        label9.setLayoutY(298.0);
        label9.setText("Memebers");

        TFLeader.setAccessibleText("TFLeader");
        TFLeader.setId("TFLeader");
        TFLeader.setLayoutX(388.0);
        TFLeader.setLayoutY(36.0);
        TFLeader.setPrefHeight(25.0);
        TFLeader.setPrefWidth(103.0);

        label10.setLayoutX(388.0);
        label10.setLayoutY(15.0);
        label10.setText("Leader ");

        LabelErrorMsg.setLayoutX(267.0);
        LabelErrorMsg.setLayoutY(427.0);
        LabelErrorMsg.setText("Error msg");

        TFNumbOfUsers.setLayoutX(495.0);
        TFNumbOfUsers.setLayoutY(36.0);
        TFNumbOfUsers.setPrefHeight(25.0);
        TFNumbOfUsers.setPrefWidth(117.0);

        label11.setLayoutX(495.0);
        label11.setLayoutY(15.0);
        label11.setText("Number Of Users");

        label12.setLayoutX(499.0);
        label12.setLayoutY(63.0);
        label12.setText("Deadline date");

        datePicker.setLayoutX(499.0);
        datePicker.setLayoutY(80.0);
        datePicker.setPrefHeight(25.0);
        datePicker.setPrefWidth(117.0);

        anchorPane.getChildren().add(TBUsers);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(ButtonDeleteUser);
        tabPane.getTabs().add(tab);
        anchorPane0.getChildren().add(label0);
        anchorPane0.getChildren().add(TFFirstName);
        anchorPane0.getChildren().add(TFLastName);
        anchorPane0.getChildren().add(TFEmail);
        anchorPane0.getChildren().add(CBAdminLevel);
        anchorPane0.getChildren().add(label1);
        anchorPane0.getChildren().add(label2);
        anchorPane0.getChildren().add(label3);
        anchorPane0.getChildren().add(label4);
        anchorPane0.getChildren().add(ButtonSignUp);
        anchorPane0.getChildren().add(LabelOperationEsit);
        anchorPane0.getChildren().add(TFPassword);
        anchorPane0.getChildren().add(label5);
        tabPane.getTabs().add(tab0);
        anchorPane1.getChildren().add(TBRanking);
        tabPane.getTabs().add(tab1);
        
        setBehaviour();
        
        getChildren().add(tabPane);
        getChildren().add(ButtonCreateWorkingGroup);
        getChildren().add(TFDescription);
        getChildren().add(TFGroupID);
        getChildren().add(label6);
        getChildren().add(label7);
        getChildren().add(TBWorkingGroups);
        getChildren().add(label8);
        getChildren().add(TBMembers);
        getChildren().add(label9);
        getChildren().add(TFLeader);
        getChildren().add(label10);
        getChildren().add(LabelErrorMsg);
        getChildren().add(TFNumbOfUsers);
        getChildren().add(label11);
        getChildren().add(label12);
        getChildren().add(datePicker);

    }
    
    public void addUsersList(List<User> list){
        TBUsers.setItems(list);
    }
    
    public void addRank(List<UserRanking> list){
        TBRanking.setItems(list);
    }
    
    public void addWorkingGroups(List<WorkingGroup> list)
    {
        TBWorkingGroups.setItems(list);
    }
    
    public void setBehaviour()
    {
        ButtonSignUp.setOnMouseClicked(e->{
           if(TFFirstName.getText().compareTo("")!= 0 &&
              TFLastName.getText().compareTo("") != 0 &&
              CBAdminLevel.getValue()!=null           &&
              TFEmail.getText().compareTo("")    != 0 &&
              TFPassword.getText().compareTo("") != 0 &&
              TFEmail.getText().contains("@")
              ) //checking of all the inserted Txt Fields
           {
               String username=TFFirstName.getText()+TFLastName.getText();
               User u=new User(username, TFPassword.getText(), (int) CBAdminLevel.getValue(),TFFirstName.getText(), TFLastName.getText(),0,TFEmail.getText()); 
               MainApp.insertUserInDB(u);
               LabelOperationEsit.setText("User saved!");
               TFPassword.setText("");
               TFFirstName.setText("");
               TFLastName.setText("");
               TFEmail.setText("");
               CBAdminLevel.getSelectionModel().clearSelection(); 
           }
           else
           {
               LabelOperationEsit.setText("Insert all informations\nin the correct format (email)");
           }
           
            
        });
        
        ButtonCreateWorkingGroup.setOnMouseClicked(e->{
            if(TFGroupID.getText().compareTo("")    != 0 &&
               TFLeader.getText().compareTo("")     != 0 &&
               TFNumbOfUsers.getText().compareTo("")!= 0 &&
               TFDescription.getText().compareTo("")!= 0 &&
               datePicker.getValue()!=null) //check all textFields
            {
                SimpleDateFormat sdf = new SimpleDateFormat();
                sdf.applyPattern("yyyy-MM-dd");
                
                
                try{
                WorkingGroup wg=new WorkingGroup(Integer.parseInt(TFGroupID.getText()), TFDescription.getText(),sdf.format(new Date()),sdf.format(java.sql.Date.valueOf(datePicker.getValue())),Integer.parseInt(TFNumbOfUsers.getText()),false);
                MainApp.createWorkingGroup(wg,TFLeader.getText());
                LabelErrorMsg.setText("Working group saved successfully");
                
                } catch (NumberFormatException ex) {
                    LabelErrorMsg.setText("Follow this format GroupID: Integer, NumberOfUsers:Integer");
                }
            }
            else
            {
               LabelErrorMsg.setText("Insert all informations\nin the correct format");
            }
        });
        
        ButtonDeleteUser.setOnMouseClicked(e->{
            User u=TBUsers.getSelected();
            if(u!=null)
                MainApp.deleteUserFormDB(u);
        });
        
        TBWorkingGroups.setOnMouseClicked(e->{
            WorkingGroup wg=TBWorkingGroups.getSelected();
            if(wg!=null)
            {
                List<User> usersInWorkingGroup=Neo4JManager.loadUsersInWorkingGroup(wg.getId());
                System.out.println("Il numero di utenti che lavora per questo gruppo è "+usersInWorkingGroup.size());
                TBMembers.setItems(usersInWorkingGroup);
            }
            
        });
    }
}
