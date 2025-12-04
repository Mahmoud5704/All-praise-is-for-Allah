package verifies;

import interface_abstract.dublicates;
import java.util.List;
import interface_abstract.verifier;

public class Col_verify extends dublicates implements verifier {

    public Col_verify(int[][] board) {
        this.board = board;
        
    }

    public boolean checker(int index) {
        int[] c = new int[9];
        for (int i = 0; i < 9; i++) {
            c[i] = board[i][index];
        }
        boolean ok = true;
        for (int x = 1; x <= 9; x++) {
            List<Integer> dups = find_dub(c, x);
            if (dups.size() > 1) {
                String s = "Duplicates of " + x + " in col " + index + " at rows: " + dups;
                ok = false;
            }
        }
        return ok;
    }

}
