
package singledraw;

public class Deck {
    private CCard[][] fCards = new CCard[14][5];
    private CCard[] fCardsLeft = new CCard[47];
    private int fCardsLeftCount;

    public Deck(){
        for (int r = 1; r < 14; r++) {
            for (int s = 1; s < 5; s++) {
                fCards[r][s] = new CCard(r,s);
            }
        }
    };

    public CCard getCard(int rank, int suit){
        return fCards[rank][suit];
    }

    public int getfCardsLeftCount() {
        return fCardsLeftCount;
    }

    public void setCardsLeft(){
        int cardLeftInDeckCount = 0;
        for (int r = 0; r < 13; r++) {
            for (int s = 0; s < 4; s++) {
                if(fCards[r][s].isLeftInDeck()){
                    cardLeftInDeckCount++;
                    fCardsLeft[cardLeftInDeckCount - 1] = fCards[r][s];
                }
            }
        }
        fCardsLeftCount = cardLeftInDeckCount;
    }
    public CCard getCardsLeft(int position){
        return fCardsLeft[position];
    }

}
