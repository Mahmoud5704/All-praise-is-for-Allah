package control_sided;

public class GameController implements Viewable {

    @Override
    public Catalog getCatalog() {
        Catalog c = new Catalog(false,false);
        return c;
    }

    @Override
    public Game getGame(DifficultyEnum level) {
        return new Game(new int[9][9]);
    }

    @Override
    public void driveGames(Game sourceGame) {
        System.out.println("Generating puzzles");
    }

    @Override
    public String verifyGame(Game game) {
        return "valid";
    }
/*
    @Override
    public int[] solveGame(Game game) {
      
    }

    @Override
    public void logUserAction(String action) {
        
    }
*/
}
