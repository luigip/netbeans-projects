package chess.pieces;

import chess.*;

public class Pawn extends Piece{
    public Pawn(Colour colour){
        super(colour);
        this.setValue(1.0f);
    }
    @Override
    public String toString(){
        switch (this.getColour()){
            case white:  return "\u2659";
            case black: return "\u265f";
        }
        return "";
    }

    public PossMoveList getPossMoveList(Board board, Square square){
        PossMoveList list = new PossMoveList();

        for(Square s : list) s.highlighted = true;
        return list;
    }

}
