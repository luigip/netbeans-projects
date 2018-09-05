/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chess.pieces;

import chess.*;


public class Rook extends Piece{
    public Rook(Colour colour){
        super(colour);
        this.setValue(5.0f);
    }

    @Override
    public String toString(){
        switch (this.getColour()){
            case white:  return "\u2656";
            case black: return "\u265c";
        }
        return "";
    }
    public PossMoveList getPossMoveList(Board board, Square square){
        PossMoveList list = new PossMoveList();

        for(Square s : list) s.highlighted = true;
        return list;
    }
}
