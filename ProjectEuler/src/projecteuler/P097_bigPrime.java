package projecteuler;

import java.math.BigInteger;

public class P097_bigPrime implements Runnable {

    @Override
    public void run() {
        // don't use BigIntegers: takes ages
//        BigInteger n = BigInteger.ZERO;
//        n = n.flipBit(7830457);        
//        String value = n.multiply(new BigInteger("28433")).add(BigInteger.ONE).toString();
//        System.out.println(value.substring(value.length() - 10, value.length()));

        long a = 28433;
        for (int i = 0; i < 7830457; i++) {
            a = a * 2;
            if (a >= 10000000000L) {
                a = a % 10000000000L;
            }
        }
        System.out.println(a + 1);


    }

    public static void main(String[] args) {
        new P097_bigPrime().run();
        System.out.println("Using bigint:");
        new P097_using_BigInteger().run();
    }
}

class P097_using_BigInteger {
    //takes 6 minutes 50 seconds
    public void run(){
        BigInteger n = new BigInteger("28433").multiply(Power(new BigInteger("2"), 7830457)).add(BigInteger.ONE);
        System.out.println(n.mod(new BigInteger("10000000000")));
    }
    
    // Modified from http://www.osix.net/modules/article/?id=696
    private BigInteger Power(BigInteger a, int b) {
//        System.out.println("Calculating " + a + " ^ " + b);
        if (b < 0) {
            throw new IllegalArgumentException("B must be a positive integer or zero");
        }
        if (b == 0) {
            return BigInteger.ONE;
        }
        if (a.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }
        if (b % 2 == 0) {
            return Power(a.multiply(a), b / 2);
        } else if (b % 2 == 1) {
            return a.multiply(Power(a.multiply(a), b / 2));
        }
        return BigInteger.ZERO;
    }
}