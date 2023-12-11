package hellofx;


// Every single import for this project; 
import java.io.File;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class QuitProgram {
// Instance Variables- 
    private Group root3;
    private Scene scene3; 
    private double scenewidth;
    private double sceneheight;
    private TextField textfield; 
    private Group videoroot;
    private Scene loganvideoscene; 
    private MediaPlayer mediaPlayer; 

// Parametrized Constructor 
public QuitProgram(double scenewidth, double sceneheight, Stage primarystage) {
    this.scenewidth = scenewidth;
    this.sceneheight = sceneheight;
    intialize();
}
// Different Constructor that provides soley dimensions
public QuitProgram(Double scenewidth, Double sceneheight) {
this.scenewidth = scenewidth;
this.sceneheight = sceneheight; 
initialize2();
}


public void intialize() {
    root3 = new Group();
    scene3 = new Scene(root3, scenewidth, sceneheight); 
    setquitscene("C:/Jonathan/JavaFXProject/logandance2.mp4"); 
    
}
// Second initialize that creates a new scene that only plays the logan video 
public void initialize2() {
    videoroot = new Group();
    loganvideoscene = new Scene(videoroot, scenewidth, sceneheight); 
    setvideoscene("C:/Jonathan/JavaFXProject/logandance2.mp4"); 
}

public void setvideoscene(String videopath) {
    File video = new File(videopath); 
    Media media = new Media(video.toURI().toString()); 
    mediaPlayer = new MediaPlayer(media);

    MediaView loganVids = new MediaView(mediaPlayer); 
   

    loganVids.setFitHeight(sceneheight);
    loganVids.setFitWidth(scenewidth); 
     PauseTransition pause = new PauseTransition(Duration.seconds(10));
        pause.setOnFinished(event -> {
            javafx.application.Platform.exit(); 
        });
        pause.play(); 

    videoroot.getChildren().add(loganVids); 
}





public void setquitscene(String loganvideo) {
    Font introlabelfont = new Font("Arial", 20);
    Label introlabel = new Label("Enter why you want to Quit");
    introlabel.setFont(introlabelfont);
    introlabel.setTextFill(Color.BLACK);
    introlabel.setLayoutX(250);
    introlabel.setLayoutY(0);

    File video = new File(loganvideo); 
    Media media = new Media(video.toURI().toString()); 
    
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); 

    MediaView loganVideo = new MediaView(mediaPlayer); 
    loganVideo.setPreserveRatio(false); 
    loganVideo.setFitHeight(sceneheight);
    loganVideo.setFitWidth(scenewidth);

    textfield = new TextField();
    textfield.setLayoutX(300);
    textfield.setLayoutY(100);
    textfield.setMinHeight(40);
    textfield.setPromptText("Why do you want to leave?");
    textfield.setOnAction(textfieldenter);

    root3.getChildren().add(loganVideo);
    root3.getChildren().add(textfield);
    root3.getChildren().add(introlabel); 
    
    mediaPlayer.play();
}

public Scene getscene3() {
    return scene3; 
}

public Scene getvideoscene() {
    return loganvideoscene; 
}

EventHandler<ActionEvent> textfieldenter = new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
        Label text = new Label();
        Font textfont = new Font("Arial", 30);
        text.setFont(textfont);
        text.setLayoutX(10);
        text.setLayoutY(200);
        text.setTextFill(Color.BLACK);
        text.setText("Really? Are you kidding me? -> You're so lame for this ");
        root3.getChildren().add(text);
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event -> {
            javafx.application.Platform.exit(); 
        });
        pause.play();                                      
    }
};

}
