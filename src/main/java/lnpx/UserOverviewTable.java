/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lnpx;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 *
 * @author Riccardo
 */
public class UserOverviewTable extends TableView<User> {
    private ObservableList<User> content;
    
    public UserOverviewTable()
    {
        super();
        TableColumn TCUserID=new TableColumn("Username");
        TCUserID.setCellValueFactory(new PropertyValueFactory<>("Username"));
          
        TableColumn TCadminStatus=new TableColumn("AdminLvl");
        TCadminStatus.setCellValueFactory(new PropertyValueFactory<>("AdminLvl"));
        
        TableColumn TCFirstName=new TableColumn("FirstName");
        TCFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        
        TableColumn TClastName=new TableColumn("LastName");
        TClastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        
        TableColumn TCMatNumber=new TableColumn("MatriculationNum");
        TCMatNumber.setCellValueFactory(new PropertyValueFactory<>("MatriculationNum"));
        
        TableColumn TCemail=new TableColumn("Email");
        TCemail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        
        
        this.getColumns().addAll(TCUserID,TCMatNumber,TCadminStatus,TCemail,TCFirstName,TClastName);
        this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
    }
    
    public void setItems(List<User> userArray)
    {
        this.getItems().clear();
        content= FXCollections.observableArrayList();
        content.addAll(userArray);
        this.getItems().clear();
        this.setItems(content);
        this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        System.out.println("Items impostati");
    }
    
    public User getSelected() {
        return this.getSelectionModel().getSelectedItem();
    }
    
    public void relaseSelection() {
        this.getSelectionModel().clearSelection();
    }

    public ObservableList<User> getContent() {
        return content;
    }

    public static Callback<ResizeFeatures, Boolean> getUNCONSTRAINED_RESIZE_POLICY() {
        return UNCONSTRAINED_RESIZE_POLICY;
    }

    public static Callback<ResizeFeatures, Boolean> getCONSTRAINED_RESIZE_POLICY() {
        return CONSTRAINED_RESIZE_POLICY;
    }

    public static Callback<TableView, Boolean> getDEFAULT_SORT_POLICY() {
        return DEFAULT_SORT_POLICY;
    }

    public static double getUSE_PREF_SIZE() {
        return USE_PREF_SIZE;
    }

    public static double getUSE_COMPUTED_SIZE() {
        return USE_COMPUTED_SIZE;
    }

    public static double getBASELINE_OFFSET_SAME_AS_HEIGHT() {
        return BASELINE_OFFSET_SAME_AS_HEIGHT;
    }
    
}
