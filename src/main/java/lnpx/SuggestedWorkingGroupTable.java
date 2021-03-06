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
public class SuggestedWorkingGroupTable extends TableView<SuggestedWorkingGroups>{
    private ObservableList<SuggestedWorkingGroups> suggestedWorkingGroups;
    
    public SuggestedWorkingGroupTable()
    {
        super();
        TableColumn TCWorkingGroupID=new TableColumn("WorkingGroupID");
        TCWorkingGroupID.setCellValueFactory(new PropertyValueFactory<>("WorkingGroupID"));
        
        TableColumn TCAffinity=new TableColumn("Affinity");
        TCAffinity.setCellValueFactory(new PropertyValueFactory<>("Affinity"));
        
        TableColumn TCDescription=new TableColumn("Description");
        TCDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        
        this.getColumns().addAll(TCWorkingGroupID,TCAffinity,TCDescription);
        this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); 
    }
    
        public void setItems(List<SuggestedWorkingGroups> swg)
    {
        this.getItems().clear();
        suggestedWorkingGroups=FXCollections.observableArrayList();
        suggestedWorkingGroups.addAll(swg);
        
        this.setItems(suggestedWorkingGroups);
        this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    
        
    public WorkingGroup getSelected() {
        if(this.getSelectionModel().getSelectedItem()==null)
            return null;
        return this.getSelectionModel().getSelectedItem().getWg();
    }
    
}
