import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameSetter {

    private List<PlayerThread> playerList;

    public GameSetter() {
        playerList = new ArrayList<>();
    }

    public Game createGame() {
        Game game = new Game(playerList, 15);

        return game;
    }

    public List<PlayerThread> getPlayerList() {
        return playerList;
    }

    public void addPlayer(PlayerThread playerThread) {
        playerList.add(playerThread);
    }
}