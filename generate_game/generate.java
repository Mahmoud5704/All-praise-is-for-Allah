package generate_game;

import Folder_handler.Folder_Handling;
import java.util.List;

public class generate {

    private static generate instance = null;

    public synchronized static generate get_instance() {
        if (instance == null) {
            instance = new generate();
        }
        return instance;
    }

    public void removeRandomCells(int[][] board, int count, RandomPairs rp) {
        List<int[]> list = rp.generateDistinctPairs(count);
        for (int[] pair : list) {
            int pos = pair[0];   // 0..80
            int row = pos / 9;
            int col = pos % 9;
            board[row][col] = 0;
        }
    }

    public void generateAllPuzzles(int[][] solvedBoard) {
        RandomPairs rp = new RandomPairs();
        String[] difficulties = {"easy", "medium", "hard"};
        int removing = 10;
        int[][] puzzle = new int[9][9];
         for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    puzzle[i][j] = solvedBoard[i][j];
                }
            }
        for (int k=0;k<3;k++) {
            removing += 5*k; 
            removeRandomCells(puzzle, removing, rp);
            Folder_Handling.get_instance().savePuzzle(puzzle, difficulties[k],Folder_Handling.get_instance().getNextFilename(difficulties[k]));
            
        }
    }


}
