package hellofx; 

import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color; 
import javafx.scene.layout.TilePane;
import javafx.scene.control.Label;

public class scenecreator {
    private Label label;
    private Button button;
    private TilePane tilepane; 

    public scenecreator(Label label, Button button, TilePane tilepane) {
        this.label = label; 
        this.button = button; 
        this.tilepane = tilepane; 
    }
    
    public Scene createscene() {
        button.setText("Start the Program!");
        button.setTranslateX(50);
        button.setTranslateY(50);
        button.setMinWidth(50);
        button.setMinHeight(50);
    Font labelfont = new Font("Arial", 18); 



        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            {   
                label.setText("   Hello World   "); 
                label.setFont(labelfont); 
            } 
        };
        button.setOnAction(event); 
        tilepane.getChildren().add(button); 
        tilepane.getChildren().add(label); 
        Scene scene2 = new Scene(tilepane, 500, 500, Color.BEIGE);
        return scene2; 
    }

}
