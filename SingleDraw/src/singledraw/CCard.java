/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package singledraw;

import java.util.Comparator;

/**
 *
 * @author Rhys
 */
public class CCard implements Comparable<CCard>{
    private int fSuit;
    private int fRank;
    private boolean fLeftInDeck;
    private String fLabel;

    public CCard(int rank, int suit) {
        fRank = rank;
        fSuit = suit;
        fLeftInDeck = true;
        fLabel = "Suit: " + fSuit + " Rank:" + fRank;
        fLabel = ranks[rank] + suits[suit];
    }
    @Override public String toString(){
        return fLabel;
 //   return "Rank:" + fRank + " Suit: " + fSuit;
    }
    public int compareTo(CCard c){
        if (this.fRank == c.fRank) return 0;
        return(this.fRank > c.fRank) ? 1 : -1;
    }


    /**
     * @return the suit
     */
    public int getSuit() {
        return fSuit;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(int suit) {
        this.fSuit = suit;
    }

    /**
     * @return the rank
     */
    public int getRank() {
        return fRank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(int rank) {
        this.fRank = rank;
    }

    /**
     * @return the leftInDeck
     */
    public boolean isLeftInDeck() {
        return fLeftInDeck;
    }

    /**
     * @param leftInDeck the leftInDeck to set
     */
    public void setLeftInDeck(boolean leftInDeck) {
        this.fLeftInDeck = leftInDeck;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return fLabel;
    }


    public void setLabel(int rank, int suit) {
        this.fLabel = ranks[rank] + suits[suit];
    }
    private static String[] suits = {"*","s","h","d","c"};
    private static String[] ranks = {"*","2","3","4","5","6","7","8","9","T","J","Q","K","A"};

}

class CardReverseComparator implements Comparator<CCard>{
    //implement as singleton to avoid repeated instanciation
    private CardReverseComparator(){} //prevents new instances being created
    public static final CardReverseComparator INSTANCE = new CardReverseComparator();

    public int compare(CCard c1, CCard c2) {
        return 0 - c1.compareTo(c2);
    }

 }

