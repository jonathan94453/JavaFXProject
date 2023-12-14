package hellofx.Layer_2;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class ChooseGF {
    private Group gfroot;
    private Scene gfscene; 
    public ChooseGF() {
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

TextField answer = new TextField();
Label question = new Label("Welcome to your girlfriends house, do you want to enter?"); 
Font answerfont = new Font("Times New Roman", 30); 
question.setLayoutX(200);
question.setLayoutY(100);
answer.setLayoutX(300);
answer.setLayoutY(200);
answer.setFont(answerfont);

question.setFont(answerfont);
question.setTextFill(Color.WHITE);












gfroot.getChildren().add(gfimages); 
gfroot.getChildren().add(question);
gfroot.getChildren().add(answer); 
}

public Scene getscene() {
    return gfscene; 
}





}
