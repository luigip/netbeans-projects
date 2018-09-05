/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chess.pieces;

import chess.*;


public class Bishop extends Piece{
    public Bishop(Colour colour){
        super(colour);
        this.setValue(3.0f);
    }
    @Override
    public String toString(){
        switch (this.getColour()){
            case white:  return "\u2657";
            case black: return "\u265d";
        }
        return "";
    }
  /*  public PossMoveList getPossMoveList(Board board, Square square){
        PossMoveList list = new PossMoveList();
        // move down / left
        for(int r = square.rank - 1, f = square.file -1; r >= 0 && f >= 0; r--, f--){
            if (board.grid[r][f].thisPiece == null){list.add(board.grid[r][f]); continue;}
            if (board.grid[r][f].thisPiece.getColour() == this.getColour()){break;}
            if (board.grid[r][f].thisPiece.getColour() != this.getColour()){list.add(board.grid[r][f]); break;}
        }
        for(int r = square.rank - 1, f = square.file +1; r >= 0 && f <= 7; r--, f++){
            if (board.grid[r][f].thisPiece == null){list.add(board.grid[r][f]); continue;}
            if (board.grid[r][f].thisPiece.getColour() == this.getColour()){break;}
            if (board.grid[r][f].thisPiece.getColour() != this.getColour()){list.add(board.grid[r][f]); break;}
        }
        for(int r = square.rank + 1, f = square.file -1; r <= 7 && f >= 0; r++, f--){
            if (board.grid[r][f].thisPiece == null){list.add(board.grid[r][f]); continue;}
            if (board.grid[r][f].thisPiece.getColour() == this.getColour()){break;}
            if (board.grid[r][f].thisPiece.getColour() != this.getColour()){list.add(board.grid[r][f]); break;}
        }
        for(int r = square.rank + 1, f = square.file +1; r <= 7 && f <= 7; r++, f++){
            if (board.grid[r][f].thisPiece == null){list.add(board.grid[r][f]); continue;}
            if (board.grid[r][f].thisPiece.getColour() == this.getColour()){break;}
            if (board.grid[r][f].thisPiece.getColour() != this.getColour()){list.add(board.grid[r][f]); break;}
        }
        for(Square s : list) s.highlighted = true;
        return list;
    }*/
    public PossMoveList getPossMoveList(Board board, Square square)
{
        PossMoveList list = new PossMoveList();

        // for the bishop, we're always changing both rank and file by one.
        addVectorMoves(list, board, square, -1, -1);
        addVectorMoves(list, board, square, -1,  1);
        addVectorMoves(list, board, square,  1, -1);
        addVectorMoves(list, board, square,  1,  1);

        for(Square s : list) s.highlighted = true;
        return list;
}

/**
 * add moves for a "vector" piece in one direction; vector pieces
 * are bishops, rooks, and queens, which have possible moves along
 * a straight or diagonal; this routine adds all those moves which
 * move in one direction along one of those vectors; they include
 * captures (and stop the vector at that point), stop when they reach
 * a piece of the same colour or the edge of the board.
 */
public void addVectorMoves(PossMoveList list, Board board, Square square,
                           int rankIncrement, int fileIncrement)
{
  int r = square.rank + rankIncrement;
  int f = square.file + fileIncrement;

  while (7 >= r && r >= 0 && 7 >= f && f >= 0)
  {
    if (board.grid[r][f].thisPiece == null)     // if there is no piece on this square,
        { list.add(board.grid[r][f]);                // add and continue the loop
        }
    else
      {
        if (board.grid[r][f].thisPiece.getColour() != this.getColour()) // if the piece is oppo colour,
          { list.add(board.grid[r][f]);                        // add and stop the loop.
          }
        break;                                                // otherwise just stop the loop.
      }
    r += rankIncrement;
    f += fileIncrement;
  }
}

}
