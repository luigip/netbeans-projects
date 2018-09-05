/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package chess;

import chess.pieces.Bishop;


public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.initializeBoard();
        System.out.println(game.board.toString());
        
    }

}
