package myutil;

import java.util.ArrayList;

public class Primes {

    /**
     * Returns a list of primes using a Sieve of Eratosthenes
     * @param upto The upper limit of primes to be returned
     * @return An ArrayList containing all primes from 0 to the value specified
     */
    public static ArrayList<Integer> getList(int upto) {
        if(upto < 2) throw new IllegalArgumentException("Argument must be 2 or greater");
        
        ArrayList<Integer> primes = new ArrayList<Integer>();
        boolean[] sieve = new boolean[upto + 1];
        sieve[2] = true;
        primes.add(2);
        for (int i = 3; i < sieve.length; i += 2) {
            sieve[i] = true;
        }
        for (int i = 3; i < Math.sqrt(sieve.length); i += 2) {
            if (sieve[i]) {
                for (int j = i + i; j < sieve.length; j += i) {
                    sieve[j] = false;
                }
            }
        }
        for (int i = 3; i < sieve.length; i += 2) {
            if (sieve[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
    
    public static void main(String[] args) {
        System.out.println(getList(2));
        
    }
}
