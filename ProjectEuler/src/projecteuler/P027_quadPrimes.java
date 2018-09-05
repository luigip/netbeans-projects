package projecteuler;

import java.util.ArrayList;
import java.util.List;

//Works. Primes routine copied from P007
public class P027_quadPrimes implements Runnable{
    final int aMax = 1000;
    final int bMax = 1000;
    ArrayList<Long> primes = new ArrayList<Long>();

    @Override
    public void run(){
        int primesMax = 0;
        int prodCoeff = 0;

        getPrimes();
        for (int a = -aMax; a <= aMax; a++) {
            //b must be prime: reduces time from 30-odd to 4s
            for (int b= 2; b <= bMax; b++) {
                if(!checkPrime(b, primes)) continue;
                int numPrimes = countPrimes(a, b);
                if(numPrimes > primesMax) {
                    prodCoeff = a * b;
                    primesMax = numPrimes;
                    System.out.println("a = " + a + ", b = " + b + ", " + numPrimes
                            + " primes... coeff = " + prodCoeff);
                }
            }
        }
    }

    int countPrimes(int a, int b){
        int n = 0;
        while(primes.contains((long)(n * n + a * n + b))){
            n++;
        }
        return n - 1;
    }

    void getPrimes() {
        primes.add(2L);
        long i = 1;

        while (i < 10000 - 2) {
            i += 2;
            if (checkPrime(i, primes)) {
                primes.add(i);
            }
        }
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

    public static void main(String[] args) {
        new P027_quadPrimes().run();
    }
}