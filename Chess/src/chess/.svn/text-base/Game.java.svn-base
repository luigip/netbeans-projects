package chess;
import chess.pieces.*;

public class Game {
    public Board board = new Board();

    public void initializeBoard(){

        board.grid[0][0].thisPiece = new Rook(Colour.white);
        board.grid[0][1].thisPiece = new Knight(Colour.white);
        board.grid[0][2].thisPiece = new Bishop(Colour.white);
        board.grid[0][3].thisPiece = new King(Colour.white);
        board.grid[0][4].thisPiece = new Queen(Colour.white);
        board.grid[0][5].thisPiece = new Bishop(Colour.white);
        board.grid[0][6].thisPiece = new Knight(Colour.white);
        board.grid[0][7].thisPiece = new Rook(Colour.white);
        for(Square s: board.grid[1]) s.thisPiece = new Pawn(Colour.white);

        board.grid[7][0].thisPiece = new Rook(Colour.black);
        board.grid[7][1].thisPiece = new Knight(Colour.black);
        board.grid[7][2].thisPiece = new Bishop(Colour.black);
        board.grid[7][3].thisPiece = new King(Colour.black);
        board.grid[7][4].thisPiece = new Queen(Colour.black);
        board.grid[7][5].thisPiece = new Bishop(Colour.black);
        board.grid[7][6].thisPiece = new Knight(Colour.black);
        board.grid[7][7].thisPiece = new Rook(Colour.black);
        for(Square s: board.grid[6]) s.thisPiece = new Pawn(Colour.black);




    }
}
