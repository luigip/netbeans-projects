package projecteuler;

import java.util.Arrays;
import java.util.HashSet;

public class P032_pandigital implements Runnable{
    @Override
    public void run(){
        HashSet<Integer> pandigitalProducts = new HashSet<Integer>();
        long sumProds = 0;
        
        for (int p = 1000; p < 10000; p++) {
            for (int a = 1; a < 10000; a++){
                if(p % a == 0){
                    int b = p / a;
                    if(checkPan(p, a, b)){
                        pandigitalProducts.add(p);
                    }
                }
            }
        }
        for(int i : pandigitalProducts) sumProds += i;
        System.out.println("Sum = " + sumProds);
    }

    static boolean checkPan(int p, int a, int b){
        String s = String.valueOf(p) + String.valueOf(a) + String.valueOf(b);
        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        if(String.valueOf(ca).equals("123456789")) return true;
        else return false;
    }
	
    public static void main(String[] args) {
        new P032_pandigital().run();
    }
}
