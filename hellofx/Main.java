package hellofx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("hellofx.fxml")); 
        primaryStage.setTitle("Hello World");
        Scene o = new Scene(root, 400, 300);  
        primaryStage.setScene(o);
        primaryStage.show(); 
    }

    public static void main(String[] args) {
        launch(args); 
    }
}
