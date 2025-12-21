package control_sided;

import Files_handler.CSVReader;
import Files_handler.Folder_Handling;
import Files_handler.Games_Catalogue;
import Exception.InvalidSolutionException;
import Exception.NotFoundException;
import Generate_Game.generate;
import java.io.IOException;
import java.util.ArrayList;
import verifies.Mod_0;

// speak and play with the backend  --->>>> control layer <<<<-----
public class GameController implements Viewable {

    @Override
    public Catalog getCatalog() {
        String[] levels = {DifficultyEnum.easy.toString(), DifficultyEnum.medium.toString(), DifficultyEnum.hard.toString()};
        boolean current = Games_Catalogue.get_instance().hasUnfinishedGame(DifficultyEnum.incomplete.toString());
        boolean allModesExist = Games_Catalogue.get_instance().allDifficultiesAvailable(levels);
        return new Catalog(current, allModesExist);
    }

    @Override
    public Game getGame(DifficultyEnum level) throws NotFoundException {
        String difficulty = level.name().toLowerCase();
        int[][] board = Folder_Handling.get_instance().loadRandomPuzzle(difficulty);
        if (board == null) {
            throw new NotFoundException("No game found for difficulty: " + difficulty);
        }
        return new Game(board);
    }

    @Override
    public void driveGames(Game game) throws InvalidSolutionException {
        try {
            CSVReader.get_instance().verifySolution(game.getBoard());
        } catch (RuntimeException ex) {
            throw new InvalidSolutionException("Invalid Sudoku solution: " + ex.getMessage());
        }
        String[] levels = {DifficultyEnum.easy.toString(), DifficultyEnum.medium.toString(), DifficultyEnum.hard.toString()};
        generate.get_instance().generateAllPuzzles(game.getBoard(), levels);
    }

    @Override

    public String verifyGame(Game game) {
        int[][] b = game.getBoard();
        Mod_0 mod = new Mod_0(b);
        String all=mod.verify();
        if (!all.isEmpty()) {
            return "invalid " + all;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (b[i][j] == 0) {
                    return "incomplete";
                }
            }
        }
        Folder_Handling.get_instance().deleteCurrentGame();
        return "valid";
    }
    /*
    @Override
    public int[] solveGame(Game game) {
      
    }
     */
    @Override
    public void logUserAction(String action) throws IOException {
    Folder_Handling.get_instance().logUserAction(action);
    }
//FIX THIS EXTRA METHOD
























     @Override
    public void undo(Game game) throws IOException {
    Folder_Handling.get_instance().undo(game.getBoard());
    }
}
