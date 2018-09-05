package projecteuler;

import java.util.ArrayList;
import java.util.HashSet;

public class P050_consecPrimes implements Runnable {

    @Override
    public void run() {
        ArrayList<Integer> pa = Common.getPrimesListSieveV3(1000000);
        HashSet<Integer> primes = new HashSet<Integer>(pa);
        int maxRun = 0;
        int maxPrime = 0;
        for (int i = 0; i < primes.size(); i++) {
            int sum = pa.get(i);
            for (int j = 1; j <= 800 && j + i < primes.size(); j++) {
                sum += pa.get(i + j);
                if (primes.contains(sum)) {
                    if (j > maxRun) {
                        maxRun = j + 1;
                        maxPrime = sum;
                    }
                }
            }
        }
        System.out.println("Prime " + maxPrime + " has run of " + maxRun);
    }

    public static void main(String[] args) {
        new P050_consecPrimes().run();
    }
}
