package projecteuler;

import java.math.BigInteger;

public class P048_last10digits implements Runnable{
    @Override
    public void run(){
        final int MAX = 1000;

        BigInteger total = BigInteger.ZERO;
        for(int i = 1; i <= MAX; i++){
            BigInteger result = BigInteger.valueOf(i).pow(i);
            total = total.add(result);
        }
        String last10 = total.toString().substring(total.toString().length() - 10);
        System.out.println(last10);
    }

	
    public static void main(String[] args) {
        new P048_last10digits().run();
    }
}
