/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facad;

import Exception.InvalidGame;
import Exception.InvalidSolutionException;
import Exception.NotFoundException;
import Files_handler.Folder_Handling;
import java.io.IOException;

/**
 *
 * @author zeyad
 */
public class ControllerFacad implements ControllerFacadInterface{
    Controllable adapter;
    public ControllerFacad(Controllable adapter){
        this.adapter = adapter;
    }
    @Override
    public boolean[] getCatalog() {
        return adapter.getCatalog();
    }

    @Override
    public int[][] getGame(char level) throws NotFoundException {
        return adapter.getGame(level);
    }

    @Override
    public void driveGames(String sourcePath) throws InvalidSolutionException {
        adapter.driveGames(sourcePath);
    }

    @Override
    public boolean[][] verifyGame(int[][] game) {
        return adapter.verifyGame(game);
    }

    @Override
    public int[][] solveGame(int[][] game) throws InvalidGame {
        return adapter.solveGame(game);
    }

    @Override
    public void logUserAction(UserAction userAction) throws IOException {
        adapter.logUserAction(userAction);
    }

    @Override
    public void undo(int[][] board) throws IOException {
        Folder_Handling.get_instance().undo(board);
    }
    
}
