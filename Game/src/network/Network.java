package network;

import graphic.Handle.EnvGroup;
import graphic.Handle.Graphic_Handler;
import graphic.Handle.environment.farm.Farm_Graphic;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.util.Duration;
import network.public_chat.ClientGUI;
import network.public_chat.Location;
import network.public_chat.ServerGUI;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Network {
    public static String serverString;
    public static String clientString;

    public static void networkScene() {
        Group root = new Group();
        Scene scene = new Scene(root, 960, 712.5);

        Rectangle getBack = new Rectangle(300, 70);
        getBack.setLayoutX(330);
        getBack.setLayoutY(370);
        getBack.setArcHeight(50);
        getBack.setArcWidth(50);
        getBack.setFill(Color.web("#03a9f4"));
        getBack.setOpacity(0);

        TextField getName = new TextField("");
        getName.setFont(new Font("times new roman", 15));
        getName.setOpacity(0);
        getName.setLayoutX(420);
        getName.setLayoutY(390);
        getName.setDisable(true);

        Label thisName = new Label("Name");
        thisName.setTextFill(Color.WHITE);
        thisName.setFont(new Font("times new roman", 20));
        thisName.setLayoutX(350);
        thisName.setLayoutY(392);
        thisName.setOpacity(0);

        Rectangle fade = new Rectangle(960, 713);
        fade.setOpacity(0.7);
        fade.setFill(Color.WHITE);

        Label multiplayer = new Label("Multiplayer");
        multiplayer.setFont(new Font("Snickles", 70));
        multiplayer.setTextFill(Color.web("#EF6C00"));
        multiplayer.setLayoutX(370);
        multiplayer.setLayoutY(100);

        ImageView background = new ImageView(new Image("graphic/sources/server/cloud.jpg"));
        background.setFitHeight(713);
        background.setFitWidth(background.getImage().getWidth() * 713 / background.getImage().getHeight());

        ImageView becomeServer = new ImageView(new Image("graphic/sources/server/become_server.png"));
        becomeServer.setFitWidth(becomeServer.getImage().getWidth() / 2);
        becomeServer.setFitHeight(becomeServer.getImage().getHeight() / 2);
        becomeServer.setLayoutY(330);
        becomeServer.setLayoutX(250);

        ImageView becomeClient = new ImageView(new Image("graphic/sources/server/become_client.png"));
        becomeClient.setFitWidth(becomeClient.getImage().getWidth() / 2);
        becomeClient.setFitHeight(becomeClient.getImage().getHeight() / 2);
        becomeClient.setLayoutY(330);
        becomeClient.setLayoutX(520);

        ImageView back = new ImageView(new Image("graphic/sources/server/back.png"));
        back.setFitWidth(80);
        back.setFitHeight(80);
        back.setLayoutX(20);
        back.setLayoutY(613);

        ImageView confirm = new ImageView(new Image("graphic/sources/server/confirm.png"));
        confirm.setFitWidth(80);
        confirm.setFitHeight(80);
        confirm.setLayoutX(860);
        confirm.setLayoutY(613);
        confirm.setOpacity(0);

        back.setOnMouseClicked(event -> Graphic_Handler.game.setScene(Graphic_Handler.mainMenu()));

        becomeServer.setOnMouseClicked(event -> {
            if(becomeServer.getOpacity() == 1) {
                Graphic_Handler.fadeMainMenu(becomeServer, 1, 0, 500).play();
                Graphic_Handler.fadeMainMenu(becomeClient, 1, 0, 500).play();
                FadeTransition name = Graphic_Handler.fadeMainMenu(getName, 0, 1, 500);
                FadeTransition nameLabel = Graphic_Handler.fadeMainMenu(thisName, 0, 1, 500);
                FadeTransition backRec = Graphic_Handler.fadeMainMenu(getBack, 0, 0.8, 500);
                FadeTransition conFade = Graphic_Handler.fadeMainMenu(confirm, 0, 1, 500);
                name.setDelay(Duration.millis(500));
                nameLabel.setDelay(Duration.millis(500));
                backRec.setDelay(Duration.millis(500));
                conFade.setDelay(Duration.millis(500));
                name.play();
                nameLabel.play();
                backRec.play();
                conFade.play();
                getName.setDisable(false);
                back.setOnMouseClicked(event1 -> networkScene());

                confirm.setOnMouseClicked(event1 -> {
                    if(!getName.getText().equals("")) {
                        int socketNumber = getFreeSocket();
                        String startName = getName.getText();
                        ServerGUI.portNumber = socketNumber;
                        new ServerGUI();
                        ClientGUI.textField = EnvGroup.textField;
                        ClientGUI.textArea = EnvGroup.textArea;
                        ClientGUI.portNumber = socketNumber;
                        ClientGUI.username = startName;

                        serverString = startName;
                        clientString = startName;

                        new ClientGUI("localhost");
                        Graphic_Handler.isOnline = true;
                        Farm_Graphic.farmScene("start");

                        setLocation();

                        String where = "/Users/parsa/Desktop/Uni/Project/team_25/Game/src/network/server_info/" + startName;
                        Path path = Paths.get(where);
                        try {
                            Files.createDirectories(path);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            FileWriter writeServerFile = new FileWriter(where + "/info.txt", true);
                            FileWriter writeServerInfo = new FileWriter("src/network/server_info/info.txt", true);
                            writeServerInfo.append(startName).append(" : ").append(Integer.toString(socketNumber)).append("\n");
                            writeServerFile.append(startName).append("\n");
                            writeServerFile.close();
                            writeServerInfo.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setHeaderText(null);
                        alert.setTitle(null);
                        alert.setContentText("Please choose a name for your server");
                        alert.show();
                    }
                });
            }
        });

        becomeClient.setOnMouseClicked(event -> {
            if(becomeClient.getOpacity() == 1) {
                ListView<String> serverNames = new ListView<>();
                try {
                    FileReader fileReader = new FileReader("src/network/server_info/info.txt");
                    StringBuilder result = new StringBuilder();
                    int ascii = fileReader.read();
                    while(ascii != -1) {
                        result.append((char) ascii);
                        ascii = fileReader.read();
                    }
                    String[] servers = result.toString().split("\n");
                    for (String server : servers) {
                        serverNames.getItems().add(server.split(" : ")[0]);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                serverNames.setLayoutX(330);
                serverNames.setLayoutY(200);
                serverNames.setMinWidth(300);
                serverNames.setMaxHeight(300);
                serverNames.setOpacity(0);
                root.getChildren().addAll(serverNames);

                getBack.setLayoutY(getBack.getLayoutY() + 150);
                getName.setLayoutY(getName.getLayoutY() + 150);
                thisName.setLayoutY(thisName.getLayoutY() + 150);

                Graphic_Handler.fadeMainMenu(becomeServer, 1, 0, 500).play();
                Graphic_Handler.fadeMainMenu(becomeClient, 1, 0, 500).play();
                FadeTransition name = Graphic_Handler.fadeMainMenu(getName, 0, 1, 500);
                FadeTransition backRec = Graphic_Handler.fadeMainMenu(getBack, 0, 0.8, 500);
                FadeTransition nameLabel = Graphic_Handler.fadeMainMenu(thisName, 0, 1, 500);
                FadeTransition conFade = Graphic_Handler.fadeMainMenu(confirm, 0, 1, 500);
                FadeTransition list = Graphic_Handler.fadeMainMenu(serverNames, 0, 1, 500);
                name.setDelay(Duration.millis(500));
                backRec.setDelay(Duration.millis(500));
                nameLabel.setDelay(Duration.millis(500));
                conFade.setDelay(Duration.millis(500));
                list.setDelay(Duration.millis(500));
                name.play();
                backRec.play();
                nameLabel.play();
                conFade.play();
                list.play();
                getName.setDisable(false);

                back.setOnMouseClicked(event1 -> networkScene());

                confirm.setOnMouseClicked(event1 -> {
                    if(!getName.getText().equals("") && serverNames.getSelectionModel().getSelectedItems().size() != 0) {
                        int socket = 1234;
                        String startName = getName.getText();
                        String serverName = serverNames.getSelectionModel().getSelectedItem();
                        try {
                            FileReader fileReader = new FileReader("src/network/server_info/info.txt");
                            StringBuilder result = new StringBuilder();
                            int ascii = fileReader.read();
                            while (ascii != -1) {
                                result.append((char) ascii);
                                ascii = fileReader.read();
                            }
                            String[] servers = result.toString().split("\n");
                            for (String server : servers) {
                                if (server.split(" : ")[0].equals(serverName)) {
                                    socket = Integer.valueOf(server.split(" : ")[1]);
                                    break;
                                }
                            }
                            FileWriter writeServerFile = new FileWriter("/Users/parsa/Desktop/Uni/Project/team_25/Game/src/network/server_info/" + serverName + "/info.txt", true);
                            writeServerFile.append(startName).append("\n");
                            writeServerFile.close();
                            ClientGUI.textArea = EnvGroup.textArea;
                            ClientGUI.textField = EnvGroup.textField;
                            ClientGUI.portNumber = socket;
                            ClientGUI.username = startName;

                            serverString = serverName;
                            clientString = startName;

                            new ClientGUI("localhost");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        setLocation();

                        Graphic_Handler.isOnline = true;
                        Farm_Graphic.farmScene("start");
                    }
                    else if(!getName.getText().equals("")) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setHeaderText(null);
                        alert.setTitle(null);
                        alert.setContentText("Please choose a server");
                        alert.show();
                    }
                    else if(serverNames.getSelectionModel().getSelectedItems().size() != 0) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setHeaderText(null);
                        alert.setTitle(null);
                        alert.setContentText("Please choose a name");
                        alert.show();
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setHeaderText(null);
                        alert.setTitle(null);
                        alert.setContentText("Please choose a name and a server");
                        alert.show();
                    }
                });
            }
        });

        ImageView server = new ImageView(new Image("graphic/sources/server/server.png"));
        server.setFitWidth(200);
        server.setFitHeight(200);
        server.setLayoutX(20);
        server.setLayoutY(20);

        root.getChildren().addAll(background, fade, server, multiplayer, getBack, becomeServer, becomeClient, back, confirm, thisName, getName);
        Graphic_Handler.game.setScene(scene);
    }

    public static int getFreeSocket() {
        int socketNumber = 1234;
        try {
            FileWriter fileWriter = new FileWriter("src/network/server_info/socket_number.txt", true);
            FileReader fileReader = new FileReader("src/network/server_info/socket_number.txt");
            StringBuilder result = new StringBuilder();
            int ascii = fileReader.read();
            while(ascii != -1) {
                result.append((char) ascii);
                ascii = fileReader.read();
            }
            String[] socketString = result.toString().split("\n");
            socketNumber = Integer.valueOf(socketString[socketString.length - 1]);

            fileWriter.append("\n").append(Integer.toString(socketNumber + 1));
            fileReader.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return socketNumber;
    }

    private static void setLocation() {
        Timeline locationSetter = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            double x = EnvGroup.getPlayer().getLayoutX() - EnvGroup.getImage().getTranslateX();
            double y = EnvGroup.getPlayer().getLayoutY() - EnvGroup.getImage().getTranslateY();
            Location location = new Location(x, y, clientString, EnvGroup.isInVillage);
            ClientGUI.sendLocation(location);
        }));
        locationSetter.setCycleCount(-1);
        locationSetter.play();
    }
}
