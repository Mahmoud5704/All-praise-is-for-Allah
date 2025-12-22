package solver;
import java.util.Iterator;

public class PermutationIterator implements Iterator<int[]> {
    private int[] current;
    private boolean hasNext = true;

    public PermutationIterator() {

        current = new int[]{1, 1, 1, 1, 1};
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public int[] next() {
        
        int[] result = current.clone();
        
        
        prepareNext();
        return result;
    }

    
    private void prepareNext() {
        for (int i = 4; i >= 0; i--) {
            if (current[i] < 9) {
                current[i]++;
                return;
            } else {
                current[i] = 1; 
            }
        }
        
        hasNext = false;
    }
}