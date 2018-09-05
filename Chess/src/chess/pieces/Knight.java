/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chess.pieces;

import chess.*;


public class Knight extends Piece{
    public Knight(Colour colour){
        super(colour);
        this.setValue(3.0f);
    }
    @Override
    public String toString(){
        switch (this.getColour()){
            case white:  return "\u2658";
            case black: return "\u265e";
        }
        return "";
    }

    public PossMoveList getPossMoveList(Board board, Square square){
        PossMoveList list = new PossMoveList();

        for(Square s : list) s.highlighted = true;
        return list;
    }

}
