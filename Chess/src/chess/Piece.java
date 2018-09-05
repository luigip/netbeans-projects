package chess;
import java.util.*;

public abstract class Piece {
    private Colour colour;
    private float value;
    
    //Constructor
    public Piece(Colour colour){
        this.colour = colour;
    }

    public enum Role{
        PAWN {
            public List<Square> getPossMoveList(Board board, Square square){
                PossMoveList list = new PossMoveList();
                //CODE
                return list;
            }
        },
        KNIGHT {

        },
        BISHOP {
            //public List<Square> getPossMoveList(Board board, Square square){

            //}
        },
        QUEEN {

        },
        KING {

        };

//    public abstract List<Square> getPossMoveList(Board board, Square square);

    }

    //Methods
    public abstract List<Square> getPossMoveList(Board board, Square square);

    
    //Getters and Setters
    public Colour getColour() {return colour;}
    public void setColour(Colour colour) {this.colour = colour;}
    public float getValue() {return value;}
    public void setValue(float value) {this.value = value;}

}
