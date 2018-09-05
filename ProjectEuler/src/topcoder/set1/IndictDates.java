package topcoder.set1;

public class IndictDates {
    public int getYear(int indict, int circleSun, int circleMoon){
        int i = 0, s = 0, m = 0, count = 1;
        while(!(i + 1 ==indict && s + 1 == circleSun && m + 1 == circleMoon)){
            i++; i %= 15;
            s++; s %= 28;
            m++; m %= 19;
            count++;
        }
        
        return count;
    }
}
