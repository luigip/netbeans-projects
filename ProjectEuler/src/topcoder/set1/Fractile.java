package topcoder.set1;

import java.util.Arrays;

public class Fractile {
    public int fractile(int[] x, int p){
        Arrays.sort(x);
        int perc = (int) (Math.ceil(p * x.length/100.0));
        return x[perc - 1 < 0 ? 0 : perc - 1];
    }
}
