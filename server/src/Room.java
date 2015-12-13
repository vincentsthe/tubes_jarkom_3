import java.util.ArrayList;
import java.util.List;

public class Room {
    public static List<Room> roomList = new ArrayList<>();

    private String name;

    private GameSetter gameSetter;

    private Game game;

    public Room(String name) {
        this.name = name;
        this.gameSetter = new GameSetter();

        Room.roomList.add(this);
    }

    public String getName() {
        return name;
    }

    public Game getGame() {
        return game;
    }

    public List<PlayerThread> getPlayers() {
        return gameSetter.getPlayerList();
    }

    public void registerPlayer(PlayerThread playerThread) {
        this.gameSetter.addPlayer(playerThread);
    }

    public boolean isGameStarted() {
        return (game != null);
    }

    public Game startGame() {
        game = gameSetter.createGame();
        for (PlayerThread player: gameSetter.getPlayerList()) {
            player.notifyGameStart();
        }
        return game;
    }

    public static synchronized Room getRoomByRoomName(String name) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).name.equals(name)) {
                return roomList.get(i);
            }
        }
        return null;
    }
}
