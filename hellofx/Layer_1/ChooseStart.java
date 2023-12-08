package hellofx.Layer_1;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene; 

public class ChooseStart {
    private double sceneheight;
    private double scenewidth;
    private Button character;
    private Group root2;
    private Scene scene2; 

    public ChooseStart(double sceneheight, double scenewidth, Button character) {
        this.sceneheight = sceneheight;
        this.scenewidth = scenewidth;
        this.character = character; 
        initialize(); 
    }
    private void initialize() {
            root2 = new Group();
            scene2 = new Scene(root2, scenewidth, sceneheight); 
            setthescene("/Scene2.jpg"); 
    }



    public void setthescene(String environmentimage) {
        Image backgroundimage = new Image(getClass().getResourceAsStream(environmentimage));
        ImageView backgroundview = new ImageView(backgroundimage);
        root2.getChildren().add(backgroundview); 
        root2.getChildren().add(character);
        
    }
    public Scene getscene() {
        return scene2; 
    }
}
