
package adapter;

import csv_files.CSVReader;
import csv_files.invalidsolution;
import generate_game.DifficultyEnum;

public class Adapter implements Controllable {

    private  Viewable controller;

    public Adapter(Viewable controller) {
        this.controller = controller;
    }


    /* ===================== CATALOG ===================== */

    @Override
    public boolean[] getCatalog() {
        Catalog c = controller.getCatalog();
        return new boolean[] { c.current, c.allModesExist };
    }

    /* ===================== GET GAME ===================== */

    @Override
    public int[][] getGame(char level) throws NotFoundException {
        DifficultyEnum diff = DifficultyEnum.fromChar(level);
        Game g = controller.getGame(diff);
        
        // IMPORTANT: return reference, NOT a deep copy
        return g.board;
    }

    /* ===================== GENERATE GAMES ===================== */

    @Override
    public void driveGames(String sourcePath) throws SolutionInvalidException {
        int[][] board = CSVReader.get_instance().read(sourcePath);

        if (board == null) {
            throw new invalidsolution("Invalid CSV file");
        }

        Game sourceGame = new Game(board);
        controller.driveGames(sourceGame);
    }

    /* ===================== VERIFY GAME ===================== */
    @Override
    public boolean[][] verifyGame(int[][] game) {

        Game g = new Game(game);
        String result = controller.verifyGame(g);

        boolean[][] validity = new boolean[9][9];

        // default: all true
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                validity[i][j] = true;

        if (result.startsWith("invalid")) {
            // Example: "invalid 1,2 3,3 6,7"
            String[] parts = result.split(" ");
            for (int i = 1; i < parts.length; i++) {
                String[] xy = parts[i].split(",");
                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);
                validity[x][y] = false;
            }
        }

        return validity;
    }

    /* ===================== SOLVE GAME ===================== */

    @Override
    public int[][] solveGame(int[][] game) throws InvalidGame {
        Game g = new Game(game);
        int[] solution = controller.solveGame(g);
        int[][] result = new int[solution.length][3];
        for (int i = 0; i < solution.length; i++) {
            int code = solution[i];
            result[i][0] = code / 100;          
            result[i][1] = (code / 10) % 10;    
            result[i][2] = code % 10;           
        }
        return result;
    }
    /* ===================== LOGGING ===================== */
    @Override
    public void logUserAction(UserAction userAction) throws IOException {
        controller.logUserAction(userAction.toString());
    }
    
    
}


