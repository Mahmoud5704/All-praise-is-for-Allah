package control_sided;

public class Game {

    private int[][] board;

    public Game(int[][] board) {
        // IMPORTANT: DON'T COPY THE BOARD BY VALUE
        // USE REFERENCES
        this.board = board;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board; // also stores reference
    }
}
