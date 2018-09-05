package topcoder.set1;

import java.util.Arrays;

public class WinningTrick {
    
    public double minimumSpeed(int[] speed, int yourSpeed){
        Arrays.sort(speed);
        int a = speed[speed.length - 1];
        return a < yourSpeed ? 0 : (a - yourSpeed) / 2.0;
    }
}
