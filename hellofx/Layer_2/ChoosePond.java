package hellofx.Layer_2;




import java.util.Random;

import hellofx.QuitProgram;
import hellofx.StartScreen;
import hellofx.Layer_1.ChooseStart;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ChoosePond {
  
    private Group pondroot;
    private Scene pondscene; 
    private TextField answer;
    private Label question; 
    private double scenewidth;
    private double sceneheight;
    private Stage primaryStage;
    private Label title; 
    private Button start; 
public ChoosePond(double scenewidth, double sceneheight, Label title, Button start, Stage primaryStage) {
    this.scenewidth = scenewidth;
    this.sceneheight = sceneheight;
    this.title = title;
    this.start = start;
    this.primaryStage = primaryStage; 
    initialize(); 
}

private void initialize() {
    pondroot = new Group();
    pondscene = new Scene(pondroot, 800, 800); 
    setscene("/Pond.jpg"); 
}

    
private void setscene(String pondimage) {
    Image image = new Image(pondimage);
    ImageView pondimageview = new ImageView(image);

pondimageview.setFitWidth(pondscene.getWidth());
pondimageview.setFitHeight(pondscene.getHeight());

Font answerfont = new Font("Times New Roman", 20); 
answer = new TextField();
question = new Label("If you would like to fish enter-(cast/quit)");

question.setLayoutX(300);
question.setLayoutY(100);
answer.setLayoutX(300);
answer.setLayoutY(200);
answer.setFont(answerfont);
answer.setOnAction(enteranswer);
question.setFont(answerfont);
question.setTextFill(Color.WHITE);

Label welcomesLabel = new Label(""); 
String welcome = "Welcome to the Pond where Logan fishes"; 
Font welcomefont = new Font("Times New Roman", 35); 
welcomesLabel.setTextFill(Color.WHITE); 
welcomesLabel.setLayoutY(50);
welcomesLabel.setLayoutX(100);
welcomesLabel.setFont(welcomefont); 

Timeline animation = new Timeline();
for(int i = 0; i <= welcome.length(); i++) {
    int index = i; 
    KeyFrame keyframe = new KeyFrame(
        Duration.seconds(i * 0.1),
        event -> {
        welcomesLabel.setText(welcome.substring(0, index));
        },
        new KeyValue(welcomesLabel.opacityProperty(), 1.0) 
    ); 
    animation.getKeyFrames().add(keyframe); 
}

animation.play(); 












pondroot.getChildren().add(pondimageview); 
pondroot.getChildren().add(question);
pondroot.getChildren().add(answer); 
pondroot.getChildren().add(welcomesLabel); 

}

public Scene getscene() {
    return pondscene; 
}

EventHandler<ActionEvent> enteranswer = new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
            String user_input = answer.getText(); 

if(user_input.equals("cast")) {
    Random random = new Random(); 
    int randomint = random.nextInt(10) + 1;
            if(randomint == 5) {
                question.setText("Congratualations you got a Fish!!");
                PauseTransition pause4 = new PauseTransition(Duration.seconds(4));
                pause4.setOnFinished(event -> {
                        ChooseStart scene6 = new ChooseStart(sceneheight, scenewidth, primaryStage, start, title); 
                        primaryStage.setScene(scene6.getscene());  
                }); 
                pause4.play();
            }

            else {
                question.setText("You did not catch anything, try again later"); 
                PauseTransition pause3 = new PauseTransition(Duration.seconds(2));
                PauseTransition pause4 = new PauseTransition(Duration.seconds(4));
                pause4.setOnFinished(event -> {
                        ChooseStart scene6 = new ChooseStart(sceneheight, scenewidth, primaryStage, start, title); 
                        primaryStage.setScene(scene6.getscene());  
                }); 
                pause3.setOnFinished(event -> {
                    QuitProgram program1 = new QuitProgram(sceneheight, scenewidth); 
                    primaryStage.setScene(program1.getvideoscene());  
                    pause4.play(); 
            });
            pause3.play();  
    
        
                 

            }


}

else if(user_input.equals("quit")) {
    question.setText("Ok, you will be directed to the map again shortly"); 
    PauseTransition pause8 = new PauseTransition(Duration.seconds(2));
                pause8.setOnFinished(event -> {
                        ChooseStart scene6 = new ChooseStart(sceneheight, scenewidth, primaryStage, start, title); 
                        primaryStage.setScene(scene6.getscene());  
                }); 
                pause8.play();
    
}

else {
    question.setText("Sorry that is not a valid object, please type cast or quit"); 
     PauseTransition pause23 = new PauseTransition(Duration.seconds(2));
                pause23.setOnFinished(event -> {
                        StartScreen restart = new StartScreen(scenewidth, sceneheight, title, start, primaryStage); 
                        primaryStage.setScene(restart.getScene());  
                }); 
                pause23.play();
}





    }
}; 

}
