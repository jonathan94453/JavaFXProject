package hellofx.Layer_1;
import java.util.Random;
// Used Imports 
import hellofx.QuitProgram;
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


public class ChooseHouse {
// Instance Variables- 
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
// Paramterized Constructor, datapassing into the object for the scene construction 
public ChooseHouse(double scenewidth, double sceneheight, Label Titlelabel, Stage primaryStage, Button Start) {
    this.scenewidth = scenewidth; 
    this.sceneheight = sceneheight; 
    this.primaryStage = primaryStage; 
    this.Titlelabel = Titlelabel; 
    this.Start = Start; 
    initialize();
}
// intialize class for the scene and group of nodes objects 
private void initialize() {
        root4 = new Group(); 
        housescene = new Scene(root4, scenewidth, sceneheight); 
        sethousescene("/Scene2.JPG"); 
}
// Scene Architecture for when the house is clicked 
private void sethousescene(String image) {
// Question Variable to prompt the user input 
Question = new Label();
Question.setText("What would you like to do? \nStudy or Play Fortnite?");
Questionfont = new Font("Arial", 15); 
Question.setTextFill(Color.BLACK); 
Question.setLayoutX(15);
Question.setLayoutY(200);
Question.setFont(Questionfont);
// Figured out you can use TextField to collect user_input with javafx; 
answer = new TextField();
answer.setLayoutX(10); 
answer.setLayoutY(300);
answer.setOnAction(answerentered);


// Creates a new imageview object for the Background picture of the hosue; 
Image picture = new Image(image); 
ImageView viewimage = new ImageView(picture);

viewimage.setFitHeight(sceneheight);
viewimage.setFitWidth(scenewidth);
// Hard Task to find the pacman font from a TTF file from the internet, 
// But this loads it from the internet 
Font welcomesLabelFont = new Font("Arial", 20); 
String welcome = "Welcome to Logan Westriches House";

// Hard to figure out how to animate the text, but this is my 
// Best representation of it; 
Label welcomesLabel = new Label(""); 
welcomesLabel.setTextFill(Color.BLACK); 
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








// Add nodes to the group; One thing I learned 
// They have to be in order if you want them each to show up in the right spots 
// Have them in order of how 
root4.getChildren().add(viewimage); 
root4.getChildren().add(welcomesLabel); 
root4.getChildren().add(Question);
root4.getChildren().add(answer);  
}
// Return House Scene 
public Scene getscenehouse() {
    return housescene; 
}
// Event Handler when something is entered into texfield 
EventHandler<ActionEvent> answerentered = new EventHandler<ActionEvent>() {;
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
    }
else if(user_input.equals("Play Fortnite")) {
            Random random2 = new Random();
            int randomint2 = random2.nextInt(10) + 1;
            if (randomint2 == 5) {
                Question.setFont(Questionfont);
                Question.setText("Congrats you got a victory royale"); 
                PauseTransition pause = new PauseTransition(Duration.seconds(3)); 
                pause.setOnFinished(event -> {
                        Fortnite newfortnite = new Fortnite(scenewidth, sceneheight);
                        primaryStage.setScene(newfortnite.getscene()); 
                }); 
                pause.play();   
                

            }
            else {
                Question.setText("You lost and got emoted on by a 9 year old");
                PauseTransition pause2 = new PauseTransition(Duration.seconds(3)); 
                pause2.setOnFinished(event -> {
                        QuitProgram lost = new QuitProgram(scenewidth, sceneheight);
                        primaryStage.setScene(lost.getscene3());
                });
                pause2.play();   
               
            }
        }

else {
            Question.setFont(Questionfont);
            Question.setText("Sorry, you got distracted and played \nfornite for 5 hours");
            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.setOnFinished(event -> {
            QuitProgram quitfully = new QuitProgram(scenewidth, sceneheight); 
            primaryStage.setScene (quitfully.getvideoscene());
        });
        pause.play(); 
        }
    






    }

};
} 
