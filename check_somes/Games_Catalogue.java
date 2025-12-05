
package check_somes;
import interface_abstract.GameCatalogue;
import java.io.File;

public class Games_Catalogue implements GameCatalogue {


    @Override
    public boolean hasUnfinishedGame() {
        File folder = new File("unfinished");
        if (!folder.exists()) return false;
        File[] files = folder.listFiles();
        // true if at least one file
        return files != null && files.length >0;  
    }

    @Override
    public boolean allDifficultiesAvailable() {
        String[] difficulties = {"easy", "medium", "hard"};
        for (String diff : difficulties) {
            File folder = new File(diff);
            if (!folder.exists()) return false;
            File[] files = folder.listFiles();
            if (files == null || files.length == 0) return false;
        }
        return true;
    }
    
} 