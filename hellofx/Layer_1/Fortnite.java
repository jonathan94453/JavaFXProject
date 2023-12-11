package hellofx.Layer_1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    Button Quit = new Button("Quit");
    Quit.setLayoutX(400);
    Quit.setLayoutY(200);
    Quit.setMinHeight(20);
    Quit.setMinWidth(100);
    Quit.setOnAction(quitapplication); 




    fortroot.getChildren().add(backgroundview); 
    fortroot.getChildren().add(Quit); 
}

public Scene getscene() {
    return fortscene; 
}

EventHandler<ActionEvent> quitapplication = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                javafx.application.Platform.exit(); 
            }
    };

}
