package verifies;

import java.util.ArrayList;
import java.util.List;

public class Mod_0{

    int[][] board;
    public Mod_0(int[][] board) {
        this.board = board;
    }
    
    public boolean verify() {
        List<Boolean> results = new ArrayList<>();
        row_verify rr = new row_verify(board);
        col_verify cc = new col_verify(board);
        box_verify bb = new box_verify(board);
        for (int i = 0; i < 9; i++) {
            results.add(rr.checker(i));
            results.add(cc.checker(i));
            results.add(bb.checker(i));
        }

        boolean ok = true;
        for (boolean b : results) {
            ok &= b;
        }

       return ok;
    }
}
