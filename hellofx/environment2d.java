package hellofx;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
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
        //Creates image handlers for the background image
            Image backgroundimage = new Image(getClass().getResourceAsStream(environmentimage));
            ImageView backgroundview = new ImageView(backgroundimage); 
            //Font object for the TITLE FONT
            Font titlefont = Font.loadFont(getClass().getResourceAsStream("/PAC-FONT.TTF"), 40); 
        //Adds the quit button
            Button quit = new Button("Quit"); 

// When quit is clicked- call the choosequit event handler. 

//Set Layout of everything
            quit.setOnAction(choosequit);
            quit.setLayoutX(360);
            quit.setLayoutY(sceneheight/2 + 80);
            backgroundview.setFitHeight(sceneheight);
            backgroundview.setFitWidth(scenewidth);
            title.setFont(titlefont); 
            title.setLayoutX(50);
            title.setLayoutY(100);
            //Layouts the start button
            start.setLayoutX(330);
            start.setLayoutY(sceneheight/2);
//Size of the button
            start.setMinWidth(100);
            start.setMaxHeight(100); 
            start.setText("Start the Game!");
// Adds it to the root group 
            root.getChildren().add(backgroundview); 
            root.getChildren().add(title);
            root.getChildren().add(start); 
            root.getChildren().add(quit); 
    }
    public Scene getScene() {
        return scene; 
    }



    EventHandler<ActionEvent> choosequit = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                javafx.application.Platform.exit();
            }
    }; 
}