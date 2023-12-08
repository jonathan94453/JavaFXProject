package hellofx; 

import hellofx.Layer_1.ChooseStart;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene; 


public class Main extends Application {
     public Scene currentscene; 
    @Override
    public void start(Stage primaryStage) throws Exception{
                
                double scenewidth = 800;
                double sceneheight = 800; 
                Label Titlelabel = new Label("Welcome to Westrichia"); 
                Button Start = new Button(); 
                environment2d background = new environment2d(scenewidth, sceneheight, Titlelabel, Start, primaryStage); 
                setcurrentscene(background.getScene()); 

                    primaryStage.setTitle("Westrichia");
                    primaryStage.setScene(currentscene);
                    primaryStage.show(); 
    }

public Scene setcurrentscene(Scene scene) {
    currentscene = scene;
    return currentscene; 
}

    public static void main(String[] args) {
        launch(args); 
    }
}