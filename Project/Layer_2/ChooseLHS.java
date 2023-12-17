package Project.Layer_2;

import Project.Layer_1.ChooseStart;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ChooseLHS {
    private Group lhsroot;
    private Scene lhsscene; 
    private double scenewidth;
    private double sceneheight;
    private Stage primaryStage;
    private Button Start;
    private Label title; 


    public ChooseLHS(double scenewidth, double sceneheight, Stage primaryStage, Button Start, Label title) {
        this.scenewidth = scenewidth;
        this.sceneheight = sceneheight; 
        this.primaryStage = primaryStage;
        this.Start = Start;
        this.title = title; 
        intialize(); 
    }
private void intialize() {
    lhsroot = new Group();
    lhsscene = new Scene(lhsroot, 800, 800); 
    setscene("/LHS.jpg"); 
}

private void setscene(String gfimage) {
    Image image = new Image(gfimage); 
    ImageView gfimages = new ImageView(image); 
    gfimages.setFitWidth(lhsscene.getWidth());
    gfimages.setFitHeight(lhsscene.getHeight()); 
    TextField answer = new TextField(); 
    Label topscreen = new Label("Welcome to LHS"); 
    Button back = new Button("Back"); 
    back.setLayoutX(500);
    back.setLayoutY(50); 
    back.setOnAction(goback);
    answer.setLayoutX(400);
    answer.setLayoutY(300);

    topscreen.setLayoutX(300);
    topscreen.setLayoutY(100);;









lhsroot.getChildren().add(gfimages); 
lhsroot.getChildren().add(answer);
lhsroot.getChildren().add(topscreen); 
lhsroot.getChildren().add(back); 

}

public Scene getscene() {
    return lhsscene; 
}
EventHandler<ActionEvent> goback = new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
            ChooseStart gostart = new ChooseStart(scenewidth, sceneheight, primaryStage, Start, title);
            primaryStage.setScene(gostart.getscene());
    }
}; 

}
