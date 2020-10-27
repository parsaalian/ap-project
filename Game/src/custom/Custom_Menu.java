package custom;

import graphic.Handle.Graphic_Handler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Custom_Menu {
    protected static Group root;
    protected static Scene scene;

    protected static ImageView confirm;

    protected static void customMunu() {
        root = new Group();
        scene = new Scene(root, 960, 712.5);

        ImageView background = new ImageView(new Image("graphic/sources/custom/custom_background.jpg"));
        background.setFitWidth(960);
        background.setFitHeight(713);

        confirm = new ImageView(new Image("graphic/sources/custom/confirm.png"));
        confirm.setFitWidth(80);
        confirm.setFitHeight(80);
        confirm.setLayoutX(860);
        confirm.setLayoutY(613);

        ImageView back = new ImageView(new Image("graphic/sources/server/back.png"));
        back.setFitWidth(80);
        back.setFitHeight(80);
        back.setLayoutX(20);
        back.setLayoutY(613);

        back.setOnMouseClicked(event -> Graphic_Handler.game.setScene(Graphic_Handler.mainMenu()));



        root.getChildren().addAll(background, back, confirm);
    }

    public static void setScene() {
        customMunu();
        Graphic_Handler.game.setScene(scene);
    }
}
