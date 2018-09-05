/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chess.pieces;

import chess.*;


public class Queen extends Piece{
    public Queen(Colour colour){
        super(colour);
        this.setValue(9.0f);
    }

    @Override
    public String toString(){
        switch (this.getColour()){
            case white:  return "\u2655";
            case black: return "\u265b";
        }
        return "";
    }
    public PossMoveList getPossMoveList(Board board, Square square){
        PossMoveList list = new PossMoveList();

        for(Square s : list) s.highlighted = true;
        return list;
    }

}
