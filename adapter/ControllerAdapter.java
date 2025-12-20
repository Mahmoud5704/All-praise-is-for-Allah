package adapter;

import control_sided.Catalog;
import control_sided.DifficultyEnum;
import Files_handler.CSVReader;
import control_sided.Game;
import control_sided.Viewable;
import Exception.InvalidSolutionException;
import Exception.NotFoundException;

//Adapter Design Pattern
public class ControllerAdapter implements Controllable {

    private Viewable controller;

    public ControllerAdapter(Viewable controller) {
        this.controller = controller;
    }

    @Override//adapt tmam bezn allah -<>-
    public boolean[] getCatalog() {
        Catalog catalog = controller.getCatalog();
        return new boolean[]{catalog.isCurrent(), catalog.is_AllLevels_Exist()};
    }

    @Override//adapt tmam bezn allah -<>-
    public int[][] getGame(char level) throws NotFoundException {
        DifficultyEnum difficulty;
        switch (Character.toLowerCase(level)) {
            case 'e':
                difficulty = DifficultyEnum.easy;
                break;
            case 'm':
                difficulty = DifficultyEnum.medium;
                break;
            case 'h':
                difficulty = DifficultyEnum.hard;
                break;
            case 'i':
                difficulty = DifficultyEnum.incomplete;
                break;
            default:
                difficulty = DifficultyEnum.easy;
        }
        Game game = controller.getGame(difficulty);
        return game.getBoard();
    }

    @Override//adapt tmam bezn allah -<>-
    public void driveGames(String sourcePath) throws InvalidSolutionException {
        int[][] solved = CSVReader.get_instance().read(sourcePath);
        controller.driveGames(new Game(solved));
    }

    @Override//adapt tmam bezn allah -<>-
    public boolean[][] verifyGame(int[][] board) {
        Game game = new Game(board);
        String s = controller.verifyGame(game);
        if (s.equals("incomplete")) {
            return null;
        }

        boolean[][] result = new boolean[9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                result[r][c] = true;
            }
        }

        if (s.equals("valid")) {
            return result;
        }

        String duplicates = s.substring(8).trim();
        String[] cells = duplicates.split("\\s+"); // split by any number of spaces
        for (String cell : cells) {
            if (!cell.isEmpty()) {
                String[] xy = cell.split(",");
                int row = Integer.parseInt(xy[0].trim());
                int col = Integer.parseInt(xy[1].trim());
                result[row][col] = false; // mark invalid cell
            }
        }

        return result;
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
