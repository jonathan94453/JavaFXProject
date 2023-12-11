// Choose Start the Game on the main screen 
package hellofx.Layer_1;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.scene.Scene; 
import javafx.stage.Stage;

public class ChooseStart {
// Instance Variables 
    private double sceneheight;
    private double scenewidth;
    private Group root2;
    private Scene scene2;
    private Stage primaryStage;  
    private Button Start;
    private Label Titlelabel; 
// Value Passing with Constructor 
    public ChooseStart(Double sceneheight, Double scenewidth, Stage primaryStage, Button Start, Label Titlelabel) {
        this.sceneheight = sceneheight;
        this.scenewidth = scenewidth; 
        this.primaryStage = primaryStage; 
        this.Start = Start;
        this.Titlelabel = Titlelabel; 
        initialize(); 
    }
    private void initialize() {
            root2 = new Group();
            scene2 = new Scene(root2, scenewidth, sceneheight); 
            setthescene("/village.jpg", "/House.jpg"); 
    }



    public void setthescene(String environmentimage, String houseimage) {
        Button Quit = new Button("Quit"); 
        Quit.setOnAction(choosequit); 
        Quit.setLayoutX(400);
        Image backgroundimage = new Image(getClass().getResourceAsStream(environmentimage));
        ImageView backgroundview = new ImageView(backgroundimage);
        backgroundview.setFitHeight(sceneheight);
        backgroundview.setFitWidth(scenewidth);

// Mouse Hover Code 
// Program to have the button enlarge itself when hovered on, placement was as close as possible. 
Image image = new Image(houseimage);
ImageView imageview = new ImageView(image); 
imageview.setFitHeight(100);
imageview.setFitWidth(100);
// House button is the image of the button 
Button house = new Button();
// the actual button is transparent, the user can only see the image 
house.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");
house.setLayoutX(-15);
house.setLayoutY(375);
house.setMinWidth(325);
house.setMinHeight(165);
// Found out that javafx has Accessor Methods for almost every single attribute 
// The image will be set to the size of the button 
imageview.setFitHeight(house.getMinHeight()); 
imageview.setFitWidth(house.getMinWidth());
house.setGraphic(imageview);
house.setOnAction(choosehouse);
// ScaleTransition is a class which allows you to transition sizes of nodes 
ScaleTransition scaletransition = new ScaleTransition(Duration.millis(200), house);
// From Size --> To Size; 
scaletransition.setFromX(1.0);
scaletransition.setFromY(1.0);
scaletransition.setToX(1.1);
scaletransition.setToY(1.1); 

house.setOnMouseEntered(event -> {
        scaletransition.playFromStart();
});

house.setOnMouseExited(event -> {
scaletransition.setRate(-1);
scaletransition.play(); 

    });








// Add nodes to the group of nodes 
        root2.getChildren().add(backgroundview);  
        root2.getChildren().add(house); 
        root2.getChildren().add(Quit); 
        
    }
// Scene Accessor Method 
    public Scene getscene() {
        return scene2; 
    }
// More Event Handlers for Buttons and Textfields; 
      EventHandler<ActionEvent> choosequit = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                javafx.application.Platform.exit();
            }
    };
    EventHandler<ActionEvent> choosehouse = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            ChooseHouse clickHouse = new ChooseHouse(scenewidth, sceneheight, Titlelabel, primaryStage, Start);
            primaryStage.setScene(clickHouse.getscenehouse()); 
        }
    };
    
}
