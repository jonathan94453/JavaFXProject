package hellofx; 

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
double scenewidth = 800;
double sceneheight = 800; 
Label Titlelabel = new Label("Welcome to Eutopia"); 
Button Start = new Button(); 
environment2d background = new environment2d(scenewidth, sceneheight, Titlelabel, Start); 
primaryStage.setScene(background.getScene());
        primaryStage.show(); 
    }

    public static void main(String[] args) {
        launch(args); 
    }
}