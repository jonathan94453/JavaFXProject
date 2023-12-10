package hellofx; 



import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.Group;
import javafx.scene.Scene; 
import javafx.util.Duration; 

public class Main extends Application { 

    @Override
    public void start(Stage primaryStage) throws Exception{
  //Initialize the Scene   
  private double scenewidth;
  private double sceneheight;

    scenewidth = 800; 
    sceneheight = 800; 
    Group originroot = new Group();
    Scene originscene = new Scene(originroot, scenewidth, sceneheight); 
    Font calculatorfont = Font.loadFont(getClass().getResourceAsStream("/valuoldcaps.ttf"), 30);
    Label welcome = new Label("Welcome to the Calculator"); 
    welcome.setLayoutX(200);
    welcome.setLayoutY(100);
    welcome.setFont(calculatorfont);
    Button Start = new Button("Continue"); 
    buttonhandler(Start, 400, 400, 30, 100);
    Label Credits = new Label(""); 
    String credits = "Credits \n Jonathan Cino \nwith the Assistance of Calvin Gross"; 
    Credits.setLayoutX(100);
    Credits.setLayoutY(400);
    Credits.setFont(calculatorfont); 
    
    Timeline animation = new Timeline();
    for(int i = 0; i <= credits.length(); i++) {
        int index = i; 
        KeyFrame keyframe = new KeyFrame(
            Duration.seconds(i * 0.1),
            event -> {
            Credits.setText(credits.substring(0, index));
            },
            new KeyValue(Credits.opacityProperty(), 1.0) 
        ); 
        animation.getKeyFrames().add(keyframe); 
    }
    
    animation.play(); 
    

//Root Children Adds 
    originroot.getChildren().add(welcome);            
    originroot.getChildren().add(Credits);
    originroot.getChildren().add(Start);  
                
primaryStage.getIcons().add(new Image("icon.jpg")); 
primaryStage.setTitle("Calculator");
primaryStage.setScene(originscene);
primaryStage.show(); 
    }


public void buttonhandler(Button button, double layoutx, double layouty, double minheight, double minwidth) {
    button.setLayoutX(layoutx); 
    button.setLayoutY(layouty);
    button.setMinHeight(minheight);
    button.setMinWidth(minwidth);
    }


//Event Handlers 
EventHandler<ActionEvent> Startonaction = new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
         final double scenewidth = originscene.getWidth();
         final double sceneheight = originscene.getHeight(); 
         
        calculator object = new calculator(scenewidth, sceneheight, primaryStage);
         primaryStage.setScene(object.getScene()); 
    }
}; 

    public static void main(String[] args) {
        launch(args); 
    }
}