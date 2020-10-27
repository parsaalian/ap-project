package graphic.Handle.environment.farm.home;

import game.environment.Farm.Home.Home;
import graphic.Handle.EnvGroup;
import graphic.Handle.Graphic_Handler;
import graphic.Handle.environment.farm.Farm_Graphic;
import graphic.Handle.environment.farm.home.bed.Bed_Graphic;
import graphic.Handle.environment.farm.home.kitchen.Kitchen_Graphic;
import graphic.Handle.environment.farm.home.storage_box.Storage_Box_Graphic;
import graphic.Handle.farmer.Farmer_Graphic;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.util.Random;

public class Home_Graphic extends Home {
    private static Timeline interact;

    private static boolean isPlaying = false;
    private static EnvGroup root;

    public static void homeScene(String where) {
        ImageView background = new ImageView(new Image("graphic/sources/maps/house.png"));
        root = new EnvGroup(background);
        Scene scene = new Scene(root, 960, 712.5);

        if (Graphic_Handler.isOnline) {
            root.addOnlineButtons();
        }

        setStart(where);

        Farmer_Graphic.setFarmerBools(root);

        Farmer_Graphic.moveFarmer(root);
        
        Graphic_Handler.game.setScene(scene);

        playPiano();
    }

    private static void setStart(String where) {
        if(where.equals("farm")) {
            root.getImage().setTranslateX(0);
            root.getImage().setTranslateY(0);
            root.getPlayer().setLayoutX(480);
            root.getPlayer().setLayoutY(635);
        }
    }

    private static void playPiano() {
        Random random = new Random();
        MediaPlayer[] mediaPlayer = new MediaPlayer[3];
        mediaPlayer[0] = new MediaPlayer(new Media(new File("src/graphic/sources/music/piano1.mp3").toURI().toString()));
        mediaPlayer[1] = new MediaPlayer(new Media(new File("src/graphic/sources/music/piano2.mp3").toURI().toString()));
        mediaPlayer[2] = new MediaPlayer(new Media(new File("src/graphic/sources/music/piano3.mp3").toURI().toString()));
        interact = new Timeline(new KeyFrame(Duration.millis(500), event -> {
            if (root.getPlayer().getLayoutX() >= 440 && root.getPlayer().getLayoutX() <= 520
                    && root.getPlayer().getLayoutY() <= 540 && root.getPlayer().getLayoutY() >= 500) {
                if(!isPlaying) {
                    int k = random.nextInt(3);
                    mediaPlayer[k].play();
                    isPlaying = true;
                }
            } else {
                for(int i = 0; i < 3; i++) {
                    mediaPlayer[i].stop();
                }
                isPlaying = false;
            }
            if (root.getPlayer().getLayoutY() >= 670
                    && root.getPlayer().getLayoutX() >= 430
                    && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 520) {
                Farmer_Graphic.move.stop();
                interact.stop();
                root.animation.stop();
                Farm_Graphic.farmScene("home");
            }
            if(root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 560
                    && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 770
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 140
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 165) {
                EnvGroup.inspect.setOpacity(0.7);
                EnvGroup.inspect.setOnMouseClicked(event1 -> Kitchen_Graphic.inspect(root));
            }
            else if(root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 80
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 250) {
                EnvGroup.inspect.setOpacity(0.7);
                EnvGroup.inspect.setOnMouseClicked(event1 -> {
                    Bed_Graphic.inspect(root);
                });
            }
            else if (root.getPlayer().getLayoutX() - root.getImage().getTranslateX() >= 760
                    && root.getPlayer().getLayoutX() - root.getImage().getTranslateX() <= 870
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() >= 480
                    && root.getPlayer().getLayoutY() - root.getImage().getTranslateY() <= 510) {
                EnvGroup.inspect.setOpacity(0.7);
                EnvGroup.inspect.setOnMouseClicked(event1 -> {
                    Storage_Box_Graphic.inspect(root);
                });
            }
            else {
                EnvGroup.inspect.setOpacity(0);
            }

        }));
        interact.setCycleCount(Animation.INDEFINITE);
        interact.play();
    }
}

//root.getPlayer().getLayoutX() - root.getImage().getTranslateX()