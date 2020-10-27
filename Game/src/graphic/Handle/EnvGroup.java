package graphic.Handle;

import game.Game;
import graphic.Handle.farmer.Farmer_Graphic;
import game.farmer.Farmer;
import graphic.Menu.Message;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import graphic.Menu.Menu;
import graphic.Menu.MenuItem;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;
import network.Network;
import network.public_chat.ClientGUI;
import network.public_chat.Location;
import network.public_chat.SingleMessage;
import network.public_chat.Status;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class EnvGroup extends Group {
    public static boolean isInVillage = false;

    private static double x, y, x1, y1;

    private static boolean isOnPublicChatWindow = false;
    private static boolean isOnChatSelectWindow = false;
    private static boolean isOnStatusWindow = false;

    public static TextArea textArea = new TextArea();
    public static TextField textField = new TextField();
    private static ListView<String> chatList = new ListView<>();
    private static Button sendChatRequest = new Button("send request");
    private static Button getPlayerStatus = new Button("get status");
    private final static int TIME_RATE = 100;

    public static ProgressBar healthPro;
    public static ProgressBar energyPro;
    public static ProgressBar staminaPro;
    public static ProgressBar satietyPro;

    private static int COLUMNS  =   9;
    private static int COUNT    =  9;
    private static int OFFSET_X =  0;
    private static int OFFSET_Y =  10 * 64;
    private static int WIDTH    = 64;
    private static int HEIGHT   = 64;

    public static ImageView inspect = new ImageView(new Image("graphic/sources/game/inspect.png"));

    private static ImageView background = new ImageView();
    private static ImageView player = new ImageView(new Image("graphic/sources/game/character.png"));

    public static ImageView otherPlayer = new ImageView(new Image("graphic/sources/online/avatar.png"));

    private Label hour = new Label();
    private Label date = new Label();

    public static ImageView appleTree = new ImageView(new Image("graphic/sources/fruits/apple_tree/tree 0.png"));

    private Menu pauseMenu;
    private Menu activeMenu = null;
    public Animation animation;

    public void setDir(String dir) {
        boolean change = true;
        if (dir.equals("UP"))
            OFFSET_Y = 8 * HEIGHT;
        else if (dir.equals("LEFT"))
            OFFSET_Y = 9 * HEIGHT;
        else if (dir.equals("DOWN"))
            OFFSET_Y = 10 * HEIGHT;
        else if (dir.equals("RIGHT"))
            OFFSET_Y = 11 * HEIGHT;
        else
            change = false;
        if (change)
            ((SpriteAnimation) animation).offsetY = OFFSET_Y;
    }

    public EnvGroup(ImageView back) {
        otherPlayer.setFitWidth(64);
        otherPlayer.setFitHeight(64);

        appleTree.setLayoutX(getImage().getTranslateX() + 497);
        appleTree.setLayoutY(getImage().getTranslateX() + 1220);

        hour.setTextFill(Color.WHITE);
        hour.setLayoutX(750);
        hour.setLayoutY(22);

        date.setTextFill(Color.WHITE);
        date.setLayoutX(700);
        date.setLayoutY(22);

        Rectangle clockBack = new Rectangle(60, 25, Color.BLACK);
        clockBack.setLayoutX(738);
        clockBack.setLayoutY(18);
        clockBack.setArcWidth(25);
        clockBack.setArcHeight(25);
        clockBack.setOpacity(0.7);

        Circle dateBack = new Circle(12.5, Color.BLACK);
        dateBack.setLayoutX(708);
        dateBack.setLayoutY(30);
        dateBack.setOpacity(0.7);

        otherPlayer.setOpacity(0);

        inspect.setFitWidth(200);
        inspect.setFitHeight(200);
        inspect.setLayoutX(380);
        inspect.setLayoutY(256.25);
        inspect.setOpacity(0);

        Button button = new Button("getLoc");
        button.setOnMouseClicked(event -> {
            System.out.println("x: " + (getPlayer().getLayoutX() - getImage().getTranslateX()) + "\ty: " + (getPlayer().getLayoutY() - getImage().getTranslateY()));
        });
        button.setDisable(false);

        Graphic_Handler.sceneRoot = this;

        player.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
        animation = new SpriteAnimation(
                player,
                Duration.millis(500),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        );

        background = back;
        ImageView pauseButton = new ImageView(new Image("graphic/sources/menu/pause.png"));
        pauseButton.setFitWidth(30);
        pauseButton.setFitHeight(30);
        pauseButton.setLayoutX(900);
        pauseButton.setLayoutY(15);

        Rectangle itemsBack = new Rectangle(940, 40);
        itemsBack.setFill(Color.WHITE);
        itemsBack.setOpacity(0.5);
        itemsBack.setLayoutX(10);
        itemsBack.setLayoutY(10);
        itemsBack.setArcWidth(40);
        itemsBack.setArcHeight(40);

        ImageView health = new ImageView(new Image("graphic/sources/game/Health.png"));
        health.setFitWidth(30);
        health.setFitHeight(30);
        health.setLayoutX(30);
        health.setLayoutY(15);
        healthPro = new ProgressBar();
        healthPro.setProgress(Farmer.health / Farmer.maxHealth);
        healthPro.setLayoutX(65);
        healthPro.setLayoutY(20);


        ImageView energy = new ImageView(new Image("graphic/sources/game/Energy.png"));
        energy.setFitWidth(30);
        energy.setFitHeight(30);
        energy.setLayoutX(200);
        energy.setLayoutY(15);
        energyPro = new ProgressBar();
        energyPro.setProgress(Farmer.energy / Farmer.maxEnergy);
        energyPro.setLayoutX(235);
        energyPro.setLayoutY(20);

        ImageView stamina = new ImageView(new Image("graphic/sources/game/Stamina.png"));
        stamina.setFitWidth(30);
        stamina.setFitHeight(30);
        stamina.setLayoutX(370);
        stamina.setLayoutY(15);
        staminaPro = new ProgressBar();
        staminaPro.setProgress(Farmer.stamina / Farmer.maxStamina);
        staminaPro.setLayoutX(405);
        staminaPro.setLayoutY(20);

        ImageView satiety = new ImageView(new Image("graphic/sources/game/Satiety.png"));
        satiety.setFitWidth(30);
        satiety.setFitHeight(30);
        satiety.setLayoutX(540);
        satiety.setLayoutY(15);
        satietyPro = new ProgressBar();
        satietyPro.setProgress(Farmer.satiety / Farmer.maxSatiety);
        satietyPro.setLayoutX(575);
        satietyPro.setLayoutY(20);

        ImageView money = new ImageView(new Image("graphic/sources/game/money.png"));
        money.setFitWidth(40);
        money.setFitHeight(40);
        money.setLayoutX(20);
        money.setLayoutY(662.5);
        Rectangle moneyBack = new Rectangle(100, 40);
        moneyBack.setFill(new Color(0.9569, 0.2588, 0.2157, 1));
        moneyBack.setLayoutX(40);
        moneyBack.setLayoutY(662.5);
        moneyBack.setArcWidth(40);
        moneyBack.setArcHeight(40);
        Rectangle moneyBack1 = new Rectangle(50, 40);
        moneyBack1.setFill(new Color(0.9569, 0.2667, 0.2235, 1));
        moneyBack1.setLayoutX(40);
        moneyBack1.setLayoutY(662.5);
        Label moneyLabel = new Label(Integer.toString(Farmer.money));
        moneyLabel.setFont(new Font("Times new roman", 25));
        moneyLabel.setTextFill(Color.WHITE);
        moneyLabel.setLayoutX(65);
        moneyLabel.setLayoutY(667.5);


        pauseMenu = new Menu("Pause", this);
        pauseMenu.getMenuItem(0).setText("Continue");
        Menu otherMenu = new Menu("Test", this, pauseMenu);
        otherMenu.addAll(new MenuItem("one", otherMenu));
        MenuItem backpack = new MenuItem("Show The Backpack", pauseMenu);
        MenuItem status = new MenuItem("Show Status", pauseMenu);
        MenuItem quit = new MenuItem("Quit to Main Menu", pauseMenu);
        status.setGoesTo(new Message(Game.Parsa.stats()));
        quit.setGoesTo(() -> Graphic_Handler.game.setScene(Graphic_Handler.mainMenu()));
        pauseMenu.addAll(backpack, status, quit);
        backpack.setGoesTo(()->Menu.accessBackpack(this, pauseMenu, ()->{}));

        getChildren().addAll(background, player, itemsBack, pauseButton, health, healthPro, energy, energyPro, stamina, staminaPro, satiety, satietyPro, moneyBack, moneyBack1, money, moneyLabel, inspect, otherPlayer, clockBack, hour, dateBack, date, appleTree);

        moveTree();

        stepTime();

        pauseButton.setOnMouseClicked(event -> {
            if(!getChildren().contains(pauseMenu)) {
                pauseMenu.start();
            }
        });

    }

    public void addOnlineButtons() {
        sendChatRequest.setMinSize(440, 50);
        sendChatRequest.setLayoutX(960);
        sendChatRequest.setLayoutY(712.5 - 50);
        sendChatRequest.setOnMouseClicked(event -> {
            if (chatList.getSelectionModel().getSelectedItems().size() == 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("You have to choose a member to start chat.");
                alert.show();
            }
            else {
                String to = chatList.getSelectionModel().getSelectedItem();
                String from = Network.clientString;
                SingleMessage singleMessage = new SingleMessage(from, to, false);
                ClientGUI.sendSingleMessage(singleMessage);
            }
        });

        getPlayerStatus.setMinSize(440,50);
        getPlayerStatus.setLayoutX(960);
        getPlayerStatus.setLayoutY(712.5 - 50);
        getPlayerStatus.setOnMouseClicked(event -> {
            if (chatList.getSelectionModel().getSelectedItems().size() == 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(null);
                alert.setHeaderText(null);
                alert.setContentText("You have to choose a member to see status.");
                alert.show();
            }
            else {
                Status status = new Status(Network.clientString, Farmer.health, Farmer.maxHealth, Farmer.energy, Farmer.maxEnergy, Farmer.stamina, Farmer.maxStamina, Farmer.satiety, Farmer.maxSatiety, Farmer.money);

            }
        });

        otherPlayer.setOpacity(0);
        otherPlayer.setLayoutX(500);
        otherPlayer.setLayoutY(650);

        chatList.setLayoutX(960);
        chatList.setMinWidth(440);
        chatList.setMinHeight(712.5);

        textArea.setLayoutX(960);
        textArea.setMinWidth(440);
        textArea.setMinHeight(680);
        textArea.setEditable(false);

        textField.setLayoutX(960);
        textField.setLayoutY(680);
        textField.setMinWidth(440);
        textField.setMinHeight(32.5);

        ImageView groupChat = new ImageView(new Image("graphic/sources/online/group_chat.png"));
        groupChat.setFitWidth(30);
        groupChat.setFitHeight(30);
        groupChat.setLayoutX(850);
        groupChat.setLayoutY(15);
        groupChat.setOnMouseClicked(event -> {
            if(isOnPublicChatWindow) {
                Graphic_Handler.game.setWidth(960);
                Graphic_Handler.game.setX(Graphic_Handler.game.getX() + 220);
                getChildren().removeAll(textArea, textField);
            }
            else {
                Graphic_Handler.game.setWidth(1400);
                Graphic_Handler.game.setX(Graphic_Handler.game.getX() - 220);
                getChildren().addAll(textArea, textField);
            }
            isOnPublicChatWindow = !isOnPublicChatWindow;
        });

        ImageView chat = new ImageView(new Image("graphic/sources/online/chat.png"));
        chat.setFitWidth(40);
        chat.setFitHeight(40);
        chat.setLayoutY(662.5);
        chat.setLayoutX(720);
        chat.setOnMouseClicked(event -> {
            if (isOnChatSelectWindow) {
                Graphic_Handler.game.setWidth(960);
                Graphic_Handler.game.setX(Graphic_Handler.game.getX() + 220);
                getChildren().removeAll(chatList, sendChatRequest);
            }
            else {
                for (String string : getNames()) {
                    if (!chatList.getItems().contains(string)) {
                        chatList.getItems().add(string);
                    }
                }
                Graphic_Handler.game.setWidth(1400);
                Graphic_Handler.game.setX(Graphic_Handler.game.getX() - 220);
                getChildren().addAll(chatList, sendChatRequest);
            }
            isOnChatSelectWindow = !isOnChatSelectWindow;
        });

        ImageView friend = new ImageView(new Image("graphic/sources/online/friends.png"));
        friend.setFitWidth(40);
        friend.setFitHeight(40);
        friend.setLayoutY(662.5);
        friend.setLayoutX(780);
        friend.setOnMouseClicked(event -> {

        });

        ImageView trade = new ImageView(new Image("graphic/sources/online/trade.png"));
        trade.setFitWidth(40);
        trade.setFitHeight(40);
        trade.setLayoutY(662.5);
        trade.setLayoutX(840);

        ImageView status = new ImageView(new Image("graphic/sources/online/status.png"));
        status.setFitWidth(40);
        status.setFitHeight(40);
        status.setLayoutY(662.5);
        status.setLayoutX(900);
        status.setOnMouseClicked(event -> {
            if (isOnStatusWindow) {
                Graphic_Handler.game.setWidth(960);
                getChildren().removeAll(chatList, getPlayerStatus);
                Graphic_Handler.game.setX(Graphic_Handler.game.getX() + 220);
            }
            else {
                for (String string : getNames()) {
                    if (!chatList.getItems().contains(string)) {
                        chatList.getItems().add(string);
                    }
                }
                Graphic_Handler.game.setWidth(1400);
                getChildren().addAll(chatList, getPlayerStatus);
                Graphic_Handler.game.setX(Graphic_Handler.game.getX() - 220);
            }
            isOnStatusWindow = !isOnStatusWindow;
        });

        getChildren().addAll(chat, friend, trade, status, groupChat);
    }

    private ArrayList<String> getNames() {
        ArrayList<String> names = new ArrayList<>();
        try {
            FileReader namesToChat = new FileReader("/Users/seyedparsa/Desktop/Project/team_25/Game/src/network/server_info/" + Network.serverString + "/info.txt");
            StringBuilder result = new StringBuilder();
            int ascii = namesToChat.read();
            while (ascii != -1) {
                result.append((char) ascii);
                ascii = namesToChat.read();
            }
            String[] servers = result.toString().split("\n");
            for (String string : servers) {
                if (!string.equals(Network.clientString)) {
                    names.add(string);
                }
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return names;
    }

    public void changePause() {
        if (activeMenu != null) {
            activeMenu.exitBack();
        }
        else {
            pauseMenu.start();
        }
    }

    public boolean isActive(){
        return activeMenu == null;
    }

    public void setActiveMenu(Menu menu){
        activeMenu = menu;
    }

    public void Pause(Menu menu){
        if (isActive()) {
            Farmer_Graphic.move.pause();
            activeMenu = menu;
        }
    }

    public void Play(){
        if (!isActive()) {
            Farmer_Graphic.move.play();
            activeMenu = null;
            requestFocus();
        }
    }

    private void showTime() {
        String hourString;
        String minuteString;
        String dateString;
        if (Clock.getHour() < 10) {
            hourString = "0" + Integer.toString(Clock.getHour());
        }
        else {
            hourString = Integer.toString(Clock.getHour());
        }
        if (Clock.getMinute() < 10) {
            minuteString = "0" + Integer.toString(Clock.getMinute());
        }
        else {
            minuteString = Integer.toString(Clock.getMinute());
        }
        if (Clock.getDate() < 10) {
            dateString = "0" + Integer.toString(Clock.getDate());
        }
        else {
            dateString = Integer.toString(Clock.getDate());
        }
        hour.setText(hourString + ":" + minuteString);
        date.setText(dateString);
    }

    private void stepTime() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(TIME_RATE), event -> {
            Clock.stepForward();
            showTime();
        }));
        timeline.setCycleCount(-1);
        timeline.play();
    }

    public static ImageView getImage(){ return background; }

    public static ImageView getPlayer() { return player; }

    public static void setLocation(Location location) {
        if (location.isInVillage() && isInVillage) {
            double x = location.getX();
            double y = location.getY();
            otherPlayer.setLayoutX(getImage().getTranslateX() + x);
            otherPlayer.setLayoutY(getImage().getTranslateY() + y);
            otherPlayer.setOpacity(1);
        }
    }

    private static void moveTree() {
        x = appleTree.getLayoutX() - getImage().getTranslateX();
        y = appleTree.getLayoutY() - getImage().getTranslateY();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), event -> {
            appleTree.setLayoutX(x + getImage().getTranslateX());
            appleTree.setLayoutY(y + getImage().getTranslateY());
            x = appleTree.getLayoutX() - getImage().getTranslateX();
            y = appleTree.getLayoutY() - getImage().getTranslateY();
        }));
        timeline.setCycleCount(-1);
        timeline.play();
    }
}
