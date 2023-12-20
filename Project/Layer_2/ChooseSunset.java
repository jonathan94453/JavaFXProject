package Project.Layer_2;

import Project.Layer_1.ChooseStart;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class ChooseSunset {
    private Group sunroot;
    private Scene sunscene;
    private double scenewidth;
    private double sceneheight;
    private Stage primaryStage;
    private Button Start;
    private Label title; 
    private double points; 

    public ChooseSunset(double scenewidth, double sceneheight, double points, Stage primaryStage, Button Start, Label title) {
        this.points = points; 
        this.scenewidth = scenewidth;
        this.sceneheight = sceneheight;
        this.primaryStage = primaryStage;
        this.Start = Start;
        this.title = title; 
        sunroot = new Group();
        sunscene = new Scene(sunroot, sceneheight, scenewidth);
        setscene("/Sunset.jpg"); 
    }
private void setscene(String sunsetimage) {
    Image image = new Image(sunsetimage); 
    ImageView sunsetview = new ImageView(image); 

sunsetview.setFitWidth(sunscene.getWidth());
sunsetview.setFitHeight(sunscene.getHeight());

// Back Button 
Button back = new Button("Back");
back.setLayoutX(350);
back.setLayoutY(20);
back.setOnAction(goback);
Font Congratsfont = new Font("Times New Roman", 30); 
Label Congrats = new Label("Congratualations, you are now an engineer for lockheed martin\n making parking lots all over the world"); 
Congrats.setLayoutX(10);
Congrats.setLayoutY(200);
Congrats.setFont(Congratsfont); 










// Root adds
sunroot.getChildren().add(sunsetview); 
sunroot.getChildren().add(back); 
sunroot.getChildren().add(Congrats); 
    }
public Scene getscene() {
    return sunscene; 
}


EventHandler<ActionEvent> goback = new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
            ChooseStart gostart = new ChooseStart(scenewidth, sceneheight, points, primaryStage, Start, title);
            primaryStage.setScene(gostart.getscene());
    }



};

} 
