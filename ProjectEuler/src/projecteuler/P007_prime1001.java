
package projecteuler;

import java.util.ArrayList;
import java.util.List;

//1st attempt: 2.53s
//Only checking up to the square root: 0.09s
//Gets all primes up to 1m in 0.72s

/*
 By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 that the 6th prime is 13.

What is the 10001st prime number?

 */

public class P007_prime1001 implements Runnable {

    public void run(){

        ArrayList<Long> primes = new ArrayList<Long>();

        primes.add(2L);
        long i = 1;
        while (primes.size() < 10001){
//        while (i < 1000000){
            i += 2;
            if (checkPrime(i, primes)){
                primes.add(i);
            }
        }
        System.out.println(primes.get(primes.size() - 1));
    }

    static boolean checkPrime(long num, List<Long> primeList){
        long sqr = (long)Math.sqrt(num) + 1;
        for (Long prime : primeList){
            if (prime > sqr) {
                return true;
            }
            if (num % prime == 0){
                return false;
            }
        }
        return true;
    }
}



class P010_primeUnder2m implements Runnable {

    public void run(){

        ArrayList<Long> primes = new ArrayList<Long>();

        primes.add(2L);
        long i = 1;
        long total = 2;
        while (i < 2000000 - 2){
            i += 2;
            if (checkPrime(i, primes)){
                primes.add(i);
                total += i;
            }
        }
        System.out.println(total);
    }

    static boolean checkPrime(long num, List<Long> primeList){
        long sqr = (long)Math.sqrt(num) + 1;
        for (Long prime : primeList){
            if (prime > sqr) {
                return true;
            }
            if (num % prime == 0){
                return false;
            }
        }
        return true;
    }
}