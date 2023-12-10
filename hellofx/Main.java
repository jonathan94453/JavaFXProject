package hellofx; 

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.Group;
import javafx.scene.Scene; 


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
  //Initialize the Scene               
    double scenewidth = 1000; 
    double sceneheight = 800; 
    Group originroot = new Group();
    Scene originscene = new Scene(originroot, scenewidth, sceneheight); 
    Font calculatorfont = Font.loadFont(getClass().getResourceAsStream("/valuoldcaps.ttf"), 50);
    Label welcome = new Label("Welcome to the Calculator"); 
    welcome.setLayoutX(20);
    welcome.setLayoutY(100);
    welcome.setFont(calculatorfont);


        
//Root Children Adds 
    originroot.getChildren().add(welcome);            
               
                
primaryStage.getIcons().add(new Image("icon.jpg")); 
primaryStage.setTitle("Calculator");
primaryStage.setScene(originscene);
primaryStage.show(); 
    }

//Event Handlers 

    public static void main(String[] args) {
        launch(args); 
    }
}