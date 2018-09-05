package projecteuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class P049_4digitSeq implements Runnable {

    @Override
    public void run() {
        ArrayList<Integer> prList = Common.getPrimesListSieveV3(9999);
        HashSet<Integer> primes = new HashSet<Integer>(prList);

        for (int p : prList) {
            if (p > 999) {
                for (int diff = 2; diff < (9999 - p) / 2; diff++) {
                    if (isPerm(p, p + diff)) {
                        if (isPerm(p, p + diff + diff)) {
                            if (primes.contains(p + diff)) {
                                if (primes.contains(p + diff + diff)) {
                                    System.out.println(p + ", " + diff);
                                    System.out.println(p + String.valueOf(p + diff) + (p + diff + diff));
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    boolean isPerm(int a, int b) {
        int[] sortA = split(a);
        Arrays.sort(sortA);
        int[] sortB = split(b);
        Arrays.sort(sortB);
        if (Arrays.equals(sortA, sortB)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     * @param n The number to be split
     * @return Array with digits, smallest first
     */
    int[] split(int n) {
        int len = (int) Math.log10((n)) + 1;
        int[] digits = new int[len];
        for (int i = 0; i < len; i++) {
            digits[i] = (int) (n / Math.pow(10, i) % 10);
        }
        return digits;
    }

    public static void main(String[] args) {
        new P049_4digitSeq().run();
    }
}
