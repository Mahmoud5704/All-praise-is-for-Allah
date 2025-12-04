package check_somes;

import interface_abstract.Mode;
import java.util.ArrayList;
import java.util.List;
import verifies.Col_verify;
import verifies.Row_verify;
import verifies.box_verify;

public class mod_0 implements Mode{

    int[][] board;
    public mod_0(int[][] board) {
        this.board = board;
    }
    
    public boolean verify() {
        List<Boolean> results = new ArrayList<>();
        Row_verify rr = new Row_verify(board);
        Col_verify cc = new Col_verify(board);
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
