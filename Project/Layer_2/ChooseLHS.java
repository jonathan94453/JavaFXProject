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
import javafx.util.Duration;

public class ChooseLHS {
    private Group lhsroot;
    private Scene lhsscene; 
    private double scenewidth;
    private double sceneheight;
    private Stage primaryStage;
    private Button Start;
    private Label title; 
    private TextField answer; 
    private Label topscreen; 
    private PauseTransition pause99; 
    private double points; 

    public ChooseLHS(double scenewidth, double sceneheight, double points, Stage primaryStage, Button Start, Label title) {
        this.points = points; 
        this.scenewidth = scenewidth;
        this.sceneheight = sceneheight; 
        this.primaryStage = primaryStage;
        this.Start = Start;
        this.title = title; 
        intialize(); 
    }
    private Boolean checkifover() {
            Boolean check = false;
            if(points > 500) {
                check = true;
            }
            return check; 
    }
    private void endscene() {
        ChooseSunset end = new ChooseSunset(scenewidth, sceneheight, points, primaryStage, Start, title);
        primaryStage.setScene(end.getscene());
    }
private void intialize() {
    lhsroot = new Group();
    lhsscene = new Scene(lhsroot, 800, 800);
    pause99 = new PauseTransition(Duration.seconds(3));
        pause99.setOnFinished(event ->{
            if(checkifover() == true) {
                endscene();
            }
            else if(checkifover() != true) {
            ChooseStart start = new ChooseStart(sceneheight, scenewidth, points, primaryStage, Start, title);
            primaryStage.setScene(start.getscene());
            }
        }); 
    setscene("/LHS.jpg"); 
}

private void setscene(String gfimage) {
    Image image = new Image(gfimage); 
    ImageView gfimages = new ImageView(image); 
    gfimages.setFitWidth(lhsscene.getWidth());
    gfimages.setFitHeight(lhsscene.getHeight()); 
    answer = new TextField(); 
    topscreen = new Label("Welcome to LHS! Are you on Honor Roll? (yes/no)"); 
    Button back = new Button("Back");
    Font topscreenfont = new Font("Times New Roman", 30); 
    back.setLayoutX(300);
    back.setLayoutY(30); 
    back.setOnAction(goback);

// TextField and layout 
    answer.setMinWidth(100);
    answer.setMinHeight(30); 
    answer.setLayoutX(370);
    answer.setLayoutY(200);
    answer.setOnAction(entertext);
    topscreen.setFont(topscreenfont); 
    topscreen.setTextFill(Color.WHITE);
    topscreen.setLayoutX(60);
    topscreen.setLayoutY(100);;









lhsroot.getChildren().add(gfimages); 
lhsroot.getChildren().add(answer);
lhsroot.getChildren().add(topscreen); 
lhsroot.getChildren().add(back); 

}

public Scene getscene() {
    return lhsscene; 
}

public EventHandler<ActionEvent> getentertext() {
    return entertext; 
}

public PauseTransition getpause99() {
    return pause99; 
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
        points += 100; 
        topscreen.setText("Wow! your so smart?!");
        pause99.play();
    }
    else {   
        points -= 50; 
        topscreen.setText("no you didn't...");
        pause99.play(); 
    }
}

else if(user_input.equals("no")) {
    points -= 50; 
    topscreen.setText("Maybe next time :(");
       pause99.play();

}


else {
    topscreen.setText("Not a recognized input, please enter exactly (yes/no)");
    pause99.play(); 
}

















    }
}; 

}
