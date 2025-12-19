package control_sided;

import Files_handler.CSVReader;
import Files_handler.Folder_Handling;
import Files_handler.Games_Catalogue;
import Exception.InvalidSolutionException;
import Exception.NotFoundException;
import Generate_Game.generate;



public class GameController implements Viewable {

    @Override
    public Catalog getCatalog() {
        boolean current = Games_Catalogue.get_instance().hasUnfinishedGame();
        boolean allModesExist = Games_Catalogue.get_instance().allDifficultiesAvailable();
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
        generate.get_instance().generateAllPuzzles(game.getBoard());
    }
    
/*
    @Override
    public String verifyGame(Game game) {
   
    }

    @Override
    public int[] solveGame(Game game) {
      
    }

    @Override
    public void logUserAction(String action) {
        
    }
*/
}
