package hellofx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.paint.Color; 
import javafx.scene.Group; 

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("hellofx.fxml")); 
        Button clickstart = new Button(); 
        clickstart.setText("Start the Program!");
        clickstart.setTranslateX(350.0);
        clickstart.setTranslateY(400.0);
        primaryStage.setTitle("Hello World");
        Group root2 = new Group(clickstart);
        Scene scene2 = new Scene(root2, 800, 800, Color.BEIGE); 
        Scene o = new Scene(root, 800, 800);  
        primaryStage.setScene(scene2);
        primaryStage.show(); 
    }

    public static void main(String[] args) {
        launch(args); 
    }
}