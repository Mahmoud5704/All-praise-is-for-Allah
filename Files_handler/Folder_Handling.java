package Files_handler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Folder_Handling {// make instance better

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
