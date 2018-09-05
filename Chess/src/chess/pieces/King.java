package chess.pieces;

import chess.*;
import java.util.*;
import java.util.ArrayList;


public class King extends Piece{

    public King(Colour colour){
        super(colour);
        this.setValue(20);
    }
    @Override
    public String toString(){
        switch (this.getColour()){
            case white:  return "\u2654";
            case black: return "\u265a";
        }
        return "";
    }
    public PossMoveList getPossMoveList(Board board, Square square){
        PossMoveList list = new PossMoveList();
        
        int[][] a = {{-1,1},{0,1},{1,1},{1,0}};
        ArrayList<Integer[]> adjacentSquares = new ArrayList<Integer[]>();
        //for(int[] b: a) adjacentSquares.add(new ArrayList<ArrayList>(Arrays.asList(b)));









        //3 squares on lower rank than King
        for (int r = square.rank - 1, f = square.file -1;
            r >= 0 && f >= 0 && f <= square.file + 1; f++){
            if (board.grid[r][f].thisPiece == null){list.add(board.grid[r][f]); continue;}
            if (board.grid[r][f].thisPiece.getColour() == this.getColour()){continue;}
            if (board.grid[r][f].thisPiece.getColour() != this.getColour()){list.add(board.grid[r][f]); continue;}
        }
        //3 squares on higher rank than King
        for (int r = square.rank + 1, f = square.file -1;
            r <= 7 && f >= 0 && f <= square.file + 1; f++){
            if (board.grid[r][f].thisPiece == null){list.add(board.grid[r][f]); continue;}
            if (board.grid[r][f].thisPiece.getColour() == this.getColour()){continue;}
            if (board.grid[r][f].thisPiece.getColour() != this.getColour()){list.add(board.grid[r][f]); continue;}
        }
        //2 squares on same rank as King
        for (int r = square.rank, f = square.file -1;
            f >= 0 && f <= square.file + 1; f = f + 2){
            if (board.grid[r][f].thisPiece == null){list.add(board.grid[r][f]); continue;}
            if (board.grid[r][f].thisPiece.getColour() == this.getColour()){continue;}
            if (board.grid[r][f].thisPiece.getColour() != this.getColour()){list.add(board.grid[r][f]); continue;}
        }
        for(Square s : list) s.highlighted = true;
        return list;
    }

}
