package verifies;

import java.util.ArrayList;

public class col_verify extends dublicates implements verifier {

    public col_verify(int[][] board) {
        this.board = board;
    }

    public String checker(int index) {
        int[] c = new int[9];
        for (int i = 0; i < 9; i++) {
            c[i] = board[i][index];
        }
        String s = "";
        for (int x = 1; x <= 9; x++) {
            ArrayList<Integer> dups = find_dub(c, x);
            if (dups.size() > 1) {
                for (int ss : dups) {
                    s += ss + "," + index+" ";
                }
            }
        }
        return s;
    }
}
