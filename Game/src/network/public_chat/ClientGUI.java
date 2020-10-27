package network.public_chat;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class ClientGUI {
    private boolean connected;
    private static Client client;
    public static TextArea textArea;
    public static TextField textField;

    public static String username = "parsa";
    public static int portNumber = 1234;
    private String defaultHost;

    // Constructor connection receiving a socket number
    public ClientGUI(String host) {
        defaultHost = host;

        textField.setOnAction(event -> {
            if(connected) {
                send(textField.getText());
                textField.setText("");
                MediaPlayer notification = new MediaPlayer(new Media(new File("src/graphic/sources/music/notif.mp3").toURI().toString()));
                notification.play();
            }
        });

        client = new Client(defaultHost, portNumber, username, this);
        if(!client.start())
            return;
        connected = true;
    }

    public static void send(String msg) {
        client.sendMessage(new ChatMessage(ChatMessage.MESSAGE, msg));
    }

    public static void sendLocation(Location location) {
        client.sendLocation(location);
    }

    public static void sendSingleMessage(SingleMessage message) {
        client.sendSingle(message);
    }

    public static void sendStatus(Status status) {
        client.sendStatus(status);
    }

    public static void append(String str) {
        textArea.appendText(str);
    }

    public static void main(String[] args) {
        new ClientGUI("localhost");
    }

}
