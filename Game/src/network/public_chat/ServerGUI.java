package network.public_chat;

public class ServerGUI {
    public static int portNumber = 1234;
    private Server server;

    public ServerGUI() {
        server = new Server(portNumber);
        new ServerRunning().start();
    }

    public static void main(String[] arg) {
        new ServerGUI();
    }

    class ServerRunning extends Thread {
        public void run() {
            server.start();
            server = null;
        }
    }
}
