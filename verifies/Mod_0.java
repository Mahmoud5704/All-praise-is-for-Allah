package verifies;

import java.util.ArrayList;

public class Mod_0 {

    int[][] board;

    public Mod_0(int[][] board) {
        this.board = board;
    }

    //Strategy design pattern
    public String verify() {
        ArrayList<String> results = new ArrayList<>();
        verifier row = new row_verify(board);
        verifier col = new col_verify(board);
        verifier box = new box_verify(board);
        Strategy_verifier s = new Strategy_verifier(row);
        for (int i = 0; i < 9; i++) {
            String dup = s.verify(i);
            if (!dup.isEmpty()) {
                results.add(dup);
            }
            s.setStrategy(col);
            dup = s.verify(i);
            if (!dup.isEmpty()) {
                results.add(dup);
            }
            s.setStrategy(box);
            dup = s.verify(i);
            if (!dup.isEmpty()) {
                results.add(dup);
            }
        }
        String all = String.join(" ", results);
        return all;
    }
}
