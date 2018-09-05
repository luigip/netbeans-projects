package projecteuler;

import java.math.BigInteger;

public class P020_factorial implements Runnable{

    public void run() {
            BigInteger n = new BigInteger("100");
//        System.out.println(factorial(n));
            BigInteger f = factorial(n);
            int total = 0;
            for (char c : f.toString().toCharArray()){
                total += Character.getNumericValue(c);
            }
            System.out.println(total);
    }
    public static BigInteger factorial(BigInteger n){
        if (n.equals(new BigInteger("0"))) return BigInteger.ONE;
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }

        public static long factorial(int n){
        if (n == 0) return 1;
        return n * (factorial(n - 1));
    }
}
