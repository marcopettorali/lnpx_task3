package lnpx;

import static java.util.Collections.list;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class UserPaneGUI extends AnchorPane {

    protected final TabPane tabPane;
    protected final Tab tab;
    protected final AnchorPane anchorPane;
    protected final Label label;
    protected final WorkingGroupTable currentTable;
    protected final Button markWorkAsCompletedButton;
    protected final Label label0;
    protected final WorkingGroupTable completedTable;
    protected final Tab tab0;
    protected final AnchorPane anchorPane0;
    protected final Button acceptApplicationButton;
    protected final ApplicationWorkingGroupTable applicationsTable;
    protected final Label label1;
    protected final WorkingGroupTable leadedTable;
    protected final Label label2;
    protected final Tab tab1;
    protected final AnchorPane anchorPane1;
    protected final Label label3;
    protected final SuggestedWorkingGroupTable suggestedTable;
    protected final Button sendApplicationButton;
    protected final Label label4;
    protected final Label label5;
    protected final Label label6;
    protected final Label label7;
    protected final Label label8;
    protected final Label label9;
    protected final Label label10;
    protected final Label descriptionLabel;
    protected final Label startDateLabel;
    protected final Label deadlineDateLabel;
    protected final Label usersLabel;
    protected final Label usersRequiredLabel;
    protected final Label completedLabel;

    public UserPaneGUI() {

        tabPane = new TabPane();
        tab = new Tab();
        anchorPane = new AnchorPane();
        label = new Label();
        currentTable = new WorkingGroupTable();
        markWorkAsCompletedButton = new Button();
        label0 = new Label();
        completedTable = new WorkingGroupTable();
        tab0 = new Tab();
        anchorPane0 = new AnchorPane();
        acceptApplicationButton = new Button();
        applicationsTable = new ApplicationWorkingGroupTable();
        label1 = new Label();
        leadedTable = new WorkingGroupTable();
        label2 = new Label();
        tab1 = new Tab();
        anchorPane1 = new AnchorPane();
        label3 = new Label();
        suggestedTable = new SuggestedWorkingGroupTable();
        sendApplicationButton = new Button();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();
        label7 = new Label();
        label8 = new Label();
        label9 = new Label();
        label10 = new Label();
        descriptionLabel = new Label();
        startDateLabel = new Label();
        deadlineDateLabel = new Label();
        usersLabel = new Label();
        usersRequiredLabel = new Label();
        completedLabel = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(595.0);
        setPrefWidth(1170.0);

        tabPane.setPrefHeight(595.0);
        tabPane.setPrefWidth(438.0);
        tabPane.setTabClosingPolicy(javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE);

        tab.setText("My Workng Groups");

        anchorPane.setMinHeight(0.0);
        anchorPane.setMinWidth(0.0);
        anchorPane.setPrefHeight(475.0);
        anchorPane.setPrefWidth(494.0);

        label.setLayoutX(14.0);
        label.setLayoutY(7.0);
        label.setText("Current");
        label.setFont(new Font(20.0));

        currentTable.setId("TBCurrentJobs");
        currentTable.setLayoutX(14.0);
        currentTable.setLayoutY(37.0);
        currentTable.setPrefHeight(208.0);
        currentTable.setPrefWidth(410.0);

        markWorkAsCompletedButton.setId("ButtonCompletedJob");
        markWorkAsCompletedButton.setLayoutX(136.0);
        markWorkAsCompletedButton.setLayoutY(258.0);
        markWorkAsCompletedButton.setMnemonicParsing(false);
        markWorkAsCompletedButton.setText("Mark my work as completed");

        label0.setLayoutX(10.0);
        label0.setLayoutY(295.0);
        label0.setText("Completed");
        label0.setFont(new Font(20.0));

        completedTable.setId("TBCompletedJobs");
        completedTable.setLayoutX(14.0);
        completedTable.setLayoutY(336.0);
        completedTable.setPrefHeight(190.0);
        completedTable.setPrefWidth(411.0);
        tab.setContent(anchorPane);

        tab0.setText("Leaded Working Groups");

        anchorPane0.setMinHeight(0.0);
        anchorPane0.setMinWidth(0.0);
        anchorPane0.setPrefHeight(180.0);
        anchorPane0.setPrefWidth(200.0);

        acceptApplicationButton.setId("ButtonAcceptAplpication");
        acceptApplicationButton.setLayoutX(139.0);
        acceptApplicationButton.setLayoutY(518.0);
        acceptApplicationButton.setMnemonicParsing(false);
        acceptApplicationButton.setText("Accept selected application");

        applicationsTable.setId("TBApplicationsForJob");
        applicationsTable.setLayoutX(15.0);
        applicationsTable.setLayoutY(298.0);
        applicationsTable.setPrefHeight(190.0);
        applicationsTable.setPrefWidth(399.0);

        label1.setLayoutX(17.0);
        label1.setLayoutY(259.0);
        label1.setText("Applications for the selected working group");
        label1.setFont(new Font(20.0));

        leadedTable.setId("TBLeader");
        leadedTable.setLayoutX(16.0);
        leadedTable.setLayoutY(43.0);
        leadedTable.setPrefHeight(190.0);
        leadedTable.setPrefWidth(399.0);

        label2.setLayoutX(17.0);
        label2.setLayoutY(13.0);
        label2.setText("Leaded");
        label2.setFont(new Font(20.0));
        tab0.setContent(anchorPane0);

        tab1.setText("Suggested Working Groups");

        anchorPane1.setMinHeight(0.0);
        anchorPane1.setMinWidth(0.0);
        anchorPane1.setPrefHeight(180.0);
        anchorPane1.setPrefWidth(200.0);

        label3.setLayoutX(16.0);
        label3.setLayoutY(18.0);
        label3.setText("Suggested");
        label3.setFont(new Font(20.0));

        suggestedTable.setId("TBSuggestedWorkingGroups");
        suggestedTable.setLayoutX(16.0);
        suggestedTable.setLayoutY(48.0);
        suggestedTable.setPrefHeight(470.0);
        suggestedTable.setPrefWidth(407.0);

        sendApplicationButton.setId("ButtonApplicationToGroup");
        sendApplicationButton.setLayoutX(82.0);
        sendApplicationButton.setLayoutY(524.0);
        sendApplicationButton.setMnemonicParsing(false);
        sendApplicationButton.setText("Send application for the selected working group");
        tab1.setContent(anchorPane1);

        label4.setLayoutX(621.0);
        label4.setLayoutY(14.0);
        label4.setText("About the selected working group");
        label4.setFont(new Font(20.0));

        label5.setLayoutX(494.0);
        label5.setLayoutY(87.0);
        label5.setText("Description");
        label5.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label5.setFont(new Font("System Bold", 12.0));

        label6.setLayoutX(493.0);
        label6.setLayoutY(144.0);
        label6.setText("Start Date");
        label6.setFont(new Font("System Bold", 12.0));

        label7.setLayoutX(492.0);
        label7.setLayoutY(208.0);
        label7.setText("Deadline Date");
        label7.setFont(new Font("System Bold", 12.0));

        label8.setLayoutX(492.0);
        label8.setLayoutY(265.0);
        label8.setText("Users");
        label8.setFont(new Font("System Bold", 12.0));

        label9.setLayoutX(492.0);
        label9.setLayoutY(324.0);
        label9.setText("Users Required");
        label9.setFont(new Font("System Bold", 12.0));

        label10.setLayoutX(492.0);
        label10.setLayoutY(389.0);
        label10.setText("All members finished the work");
        label10.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        label10.setFont(new Font("System Bold", 12.0));

        descriptionLabel.setLayoutX(749.0);
        descriptionLabel.setLayoutY(87.0);
        descriptionLabel.setText("Description of the selected working group will appear here");

        startDateLabel.setLayoutX(749.0);
        startDateLabel.setLayoutY(144.0);
        startDateLabel.setText("_ / _ / _");

        deadlineDateLabel.setLayoutX(748.0);
        deadlineDateLabel.setLayoutY(208.0);
        deadlineDateLabel.setText("_ / _ / _");

        usersLabel.setLayoutX(747.0);
        usersLabel.setLayoutY(265.0);
        usersLabel.setText("#");

        usersRequiredLabel.setLayoutX(747.0);
        usersRequiredLabel.setLayoutY(324.0);
        usersRequiredLabel.setText("#");

        completedLabel.setLayoutX(745.0);
        completedLabel.setLayoutY(389.0);
        completedLabel.setText("...");

        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(currentTable);
        anchorPane.getChildren().add(markWorkAsCompletedButton);
        anchorPane.getChildren().add(label0);
        anchorPane.getChildren().add(completedTable);
        tabPane.getTabs().add(tab);
        anchorPane0.getChildren().add(acceptApplicationButton);
        anchorPane0.getChildren().add(applicationsTable);
        anchorPane0.getChildren().add(label1);
        anchorPane0.getChildren().add(leadedTable);
        anchorPane0.getChildren().add(label2);
        tabPane.getTabs().add(tab0);
        anchorPane1.getChildren().add(label3);
        anchorPane1.getChildren().add(suggestedTable);
        anchorPane1.getChildren().add(sendApplicationButton);
        tabPane.getTabs().add(tab1);
        
        setBehaviour();
        
        getChildren().add(tabPane);
        getChildren().add(label4);
        getChildren().add(label5);
        getChildren().add(label6);
        getChildren().add(label7);
        getChildren().add(label8);
        getChildren().add(label9);
        getChildren().add(label10);
        getChildren().add(descriptionLabel);
        getChildren().add(startDateLabel);
        getChildren().add(deadlineDateLabel);
        getChildren().add(usersLabel);
        getChildren().add(usersRequiredLabel);
        getChildren().add(completedLabel);

    }
    
    public void setBehaviour()
    {
        currentTable.setOnMouseClicked(e->{
            WorkingGroup wg=currentTable.getSelected();
            if(wg!=null)
                updateAboutWorkingGroup(wg);
        });
        completedTable.setOnMouseClicked(e->{
            WorkingGroup wg=completedTable.getSelected();
            if(wg!=null)
                 updateAboutWorkingGroup(wg);
        });
        
        leadedTable.setOnMouseClicked(e->{
            WorkingGroup wg= leadedTable.getSelected();
            if(wg!=null)
            {
                updateAboutWorkingGroup(wg);
                MainApp.loadApplicationsForWorkingGroup(wg);
            }
        });
        
        
        //this has a double paramter that need to be considered
        suggestedTable.setOnMouseClicked(e->{
           //updateAboutWorkingGroup(wg);
        });
        
        markWorkAsCompletedButton.setOnMouseClicked(e->{
            //obtain from the table the working group
            WorkingGroup wg= currentTable.getSelected();
            if(wg!=null)
            {
                MainApp.markWorkAsComplited(wg);
                updateAboutWorkingGroup(wg);
            }
        });
        
        acceptApplicationButton.setOnMouseClicked(e->{
            //Manca la funzione che restituisce dal workingGroup ID il
            //Working group
            ApplicationWorkingGroup a=applicationsTable.getSelected();
            if(a!=null)
            {
                MainApp.acceptApplication(a);
                WorkingGroup wgSelected= leadedTable.getSelected();
                System.out.println(wgSelected);
                if(wgSelected!=null)
                {
                         MainApp.loadApplicationsForWorkingGroup(wgSelected);
                         updateAboutWorkingGroup(wgSelected);
                }
            }
        });
        
        // this has a double parameter in suggested we need to check 
       sendApplicationButton.setOnMouseClicked(e->{
            SuggestedWorkingGroups swg=suggestedTable.getSelected();
            if(swg!=null)
            {
                int wgId=swg.getWorkingGroupID();
                MainApp.sendApplication(wgId);
                WorkingGroup wgSelected= leadedTable.getSelected();
                if(wgSelected!=null)
                {
                                MainApp.loadApplicationsForWorkingGroup(wgSelected);
                }
            }
        });
                
        
        //mettere anche i button
        
    }
    
    public void addCurrent(List<WorkingGroup> wg){
        currentTable.setItems(wg);
    }
    
    public void addCompleted(List<WorkingGroup> wg){
        completedTable.setItems(wg);
    }
    
    public void addLeaded(List<WorkingGroup> wg){
        leadedTable.setItems(wg);
    }
    
    public void addApplications(List<ApplicationWorkingGroup> awg){
        applicationsTable.setItems(awg);
    }
    
    public void addSuggested(List<SuggestedWorkingGroups> swg){
        suggestedTable.setItems(swg);
    }
    
    public void updateAboutWorkingGroup(WorkingGroup wg)
    {
        descriptionLabel.setText(wg.getDescription());
        startDateLabel.setText(wg.getStartDate());
        deadlineDateLabel.setText(wg.getDeadlineDate());
        usersLabel.setText(String.valueOf(Neo4JManager.loadUsersInWorkingGroup(wg.getId()).size()));
        usersRequiredLabel.setText(String.valueOf(wg.getUsersRequired()));
        completedLabel.setText(String.valueOf(Neo4JManager.checkCompletedWork(wg)));
        
        // need job done or not , gestisci le casistiche 
    }
    
    

}
