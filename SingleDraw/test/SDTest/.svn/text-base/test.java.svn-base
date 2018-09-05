/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SDTest;

import singledraw.*;
import java.util.Arrays;
/**
 *
 * @author Rhys
 */

public class test {

    public static void main(String[] args){

        test t = new test();
        Deck deck = new Deck();
        int[][] tcards = {  {4,2},
                            {3,4},
                            {2,11},
                            {2,4},
                            {1,12}
                            };
       
        CHand h = new CHand();
        for(int i = 0; i <5; i++){
            h.setOneCard(i, deck.getCard(tcards[i][1], tcards[i][0]));
        }
        System.out.println(h.toString());

        CHand h2 = (CHand)h.clone();
        h2.sortHand();
        System.out.println("sorted: \n"+h2.toString());
        System.out.println(h.getOneCard(0).compareTo(h.getOneCard(1)));

        h2.determineHandStrength(GameType.LOWBALL);
        System.out.println(Arrays.toString(h2.getStrengthRank()));
    }
    public test() {
        
    }

}
