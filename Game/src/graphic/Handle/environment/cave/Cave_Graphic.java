package graphic.Handle.environment.cave;

import graphic.Handle.EnvGroup;
import graphic.Handle.Graphic_Handler;
import graphic.Handle.environment.jungle.Jungle_Graphic;
import graphic.Handle.farmer.Farmer_Graphic;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Cave_Graphic {
    public static EnvGroup root;
    private static Timeline interact;

    public static void caveScene(String where) {
        ImageView background = new ImageView(new Image("graphic/sources/maps/cave.png"));
        root = new EnvGroup(background);
        Scene scene = new Scene(root, 960, 712.5);

        if (Graphic_Handler.isOnline) {
            root.addOnlineButtons();
        }

        setStart(where);

        Farmer_Graphic.setFarmerBools(root);

        Farmer_Graphic.moveFarmer(root);

        Graphic_Handler.game.setScene(scene);

        moveInCave();
    }

    private static void moveInCave() {
        interact = new Timeline(new KeyFrame(Duration.millis(0.1), event -> {
            if(root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 546
                    && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 610
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 920) {
                Farmer_Graphic.move.stop();
                interact.stop();
                root.animation.stop();
                Jungle_Graphic.jungleScene("cave");
            }
            //inspect stones
            if ((root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 560
                    && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 620
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 155
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 180)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 750
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 810
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 595
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 630)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 600
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 655
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 750
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 785)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 375
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 426
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 695
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 725)
                    ||
                    (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 115
                            && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 170
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 600
                            && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 625)
                    ) {
                EnvGroup.inspect.setOpacity(0.7);
                EnvGroup.inspect.setOnMouseClicked(event1 -> {

                });
            }
            else {
                EnvGroup.inspect.setOpacity(0);
            }
        }));
        interact.setCycleCount(Animation.INDEFINITE);
        interact.play();
    }

    private static void setStart(String where) {
        if(where.equals("jungle")) {
            root.getImage().setTranslateX(0);
            root.getImage().setTranslateY(-245);
            root.getPlayer().setLayoutX(573);
            root.getPlayer().setLayoutY(647);
        }
    }
}
