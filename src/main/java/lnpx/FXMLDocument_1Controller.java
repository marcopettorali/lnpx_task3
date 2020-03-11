/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lnpx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Riccardo
 */
public class FXMLDocument_1Controller implements Initializable {

    @FXML
    private TableView<?> currentTable;
    @FXML
    private TableView<?> completedTable;
    @FXML
    private Button markWorkAsCompletedButton;
    @FXML
    private Button acceptApplicationButton;
    @FXML
    private TableView<?> leadedTable;
    @FXML
    private TableView<?> applicationsTable;
    @FXML
    private TableView<?> suggestedTable;
    @FXML
    private Button sendApplicationButton;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label startDateLabel;
    @FXML
    private Label usersLabel;
    @FXML
    private Label usersRequiredLabel;
    @FXML
    private Label deadlineDateLabel;
    @FXML
    private Label completedLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
