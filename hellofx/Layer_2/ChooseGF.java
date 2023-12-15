package hellofx.Layer_2;

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


public class ChooseGF {
    private Group gfroot;
    private Scene gfscene; 
    private TextField answer;
    private Label question; 
    private double scenewidth;
    private double sceneheight;
    private Label title;
    private Button Start;
    private Stage primaryStage; 
    public ChooseGF(double scenewidth,  double sceneheight, Label title, Button Start, Stage primaryStage) {
        this.scenewidth = scenewidth;
        this.sceneheight = sceneheight;
        this.title = title;
        this.Start = Start;
        this.primaryStage = primaryStage; 
        intialize(); 
    }
private void intialize() {
    gfroot = new Group();
    gfscene = new Scene(gfroot, 800, 800); 
    setscene("/gf.jpg"); 
}

private void setscene(String gfimage) {
    Image image = new Image(gfimage); 
    ImageView gfimages = new ImageView(image); 
    gfimages.setFitWidth(gfscene.getWidth());
    gfimages.setFitHeight(gfscene.getHeight()); 

answer = new TextField();
question = new Label("Welcome to your girlfriends house, do you want to enter? (yes/no)"); 
Font answerfont = new Font("Times New Roman", 25); 
question.setLayoutX(55);
question.setLayoutY(100);

answer.setLayoutX(200);
answer.setLayoutY(200);
answer.setFont(answerfont);
answer.setOnAction(enteranswer);
question.setFont(answerfont);
question.setTextFill(Color.WHITE);












gfroot.getChildren().add(gfimages); 
gfroot.getChildren().add(question);
gfroot.getChildren().add(answer); 
}

public Scene getscene() {
    return gfscene; 
}



EventHandler<ActionEvent> enteranswer = new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
            String user_input = answer.getText();

if(user_input.equals("yes")) {
    question.setText("Sorry but you dont have a girlfriend");
    PauseTransition pause60 = new PauseTransition(Duration.seconds(1)); 
    pause60.setOnFinished(event -> {
        question.setText("....Yet?");
    });
    PauseTransition pause61 = new PauseTransition(Duration.seconds(2)); 
    pause61.setOnFinished(event -> {
        pause60.play();
        ChooseStart start80 = new ChooseStart(sceneheight, scenewidth, primaryStage, Start, title); 
        primaryStage.setScene(start80.getscene());
    }); 




    pause61.play(); 
}
    }
}; 

}
