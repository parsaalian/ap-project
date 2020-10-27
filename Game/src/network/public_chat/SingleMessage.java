package network.public_chat;

import java.io.Serializable;

public class SingleMessage implements Serializable {
    private String from;
    private String to;
    private boolean canChat;

    public SingleMessage(String from, String to, boolean canChat) {
        System.out.println(1);
        this.from = from;
        this.to = to;
        this.canChat = canChat;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public boolean isCanChat() {
        return canChat;
    }
}
