package topcoder.set1;

public class Finder {
    public static int FindSequence(int[][] grid, int length) {
        int x = grid.length, y = grid[0].length;
        int[] values = {-1, 1};
        // Iterate through array elements
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for(int a : values){
                    // count[0] = x-axis, count[1] = y-axis, count[2] = diagonal xy, count[3] = diagonal -xy
                    int[] count = new int[4];
                    for (int k = 0; k < length; k++) {
                        int l = (i + k) % x;
                        int m = (j + k) % y;
                        int n = ((i - k) % x + x) % x; 
                        if(grid[l][j] == a && !(k > 0 && l == i)) count[0]++;
                        if(grid[i][m] == a && !(k > 0 && m == j)) count[1]++;
                        if(grid[l][m] == a && !(k > 0 && l == i && m == j)) count[2]++;
                        if(grid[n][m] == a && !(k > 0 && n == i && m == j)) count[3]++;
                    }
                    for(int p : count)
                        if(p == length) return a;
                }
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        int[][] t1 = {{ 1, 1, 1},
                      { 0, 0, 0},
                      { 0, 1, 0}};
        int[][] t2 = {{ 0,-1, 0},
                      { 0,-1, 0},
                      { 0,-1, 0}};
        int[][] t3 = {{-1, 0, 0},
                      { 0,-1, 0},
                      { 0, 0,-1}};
        int[][] t4 = {{ 0, 0, 0, 0, 0},
                      { 0, 0, 0, 0, 0},
                      { 1, 1, 0, 1, 1},
                      { 0, 0, 0, 0, 0},
                      { 0, 0, 0, 0, 0}};
        int[][] t5 = {{ 0,-1},
                      {-1, 0},
                      { 0,-1},
                      {-1, 0},
                      {-1, 0}};
        int[][] t6 = {{ 0, 0, 0, 0, 0},
                      { 0, 0, 0, 0, 0},
                      { 0, 1, 0, 1, 1},
                      { 0, 0, 0, 0, 1},
                      { 1, 0, 0, 0, 0}};
        int[][] t7 = {{ 0, 0, 0,-1, 0},
                      { 0, 0,-1, 0, 0},
                      { 0, 1, 0, 1, 1},
                      { 0, 0, 0, 0, 1},
                      { 0, 0, 0, 0,-1}};
        System.out.println(FindSequence(t1, 4)); // 0
        System.out.println(FindSequence(t2, 3)); // -1
        System.out.println(FindSequence(t3, 3)); // -1
        System.out.println(FindSequence(t4, 4)); // 1
        System.out.println(FindSequence(t4, 5)); // 0
        System.out.println(FindSequence(t5, 4)); // -1
        System.out.println(FindSequence(t6, 3)); // 1
        System.out.println(FindSequence(t7, 3)); // -1
    }
}
