package projecteuler;

import java.util.ArrayList;

public class primespeed implements Runnable{
    @Override
    public void run(){
//        int[] tests = new int[]{10000, 100000, 1000000};
        int[] tests = new int[]{10000, 100000, 1000000, 10000000, 50000000};
        for(int t : tests){
            System.out.println(t + ":");
            long st = System.nanoTime();
            ArrayList<Integer> primes = Common.getPrimesListSieveV2(t);
            System.out.println("Using method A: " + primes.size());
            System.out.printf("Time: %.4f ms %n", (System.nanoTime() - st)/1000000d);
            


            long st2 = System.nanoTime();
            ArrayList<Integer> primes2 = Common.getPrimesListSieveV3(t);
            System.out.println("Using method B: " + primes2.size());
            System.out.printf("Time: %.4f ms %n", (System.nanoTime() - st2)/1000000d);

            System.out.println();
        }

    }

	
    public static void main(String[] args) {
        new primespeed().run();
    }
}
