package adapter;

import Exception.InvalidSolutionException;
import Exception.NotFoundException;
import java.io.IOException;

public interface Controllable {

    boolean[] getCatalog();

    int[][] getGame(char level) throws NotFoundException;

    void driveGames(String sourcePath) throws InvalidSolutionException;
/*
    
    boolean[][] verifyGame(int[][] game);
    
    int[][] solveGame(int[][] game) throws InvalidGame;
    */
    void logUserAction(UserAction userAction) throws IOException;
    
}