package verifies;
 
import java.util.ArrayList;

public class row_verify extends dublicates implements  verifier {


    public row_verify(int[][] board) {
        this.board = board;
    }


    public boolean checker(int index) {
        int[] r = board[index];
        boolean ok = true;
        for (int x = 1; x <= 9; x++) {
            ArrayList<Integer> dups = find_dub(r, x);
            if (dups.size() > 1) {
                String s = "Duplicates of " + x + " in ROW " + index + " at cols: " + dups;
                ok = false;
            }
        }
        return ok;
    }

}
