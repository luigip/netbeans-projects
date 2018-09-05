package projecteuler;

import java.util.ArrayList;
import java.util.TreeSet;

public class P045_hexagonalNums implements Runnable {
    static final ArrayList<Long> TRIANG = new ArrayList<Long>();
    static final TreeSet<Long> PENTAG = new TreeSet<Long>();
    static final TreeSet<Long> HEXAG = new TreeSet<Long>();
    static final int MAX = 1000000;
    static{
        for(long i = 0; i < MAX; i++){
            TRIANG.add(i * (i + 1) / 2);
            PENTAG.add(i * (3 * i - 1) / 2);
            HEXAG.add(i * (2 * i -1));
        }
    }
    
    @Override
    public void run() {
        for(int n = 284; n < MAX; n++){
            Long tri = TRIANG.get(n);
            if(PENTAG.contains(tri) && HEXAG.contains(tri)){
                System.out.println("Tri = " + tri);
            }
        }
    }
    
       
    
    public static void main(String[] args) {
        new P045_hexagonalNums().run();
    }
}
