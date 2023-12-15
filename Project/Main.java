// This project was not created with the assistance of any UI Designer or FXML Files 
//Everything is created and generated through Java and the Use of Javafx Libraries; 
package Project; 

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.Scene; 

// Main Class 
public class Main extends Application {
     public Scene currentscene; 
    @Override
    public void start(Stage primaryStage) throws Exception{
  // scenewidth and sceneheight are referenced in almost every class              
                final double scenewidth = 800; 
                final  double sceneheight = 800; 
// Title label class 
            Label Titlelabel = new Label("Welcome to Westrichia"); 
            Button Start = new Button(); 
            StartScreen background = new StartScreen(scenewidth, sceneheight, Titlelabel, Start, primaryStage); 
            setcurrentscene(background.getScene()); 
// Stage configuration (Icon is a house from the main village) 
            primaryStage.getIcons().add(new Image("/Scene2.jpg")); 
            primaryStage.setTitle("Westrichia");
            primaryStage.setScene(currentscene);
            primaryStage.show(); 
    }
//Scene returner 
public Scene setcurrentscene(Scene scene) {
    currentscene = scene;
    return currentscene; 
}
// Runner Class 
    public static void main(String[] args) {
        launch(args); 
    }
}