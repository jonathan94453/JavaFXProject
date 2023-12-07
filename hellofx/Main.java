package hellofx;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.paint.Color; 
import javafx.scene.Group; 
import javafx.event.EventHandler; 
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Label label1 = new Label("Button not Selected"); 
        Button clickstart = new Button(); 
        clickstart.setText("Start the Program!");
        clickstart.setTranslateX(350.0);
        clickstart.setTranslateY(400.0);
        TilePane r = new TilePane(); 
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                label1.setText("   button   selected    "); 
            } 
        };
        clickstart.setOnAction(event); 
        r.getChildren().add(clickstart); 
        r.getChildren().add(label1); 
        Scene scene2 = new Scene(r, 400, 400); 
        primaryStage.setScene(scene2);
        primaryStage.show(); 
    }

    public static void main(String[] args) {
        launch(args); 
    }
}