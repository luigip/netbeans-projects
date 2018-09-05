/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chess;


public class Board {
    public Square[][] grid;

    public Board(){
        grid = new Square[8][8];
        for(int rank = 0; rank <8; rank++){
            for(int file = 0; file <8; file++){
                grid[rank][file] = new Square(rank, file);
                grid[rank][file].colour = ((rank + file) % 2 == 0) ? Colour.black : Colour.white;
            }
        }
    }
    public void movePiece(int fromRank, int fromFile, int toRank, int toFile){
        if (grid[fromRank][fromFile].thisPiece == null) 
            throw new RuntimeException("No piece on square");
        if (grid[toRank][toFile].thisPiece != null &&
                grid[fromRank][fromFile].thisPiece.getColour() == grid[toRank][toFile].thisPiece.getColour())
            throw new RuntimeException("Attempted to take own piece");
        
        grid[toRank][toFile].thisPiece = grid[fromRank][fromFile].thisPiece;
        grid[fromRank][fromFile].thisPiece = null;
        
    }
    public float evaluatePosition(){
        

        return 0f;
    }
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(int r = 7; r >=0; r--){
        s.append(r);
        s.append(" ");
        for(int f = 0; f <=7; f++){
         //   if(grid[r][f].thisPiece == null) s.append (grid[r][f].toString());
         //   else s.append(grid[r][f].thisPiece.toString());
            s.append(grid[r][f].toString());
            }
        s.append ("\n");
        }
        s.append("  01234567");
        return s.toString();
    }
}
