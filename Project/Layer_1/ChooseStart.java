// Choose Start the Game on the main screen 
package Project.Layer_1;

import Project.StartScreen;
import Project.Layer_2.ChooseGF;
import Project.Layer_2.ChooseHouse;
import Project.Layer_2.ChooseLHS;
import Project.Layer_2.ChoosePond;
import Project.Layer_2.ChooseSandT;
import Project.Layer_2.ChooseSunset;
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
    private double points;
    private double sceneheight;
    private double scenewidth;
    private Group root2;
    private Scene scene2;
    private Stage primaryStage;  
    private Button Start;
    private Label Titlelabel; 
    private Button showpoints; 
// Value Passing with Constructor 
    public ChooseStart(Double sceneheight, Double scenewidth, Double points, Stage primaryStage, Button Start, Label Titlelabel) {   
        this.points = points; 
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
            setthescene("/village.jpg", "/House.jpg", "/Pond.jpg", "/LHS.jpg", "/gf.jpg", "/SANDT.jpg", "/Sunset.jpg"); 
    }


// Extremely Extensive Method, Constructing each Button in the game for each section
// Of the Map; 
    public void setthescene(String environmentimage, String houseimage, String pondimage, String lhshouse, String gfhouse, String Univeristy, String Sunsetend) {
        Button Quit = new Button("Back"); 
        Quit.setOnAction(choosequit); 
        Quit.setLayoutX(400);
        showpoints = new Button("Show Points"); 
        showpoints.setLayoutX(490);
        showpoints.setOnAction(dispoints);
        Image backgroundimage = new Image(getClass().getResourceAsStream(environmentimage));
        ImageView backgroundview = new ImageView(backgroundimage);
        backgroundview.setFitHeight(sceneheight);
        backgroundview.setFitWidth(scenewidth);

// Mouse Hover Code 
// Program to have the button enlarge itself when hovered on, placement was as close as possible. 
Button SandT = new Button();

Button GFhouse = new Button();
Button LHS = new Button(); 
Button lake = new Button(); 
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


lake.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");
lake.setLayoutX(-15);
lake.setLayoutY(550);
lake.setMinWidth(530);
lake.setMinHeight(210);
lake.setOnAction(choosepond);


ScaleTransition scaletransition2 = new ScaleTransition(Duration.millis(200), lake);
// From Size --> To Size; 
scaletransition2.setFromX(1.0);
scaletransition2.setFromY(1.0);
scaletransition2.setToX(1.1);
scaletransition2.setToY(1.1); 

lake.setOnMouseEntered(event -> {
        scaletransition2.playFromStart();
});

lake.setOnMouseExited(event -> {
scaletransition2.setRate(-1);
scaletransition2.play(); 

    });

LHS.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");
LHS.setLayoutX(540);
LHS.setLayoutY(145);
LHS.setMinWidth(280);
LHS.setMinHeight(160);
LHS.setOnAction(chooselhs);
ScaleTransition scaletransition3 = new ScaleTransition(Duration.millis(200), LHS);
// From Size --> To Size; 
scaletransition3.setFromX(1.0);
scaletransition3.setFromY(1.0);
scaletransition3.setToX(1.1);
scaletransition3.setToY(1.1); 

LHS.setOnMouseEntered(event -> {
        scaletransition3.playFromStart();
});

LHS.setOnMouseExited(event -> {
scaletransition3.setRate(-1);
scaletransition3.play(); 

    });

GFhouse.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");
GFhouse.setLayoutX(624);
GFhouse.setLayoutY(310);
GFhouse.setMinWidth(180);
GFhouse.setMinHeight(120);
GFhouse.setOnAction(choosegfhouse); 

ScaleTransition scaletransition4 = new ScaleTransition(Duration.millis(200), GFhouse);
// From Size --> To Size; 
scaletransition4.setFromX(1.0);
scaletransition4.setFromY(1.0);
scaletransition4.setToX(1.1);
scaletransition4.setToY(1.1); 

GFhouse.setOnMouseEntered(event -> {
        scaletransition4.playFromStart();
});

GFhouse.setOnMouseExited(event -> {
scaletransition4.setRate(-1);
scaletransition4.play(); 

    });

// Button for the College 
SandT.setStyle("-fx-background-color: transparent; -fx-border-width: 0;");
SandT.setLayoutX(-15);
SandT.setLayoutY(200);
SandT.setMinWidth(300);
SandT.setMinHeight(165);
SandT.setOnAction(choosesandt);

ScaleTransition scaletransition5 = new ScaleTransition(Duration.millis(200), SandT);
// From Size --> To Size; 
scaletransition5.setFromX(1.0);
scaletransition5.setFromY(1.0);
scaletransition5.setToX(1.1);
scaletransition5.setToY(1.1); 

SandT.setOnMouseEntered(event -> {
        scaletransition5.playFromStart();
});

SandT.setOnMouseExited(event -> {
scaletransition5.setRate(-1);
scaletransition5.play(); 

    });






// Image, Imageviews, setGraphics
Image image2 = new Image(pondimage);
Image image3 = new Image(lhshouse);
Image image4 = new Image(gfhouse); 
Image image5 = new Image(Univeristy); 


ImageView imageview2 = new ImageView(image2); 
ImageView imageview3 = new ImageView(image3); 
ImageView imageview4 = new ImageView(image4); 
ImageView imageview5 = new ImageView(image5); 


imageview2.setFitHeight(lake.getMinHeight()); 
imageview2.setFitWidth(lake.getMinWidth());
imageview3.setFitHeight(LHS.getMinHeight());
imageview3.setFitWidth(LHS.getMinWidth());
imageview4.setFitHeight(GFhouse.getMinHeight());
imageview4.setFitWidth(GFhouse.getMinWidth()); 
imageview5.setFitHeight(SandT.getMinHeight());
imageview5.setFitWidth(SandT.getMinWidth());


lake.setGraphic(imageview2);
LHS.setGraphic(imageview3);
GFhouse.setGraphic(imageview4); 
SandT.setGraphic(imageview5);


// Add nodes to the group of nodes 
        root2.getChildren().add(backgroundview);  
        root2.getChildren().add(house); 
        root2.getChildren().add(lake); 
        root2.getChildren().add(LHS);
        root2.getChildren().add(GFhouse); 
        root2.getChildren().add(SandT); 
        root2.getChildren().add(Quit); 
        root2.getChildren().add(showpoints); 




    }



