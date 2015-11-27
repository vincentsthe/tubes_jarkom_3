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

    public int getWinner() {
        final int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
        final int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};

        int boardSize = board.getBoardSize();

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board.getTileAtPosition(i, j) != -1) {
                    for (int z = 0; z < 8; z++) {
                        int yn = i;
                        int xn = j;

                        int streak = 0;
                        while ((streak < winCount) && ((yn >= 0) && (yn < boardSize)) && ((xn >= 0) && (xn < boardSize)) && (board.getTileAtPosition(i, j) == board.getTileAtPosition(yn, xn))) {
                            streak++;
                            yn += dy[z];
                            xn += dx[z];
                        }

                        if (streak == winCount) {
                            return board.getTileAtPosition(i, j);
                        }
                    }
                }
            }
        }

        return -1;
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

    private void broadcastBoard() {
        Gson gson = new Gson();
        String boardJson = gson.toJson(board);

        for (int i = 0; i < playerList.size(); i++) {
            playerList.get(i).sendMessage(boardJson);
        }
    }
}
