package verifies;

import java.util.ArrayList;

public class box_verify extends dublicates implements verifier {

    public box_verify(int[][] board) {

        this.board = board;
    }

    public String checker(int index) {

        int startRow = (index / 3) * 3;
        int startCol = (index % 3) * 3;
        int[] box = new int[9];
        int k = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                box[k++] = board[startRow + i][startCol + j];
            }
        }

        String s ="";
        for (int x = 1; x <= 9; x++) {
            ArrayList<Integer> dups = find_dub(box, x);
            if (dups.size() > 1) {
                for (int pos : dups) {
                 //Convert box to row,col
                    int row = startRow + pos / 3;
                    int col = startCol + pos % 3;
                    s=row+","+col+" ";
                }
            }
        }
        return s;
    }

}
