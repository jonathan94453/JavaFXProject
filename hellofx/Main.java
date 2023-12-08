package hellofx; 

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Label label1 = new Label("What should I say?"); 
        Button clickstart = new Button(); 
        TilePane r = new TilePane();

scenecreator o = new scenecreator(label1, clickstart, r); 
        primaryStage.setScene(o.createscene()); 
        primaryStage.show(); 
    }

    public static void main(String[] args) {
        launch(args); 
    }
}