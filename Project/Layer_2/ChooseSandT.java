package Project.Layer_2;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChooseSandT {
    private Group sandtgroup;
    private Scene sandtscene;


    public ChooseSandT() {
        sandtgroup = new Group();
        sandtscene = new Scene(sandtgroup, 800, 800); 
        setscene("/SANDT.jpg"); 
    }

private void setscene(String imageString) {
    Image image = new Image(imageString); 
    ImageView sandtimage = new ImageView(image); 

sandtimage.setFitHeight(sandtscene.getHeight());
sandtimage.setFitWidth(sandtscene.getHeight()); 










    sandtgroup.getChildren().add(sandtimage); 
}









public Scene getscene() {
    return sandtscene; 
}

}
