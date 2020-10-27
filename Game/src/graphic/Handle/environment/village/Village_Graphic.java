package graphic.Handle.environment.village;

import graphic.Handle.EnvGroup;
import graphic.Handle.Graphic_Handler;
import graphic.Handle.environment.farm.Farm_Graphic;
import graphic.Handle.environment.village.Market_Graphic.Market_Graphic;
import graphic.Handle.environment.village.gym.Gym_Graphic;
import graphic.Handle.environment.village.workshop.Workshop_Graphic;
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

public class Village_Graphic {
    public static EnvGroup root;
    private static Timeline interact;

    public static void villageScene(String where) {
        ImageView background = new ImageView(new Image("graphic/sources/maps/village.png"));
        root = new EnvGroup(background);
        Scene scene = new Scene(root, 960, 712.5);

        if (Graphic_Handler.isOnline) {
            root.addOnlineButtons();
        }

        setStart(where);

        Farmer_Graphic.setFarmerBools(root);

        Farmer_Graphic.moveFarmer(root);

        Graphic_Handler.game.setScene(scene);

        moveInVillage();
    }

    private static void moveInVillage() {
        interact = new Timeline(new KeyFrame(Duration.millis(0.1), event -> {
            if (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 300
                    && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 400
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 1240) {
                Farmer_Graphic.move.stop();
                interact.stop();
                root.animation.stop();
                EnvGroup.isInVillage = false;
                Farm_Graphic.farmScene("village");
            }
            //workshop
            if(root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 160
                    && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 255
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 490
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 540) {
                EnvGroup.inspect.setOpacity(0.7);
                EnvGroup.inspect.setOnMouseClicked(event1 -> {
                    Workshop_Graphic.inspectWorkshop(root);
                });
            }
            //gym
            else if(root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 150
                    && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 185
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 210
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 240) {
                EnvGroup.inspect.setOpacity(0.7);
                EnvGroup.inspect.setOnMouseClicked(event1 -> {
                    Gym_Graphic.inspectGym(root);
                });
            }
            //clinic
            else if(root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 380
                    && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 415
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 110
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 155) {
                EnvGroup.inspect.setOpacity(0.7);
                EnvGroup.inspect.setOnMouseClicked(event1 -> {

                });
            }
            //ranch
            else if(root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 645
                    && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 685
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 70
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 170) {
                EnvGroup.inspect.setOpacity(0.7);
                EnvGroup.inspect.setOnMouseClicked(event1 -> {

                });
            }
            //market
            else if(root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 960
                    && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 1025
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 140
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 170) {
                EnvGroup.inspect.setOpacity(0.7);
                EnvGroup.inspect.setOnMouseClicked(event1 -> {
                    Market_Graphic.inspectMarket(root);
                });
            }
            //cafe
            else if(root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 1020
                    && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 1080
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 390
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 430) {
                EnvGroup.inspect.setOpacity(0.7);
                EnvGroup.inspect.setOnMouseClicked(event1 -> {

                });
            }
            //laboratory
            else if(root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 830
                    && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 910
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 590
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 630) {
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
        if(where.equals("farm")) {
            root.getImage().setTranslateX(0);
            root.getImage().setTranslateY(-567);
            root.getPlayer().setLayoutX(359);
            root.getPlayer().setLayoutY(665.5);
        }
    }
}
