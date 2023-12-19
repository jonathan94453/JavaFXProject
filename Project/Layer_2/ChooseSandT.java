package Project.Layer_2;

import java.util.Random;

import Project.Layer_1.ChooseStart;
import javafx.animation.PauseTransition;
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

public class ChooseSandT {
    private Group sandtgroup;
    private Scene sandtscene;
    private double scenewidth;
    private double sceneheight;
    private Stage primaryStage; 
    private Button Start; 
    private Label title; 
    private TextField answer;
    private Label topscreen; 
    private PauseTransition pause99; 
    private double points; 


    public ChooseSandT(double scenewidth, double sceneheight, double points, Stage primaryStage, Button Start, Label title) {
        ChooseLHS pausemethod = new ChooseLHS(scenewidth, sceneheight, points, primaryStage, Start, title); 
        this.points = points; 
        this.scenewidth = scenewidth;
        this.sceneheight = sceneheight;
        this.primaryStage = primaryStage;
        this.Start = Start;
        this.title = title; 
        pause99 = pausemethod.getpause99(); 
        sandtgroup = new Group();
        sandtscene = new Scene(sandtgroup, 800, 800); 
        setscene("/SANDT.jpg"); 
    }

private void setscene(String imageString) {
    Image image = new Image(imageString); 
    ImageView sandtimage = new ImageView(image); 

sandtimage.setFitHeight(sandtscene.getHeight());
sandtimage.setFitWidth(sandtscene.getHeight()); 

Button back = new Button("Back"); 
back.setLayoutX(350);
back.setLayoutY(20); 
back.setOnAction(goback);

//TextField Prompt and Font objects and layouts 

answer = new TextField();
topscreen = new Label("Welcome to MST (Logan's College), Did you graduate (yes/no)"); 
Font promptfont = new Font("Times New Roman", 30); 
topscreen.setFont(promptfont);

// prompt and textfield layouts. 
topscreen.setLayoutX(30);
topscreen.setLayoutY(55);
topscreen.setTextFill(Color.WHITE);
answer.setLayoutX(300);
answer.setLayoutY(100);
answer.setOnAction(entertext);




    sandtgroup.getChildren().add(sandtimage); 
    sandtgroup.getChildren().add(back); 
    sandtgroup.getChildren().add(topscreen); 
    sandtgroup.getChildren().add(answer); 
}
public Scene getscene() {
    return sandtscene; 
}

EventHandler<ActionEvent> goback = new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
            ChooseStart gostart = new ChooseStart(scenewidth, sceneheight, points, primaryStage, Start, title);
            primaryStage.setScene(gostart.getscene());
    }
}; 
EventHandler<ActionEvent> entertext = new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
            String user_input = answer.getText(); 

if(user_input.equals("yes")) {
    Random random = new Random();
    int randomint = random.nextInt(100) + 1;
    if(randomint <= 50) {
        topscreen.setText("You landed a 6 figure engineering position at spacex");
        pause99.play();
    }
    else {
        topscreen.setText("umm you still need to pass algebra II");
        pause99.play(); 
    }
}

else if(user_input.equals("no")) {
    topscreen.setText("going to get your masters?");
       pause99.play();

}


else {
    topscreen.setText("Not a recognized input, please enter exactly (yes/no)");
    pause99.play(); 
}

    }
}; 


}
