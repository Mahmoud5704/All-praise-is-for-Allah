
package adapter;
public class UserAction {
    private int column;
    private int row;
    private int val;
    private int prev;
    private int[][] board;
    public UserAction(int row, int column, int val, int[][] board){
        this.column = column;
        this.row = row;
        this.board = board;
        this.val = val;
        this.prev = board[row][column];
        this.board[row][column] = val; //update board
    }
    @Override
    public String toString(){
        String del = ", ";
        return "(" + row + del + column + del + val + del + prev + ")";
    }
    public int[][] getNewBoard(){
        System.out.println("row: " + row);
        System.out.println("column: " + column);
        System.out.println("value: " + val);
        System.out.println("prev: " + prev);
        return this.board;
    }
}
