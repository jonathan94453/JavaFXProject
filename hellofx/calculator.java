package hellofx;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class calculator {
    private double scenewidth;
    private double sceneheight;
    private Stage primaryStage;
    private Group origin2root;
    private Scene calculatorscene;
    private Font defaultfont; 

    public calculator(double scenewidth, double sceneheight, Stage primaryStage, Font defaultfont) {
        this.scenewidth = scenewidth;
        this.sceneheight = sceneheight;
        this.primaryStage = primaryStage; 
        this.defaultfont = defaultfont; 
        initialize();
    }

public void initialize() {
    origin2root = new Group();
    calculatorscene = new Scene(origin2root, scenewidth, sceneheight); 
    setscene();

}
private void setscene() {
    Label objectlabel = new Label("This is a new scene");
    objectlabel.setFont(defaultfont);
    labelhandler(objectlabel, 400, 400);
    origin2root.getChildren().add(objectlabel); 
}


public Scene getScene() {
    return calculatorscene; 
}


private void labelhandler(Label button, double layoutx, double layouty) {
    button.setLayoutX(layoutx); 
    button.setLayoutY(layouty);
    
    }

    
}
