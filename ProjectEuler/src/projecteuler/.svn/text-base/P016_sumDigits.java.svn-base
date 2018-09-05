package projecteuler;

import java.math.BigInteger;

public class P016_sumDigits implements Runnable{
    public void run() {
        BigInteger b = new BigInteger("2").pow(1000);
        int sum = 0;
        for (char c : b.toString().toCharArray()){
            sum += Character.getNumericValue(c);
        }
        
        System.out.println("Sum: " + sum);
    }
}
