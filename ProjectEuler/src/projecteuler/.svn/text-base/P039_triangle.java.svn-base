package projecteuler;

import java.util.HashSet;
import java.util.ArrayList;
import static java.lang.Math.*;

public class P039_triangle implements Runnable {
/* This is longer than necessary - we don't need the HashSets or ArrayLists or output - 
 * only if we want to do extra and output the actual solutions 
 */
    @Override
    public void run() {
        int solCountMax = 0;
        int pMax = 0;
        HashSet bestSols = null;
        
        for(int p = 1; p <= 1000; p++){
            int solCount = 0;
            HashSet<ArrayList<Integer>> sols = new HashSet<ArrayList<Integer>>();
            
            int aMax = (int)(p * 1 / (1 + 1 + sqrt(2)));
            for(int a = 1; a <= aMax; a++){
                // o = (p^2 - 2ap) / 2(p - a)
                if( ((int)pow(p,2) - 2*a*p) % (2*(p - a)) == 0){
                // sides are integral length
                    solCount++;
                    
                    ArrayList<Integer> sol = new ArrayList<Integer>();
                    sol.add(a);
                    int o = (int)(pow(p,2) - 2*a*p) / (2*(p - a));
                    sol.add(o);
                    sol.add(p - a - o);
                    sols.add(sol);
                }
                if(solCount > solCountMax) {
                    solCountMax = solCount;
                    pMax = p;
                    bestSols = sols;
                }
            }
            if(solCount > 0){
                System.out.println("Integral lengths at p = " + p + " (" + sols.size() + " solutions): ");
                System.out.println(sols);
            }
        }
        System.out.println("");
        System.out.println("Max p: " + pMax + " with " + solCountMax + " solutions");
        System.out.println(bestSols);
        
    }
    
    public static void main(String[] args) {
        new P039_triangle().run();
    }
}
