package projecteuler;

import java.math.BigInteger;

public class P025_fibb1000 implements Runnable {

    @Override
    public void run() {
        int n = 2;
        BigInteger f = new BigInteger("1");
        BigInteger g = new BigInteger("1");
        BigInteger h;
        do {
            h = f.add(g);
            f = g;
            g = h;
            n++;
        } while (h.toString(10).length() < 1000);
        System.out.println(n);
    }
    public static void main(String[] args) {
        new P025_fibb1000().run();
    }
}

//class F{public static void main(String[]a){int n=2;BigInteger f=BigInteger.ONE,g=f,h;do{h=f.add(g);f=g;g=h;n++;}while(h.toString().length()<1000);System.out.print(n);}}