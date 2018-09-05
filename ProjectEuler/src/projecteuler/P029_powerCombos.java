package projecteuler;

import java.math.BigInteger;
import java.util.TreeSet;

public class P029_powerCombos implements Runnable{
    static final int aMax = 100;
    static final int bMax = 100;

    @Override
    public void run(){
        TreeSet<BigInteger> ts = new TreeSet<BigInteger>();
        for(int a = 2; a <= aMax; a++){
            for(int b = 2; b <= bMax; b++){
                BigInteger result = BigInteger.valueOf(a).pow(b);
                ts.add(result);
            }
        }
        System.out.println(ts.size());

    }
	
    public static void main(String[] args) {
        new P029_powerCombos().run();
    }
}
