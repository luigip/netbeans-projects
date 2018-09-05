package projecteuler;

import java.util.ArrayList;
import java.util.TreeSet;

public class P044_pentagDiff implements Runnable {
    static final ArrayList<Long> PENTAG = new ArrayList<Long>();
    static final TreeSet<Long> PENTAGTREE = new TreeSet<Long>();
    static final long MAX = 10000;

    static {
        for (long i = 1; i < MAX; i++) {
            PENTAG.add(i * (3 * i - 1) / 2);
        }
        PENTAGTREE.addAll(PENTAG);
    }

    @Override
    public void run() {
        for (int j = 0; j < PENTAG.size(); j++) {
            for(int k = j; k < PENTAG.size(); k++){
                if(sumPent(PENTAG.get(j), PENTAG.get(k)) && diffPent(PENTAG.get(j), PENTAG.get(k))){
                    System.out.println(PENTAG.get(j) + " and " + PENTAG.get(k) + 
                            ": D = " + Math.abs(PENTAG.get(j) - PENTAG.get(k)));
                    return;
                }
            }
        }        
    
    }
    boolean sumPent(long a, long b){
        if(PENTAGTREE.contains(a + b)) return true;
        return false;
    }
    
    boolean diffPent(long a, long b){
        if(PENTAGTREE.contains(Math.abs(a - b))) return true;
        return false;
    }

    public static void main(String[] args) {
        new P044_pentagDiff().run();
    }
}
