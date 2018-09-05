package projecteuler;

import java.math.BigInteger;

public class P053_combinations implements Runnable {

    @Override
    public void run() {
        int count = 0;
        for (int n = 1; n <= 100; n++) {
            for (int r = 1; r <= n ; r++) {
                BigInteger result = factorial(BigInteger.valueOf(n))
                                        .divide(factorial(BigInteger.valueOf(r)))
                                        .divide(factorial(BigInteger.valueOf(n - r)));
                if(result.compareTo(BigInteger.valueOf(1000000)) > 0){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    
    static BigInteger factorial(BigInteger n){
        if(n.compareTo(BigInteger.ZERO) == 0) return BigInteger.ONE;
        return(n.multiply(factorial(n.subtract(BigInteger.ONE))));
    }
    
    public static void main(String[] args) {
        new P053_combinations().run();
    }
}
