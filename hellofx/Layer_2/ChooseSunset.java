package hellofx.Layer_2;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ChooseSunset {
    private Group sunroot;
    private Scene sunscene;

    public ChooseSunset() {
        sunroot = new Group();
        sunscene = new Scene(sunroot, 350, 276);
        setscene("/Sunset.jpg"); 
    }
private void setscene(String sunsetimage) {
    Image image = new Image(sunsetimage); 
    ImageView sunsetview = new ImageView(image); 











sunroot.getChildren().add(sunsetview); 









    }
public Scene getscene() {
    return sunscene; 
}
}
