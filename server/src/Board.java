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
}
