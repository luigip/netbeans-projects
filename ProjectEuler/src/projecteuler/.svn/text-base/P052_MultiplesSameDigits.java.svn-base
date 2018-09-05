package projecteuler;

import java.util.Arrays;
import java.util.HashSet;

public class P052_MultiplesSameDigits implements Runnable {

    @Override
    public void run() {
        for (int i = 1;; i++) {
            for (int m = 2;; m++) {
                if (!isPerm2(i, m * i)) {
                    break;
                }
                if (m == 6) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }
    static boolean isPerm2(int a, int b) {
        HashSet<Character> aset = new HashSet<Character>();
        HashSet<Character> bset = new HashSet<Character>();
        for(char x : String.valueOf(a).toCharArray()) aset.add(x);
        for(char x : String.valueOf(b).toCharArray()) bset.add(x);
        if(aset.equals(bset)) return true;
        return false;        
    }
    
    ////
    // methods below not required
    static boolean isPerm(int a, int b) {
        int[] sortA = split2(a);
        Arrays.sort(sortA);
        int[] sortB = split2(b);
        Arrays.sort(sortB);
        if (Arrays.equals(sortA, sortB)) {
            return true;
        } else {
            return false;
        }
    }

    static int[] split(int n) {
        int len = (int) Math.log10((n)) + 1;
        int[] digits = new int[len];
        for (int i = 0; i < len; i++) {
            digits[i] = (int) (n / Math.pow(10, i) % 10);
        }
        return digits;
    }

    static int[] split2(int n) {
        int[] digits = new int[10];
        int b = 0;
        while (n >= 1) {
            digits[b] = n % 10;
            n /= 10;
            b++;
        }
        return digits;
    }



    public static void main(String[] args) {
        for (int i = 0; i < 10000000; i++) {
            isPerm(123, 322);
        }
         
        
//        new P052_MultiplesSameDigits().run();
    }
}
