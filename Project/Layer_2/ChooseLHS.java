package Project.Layer_2;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChooseLHS {
    private Group lhsroot;
    private Scene lhsscene; 


    public ChooseLHS() {
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












lhsroot.getChildren().add(gfimages); 


}

public Scene getscene() {
    return lhsscene; 
}


}
