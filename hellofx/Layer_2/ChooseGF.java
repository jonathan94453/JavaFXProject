package hellofx.Layer_2;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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













gfroot.getChildren().add(gfimages); 


}

public Scene getscene() {
    return gfscene; 
}





}
