package verifies;

import java.util.ArrayList;

public class Mod_0{

    int[][] board;
    public Mod_0(int[][] board) {
        this.board = board;
    }
    //Strategy design pattern
    public boolean verify() {
        ArrayList<Boolean> results = new ArrayList<>();
        verifier rr = new row_verify(board);
        verifier cc = new col_verify(board);
        verifier bb = new box_verify(board);
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
