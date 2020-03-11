/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lnpx;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Riccardo
 */
public class WorkingGroupTable extends TableView<WorkingGroup> {
    private ObservableList<WorkingGroup> workingGroups;
    
    public WorkingGroupTable()
    {
        super();
        TableColumn TCId=new TableColumn("Id");
        TCId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        
        TableColumn TCDescription=new TableColumn("Description");
        TCDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        
        TableColumn TCStartDate=new TableColumn("StartDate");
        TCStartDate.setCellValueFactory(new PropertyValueFactory<>("StartDate"));
        
        TableColumn TCDeadlineDate=new TableColumn("DeadlineDate");
        TCDeadlineDate.setCellValueFactory(new PropertyValueFactory<>("DeadlineDate"));
        
        TableColumn TCUsersRequired=new TableColumn("UsersRequired");
        TCUsersRequired.setCellValueFactory(new PropertyValueFactory<>("UsersRequired"));
        
        TableColumn TCCompleted=new TableColumn("Completed");
        TCCompleted.setCellValueFactory(new PropertyValueFactory<>("Completed"));
        
        this.getColumns().addAll(TCId,TCDescription,TCStartDate,TCDeadlineDate,TCUsersRequired,TCCompleted);
        this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);    
    }
    
    public void setItems(List<WorkingGroup> wg)
    {
        this.getItems().clear();
        workingGroups=FXCollections.observableArrayList();
        workingGroups.addAll(wg);
        
        this.setItems(workingGroups);
        this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    
        
    public WorkingGroup getSelected() {
        return this.getSelectionModel().getSelectedItem();
    }
}
