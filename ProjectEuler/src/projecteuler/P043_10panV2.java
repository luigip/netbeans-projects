package projecteuler;

import java.util.ArrayList;

public class P043_10panV2 implements Runnable {

    static final int[] primes = {2, 3, 5, 7, 11, 13, 17};
    static final long[] pows = {1000000, 100000, 10000, 1000, 100, 10, 1};
    final ArrayList<Long> pandigitals = new ArrayList<Long>(3500000);
    final boolean[] pool = new boolean[10];
    // digits, lowest order first, i.e. digits[3] is the 10^3 or thousands digit.
    // Initialised with first pandigital
    final int digits[] = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 0, 1};

    @Override
    public void run() {
        pandigitals.add(getLongFromDigits());
        boolean gotAll = false;
        while (!gotAll) {
            Long next = nextPandigital();
            pandigitals.add(next);
            if (next == 9876543210L) {
                gotAll = true;
            }
        }
        System.out.println("found " + pandigitals.size());

        long total = 0;
        for (long p : pandigitals) {
            if (isValid(p)) {
                total += p;
            }
        }
        System.out.println("Total of valid pandigitals: " + total);
    }

    long nextPandigital() {
        boolean found = false;
        int index = 0;
        while (!found) {
            if (updateDigit(index)) {
                // this is highest order index to be updated
                for (int i = index - 1; i >= 0; i--) {
                    getDigitFromPool(i, -1);
                }
                found = true;
            } else {
                index++;
            }
        }
        return getLongFromDigits();
    }

    void putDigitInPool(int index) {
        pool[digits[index]] = true;
        digits[index] = -1;
    }

    boolean getDigitFromPool(int index, int origDigit) {
        // Looks for number higher than original & returns true if found
        boolean foundHigher = false;
        for (int i = origDigit + 1; i < 10 && !foundHigher; i++) {
            if (pool[i]) {
                digits[index] = i;
                pool[i] = false;
                foundHigher = true;
            }
        }
        return foundHigher;
    }

    boolean updateDigit(int index) {
        boolean digitUpdated = false;
        int origDigit = digits[index];
        putDigitInPool(index);
        if (getDigitFromPool(index, origDigit)) {
            digitUpdated = true;
        }
        return digitUpdated;
    }

    long getLongFromDigits() {
        long total = 0;
        for (int i = 0; i < 10; i++) {
            total += digits[i] * Math.pow(10, i);
        }
        return total;
    }

    static boolean isValid(long value) {
        boolean valid = true;
        for (int i = 0; valid && i <= 6; i++) {
            valid = ((value / pows[i]) % 1000) % primes[i] == 0;
        }
        return valid;
    }

    public static void main(String[] args) {
        new P043_10panV2().run();
    }
//////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    public void bruteForce() {
        //Will take nearly 2 hours to run
        long start = System.currentTimeMillis();
        long total = 10000000000L - 1023456789;
        long pointOnePc = total / 1000;
        for (long i = 1023456789; i < 10000000000L; i++) {
            if (isPandigital(i)) {
                pandigitals.add(i);
            }
            //chart progress
            if (i % pointOnePc == 0) {
                System.out.printf("%.1f%%... %.0fs... %d pandigitals%n", ((i - 1023456789) * 100d / total),
                        (System.currentTimeMillis() - start) / 1000d, pandigitals.size());
            }
        }
    }

    static boolean isPandigital(long value) {
        // Takes a 10 digit number and checks for values 0-9
        // (not used)
        boolean isPan = true;
        int len = (int) Math.log10(value) + 1;
        if (len != 10) {
            isPan = false;
        }
        boolean[] digitCheck = new boolean[len];
        for (int i = 0; i < len && isPan; i++) {
            int dig = (int) (value / Math.pow(10, i) % 10);
            if (digitCheck[dig]) {
                isPan = false;
            } else {
                digitCheck[dig] = true;
            }
        }
        return isPan;
    }
}
