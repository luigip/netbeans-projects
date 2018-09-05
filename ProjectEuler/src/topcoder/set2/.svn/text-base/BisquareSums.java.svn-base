package topcoder.set2;

import java.util.HashSet;

public class BisquareSums {

    public int getSums(int low, int high) {
        HashSet<Integer> bisquares = new HashSet<Integer>();
        for (int i = 0; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                bisquares.add(j * j + i * i);
            }
        }
        int count = 0;
        for (int i = low; i <= high; i++) {
            if(bisquares.contains(i)) count++;
        }
        return count;
    }
}
