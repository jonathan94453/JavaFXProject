package hellofx;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
public class environment2d {
    private Group root; 
    private Scene scene;
    private double scenewidth;
    private double sceneheight;
    private Label title;
    private Button start;

    public environment2d(double scenewidth, double sceneheight, Label title, Button start) {
        this.scenewidth = scenewidth;
        this.sceneheight = sceneheight;
        this.title = title;
        this.start = start;  
        intialize(); 
    }

    private void intialize() {
        root = new Group();
        scene = new Scene(root, scenewidth, sceneheight); 
        
        setstart("/village.jpg"); 
    }
    
    private void setstart(String environmentimage) {
            Image backgroundimage = new Image(getClass().getResourceAsStream(environmentimage));
            ImageView backgroundview = new ImageView(backgroundimage); 

            backgroundview.setFitHeight(sceneheight);
            backgroundview.setFitWidth(scenewidth);
            title.setLayoutX(scenewidth/2);
            title.setLayoutY(100);
            //Layouts the start button
            start.setLayoutX(360);
            start.setLayoutY(sceneheight/2);
//Size of the button
            start.setMinWidth(100);
            start.setMaxHeight(100); 
            start.setText("Start the Game!");
// Adds it to the root group 
            root.getChildren().add(backgroundview); 
            root.getChildren().add(title);
            root.getChildren().add(start); 
    }
    public Scene getScene() {
        return scene; 
    }
}