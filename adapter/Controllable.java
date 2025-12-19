package adapter;

import exceptions.InvalidSolutionException;
import exceptions.NotFoundException;

public interface Controllable {

    boolean[] getCatalog();

    int[][] getGame(char level) throws NotFoundException;

    void driveGames(String sourcePath) throws InvalidSolutionException;
/*
    
    boolean[][] verifyGame(int[][] game);
    
    int[][] solveGame(int[][] game) throws InvalidGame;
    
    void logUserAction(UserAction userAction) throws IOException;
    
*/
}