package topcode.TCHS;

public class S20_250 {
    public int bestSurname(String[] surnames) {
        int max = 0;
        int best = 0;
        for(int i = 0; i < surnames.length; i++){
            int score = 0;
            for(char c : surnames[i].toCharArray()) score += c;
            if(score > max){
                max = score;
                best = i;
            }
        }
        return best;
    }
}
