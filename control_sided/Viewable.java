package control_sided;

import Exception.InvalidGame;
import Exception.InvalidSolutionException;
import Exception.NotFoundException;
import java.io.IOException;

public interface Viewable {

    Catalog getCatalog();

    Game getGame(DifficultyEnum level) throws NotFoundException;

    void driveGames(Game sourceGame) throws InvalidSolutionException;
    
    String verifyGame(Game game);
    
    int[] solveGame(Game game) throws InvalidGame;
    
    void logUserAction(String userAction) throws IOException;
}
