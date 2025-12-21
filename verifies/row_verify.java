package verifies;

import java.util.ArrayList;

public class row_verify extends dublicates implements verifier {

    public row_verify(int[][] board) {
        this.board = board;
    }

    public String checker(int index) {
        int[] r = board[index];
        String s = "";
        for (int x = 1; x <= 9; x++) {
            ArrayList<Integer> dups = find_dub(r, x);
            if (dups.size() > 1) {
                for (int ss : dups) {
                    s += index + "," + ss+" ";
                }
            }
        }
        return s;
    }
}
