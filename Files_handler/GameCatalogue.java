
package Files_handler;

  public interface GameCatalogue {
    boolean hasUnfinishedGame(String level);
    boolean allDifficultiesAvailable(String[] levels); // easy, medium, hard
}

