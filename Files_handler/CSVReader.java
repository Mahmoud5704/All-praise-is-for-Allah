package Files_handler;

import Exception.InvalidSolutionException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import verifies.Mod_0;

public class CSVReader {
    //Singelton Design Pattern
    private static CSVReader instance = null;

    CSVReader() {
    }

    public static CSVReader get_instance() {
        if (instance == null) {
            instance = new CSVReader();
        }
        return instance;
    }

    public int[][] read(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            String lineContent[];
            if (line != null && line.charAt(0) == (char) 65279) //check for BOM character
            {
                line = line.substring(1, line.length());
            }
            int[][] result = new int[9][9];
            for (int i = 0; line != null && i < 9; i++) {
                lineContent = line.split(",");
                if (lineContent.length != 9) {
                    return null;
                }
                for (int j = 0; j < lineContent.length; j++) {
                    result[i][j] = Integer.parseInt(lineContent[j].strip());
                }
                line = br.readLine();
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(result[i][j]);
                }
                System.out.println("");
            }
            return result;
        } catch (IOException e) {
            System.out.println("Error reading file.");
        } catch (NumberFormatException e) {
            System.out.println("csv must contain numbers only!");
        }
        return null;
    }

    public void verifySolution(int[][] board) throws InvalidSolutionException {
        Mod_0 mode = new Mod_0(board);
        String s=mode.verify();
        if (!s.isEmpty()) {
            System.out.print(s);
            throw  new InvalidSolutionException("Sudoku board is INVALID or INCOMPLETE!");
        }
    }

}
