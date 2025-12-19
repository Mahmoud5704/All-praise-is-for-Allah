package verifies;

import java.util.ArrayList;

public class box_verify extends dublicates implements  verifier {

    public box_verify(int[][] board){
       
        this.board = board;
    }



    public boolean checker(int index) {
        int startRow = (index / 3) * 3;
        int startCol = (index % 3) * 3;
        boolean ok = true;

        for (int x = 1; x <= 9; x++) {
            ArrayList<String> positions = new ArrayList<>();
            int count = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[startRow + i][startCol + j] == x) {
                        positions.add("(" + (startRow + i) + "," + (startCol + j) + ")");
                        count++;
                    }
                }
            }

            if (count > 1) {
                ok = false;
                String s = "Duplicates of " + x + " in BOX " + index + " at positions: " + positions;
            }
        }

        return ok;
    }
}
