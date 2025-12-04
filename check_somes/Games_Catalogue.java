
package check_somes;
import interface_abstract.GameCatalogue;
import java.io.File;

public class Games_Catalogue implements GameCatalogue {

    private final String basePath = "games"; // root folder for puzzles

    @Override
    public boolean hasUnfinishedGame() {
        File unfinishedFolder = new File(basePath + "/unfinished");
        if (!unfinishedFolder.exists()) return false;

        File[] files = unfinishedFolder.listFiles();
        return files != null && files.length > 0;  // true if at least one file
    }

    @Override
    public boolean allDifficultiesAvailable() {
        String[] difficulties = {"easy", "medium", "hard"};
        for (String diff : difficulties) {
            File folder = new File(basePath + "/" + diff);
            if (!folder.exists()) return false;

            File[] files = folder.listFiles();
            if (files == null || files.length == 0) return false;
        }
        return true;
    }
    
}