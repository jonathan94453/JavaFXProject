package hellofx;

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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class QuitProgram {
    private Group root3;
    private Scene scene3; 
    private double scenewidth;
    private double sceneheight;
    private TextField textfield; 


public QuitProgram(double scenewidth, double sceneheight, Stage primarystage) {
    this.scenewidth = scenewidth;
    this.sceneheight = sceneheight;
    intialize();
}


public void intialize() {
    root3 = new Group();
    scene3 = new Scene(root3, scenewidth, sceneheight); 
    setquitscene("C:/Jonathan/JavaFXProject/logandance2.mp4"); 
    
}

public void setquitscene(String loganvideo) {
    File video = new File(loganvideo); 
    Media media = new Media(video.toURI().toString()); 
    
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); 

    MediaView loganVideo = new MediaView(mediaPlayer); 
    loganVideo.setPreserveRatio(false); 
    loganVideo.setFitHeight(sceneheight);
    loganVideo.setFitWidth(scenewidth);

    textfield = new TextField();
    textfield.setLayoutX(400);
    textfield.setLayoutY(200);
    textfield.setPromptText("Why do you want to leave?");
    textfield.setOnAction(textfieldenter);

    root3.getChildren().add(loganVideo);
    root3.getChildren().add(textfield);
    
    mediaPlayer.play();
}

public Scene getscene3() {
    return scene3; 
}

EventHandler<ActionEvent> textfieldenter = new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
        String user_input = textfield.getText();
        Label text = new Label();
        Font textfont = new Font("Arial", 30);
        text.setFont(textfont);
        text.setLayoutX(10);
        text.setLayoutY(100);
        text.setText("Really? Are you kidding me? -> You're so lame for this " + user_input);
        root3.getChildren().add(text);
        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(event -> {
            javafx.application.Platform.exit(); 
        });
        pause.play();                                      
    }
};

}
