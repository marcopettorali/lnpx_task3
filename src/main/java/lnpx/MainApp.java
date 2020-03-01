package lnpx;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static lnpx.Neo4JManager.insertUser;
import static lnpx.Neo4JManager.insertWorkingGroup;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //launch(args);
        Neo4JManager.connectToDB("bolt://localhost:7687","Graph","");
        //Neo4JManager.createTestDB();
       Map<User,Double> us = Neo4JManager.loadLeadersRanking();
       System.out.println(us.keySet().iterator().next().getUsername()+" "+us.get(us.keySet().iterator().next()));
        Neo4JManager.closeDB();
    }

}
