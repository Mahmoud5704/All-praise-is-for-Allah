package solver;

import Exception.InvalidGame;
import java.util.ArrayList;
import java.util.List;


public class SudokuSolver {

    public static boolean solutionFound = false;
    public static int[] finalSolution = null;

    
    public int[] solveGame(int[][] board) throws InvalidGame {
        solutionFound = false;
        finalSolution = null;

        List<Point> emptyCells = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    emptyCells.add(new Point(i, j));
                }
            }
        }

        if (emptyCells.size() != 5) {
            throw new InvalidGame("Solver only works for exactly 5 empty cells.");
        }

        PermutationIterator iterator = new PermutationIterator();
        List<Thread> workers = new ArrayList<>();

        while (iterator.hasNext() && !solutionFound) {
            int[] combination = iterator.next();

            Thread worker = new Thread(() -> {
                if (solutionFound) return;

                if (isValidVirtual(board, emptyCells, combination)) {
                    solutionFound = true;
                    finalSolution = combination;
                    System.out.println("Solution Found!");
                }
            });

            worker.start();
            workers.add(worker);

            if (workers.size() > 1000) {
                workers.removeIf(t -> !t.isAlive());
            }
        }

        while (!workers.isEmpty()) {
            workers.removeIf(t -> !t.isAlive());
            if (solutionFound) break;
        }

        if (finalSolution != null) {
           
            return finalSolution;
        } else {
            throw new InvalidGame("No solution found.");
        }
    }

    

    private boolean isValidVirtual(int[][] originalBoard, List<Point> emptyLocs, int[] values) {
        for (int i = 0; i < 9; i++) {
            // Check Row
            if (!checkUnit(originalBoard, emptyLocs, values, i, 0, i, 8))
                return false;
            // Check Col
            if (!checkUnit(originalBoard, emptyLocs, values, 0, i, 8, i))
                return false;
        }

        // Check 3x3 Boxes
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                if (!checkUnit(originalBoard, emptyLocs, values, row, col, row + 2, col + 2))
                    return false;
            }
        }
        return true;
    }

    private boolean checkUnit(int[][] board, List<Point> emptyLocs, int[] values, int r1, int c1, int r2, int c2) {
        boolean[] seen = new boolean[10]; // 1-9

        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                int val = board[r][c];
                
                
                
                if (val == 0) 
                {
                    for (int k = 0; k < 5; k++) 
                    {
                        Point p = emptyLocs.get(k);
                        if (p.r == r && p.c == c) 
                        {
                            val = values[k];
                            break;
                        }
                    }
                }

                if (val != 0) 
                {
                    if (seen[val])
                        return false;
                    seen[val] = true;
                }
            }
        }
        return true;
    }
}



/*
private int[][] createSolvedBoard(int[][] original, List<Point> locs, int[] values) {
        int[][] solvedBoard = new int[9][9];
        
        for (int i = 0; i < 9; i++) {
            System.arraycopy(original[i], 0, solvedBoard[i], 0, 9);
        }
       
        for (int k = 0; k < 5; k++) {
            Point p = locs.get(k);
            solvedBoard[p.r][p.c] = values[k];
        }
        return solvedBoard;
    }
*/