import chess.*;
import chess.pieces.*;



public class Test1 {
    public static void main(String[] args){
        Game game = new Game();
        game.initializeBoard();
        
        game.board.movePiece(0, 2, 5, 1);
        game.board.grid[5][1].thisPiece.getPossMoveList(game.board, game.board.grid[5][1]);
        System.out.println(game.board.toString());
    }
}
