import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] argv) {
        int port = Integer.parseInt(argv[0]);

        try {
            ServerSocket serverSocket = new ServerSocket(port);

            PlayerConnection playerConnection = new PlayerConnection(serverSocket);

            System.out.println("Waiting for player to join.....");
            playerConnection.start();
        } catch (IOException e) {
            System.out.println("Error establishing socket");
        }
    }
}

class PlayerConnection extends Thread {

    private ServerSocket serverSocket;

    private List<PlayerThread> playerThreadList;

    public PlayerConnection(ServerSocket serverSocket) {
        this.playerThreadList = new ArrayList<>();
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        Socket socket = null;

        while (true) {
            try {
                if (serverSocket == null) {
                    System.out.println("server socket null");
                }
                socket = serverSocket.accept();
                if (socket == null) {
                    System.out.printf("Socket null");
                }
                System.out.println("A player is connected");
            } catch (IOException ex) {
                System.out.println("Error connecting to client...");
            }

            if (Thread.interrupted()) {
                return;
            }
            PlayerThread playerThread = new PlayerThread(socket);
            playerThread.start();
            playerThreadList.add(playerThread);
        }
    }
}