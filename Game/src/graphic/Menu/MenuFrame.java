package graphic.Menu;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MenuFrame extends StackPane {
    Rectangle frame = new Rectangle(0, 0);
    ScrollPane scrollPane;
    public MenuFrame(Menu content){
        frame.setFill(Color.WHITE);
        frame.setArcHeight(25);
        frame.setArcWidth(25);
        frame.setStroke(Color.VIOLET);
        frame.setOpacity(0.9);
        frame.setStrokeWidth(15);
        scrollPane = new ScrollPane(content);
        scrollPane.setFitToWidth(true);
        getChildren().addAll(frame, content);
    }
}