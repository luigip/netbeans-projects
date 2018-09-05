package topcode.TCHS;

public class S18_250 {
    public int getApples(int[] x, int[] y, int[] day, int howMany){
        int count = 0;
        int i = 0;
        for (i = 0; i < day.length && count < howMany; i++) {
            if(x[i] >= 0 && x[i] <= 100 && y[i] >=0 && y[i] <= 100) count++;
        }
        return count < howMany ? -1 : day[i - 1];
    }
}
