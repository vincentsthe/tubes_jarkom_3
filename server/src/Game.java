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

    public void move(int y, int x, int player) {
        if ((player == currentTurn) && (board.isTileEmpty(y, x))) {
            board.placeBidAtTile(player, y, x);

            currentTurn++;
            currentTurn %= playerList.size();

            while (!playerList.get(currentTurn).isConnected()) {
                currentTurn++;
                currentTurn %= playerList.size();
            }

            broadcastBoard();
        }
    }

    public boolean haveWinner() {
        return (board.getConsecutiveBid(winCount) != -1);
    }

    private void broadcastBoard() {
        if (!haveWinner()) {
            Gson gson = new Gson();
            String boardJson = gson.toJson(board);

            for (int i = 0; i < playerList.size(); i++) {
                playerList.get(i).sendMessage(boardJson);
            }
        } else {
            int winner = board.getConsecutiveBid(winCount);

            for (int i = 0; i < playerList.size(); i++) {
                playerList.get(i).sendMessage("Player " + winner + " WIN!!!");
            }
        }
    }
}
