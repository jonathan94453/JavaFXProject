package hellofx;
import javafx.event.EventHandler;

//All are used imports 
import javafx.stage.Stage;
import hellofx.Layer_1.ChooseStart;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class environment2d {
// Instance variables
    private Group root; 
    private Scene scene;
    private double scenewidth;
    private double sceneheight;
    private Label title;
    private Button start;
    private Stage primarystage; 
// Paramaterized Constructor to assign values to instance variables 
    public environment2d(double scenewidth, double sceneheight, Label title, Button start, Stage primarystage) {
        this.scenewidth = scenewidth;
        this.sceneheight = sceneheight;
        this.title = title;
        this.start = start;
        this.primarystage = primarystage; 
// initialize method to set scene and node variables
        intialize(); 
    }

    private void intialize() {
        root = new Group();
        scene = new Scene(root, scenewidth, sceneheight); 
  // Main scene intialize with path of village picture passed to the method       
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
            Button ShowMap = new Button("Show Map"); 



//Set Layout of everything
            quit.setOnAction(choosequit);
            quit.setLayoutX(330);
            quit.setLayoutY(sceneheight/2 + 90);
            quit.setMinWidth(100);
            backgroundview.setFitHeight(sceneheight);
            backgroundview.setFitWidth(scenewidth);
            title.setFont(titlefont); 
            title.setLayoutX(30);
            title.setLayoutY(100);
            //Layouts the start button
            start.setOnAction(choosestart);
            start.setLayoutX(330);
            start.setLayoutY(sceneheight/2);
//Size of the button
            start.setMinWidth(100);
            start.setMaxHeight(100); 
            start.setText("Start the Game!");
// Show map layout 
            ShowMap.setLayoutX(330);
            ShowMap.setOnAction(Showthemap);
            ShowMap.setLayoutY(sceneheight/2 + 40);
            ShowMap.setMinWidth(100);
            ShowMap.setMinHeight(-10); 

// Adds it to the root group 
            root.getChildren().add(backgroundview); 
            root.getChildren().add(title);
            root.getChildren().add(start); 
            root.getChildren().add(quit); 
            root.getChildren().add(ShowMap); 
    }
// Accessor Method to return the scene 
    public Scene getScene() {
        return scene; 
    }


// Event handlers for the first page of the game 
    EventHandler<ActionEvent> choosequit = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                QuitProgram quitgame = new QuitProgram(scenewidth, sceneheight, primarystage);
                primarystage.setScene(quitgame.getscene3()); 
            }
    };
// Any type of quit button is clicked 
    EventHandler<ActionEvent> quitapplication = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                javafx.application.Platform.exit(); 
            }
    };
// Start the game button is clicked 
    EventHandler<ActionEvent> choosestart = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
        ChooseStart scene2 = new ChooseStart(sceneheight, scenewidth, primarystage, start, title); 
        primarystage.setScene(scene2.getscene()); 
}
};
//Showmap button is clicked 
    EventHandler<ActionEvent> Showthemap = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
// Small Scene Architecture when showmap is clicked 
   TriangleMesh mesh = new TriangleMesh();
        mesh.getPoints().addAll(
                0, 0, 0,
                50, 0, 0,
                0, 50, 0
        );
        mesh.getTexCoords().addAll(0, 0);

        int[] faces = {0, 0, 1, 0, 2, 0};
        mesh.getFaces().addAll(faces);

        // Create a MeshView and apply the mesh
        MeshView meshView = new MeshView(mesh);
        meshView.setTranslateX(100);
        meshView.setTranslateY(100);

            Group maproot = new Group();
            maproot.getChildren().add(meshView); 
            Scene map = new Scene(maproot, scenewidth, sceneheight);
            primarystage.setScene(map); 
//             Image backgroundimage = new Image(getClass().getResourceAsStream("/village.jpg"));
//             ImageView backgroundview = new ImageView(backgroundimage);
//             backgroundview.setFitHeight(sceneheight);
//             backgroundview.setFitWidth(scenewidth);
// // Quit Button quits out of the application 
// // I make quit buttons for any scene that still needs more extensive architecture 
//             Button quit = new Button("Quit"); 
//             quit.setLayoutX(350);
//             quit.setLayoutY(100);
//             quit.setMinHeight(20);
//             quit.setMinWidth(100);
//             quit.setOnAction(quitapplication);
//             maproot.getChildren().add(backgroundview); 
//             maproot.getChildren().add(quit); 
//             primarystage.setScene(map);       

        }
    }; 
}