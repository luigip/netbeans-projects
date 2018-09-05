/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chess;


public class Square {
    public Piece thisPiece;
    public Colour colour;
    public int rank;
    public int file;
    public boolean highlighted;

    public Square(int rank, int file){
        this.rank = rank;
        this.file = file;

    }
    @Override
    public String toString(){
        if(highlighted) return "*";
        if(thisPiece != null) return thisPiece.toString();
        switch (this.colour){case white: return "\u25a1";  case black: return "\u25a8";}
        throw new RuntimeException();
    }
    public int checkMove(Square fromSquare){
        // returns 0 if empty, 1 if same colour, 2 if different colour
        if (thisPiece == null) return 0;
        if (thisPiece.getColour() == fromSquare.thisPiece.getColour()) return 1;
        else return 2;
    }


}
