package hellofx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller{
    

    @FXML
    private Label label;
    

    public void initialize() {
        label.setText("We did it boys");
        
    }
}
