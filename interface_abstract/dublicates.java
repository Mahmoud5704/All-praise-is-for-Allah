package interface_abstract;
import java.util.ArrayList;
import java.util.List;


public abstract class dublicates {
    protected int[][] board;
    public List<Integer> find_dub(int[] rc, int x) {
        List<Integer> ind = new ArrayList<>();
        for (int j = 0; j < rc.length; j++) {
            if (rc[j] == x) {
                ind.add(j);
            }
        }
        return ind;
    }

}
