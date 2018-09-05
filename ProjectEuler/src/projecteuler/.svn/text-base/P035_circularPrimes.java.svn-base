package projecteuler;

import java.util.ArrayList;

public class P035_circularPrimes implements Runnable {

    ArrayList<Integer> primes = new ArrayList<Integer>();
    int cPrimeCount;

    @Override
    public void run() {
        primes = Common.getPrimesListSieve(1000000);

        for(long p: primes){
            String s = String.valueOf(p);
            boolean isCircular = true;
            for (int i = 1; i < s.length(); i++){
                s = rotate(s);
                if(Common.checkPrime(Integer.valueOf(s), primes) == false){
                    isCircular = false;
                    break;
                }
            }
            if (isCircular){
                System.out.println("Circular prime: " + p);
                cPrimeCount++;
            }
        }
        System.out.println("Count: " + cPrimeCount);

    }

    static String rotate(String n){
        return n.substring(1) + n.charAt(0);
    }

    public static void main(String[] args) {
        new P035_circularPrimes().run();
    }
}
