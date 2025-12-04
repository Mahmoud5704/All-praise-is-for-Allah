package backend_generate;

import java.util.List;
import check_somes.mod_0;

public class generate {

    public void removeRandomCells(int[][] board, int count, RandomPairs rp) {
        List<int[]> list = rp.generateDistinctPairs(count);
        for (int[] pair : list) {
            int pos = pair[0];   // 0..80
            int row = pos / 9;
            int col = pos % 9;
            board[row][col] = 0;
        }
    }

    public int[][] generatePuzzleOnly(int[][] solvedBoard, String dif) {

        int[][] puzzle = new int[9][9];

        // Copy board
        for (int i = 0; i < 9; i++) {
            System.arraycopy(solvedBoard[i], 0, puzzle[i], 0, 9);
        }

        int removeCount=0;
        if (dif.equalsIgnoreCase("easy")) {
            removeCount = 10;
        } else if (dif.equalsIgnoreCase("medium")) {
            removeCount = 15;
        } else if (dif.equalsIgnoreCase("hard")) {
            removeCount = 25;
        } 
        RandomPairs rp = new RandomPairs();
        removeRandomCells(puzzle, removeCount, rp);

        return puzzle;
    }

    public void verifySolution(int[][] board) {
        mod_0 verifier = new mod_0(board);
        if (!verifier.verify()) {
            throw new RuntimeException("Sudoku board is INVALID or INCOMPLETE!");
        }
    }
}
