package topcoder.set1;

import java.util.Arrays;

public class LineOfSight {

    public int bestPosition(String[] board) {
        int x = board.length;
        int y = board[0].length();
        char[][] b = new char[x][];
        for (int i = 0; i < x; i++) {
            b[i] = board[i].toCharArray();
        }
        boolean[][] safe = new boolean[x][y];
        for (boolean[] i : safe) {
            Arrays.fill(i, true);
        }

        int numSafe = x * y;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (b[i][j] == 'X') {
                    for (int k = 0; k < x; k++) {
                        if(safe[k][j]) numSafe--;
                        safe[k][j] = false;
                    }
                    for (int k = 0; k < y; k++) {
                        if(safe[i][k]) numSafe--;
                        safe[i][k] = false;
                    }
                }
            }
        }

        int minSafe = Integer.MAX_VALUE;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (safe[i][j]) {
                    minSafe = Math.min(minSafe, numSafe - numNewInLine(safe, i, j));
                }
            }

        }
        return minSafe == Integer.MAX_VALUE ? -1 : minSafe;
    }

    private int numNewInLine(boolean[][] b, int x, int y) {
        int c = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i][y]) {
                c++;
            }
        }
        for (int i = 0; i < b[0].length; i++) {
            if (b[x][i]) {
                c++;
            }
        }
        return c - 1;
    }

    public static void main(String[] args) {
        LineOfSight l = new LineOfSight();
        String[] b = {".X..", "X...", "....","...."};
        System.out.println(l.bestPosition(b));
    }
}
