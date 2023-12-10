package hellofx.Layer_1;
import java.util.Random;

import hellofx.QuitProgram;
import hellofx.environment2d;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration; 


public class ChooseHouse {
    private double scenewidth; 
    private double sceneheight;
    private Stage primaryStage;
    private Group root4; 
    private Scene housescene; 
    private TextField answer;
    private Label Question; 
    private Label Titlelabel; 
    private Button Start; 
    private Font Questionfont; 
public ChooseHouse(double scenewidth, double sceneheight, Label Titlelabel, Stage primaryStage, Button Start) {
    this.scenewidth = scenewidth; 
    this.sceneheight = sceneheight; 
    this.primaryStage = primaryStage; 
    this.Titlelabel = Titlelabel; 
    this.Start = Start; 
    initialize();
}

private void initialize() {
        root4 = new Group(); 
        housescene = new Scene(root4, scenewidth, sceneheight); 
        sethousescene("/Scene2.JPG"); 
}

private void sethousescene(String image) {
Question = new Label();
Question.setText("What would you like to do? \nStudy or Play Fortnite?");
Questionfont = Font.loadFont(getClass().getResourceAsStream("/PAC-FONT.TTF"), 15); 
Question.setLayoutX(15);
Question.setLayoutY(200);
Question.setFont(Questionfont);

answer = new TextField();
answer.setLayoutX(10); 
answer.setLayoutY(300);
answer.setOnAction(answerentered);



Image picture = new Image(image); 
ImageView viewimage = new ImageView(picture);

viewimage.setFitHeight(sceneheight);
viewimage.setFitWidth(scenewidth);
Font welcomesLabelFont = Font.loadFont(getClass().getResourceAsStream("/PAC-FONT.TTF"), 20); 
String welcome = "Welcome to Logan Westriches House"; 

Label welcomesLabel = new Label(""); 
welcomesLabel.setLayoutX(100);
welcomesLabel.setFont(welcomesLabelFont); 

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









root4.getChildren().add(viewimage); 
root4.getChildren().add(welcomesLabel); 
root4.getChildren().add(Question);
root4.getChildren().add(answer); 
}

public Scene getscenehouse() {
    return housescene; 
}
EventHandler<ActionEvent> answerentered = new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
    String user_input = answer.getText(); 
    if (user_input.equals("Study")) {
        Random random = new Random();
        int randomint = random.nextInt(10) + 1;
        if(randomint == 5) {
            Question.setFont(Questionfont);
            Question.setText("Congrats you studied");
            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(event -> {
                ChooseStart scene2 = new ChooseStart(sceneheight, scenewidth, primaryStage, Start, Titlelabel); 
                primaryStage.setScene(scene2.getscene()); 
        });
        pause.play();   
        } 

        else {
            Question.setFont(Questionfont);
            Question.setText("Sorry, you got distracted and played \nfornite with Jacob for 5 hours");
            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(event -> {
            QuitProgram quitfully = new QuitProgram(scenewidth, sceneheight); 
            primaryStage.setScene (quitfully.getvideoscene());
        });
        pause.play(); 
        }
    }
}
}; 


}
