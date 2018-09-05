package life;

import java.io.File;
import java.io.Serializable;
/**
 * Calculation
 * 
 */
public class LifeGrid implements Cloneable, Serializable{

    int dimX = 20;
    int dimY = 20;
    boolean[][] grid = new boolean[dimX][dimY];

    public LifeGrid() {
    }

    public LifeGrid(int x, int y) {
        dimX = x;
        dimY = y;
        grid = new boolean[dimX][dimY];
    }

    public void setSquare(int x, int y, boolean value) {
        if (grid == null || x < 0 || x > grid.length || y < 0 || y > grid[x].length) {
            throw new IllegalArgumentException("Bad value passed to setSquare");
        }
        grid[x][y] = value;
    }
    
    public boolean getSquare(int x, int y){
        return grid[x][y];
    }
    
    public void iterate(){
        boolean[][] newGrid = new boolean[dimX][dimY];
        for (int x = 0; x < dimX; x++) {
            for (int y = 0; y < dimY; y++) {
                
                int nCount = 0;
                for (int i = Math.max(0, x - 1); i <= Math.min(dimX - 1, x + 1); i++) {
                    for (int j = (Math.max(0, y - 1)); j <= (Math.min(dimY - 1, y + 1)); j++) {
                        if(!(i == x && j == y) && grid[i][j]){
                            nCount++;
                        }
                    }
                }
                boolean n;
                switch(nCount){
                    case 0:
                    case 1: n = false; 
                        break;
                    case 2: n = grid[x][y];
                        break;
                    case 3: n = true;
                        break;
                    default: n = false;
                }
                newGrid[x][y] = n;
            }
        }
        grid = newGrid;
    }
    
    void addClip(LifeClip clip, int offsetX, int offsetY) {
        for(int x = 0; x < clip.dimX; x++){
            for(int y = 0; y < clip.dimY; y++){
                if((x + offsetX < dimX) && (y + offsetY < dimY)){
                grid[x + offsetX][y + offsetY] = clip.grid[x][y];
                }
            }
        }
    }
    
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
}
class LifeClip extends LifeGrid {
    
    public LifeClip(File file){
        
    }
    public LifeClip(boolean[][] input){
        dimX = input.length;
        dimY = input[0].length;
        grid = input;
    }
//    public LifeClip(){
//        dimX = 3;
//        dimY = 3;
//        grid[1][0] = true;
//        grid[0][1] = true;
//    }
}
