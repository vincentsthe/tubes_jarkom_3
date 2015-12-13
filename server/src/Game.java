import com.google.gson.Gson;

import java.util.List;

public class Game {

    private Board board;

    private int winCount;

    private int currentTurn;

    private List<PlayerThread> playerList;

    public Game(List<PlayerThread> playerList, int boardSize) {
        board = new Board(boardSize);
        this.playerList = playerList;
        this.winCount = 5;
        this.currentTurn = 0;
    }

    public void start() {
        for (int i = 0; i < playerList.size(); i++) {
            playerList.get(i).setGame(this);
        }
    }

    public Board getBoard() {
        return board;
    }

    public List<PlayerThread> getPlayerList() {
        return playerList;
    }

    public void move(int y, int x, PlayerThread playerThread) {
        System.out.println(x + " " + y);
        int player = -1;
        for (int i = 0; i < playerList.size(); i++) {
            if (playerThread == playerList.get(i)) {
                player = i;
            }
        }

        if ((player == currentTurn) && (board.isTileEmpty(y, x))) {
            board.placeBidAtTile(player, y, x);

            currentTurn++;
            currentTurn %= playerList.size();

            while (!playerList.get(currentTurn).isConnected()) {
                currentTurn++;
                currentTurn %= playerList.size();
            }
        }
    }

    public boolean haveWinner() {
        return (board.getConsecutiveBid(winCount) != -1);
    }
}
