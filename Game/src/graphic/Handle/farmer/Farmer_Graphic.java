package graphic.Handle.farmer;

import game.environment.Farm.Farm;
import game.farmer.Farmer;
import graphic.Handle.EnvGroup;
import graphic.Handle.Graphic_Handler;
import graphic.Handle.SpriteAnimation;
import graphic.Handle.environment.cave.Cave_Graphic;
import graphic.Handle.environment.farm.Farm_Graphic;
import graphic.Handle.environment.farm.home.Home_Graphic;
import graphic.Handle.environment.jungle.Jungle_Graphic;
import graphic.Handle.environment.village.Village_Graphic;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

public class Farmer_Graphic {
    public static Timeline move;
    public static Timeline change;

    private static boolean[][] canPass = null;

    private final static int velocity = 300;

    private static boolean rightPressed;
    private static boolean leftPressed;
    private static boolean upPressed;
    private static boolean downPressed;
    private static boolean isRunning;



    public static void moveFarmer(EnvGroup root) {
        ImageView player = root.getPlayer();
        ImageView Image = root.getImage();
        root.requestFocus();
        move = new Timeline(new KeyFrame(Duration.millis(0.1), event -> {
            final double xVel = velocity * (rightPressed ? -1 : (leftPressed ? 1 : 0)) * (notStraight() ? Math.sqrt(2) / 2 : 1) * (isRunning ? 1.5 : 1);
            final double yVel = velocity * (downPressed ? -1 : (upPressed ? 1 : 0)) * (notStraight() ? Math.sqrt(2) / 2 : 1) * (isRunning ? 1.5 : 1);

            final double elapsedSeconds = 0.0001;

            /*System.out.print(player.getLayoutX() - Image.getTranslateX() + " ");
            System.out.print(player.getLayoutY() - Image.getTranslateY() + " ");
            System.out.print(Image.getTranslateX() + " ");
            System.out.println(Image.getTranslateY());*/

            final double deltaX = elapsedSeconds * xVel;
            final double deltaY = elapsedSeconds * yVel;

            if (Farmer.stamina < 2) {
                move.stop();
            }
            else {
                move.play();
            }


            if (rightPressed)
                root.setDir("RIGHT");
            else if (leftPressed)
                root.setDir("LEFT");
            else if (upPressed)
                root.setDir("UP");
            else if (downPressed)
                root.setDir("DOWN");

            if (Farmer.satiety >= 1) {
                Farmer.satiety = changeAmount(Farmer.satiety, -Farmer.satietyCons * elapsedSeconds);
                EnvGroup.satietyPro.setProgress(Farmer.satiety / Farmer.maxSatiety);
            }

            if (Farmer.energy >= 1) {
                Farmer.energy = changeAmount(Farmer.energy, -Farmer.energyCons * elapsedSeconds);
                EnvGroup.energyPro.setProgress(Farmer.energy / Farmer.maxEnergy);
            }

            if (player.getLayoutX() - Image.getTranslateX() >= 0
                    && player.getLayoutX() - Image.getTranslateX() <= Image.getImage().getWidth() - 32
                    && player.getLayoutY() - Image.getTranslateY() >= 0
                    && player.getLayoutY() - Image.getTranslateY() <= Image.getImage().getHeight() - 32) {
                if (player.getLayoutX() - Image.getTranslateX() >= 480 && player.getLayoutX() - Image.getTranslateX() <= Image.getImage().getWidth() - 480) {
                    final double x = player.getLayoutX() - Image.getTranslateX();
                    final double y = player.getLayoutY() - Image.getTranslateY();
                        final double oldX = Image.getTranslateX();
                        final double newX = oldX + deltaX;
                        Image.setTranslateX(newX);
                    if((rightPressed || leftPressed || upPressed || downPressed) && Farmer.stamina >= 1) {
                        Farmer.stamina = changeAmount(Farmer.stamina, -Farmer.staminaCons * elapsedSeconds * (isRunning ? 3 : 1));
                        EnvGroup.staminaPro.setProgress(Farmer.stamina / Farmer.maxStamina);
                    }
                    else {
                        if (Farmer.stamina <= Farmer.maxStamina) {
                            Farmer.stamina = changeAmount(Farmer.stamina, Farmer.staminaRefill * elapsedSeconds * (isRunning ? 3 : 1));
                            EnvGroup.staminaPro.setProgress(Farmer.stamina / Farmer.maxStamina);
                        }
                    }
                } else {
                    final double x = player.getLayoutX() - Image.getTranslateX();
                    final double y = player.getLayoutY() - Image.getTranslateY();
                        final double oldX = player.getLayoutX();
                        final double newX = oldX - deltaX;
                        player.setLayoutX(newX);
                    if((rightPressed || leftPressed || upPressed || downPressed) && Farmer.stamina >= 1) {
                        Farmer.stamina = changeAmount(Farmer.stamina, -Farmer.staminaCons * elapsedSeconds * (isRunning ? 3 : 1));
                        EnvGroup.staminaPro.setProgress(Farmer.stamina / Farmer.maxStamina);
                    }
                    else {
                        if (Farmer.stamina <= Farmer.maxStamina) {
                            Farmer.stamina = changeAmount(Farmer.stamina, Farmer.staminaRefill * elapsedSeconds * (isRunning ? 3 : 1));
                            EnvGroup.staminaPro.setProgress(Farmer.stamina / Farmer.maxStamina);
                        }
                    }
                }
                if (player.getLayoutY() - Image.getTranslateY() >= 356.25 && player.getLayoutY() - Image.getTranslateY() <= Image.getImage().getHeight() - 356.25) {
                    final double x = player.getLayoutX() - Image.getTranslateX();
                    final double y = player.getLayoutY() - Image.getTranslateY();
                        final double oldY = Image.getTranslateY();
                        final double newY = oldY + deltaY;
                        Image.setTranslateY(newY);
                    if((rightPressed || leftPressed || upPressed || downPressed) && Farmer.stamina >= 1) {
                        Farmer.stamina = changeAmount(Farmer.stamina, -Farmer.staminaCons * elapsedSeconds * (isRunning ? 3 : 1));
                        EnvGroup.staminaPro.setProgress(Farmer.stamina / Farmer.maxStamina);
                    }
                    else {
                        if (Farmer.stamina <= Farmer.maxStamina) {
                            Farmer.stamina = changeAmount(Farmer.stamina, Farmer.staminaRefill * elapsedSeconds * (isRunning ? 3 : 1));
                            EnvGroup.staminaPro.setProgress(Farmer.stamina / Farmer.maxStamina);
                        }
                    }
                } else {
                    final double x = player.getLayoutX() - Image.getTranslateX();
                    final double y = player.getLayoutY() - Image.getTranslateY();
                        final double oldY = player.getLayoutY();
                        final double newY = oldY - deltaY;
                        player.setLayoutY(newY);
                    if((rightPressed || leftPressed || upPressed || downPressed) && Farmer.stamina >= 1) {
                        Farmer.stamina = changeAmount(Farmer.stamina, -Farmer.staminaCons * elapsedSeconds * (isRunning ? 3 : 1));
                        EnvGroup.staminaPro.setProgress(Farmer.stamina / Farmer.maxStamina);
                    }
                    else {
                        if (Farmer.stamina <= Farmer.maxStamina) {
                            Farmer.stamina = changeAmount(Farmer.stamina, Farmer.staminaRefill * elapsedSeconds * (isRunning ? 3 : 1));
                            EnvGroup.staminaPro.setProgress(Farmer.stamina / Farmer.maxStamina);
                        }
                    }
                }
            }
            else if (player.getLayoutX() - Image.getTranslateX() <= 0) {
                player.setLayoutX(Image.getTranslateX() + 1);
            }
            else if (player.getLayoutY() - Image.getTranslateY() <= 0) {
                player.setLayoutY(Image.getTranslateY() + 1);
            }
            else if (player.getLayoutX() - Image.getTranslateX() >= Image.getImage().getWidth() - 32) {
                player.setLayoutX(Image.getTranslateX() + Image.getImage().getWidth() - 33);
            }
            else {
                player.setLayoutY(Image.getTranslateY() + Image.getImage().getHeight() - 33);
            }
        }));
        move.setCycleCount(Animation.INDEFINITE);
        move.play();
    }

