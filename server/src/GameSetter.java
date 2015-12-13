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
        Game game = new Game(playerList, 20);

        return game;
    }

    public List<PlayerThread> getPlayerList() {
        return playerList;
    }

    public void addPlayer(PlayerThread playerThread) {
        boolean found = false;
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i) == playerThread) {
                found = true;
            }
        }

        if (!found) {
            playerList.add(playerThread);
        }
    }
}