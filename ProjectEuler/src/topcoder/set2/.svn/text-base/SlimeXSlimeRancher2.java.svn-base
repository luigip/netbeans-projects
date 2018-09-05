package topcoder.set2;

import java.util.Arrays;

public class SlimeXSlimeRancher2 {
    public int train(int[] attributes){
        Arrays.sort(attributes);
        int sum = 0;
        for (int i = 0; i < attributes.length - 1; i++) {
            sum += attributes[attributes.length - 1] - attributes[i];
        }
        return sum;
    }
}
