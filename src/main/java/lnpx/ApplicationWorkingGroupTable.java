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
public class ApplicationWorkingGroupTable extends TableView<ApplicationWorkingGroup> {
    private ObservableList<ApplicationWorkingGroup> content;
    
    public ApplicationWorkingGroupTable(){
        super();
        TableColumn TCUsername=new TableColumn("Username");
        TCUsername.setCellValueFactory(new PropertyValueFactory<>("Username"));
        
        TableColumn TCTimestamp=new TableColumn("Timestamp");
        TCTimestamp.setCellValueFactory(new PropertyValueFactory<>("Timestamp"));
        
        TableColumn TCWorkingGroupID=new TableColumn("WorkingGroupID");
        TCWorkingGroupID.setCellValueFactory(new PropertyValueFactory<>("WorkingGroupID"));
        
        this.getColumns().addAll(TCUsername,TCTimestamp, TCWorkingGroupID);
        this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    
    public void setItems(List<ApplicationWorkingGroup> applicationArray)
    {
        this.getItems().clear();
        content= FXCollections.observableArrayList();
        content.addAll(applicationArray);
        this.getItems().clear();
        this.setItems(content);
        this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        System.out.println("Items impostati");
    }
    
    public ApplicationWorkingGroup getSelected() {
        return this.getSelectionModel().getSelectedItem();
    }
    
    public void relaseSelection() {
        this.getSelectionModel().clearSelection();
    }
    
    public void clear()
    {
        content.clear();
    }
}
