package projecteuler;

import java.util.ArrayList;
import java.util.HashSet;

// Not very optimised, but takes 2 seconds which is acceptable
public class P051_PrimeDigitReplace implements Runnable {

    static final int MAX = 1000000;
    static final int FAM_SIZE = 8;
    static final ArrayList<Integer> primesList = Common.getPrimesListSieveV3(MAX);
    static final HashSet<Integer> primesSet = new HashSet<Integer>(primesList);

    @Override
    public void run() {
        // try numbers from 10 to the maximum
        for (int i = 10; i < MAX; i++) {
            if(!primesSet.contains(i)) continue;
            // get digit combos up to digit length
            int numDigs = (int) Math.log10(i) + 1;
            int digitsBinary = 1;
            ArrayList<Integer> digits = getDigitCombo(digitsBinary);
            // loop until covered all combos of digits
            while (digits.get(digits.size() - 1) < numDigs) {
                int familyCount = 0;
                int base = i;
                //loop through numbers 0 - 9 
                for (int k = 0; k < 10; k++) {
                    // loop through number of digits to be replaced
                    for (int j : digits) {
                        base = replaceDigit(base, j, k);
                    }
                    if (primesSet.contains(base)) {
                        //if first digit is replaced by zero, ignore
                        if (base >= Math.pow(10, numDigs - 1)) {
                            familyCount++;
                        }
                    }
                }
                if (familyCount == FAM_SIZE) {
                    System.out.println("n = " + i + ", digits " + digits);
                    System.out.println("If first digit is one of those replaced, use replacement of 1, else zero");
                    System.out.println("(note index 0 is the number on the right; 1 is second from right etc.)");
                    return;
                }
                digitsBinary++;
                digits = getDigitCombo(digitsBinary);
            }
        }
    }

    static int replaceDigit(int n, int index, int digit) {
        int pow = (int) Math.pow(10, index);
        return n - ((n / pow % 10) * pow) + (digit * pow);
    }

    /**
     * @param v
     * @return List of positions of binary 1 in the number, e.g. <br>
     * v = 1 (decimal 1), returns [0] <br>
     * v = 10100 (decimal 20), returns [2, 4]
     */
    static ArrayList<Integer> getDigitCombo(int v) {
        ArrayList<Integer> digitCombo = new ArrayList<Integer>();
        int dig = 0;
        while (v > 0) {
            if (v % 2 == 1) {
                digitCombo.add(dig);
            }
            v >>= 1;
            dig++;
        }
        return digitCombo;
    }

    public static void main(String[] args) {
        new P051_PrimeDigitReplace().run();
    }
}
