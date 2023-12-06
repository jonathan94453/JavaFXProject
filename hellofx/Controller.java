package hellofx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.paint.Color; 
import javafx.scene.Group; 

public class Controller{
    

    @FXML
    private Label label;
    private Button startbutton;
    
public void handlebuttonpress(ActionEvent event) {
    
}

    public void initialize() {
       label.setText("Logan is gay");
       handlebuttonpress(startbutton); 
    }
}