    /*public static void changeStatics(final int amount, int changeAmount) {
        change = new Timeline(new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
            int amountCopy = amount;
            @Override
            public void handle(ActionEvent event) {
                amountCopy = changeAmount(amountCopy, changeAmount);
                System.out.println(amountCopy);
            }
        }));
        change.setCycleCount(Animation.INDEFINITE);
        change.play();
    }*/

    private static boolean notStraight() {
        return  (rightPressed & upPressed) | (rightPressed & downPressed)
                & (leftPressed & upPressed) | (leftPressed & downPressed);
    }

    public static void setFarmerBools(EnvGroup root) {
        root.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    upPressed = true;
                    break;
                case DOWN:
                    downPressed = true;
                    break;
                case RIGHT:
                    rightPressed = true;
                    break;
                case LEFT:
                    leftPressed = true;
                    break;
                case ESCAPE:
                    move.pause();
                    root.changePause();
                    break;
                case SPACE:
                    isRunning = true;
                    break;
            }
            if (root.isActive()){
                root.animation.setCycleCount(-1);
                root.animation.play();
            }
        });

        root.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case UP:
                    upPressed = false;
                    break;
                case DOWN:
                    downPressed = false;
                    break;
                case RIGHT:
                    rightPressed = false;
                    break;
                case LEFT:
                    leftPressed = false;
                    break;
                case SPACE:
                    isRunning = false;
                    break;
            }
            if (upPressed == false && downPressed == false && leftPressed == false && rightPressed == false)
                root.animation.stop();

        });
    }

    private static double changeAmount(double amount, double change) {
        amount += change;
        return amount;
    }

    /*public static void setCanPass(int a[], int n, int m) {
        canPass = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                canPass[i][j] = a[j + i * n] == 0;
            }
        }
    }

    private static boolean isValidPlayerPosition(double x, double y) {
        return canPass[(int)(x / 16)][(int)(y / 16)];
    }*/
}
