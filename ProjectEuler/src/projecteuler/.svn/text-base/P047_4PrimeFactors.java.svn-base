package projecteuler;

import java.util.ArrayList;
import java.util.HashSet;

public class P047_4PrimeFactors implements Runnable {

    static final int NUM_PRIME_FACTORS = 4;
    static final int MAX_PRIME = 1000000;
    static ArrayList<Integer> primes = Common.getPrimesListSieveV3(MAX_PRIME);

    @Override
    public void run() {

        int n = 9;
        boolean found = false;
        while (!found) {
            boolean valid = true;
            for (int i = 0; valid && i < NUM_PRIME_FACTORS; i++) {
                if (getPrimeFactorsDistinct(n).size() != NUM_PRIME_FACTORS) {
                    valid = false;
                }
                n++;
            }
            if (valid) {
                System.out.println("First in sequence = " + (n - NUM_PRIME_FACTORS));
                found = true;
            }
        }
    }
    // not used in this solution:
    static ArrayList<Integer> getPrimeFactors(int n) {
        ArrayList<Integer> factors = new ArrayList<Integer>();
        int m = n;
        boolean allFound = false;
        int i = 0;
        while (!allFound) {
            int p = primes.get(i);
            if (m % p == 0) {
                if (m == p) {
                    allFound = true;
                }
                m = m / p;
                factors.add(p);
                i = 0;
            } else {
                i++;
            }
        }
        return factors;
    }
    static HashSet<Integer> getPrimeFactorsDistinct(int n) {
        HashSet<Integer> factors = new HashSet<Integer>();
        int m = n;
        boolean allFound = false;
        int i = 0;
        while (!allFound) {
            int p = primes.get(i);
            if (m % p == 0) {
                if (m == p) {
                    allFound = true;
                }
                m = m / p;
                factors.add(p);
                i = 0;
            } else {
                i++;
            }
        }
        return factors;
    }
    public static void main(String[] args) {
        new P047_4PrimeFactors().run();
//        System.out.println(getPrimeFactorsDistinct(9));
    }
}
