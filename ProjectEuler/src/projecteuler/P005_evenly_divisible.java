
package projecteuler;

/**
 *
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * <p>
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class P005_evenly_divisible implements Runnable{
    final int t = 20;

    public void run() {
        int i = t;
        while(!isEvenlyDivisible(i, t)){
            i += 2;
        }
        System.out.println(i);
    }
    boolean isEvenlyDivisible(int a, int b){
        for (int i = 2; i <= b; i++) {
            if (a % i != 0) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        long t = System.nanoTime();
        new P005_evenly_divisible().run();
        System.out.println((System.nanoTime() - t)/1e9 + " s");
    }
}
