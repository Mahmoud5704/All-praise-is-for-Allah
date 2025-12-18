package Files_handler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Folder_Handling {// make instance better

    private static Folder_Handling instance = null;

    public  static Folder_Handling get_instance() {
        if (instance == null) {
            instance = new Folder_Handling();
        }
        return instance;
    }

    // method to make filename by order 1 then 2 then 3 then 4 then 5
    public String getNextFilename(String folderName) {
        File dir = new File(folderName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        int maxIndex = 0;
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                String name = f.getName();
                int dotIndex = name.indexOf('.');
                name = name.substring(0, dotIndex); // take only before dot
                try {
                    int idx = Integer.parseInt(name);
                    if (idx > maxIndex) {
                        maxIndex = idx;
                    }
                } catch (NumberFormatException e) {
                    // ignore files that are not numbers
                }
            }
        }

        return (maxIndex + 1) + ".csv"; // next number
    }

    // method to save each puzzle in specific folder by its difficulty or if incomplete
    public void savePuzzle(int[][] board, String foldername, String filename) {
        try {
            File dir = new File(foldername);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, filename);
            try (FileWriter fw = new FileWriter(file)) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        fw.write(board[i][j] + "");
                        if (j < 8) {
                            fw.write(",");
                        }
                    }
                    fw.write("\n");
                }
            }
            System.out.println("Saved puzzle to: " + file.getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Failed Saved puzzle to the file");
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

        File chosen = files[new Random().nextInt(files.length)];//using  random is new here ????

        int[][] board = new int[9][9];

        try (Scanner sc = new Scanner(chosen)) {
            for (int i = 0; i < 9; i++) {
                String[] nums = sc.nextLine().split(",");
                for (int j = 0; j < 9; j++) {
                    board[i][j] = Integer.parseInt(nums[j].trim());
                }
            }
        } catch (Exception e) {
            System.out.println("Failed Saved puzzle to the file");
        }
        return board;
    }


}
