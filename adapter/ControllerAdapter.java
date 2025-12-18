package adapter;

import control_sided.Catalog;
import control_sided.DifficultyEnum;
import Files_handler.CSVReader;
import control_sided.Game;
import control_sided.Viewable;
import exceptions.InvalidSolutionException;
import exceptions.NotFoundException;
import view_sided.Controllable;


public class ControllerAdapter implements Controllable {

    private  Viewable controller;

    public ControllerAdapter(Viewable controller) {
        this.controller = controller;
    }

    @Override
    public boolean[] getCatalog() {
        Catalog catalog = controller.getCatalog();
        return new boolean[]{ catalog.current, catalog.allModesExist };
    }

    @Override
    public int[][] getGame(char level)throws NotFoundException {
        DifficultyEnum difficulty;
        switch(Character.toLowerCase(level)) {
            case 'e': difficulty = DifficultyEnum.EASY; break;
            case 'm': difficulty = DifficultyEnum.MEDIUM; break;
            case 'h': difficulty = DifficultyEnum.DIFFICULT; break;
            case 'i': difficulty = DifficultyEnum.INCOMPLETE; break;
            default: difficulty = DifficultyEnum.EASY;
        }
        Game game = controller.getGame(difficulty);
        return game.board;
    }

    @Override
    public void driveGames(String sourcePath) throws InvalidSolutionException {
        int[][] solved = CSVReader.get_instance().read(sourcePath);
      //  controller.driveGames(new Game(solved));
    }

    @Override
    public boolean[][] verifyGame(int[][] game) {
        Game g = new Game(game);
        String result = controller.verifyGame(g);
        boolean[][] valid = new boolean[9][9];

        // Default: mark all correct
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                valid[i][j] = true;

        if(result.startsWith("invalid")) {
            // Optionally parse result to mark invalid cells
        }
        return valid;
    }
    
    /*
        @Override
        public int[][] solveGame(int[][] game) throws InvalidGame {

        }

        @Override
        public void logUserAction(UserAction userAction) {
        }
    */
}