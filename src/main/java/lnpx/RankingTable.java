/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lnpx;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Riccardo
 */
public class RankingTable extends TableView<UserRanking>{
    
    private ObservableList<UserRanking> UserRank;
    
    public RankingTable()
    {
        super();
        TableColumn TCUsername=new TableColumn("Username");
        TCUsername.setCellValueFactory(new PropertyValueFactory<>("Username"));
        
        TableColumn TCRanking=new TableColumn("Ranking");
        TCRanking.setCellValueFactory(new PropertyValueFactory<>("Ranking"));
        
        this.getColumns().addAll(TCUsername,TCRanking);
        this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    
    public void setItems(List<UserRanking> ur)
    {
        this.getItems().clear();
        UserRank=FXCollections.observableArrayList();
        UserRank.addAll(ur);
        
        this.setItems(UserRank);
        this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    
    
}
