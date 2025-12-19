package adapter;

import control_sided.Catalog;
import control_sided.DifficultyEnum;
import Files_handler.CSVReader;
import control_sided.Game;
import control_sided.Viewable;
import exceptions.InvalidSolutionException;
import exceptions.NotFoundException;


public class ControllerAdapter implements Controllable {

    private  Viewable controller;

    public ControllerAdapter(Viewable controller) {
        this.controller = controller;
    }

    @Override//adapt tmam bezn allah -<>-
    public boolean[] getCatalog() {
        Catalog catalog = controller.getCatalog();
        return new boolean[]{ catalog.isCurrent(), catalog.is_AllLevels_Exist() };
    }

    @Override//adapt tmam bezn allah -<>-
    public int[][] getGame(char level) throws NotFoundException {
        DifficultyEnum difficulty;
        switch(Character.toLowerCase(level)) {
            case 'e': difficulty = DifficultyEnum.EASY; break;
            case 'm': difficulty = DifficultyEnum.MEDIUM; break;
            case 'h': difficulty = DifficultyEnum.HARD; break;
            case 'i': difficulty = DifficultyEnum.INCOMPLETE; break;
            default: difficulty = DifficultyEnum.EASY;
        }
        Game game = controller.getGame(difficulty);
        return game.getBoard();
    }

    @Override//adapt tmam bezn allah -<>-
    public void driveGames(String sourcePath) throws InvalidSolutionException {
        int[][] solved = CSVReader.get_instance().read(sourcePath);
        controller.driveGames(new Game(solved));
    }

  /*
        @Override
        public boolean[][] verifyGame(int[][] game) {

        }

    
        @Override
        public int[][] solveGame(int[][] game) throws InvalidGame {

        }

        @Override
        public void logUserAction(UserAction userAction) {
        }
    */
}