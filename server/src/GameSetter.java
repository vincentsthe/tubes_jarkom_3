import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameSetter {

    private List<PlayerThread> playerList;

    private ServerSocket serverSocket;

    PlayerRegistrator playerRegistrator;

    public GameSetter(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        playerList = new ArrayList<>();
        playerRegistrator = new PlayerRegistrator(this);

        System.out.println("Waiting for player to join.....");
        playerRegistrator.start();
    }

    public Game createGame() {
        playerRegistrator.interrupt();
        Game game = new Game(playerList, 15);

        return game;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void addPlayer(Socket connection) {
        playerList.add(new PlayerThread(connection, playerList.size()));
    }
}

class PlayerRegistrator extends Thread {

    private GameSetter gameSetter;

    public PlayerRegistrator(GameSetter gameSetter) {
        this.gameSetter = gameSetter;
    }

    @Override
    public void run() {
        Socket socket = null;

        while (true) {
            try {
                if (gameSetter.getServerSocket() == null) {
                    System.out.println("server socket null");
                }
                socket = gameSetter.getServerSocket().accept();
            } catch (IOException ex) {
                System.out.println("Error connecting to client...");
            }

            if (Thread.interrupted()) {
                return;
            }
            gameSetter.addPlayer(socket);
        }
    }
}