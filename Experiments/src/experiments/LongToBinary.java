package experiments;

import java.math.BigInteger;

public class LongToBinary {
    static String toBinary(long n) {
        String r = "";
        while (n > 0) {
            r = (n % 2 == 0 ? "0" : "1") + r;
            n /= 2;
        }
        return r;
    }
    static String toBinary2(long n) {
        int neg = n < 0 ? 1 : 0;
        if(n < 0) n = -n;
        int pos = 0;
        boolean[] a = new boolean[64];
        do {
            a[pos++] = n % 2 == 1;
        } while ((n >>>= 1) != 0);
        char[] c = new char[pos + neg];
        if(neg > 0) c[0] = '-';
        for (int i = 0; i < pos; i++) {
            c[pos - i - 1 + neg] = a[i] ? '1' : '0';
        }
        return new String(c);
    }
    
    static String toBinary3(long n) {
        char[] c = new char[64];
        for(int i = 63; i >= 0; i--, n >>>= 1) {
            c[i] = n % 2 != 0 ? '1' : '0';          
        }
        return new String(c);        
    }
    
    public static void main(String[] args) {
//        long t0, t; String s;
//        int m = 100000;
//        
//        for (int j = 0; j < 2; j++) {
//           
//            t0 = System.currentTimeMillis();
//            for (int i = 0; i < m; i++) {
//                s = toBinary2(-3324679375210329505L);
//            }
//            t = System.currentTimeMillis() - t0;
//            System.out.println("Run " + j + ": Custom  (long): " + t);
//            t0 = System.currentTimeMillis();
//            for (int i = 0; i < m; i++) {
//                s = toBinary2(-1L);
//            }
//            t = System.currentTimeMillis() - t0;
//            System.out.println("Run " + j + ": Custom (short): " + t);
//            
//            t0 = System.currentTimeMillis();
//            for (int i = 0; i < m; i++) {
//                s = Long.toString(-3324679375210329505L, 2);
//            }
//            t = System.currentTimeMillis() - t0;
//            System.out.println("Run " + j + ": Long    (long): " + t);
//            t0 = System.currentTimeMillis();
//            for (int i = 0; i < m; i++) {
//                s = Long.toString(-1L, 2);
//            }
//            t = System.currentTimeMillis() - t0;
//            System.out.println("Run " + j + ": Long   (short): " + t);
//            
//
//            BigInteger blong = BigInteger.valueOf(-3324679375210329505L);
//            BigInteger bshort = BigInteger.valueOf(-1L);
//            
//            t0 = System.currentTimeMillis();
//            for (int i = 0; i < m; i++) {
//                s = blong.toString(2);
//            }
//            t = System.currentTimeMillis() - t0;
//            System.out.println("Run " + j + ": BigInt  (long): " + t);
//            t0 = System.currentTimeMillis();
//            for (int i = 0; i < m; i++) {
//                s = bshort.toString(2);
//            }
//            t = System.currentTimeMillis() - t0;
//            System.out.println("Run " + j + ": BigInt (short): " + t);            
//        }
//        long[] ls = {4, 15, -4, 0, 1, -1, -0, 345, -345, Long.MAX_VALUE, Long.MIN_VALUE};
        long[] ls = {-1,-2,-3,-4,-5,-6,-7, -127, -126};
        for(long n : ls) {
            System.out.println("Long   " + Long.toString(n, 2));
            System.out.println("Big    " + BigInteger.valueOf(n).toString(2));
            System.out.println("Custom " + toBinary3(n) + "\n");
        }
            
                
    }
}
