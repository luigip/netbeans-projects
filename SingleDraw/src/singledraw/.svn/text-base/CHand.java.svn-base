package singledraw;
import java.util.Arrays;

public class CHand implements Cloneable, Comparable<CHand>
{
    private CCard[] fCards = new CCard[5];
    private int[] strengthRank = new int[6];
    private int fStrengthRankHash;
    private float fEquity;

    public CHand(){
    }
    public int compareTo(CHand hand){
        if (this.fStrengthRankHash > hand.fStrengthRankHash) return 1;
        else if (this.fStrengthRankHash < hand.fStrengthRankHash) return -1;
        else return 0;
    }

    
    public CCard getOneCard(int cardNum)
    {
        return fCards[cardNum];
    }
    public void setOneCard(int cardNum, CCard value)
    {
        fCards[cardNum] = value;
    }

    public int[] getStrengthRank() {
        return strengthRank;
    }

    public int strength() {
        return fStrengthRankHash;
    }
    private void setStrengthRankHash(){
        fStrengthRankHash = 1 * strengthRank[5] +
                            14 * strengthRank[4] +
                            196 * strengthRank[3] +
                            2744 * strengthRank[2] +
                            38416 * strengthRank[1] +
                            537824 * strengthRank[0];
    }

    public float getEquity() {
        return fEquity;
    }

    public void setEquity(float equity) {
        this.fEquity = equity;
    }

    @Override public Object clone() 
    {
        CHand result;
        try{
              result = (CHand)super.clone();
        }
        catch(CloneNotSupportedException e){
            throw new AssertionError();
        }
        return result;
    }

    @Override public String toString(){
        StringBuilder s = new StringBuilder();
        for(CCard c : fCards){
            s.append(c.toString());
            s.append (" ");
        }
        return s.toString();
    }
    public void sortHand(){
        Arrays.sort(fCards, CardReverseComparator.INSTANCE);
    }

    public void determineHandStrength(GameType gameType){
        int rank, rankNext, suit, suitNext, a, i;
        int[] rankCount = new int[14];

        boolean isStraightFlush = false, isQuads = false, isFullHouse = false,
                isFlush = false, isStraight = false, isTrips = false,
                isTwoPair = false, isOnePair = false, isHighCard = false;

        isFlush = true;
        isStraight = true;

        sortHand();

        SEARCHING: //Break block to leave when hand value found
        {

        //Count cards of each rank then look for straights and flushes
        for(i=0; i<5; i++){
            rank = fCards[i].getRank();
            suit = fCards[i].getSuit();
            rankCount[rank]++;
            if(i < 4){
                rankNext = fCards[i+1].getRank();
                suitNext = fCards[i+1].getSuit();
                if (suit != suitNext) isFlush = false;
                if (rank != rankNext + 1) isStraight = false;
            }
        }

        //Special case of A5432 being straight in high games
        if(gameType == GameType.HIGH){
            if(fCards[0].getRank() == 13){
                if(fCards[1].getRank() == 4){
                    if(fCards[2].getRank() == 3){
                        if(fCards[3].getRank() == 2){
                            if(fCards[4].getRank() == 1){
                                // move A to lowest rank
                                CCard CardTemp;
                                for(i=0; i<4; i++){
                                    CardTemp = fCards[i];
                                    fCards[i] = fCards[i+1];
                                    fCards[i+1] = CardTemp;
                                }
                                isStraight = true;
                            }
                        }
                    }
                }
            }
        }
        // is straight flush?
        if(isFlush && isStraight){
            isStraightFlush = true; isFlush = false; isStraight = false;
            strengthRank[0] = 9;
            strengthRank[1] = fCards[0].getRank();
            break SEARCHING;
        }

        //set strengthRank if straight or flush
        if(isFlush){
            strengthRank[0] = 6;
            for (i = 1; i <= 5; i++) {
                strengthRank[i] = fCards[i-1].getRank();
            }
            break SEARCHING;
        }
        if(isStraight){
            strengthRank[0] = 5;
            strengthRank[1] = fCards[0].getRank();
            break SEARCHING;
        }
        //is quads, full house, two pair or pair?
        SEARCH1:
        for (i = 13; i > 0; i--) { //searches high to low so we get higher of 2 pair first
            //Quads
            if (rankCount[i] == 4){
                isQuads = true;
                strengthRank[0] = 8;
                strengthRank[1] = i;
                for(a = 1; a<=13; a++){
                    if(rankCount[a] == 1) {strengthRank[2] = a;}
                }
                break SEARCHING;
            }
            //Trips / full house
            if (rankCount[i] == 3){
                strengthRank[1] = i;
                for(a = 1; a <= 13; a++){
                    if(rankCount[a] == 2){
                        isFullHouse = true;
                        strengthRank[0] = 7;
                        strengthRank[2] = a;
                        break SEARCHING;
                    }
                }
                assert (isFullHouse == false); //debugging safety check
                isTrips = true;
                strengthRank[0] = 4;
                for( a = 13; a >= 1; a--){
                    if(rankCount[a] == 1){
                        if(strengthRank[2] == 0) strengthRank[2] = a;
                                            else strengthRank[3] = a;
                    }
                }
                break SEARCHING;
            }
            //Pair / 2 pair

            if (rankCount[i] == 2){
                strengthRank[1] = i;
                for(a = 1; a <= 13; a++){
                    if(rankCount[a] == 2 && a != i){
                        isTwoPair = true;
                        strengthRank[0] = 3;
                        strengthRank[1] = i;
                        strengthRank[2] = a;
                        // determine two pair's kicker
                        for(int j = 1; j <= 13; j++){
                            if(rankCount[j] == 1){
                                strengthRank[3] = j;
                                break SEARCHING;
                            }
                        }
                    }
                    if(rankCount[a] == 3) {
                        isFullHouse = true;
                        continue SEARCH1;
                    }
                }
                //One pair
                assert (isTwoPair == false && isFullHouse == false);
                isOnePair = true;
                strengthRank[0] = 2;
                for(a = 13; a >= 1; a--){
                    if(rankCount[a] == 1){
                        if(strengthRank[2] == 0) strengthRank[2] = a;
                        else if(strengthRank[3] == 0) strengthRank[3] = a;
                        else strengthRank[4] = a;
                    }
                }
                break SEARCHING;
            }
        }
        //High card
        assert !(isStraightFlush || isQuads || isFullHouse || isFlush ||
                isStraight || isTrips || isTwoPair || isOnePair);
        isHighCard = true;
        strengthRank[0] = 1;
        for(i = 1; i <= 5; i++) strengthRank[i] = fCards[i-1].getRank();
    }// End of SEARCHING block
    setStrengthRankHash();
    }
}