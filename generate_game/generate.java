package Generate_Game;

import Files_handler.Folder_Handling;
import control_sided.DifficultyEnum;
import java.util.List;

//Singelton Design Pattern
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
            board[pair[0]][pair[1]] = 0;
        }

    }

    public void generateAllPuzzles(int[][] solvedBoard) {
        RandomPairs rp = new RandomPairs();
        int removing = 10;
        int k = 0;
        for (DifficultyEnum diff : DifficultyEnum.values()) {

            String diff_lower = diff.name().toLowerCase();
            if (diff_lower.equals(DifficultyEnum.INCOMPLETE.toString().toLowerCase())) {
                continue;
            }
            int[][] puzzle = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    puzzle[i][j] = solvedBoard[i][j];
                }
            }
            removing += 5 * (k++);

            removeRandomCells(puzzle, removing, rp);
            Folder_Handling.get_instance().savePuzzle(puzzle, diff_lower, Folder_Handling.get_instance().getNextFilename(diff_lower));
        }
    }

}