// Scene Accessor Method 
    public Scene getscene() { 
        return scene2; 
    }










// EVENT HANDLERS FOR EACH BUTTON 
      EventHandler<ActionEvent> choosequit = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                StartScreen goback = new StartScreen(scenewidth, sceneheight, points, Titlelabel, Start, primaryStage);
                primaryStage.setScene(goback.getScene());
            }
    };
// Event Handler to Choose Logan's House 
    EventHandler<ActionEvent> choosehouse = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            ChooseHouse clickHouse = new ChooseHouse(scenewidth, sceneheight, points, Titlelabel, primaryStage, Start);
            primaryStage.setScene(clickHouse.getscenehouse()); 
        }
    };
// Pond button Action
EventHandler <ActionEvent> choosepond = new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
        ChoosePond pond = new ChoosePond(sceneheight, scenewidth, points, Titlelabel, Start, primaryStage);
        primaryStage.setScene(pond.getscene());
    }
};

EventHandler<ActionEvent> choosesunset = new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
            ChooseSunset sunset = new ChooseSunset(sceneheight, scenewidth, points, primaryStage, Start, Titlelabel);
            primaryStage.setScene(sunset.getscene());
    }
};


EventHandler<ActionEvent> choosegfhouse = new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
            ChooseGF gf = new ChooseGF(scenewidth, sceneheight, points, Titlelabel, Start, primaryStage);
            primaryStage.setScene(gf.getscene());
    }
};

EventHandler<ActionEvent> choosesandt = new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
            ChooseSandT college = new ChooseSandT(scenewidth, sceneheight, points, primaryStage, Start, Titlelabel);
            primaryStage.setScene(college.getscene());
    }
}; 

EventHandler<ActionEvent> chooselhs = new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
            ChooseLHS LHS = new ChooseLHS(sceneheight, scenewidth, points, primaryStage, Start, Titlelabel);
            primaryStage.setScene(LHS.getscene());
    }
}; 

EventHandler<ActionEvent> dispoints = new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
            showpoints.setText("" + points); 
    }
}; 
    
}
