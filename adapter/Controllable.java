package adapter;

import Exception.InvalidSolutionException;
import Exception.NotFoundException;

public interface Controllable {

    boolean[] getCatalog();

    int[][] getGame(char level) throws NotFoundException;

    void driveGames(String sourcePath) throws InvalidSolutionException;

    
    boolean[][] verifyGame(int[][] game);
  /*  
    int[][] solveGame(int[][] game) throws InvalidGame;
    
    void logUserAction(UserAction userAction) throws IOException;
    
*/
    //El satr da bas ya Zeyad
    public void undo(int[][] board) throws IOException;
}
