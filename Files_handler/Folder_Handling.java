package Files_handler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Folder_Handling {
    //Singelton Design Pattern

    private static Folder_Handling instance = null;

    public static Folder_Handling get_instance() {
        if (instance == null) {
            instance = new Folder_Handling();
        }
        return instance;
    }

    // method to make filename by order 1 then 2 then 3 then 4 then 5
    public String getNextFilename(String folderName) {
        File F = new File(folderName);
        if (!F.exists()) {
            F.mkdirs();
        }
        int maxIndex = 0;
        File[] files = F.listFiles();
        if (files != null) {
            for (File f : files) {
                String name = f.getName();
                int dotIndex = name.indexOf('.');
                name = name.substring(0, dotIndex); // we will take only before dot
                int idx = Integer.parseInt(name);
                if (idx > maxIndex) {
                    maxIndex = idx;

                }
            }
        }
        return (maxIndex + 1) + ".csv";  // next number
    }
    
    // method to save each puzzle in specific folder by its difficulty or if incomplete
    public void savePuzzle(int[][] board, String foldername, String filename)  {
        FileWriter fw = null;
        try {
            File F = new File(foldername);
            if (!F.exists()) {
                F.mkdirs();
            }   File file = new File(F, filename);
            fw = new FileWriter(file);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    fw.write(board[i][j] + "");
                    if (j < 8) {
                        fw.write(",");
                    }
                }
                fw.write("\n");
            }
            fw.close();
        } catch (IOException ex) {
            System.getLogger(Folder_Handling.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    // method to load  puzzle from specific folder by its difficulty or if is incomplete
    public int[][] loadRandomPuzzle(String folderPath) {
        
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("Folder is empty: " + folderPath);
            return null;
        }

//        File chosen = files[new Random().nextInt(files.length)];//using  random is new here ????
        File chosen = 
        int[][] board = new int[9][9];

        try (Scanner sc = new Scanner(chosen)) {
            for (int i = 0; i < 9; i++) {
                String[] nums = sc.nextLine().split(",");
                for (int j = 0; j < 9; j++) {
                    board[i][j] = Integer.parseInt(nums[j].trim());
                }
            }
        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println(chosen.getName());
            System.out.println("Failed Saved puzzle to the file");
        }
        return board;
    }


    
    //AHO YA ZEYAD EL GOZ2 BTA3Y MN AWEL HENA lel a5er
    //method to save the moves in a log file (used for the undo button)
    public void logUserAction(String action) throws IOException {
    Path logPath = Paths.get("incomplete", "undo.log");

    Files.createDirectories(logPath.getParent());

    try (BufferedWriter writer = Files.newBufferedWriter(
            logPath,
            StandardOpenOption.CREATE,
            StandardOpenOption.APPEND)) {

        writer.write(action);
        writer.newLine();
    }
}
    //method to do the undo logic
    public void undo(int[][] board) throws IOException {
    File logFile = new File("incomplete", "undo.log");
    if (!logFile.exists()) return;

    ArrayList<String> lines = new ArrayList<>();
    try (Scanner sc = new Scanner(logFile)) {
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
    }

    if (lines.isEmpty()) return;

    String last = lines.remove(lines.size() - 1);

    last = last.replace("(", "").replace(")", "");
    String[] parts = last.split(", ");

    int x = Integer.parseInt(parts[0]);
    int y = Integer.parseInt(parts[1]);
    int prev = Integer.parseInt(parts[3]);

    board[x][y] = prev;

    try (FileWriter fw = new FileWriter(logFile)) {
        for (String line : lines) {
            fw.write(line + "\n");
        }
    }
}
    //method temsa7 el current game
    public void deleteCurrentGame() {
    File folder = new File("incomplete");
    if (!folder.exists()) return;

    File logFile = new File(folder, "undo.log");
    File currentGame = new File(folder, "current.csv");

    if (logFile.exists()) {
        logFile.delete();
    }

    if (currentGame.exists()) {
        currentGame.delete();
    }
}
}
