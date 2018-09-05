package projecteuler;

import java.util.ArrayList;
import java.util.TreeSet;
import myutil.Primes;

public class P037_truncatable implements Runnable {

    public void run() {
        final int MAX = 1000000;
        int sum = 0;
        
        ArrayList<Integer> primes = Primes.getList(MAX);
        TreeSet<Integer> ptree = new TreeSet<Integer>(); //for performance
          
        for (Integer p : primes) {
            ptree.add(p);
            if (p > 9) {
                String s = p.toString();
                boolean truncatable = true;
                for (int i = 1; i < s.length(); i++) {
                    if (!ptree.contains(Integer.valueOf(s.substring(i)))
                            || !ptree.contains(Integer.valueOf(s.substring(0, i)))) {
                        truncatable = false;
                        break;
                    }
                }
                if (truncatable) {
                    sum += p;
                    System.out.println(p);
                }
            }
        }
        System.out.println("Total: " + sum);
    }

    public static void main(String[] args) {
        new P037_truncatable().run();
    }
}
