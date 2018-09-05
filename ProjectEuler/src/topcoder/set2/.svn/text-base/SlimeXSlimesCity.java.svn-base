package topcoder.set2;

import java.util.Arrays;

public class SlimeXSlimesCity {
    public int merge(int[] pop){
        int count = 0;
        int n = pop.length;
        boolean[] poss = new boolean[n];
        Arrays.fill(poss, true);
        Arrays.sort(pop);
        for (int i = 0; i < n; i++) {
            long newpop = pop[i];
            boolean[] added = new boolean[n];
            added[i] = true;
            boolean fin = false;
            while(!fin && !added[n - 1]){
                for (int j = 0; j < n; j++) {
                    if(!added[j]){
                        if(pop[j] <= newpop){
                            added[j] = true;
                            newpop += pop[j];
                        }
                        else{
                            poss[i] = false;
                            fin = true;
                        }
                        break;
                    }
                }
            }
            if(poss[i]) count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        SlimeXSlimesCity s = new SlimeXSlimesCity();
        int[] pop = {1,1,1};
        System.out.println(s.merge(pop));
    }
}
