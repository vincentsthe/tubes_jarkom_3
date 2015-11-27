import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<List<Integer>> playerTile;

    private int boardSize;

    public Board(int size) {
        boardSize = size;
        playerTile = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(-1);
            }
            playerTile.add(row);
        }
    }

    public int getBoardSize() {
        return boardSize;
    }

    public int getTileAtPosition(int y, int x) {
        return playerTile.get(y).get(x);
    }

    public boolean isTileEmpty(int y, int x) {
        return (getTileAtPosition(y, x) == -1);
    }

    public void placeBidAtTile(int playerNumber, int y, int x) {
        playerTile.get(y).set(x, playerNumber);
    }

    public int getConsecutiveBid(int n) {
        final int dy[] = {-1, -1, 0, 1, 1, 1, 0, -1};
        final int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};

        int boardSize = getBoardSize();

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (getTileAtPosition(i, j) != -1) {
                    for (int z = 0; z < 8; z++) {
                        int yn = i;
                        int xn = j;

                        int streak = 0;
                        while ((streak < n) && ((yn >= 0) && (yn < boardSize)) && ((xn >= 0) && (xn < boardSize)) && (getTileAtPosition(i, j) == getTileAtPosition(yn, xn))) {
                            streak++;
                            yn += dy[z];
                            xn += dx[z];
                        }

                        if (streak == n) {
                            return getTileAtPosition(i, j);
                        }
                    }
                }
            }
        }

        return -1;
    }
}
