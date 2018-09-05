package projecteuler;

import java.util.ArrayList;
import java.util.List;

/**
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?

 */
public class P003_primes implements Runnable {
    public void run(){
        long target = 600851475143L;
        long dividend = target;
        ArrayList<Long> primes = new ArrayList<Long>();

        primes.add(2L);
        for (long i = 3; i < dividend; i += 2){
            if (checkPrime(i, primes)){
                primes.add(i);
                if(dividend % i == 0){
                    System.out.println("Prime factor: " + i);
                    dividend /= i;
                }
            }
        }
        System.out.println("Largest prime factor: " + dividend);
    }

    static boolean checkPrime(long num, List<Long> primeList){
        for (Long prime : primeList){
            if(num % prime == 0){
                return false;
            }
        }
        return true;
    }
}

//Someone else's version that runs a lot faster!
class P003_AltPrime implements Runnable{
    public void run(){
        long n = 600851475143L;
        long d = 2L;
        while(d < n / d){
            if (n % d == 0){
                n /= d;
            }else d += 1;
        }
        System.out.println(n);
    }

    public static void main(String[] args) {
        new P003_AltPrime().run();
//        new P003_primes().run();
    }
}