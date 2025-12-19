package verifies;
import java.util.ArrayList;


public abstract class dublicates {
    protected int[][] board;
    public ArrayList<Integer> find_dub(int[] rc, int x) {
        ArrayList<Integer> ind = new ArrayList<>();
        for (int j = 0; j < rc.length; j++) {
            if (rc[j] == x) {
                ind.add(j);
            }
        }
        return ind;
    }

}
