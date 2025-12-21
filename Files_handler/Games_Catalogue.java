package Files_handler;

import control_sided.DifficultyEnum;
import java.io.File;

//Singelton Design Pattern
public class Games_Catalogue implements GameCatalogue {

    private static Games_Catalogue instance = null;

    public static Games_Catalogue get_instance() {
        if (instance == null) {
            instance = new Games_Catalogue();
        }
        return instance;
    }

    @Override
    public boolean hasUnfinishedGame(String level) {
        File folder = new File(level);
        if (!folder.exists()) {
            return false;
        }
        File[] files = folder.listFiles();
        // true if at least one file in the folder
        return files != null && files.length > 0;
    }

    @Override
    public boolean allDifficultiesAvailable(String[] levels) {
        for (String folderName :levels) {
        
            File folder = new File(folderName);
            if (!folder.exists()) {
                return false;
            }
            File[] files = folder.listFiles();
            if (files == null || files.length == 0) {
                return false;
            }
        }
        return true;
    }

}
