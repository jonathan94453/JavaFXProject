package hellofx.Layer_1;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.scene.Scene; 

public class ChooseStart {
    private double sceneheight;
    private double scenewidth;

    private Group root2;
    private Scene scene2; 

    public ChooseStart(Double sceneheight, Double scenewidth) {
        this.sceneheight = sceneheight;
        this.scenewidth = scenewidth; 
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

Image image = new Image(houseimage);
ImageView imageview = new ImageView(image); 
imageview.setFitHeight(100);
imageview.setFitWidth(100);
Button house = new Button();
house.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");
house.setLayoutX(-15);
house.setLayoutY(375);
house.setMinWidth(325);
house.setMinHeight(165);
imageview.setFitHeight(house.getMinHeight()); 
imageview.setFitWidth(house.getMinWidth());
house.setGraphic(imageview);

ScaleTransition scaletransition = new ScaleTransition(Duration.millis(200), house);
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









        root2.getChildren().add(backgroundview);  
        root2.getChildren().add(house); 
        root2.getChildren().add(Quit); 
        
    }
    public Scene getscene() {
        return scene2; 
    }
      EventHandler<ActionEvent> choosequit = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                javafx.application.Platform.exit();
            }
    };
    EventHandler<ActionEvent> choosehouse = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            //Create a new object and fill in the class 
        }
    };
}
