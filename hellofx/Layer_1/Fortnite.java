package hellofx.Layer_1;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Fortnite {
    private double scenewidth;
    private double sceneheight;
    private Group fortroot;
    private Scene fortscene; 

    public Fortnite(double scenewidth, double sceneheight) {
        this.sceneheight = sceneheight;
        this.scenewidth = scenewidth;
        initialize(); 
    }

private void initialize() {
    fortroot = new Group();
    fortscene = new Scene(fortroot, scenewidth, sceneheight); 
    setscene("/Fortnite.jpg"); 
}

public void setscene(String background) {
    Image backgroundimage = new Image(getClass().getResourceAsStream(background));
    ImageView backgroundview = new ImageView(backgroundimage); 
    backgroundview.setFitHeight(sceneheight);
    backgroundview.setFitWidth(scenewidth);






    fortroot.getChildren().add(backgroundview); 
}

public Scene getscene() {
    return fortscene; 
}



}
