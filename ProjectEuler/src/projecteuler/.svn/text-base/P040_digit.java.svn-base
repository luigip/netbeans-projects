package projecteuler;

import java.util.Arrays;
import java.util.List;

public class P040_digit implements Runnable {

    @Override
    public void run() {
        int digitCount = 0;
        int result = 1;
        List<Integer> nums = Arrays.asList(new Integer[]{1, 10, 100, 1000, 10000, 100000, 1000000});
        int i = 1;
        boolean done = false;
        while (!done) {
            String asString = String.valueOf(i);
            for(int j = 0; j < asString.length(); j++){
                digitCount++;
                if (nums.contains(digitCount)) {
                    result *= Integer.valueOf(asString.substring(j, j+1));
                    System.out.println("d-" + digitCount + ": " + result);
                    if(digitCount == 1000000) done = true;
                }
            }
            i++;
        }
    }

    public static void main(String[] args) {
        new P040_digit().run();
    }
}
