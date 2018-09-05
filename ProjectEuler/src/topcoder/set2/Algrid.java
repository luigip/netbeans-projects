package topcoder.set2;

import java.util.Arrays;
/*
 * Gave up on this one - not partic interesting, but tricky
 */
public class Algrid {
    public String[] makeProgram(String[] output){
        int H = output.length;
        int W = output[0].length();
        char[][] grid = new char[H][W];
        for(int i = 0; i < H; i++){
            grid[i] = output[i].toCharArray();
        }
        for (int i = H - 2; i <= 0; i--) {
            for (int j = W - 2; j <= 0; j--) {
                char A = grid[i][j], B = grid[i][j + 1];
                if     (A == 'W' && B == 'W'){
                    
                }
                else if(A == 'B' && B == 'W'){
                    if(grid[i + 1][j] != 'B') return new String[]{};
                    
//                    grid[i + 1][j] = 'B'; grid[i + 1][j + 1] = 'B';
                }
                else if(A == 'W' && B == 'B'){
//                    grid[i + 1][j] = 'W'; grid[i + 1][j + 1] = 'W';
                }
                else if(A == 'B' && B == 'B'){
//                    char c = grid[i + 1][j];
//                    grid[i + 1][j] = grid[i + 1][j + 1]; grid[i + 1][j + 1] = c;
                }                
            }
        }
                
        
        
        return new String[]{};
    }
    
    static boolean validate(char[][] grid, String[] target){
        int H = grid.length;
        int W = grid[0].length;
        for (int i = 0; i <= H - 2; i++) {
            for (int j = 0; j <= W -2; j++) {
                char A = grid[i][j], B = grid[i][j + 1];
                if     (A == 'W' && B == 'W'){
                    // do nothing
                }
                else if(A == 'B' && B == 'W'){
                    grid[i + 1][j] = 'B'; grid[i + 1][j + 1] = 'B';
                }
                else if(A == 'W' && B == 'B'){
                    grid[i + 1][j] = 'W'; grid[i + 1][j + 1] = 'W';
                }
                else if(A == 'B' && B == 'B'){
                    char c = grid[i + 1][j];
                    grid[i + 1][j] = grid[i + 1][j + 1]; grid[i + 1][j + 1] = c;
                }
            }
        }
        boolean valid = true;
        for(int i = 0; i < target.length; i++){
            if(!Arrays.equals(target[i].toCharArray(), grid[i])) valid = false;
        }
        return valid;
    }
    
    public static void main(String[] args) {
        Algrid a = new Algrid();
        String[] target = {"WWWWWWW",
                             "WWWWWWB",
                             "BBBBBWW"};
        String[] inpStr = {"WWWWWWW", 
                            "WWWWWWB", 
                            "BBBBBBB" };
        char[][] test = new char[target.length][target[0].length()];
        for(int i = 0; i < inpStr.length; i++){
            test[i] = inpStr[i].toCharArray();
        }
        System.out.println(validate(test, target));
    }
}
