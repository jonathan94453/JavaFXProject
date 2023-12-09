package hellofx.Layer_1;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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

public ChooseHouse(double scenewidth, double sceneheight, Stage primaryStage) {
    this.scenewidth = scenewidth; 
    this.sceneheight = sceneheight; 
    this.primaryStage = primaryStage; 
    initialize();
}

private void initialize() {
        root4 = new Group(); 
        housescene = new Scene(root4, scenewidth, sceneheight); 
        sethousescene("/Scene2.JPG"); 
}

private void sethousescene(String image) {

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
}

public Scene getscenehouse() {
    return housescene; 
}



}
