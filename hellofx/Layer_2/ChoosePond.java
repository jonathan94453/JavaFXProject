package hellofx.Layer_2;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChoosePond {
  
    private Group pondroot;
    private Scene pondscene; 

public ChoosePond() {
    initialize(); 
}

private void initialize() {
    pondroot = new Group();
    pondscene = new Scene(pondroot, 900, 400); 
    setscene("/Pond.jpg"); 
}

    
private void setscene(String pondimage) {
    Image image = new Image(pondimage);
    ImageView pondimageview = new ImageView(image);




    




pondroot.getChildren().add(pondimageview); 
}

public Scene getscene() {
    return pondscene; 
}



}
