package projecteuler;

import java.util.ArrayList;

public class P046_Goldbach implements Runnable {
    static final int MAX = 10000;
    @Override
    public void run() {
        boolean[] primes = Common.getPrimesSieveV3(MAX);
        ArrayList<Integer> primesList = Common.getPrimesListSieveV3(MAX);
        for (int i = 9; i < MAX; i += 2) {
            if(!primes[i]){
                boolean confirmed = false;
                for (int j = 0; j < primesList.size(); j++) {
                    int p = primesList.get(j);
                    if(p >= i) break;
                    if(isSquare((i - p) / 2d)){
                        confirmed = true;
                        break;
                    }
                }
                if(confirmed == false){
                    System.out.println("Odd composite: " + i);
                    return;
                }
            }
        }
        
        
    }
    
    static boolean isSquare(double n){
        if(Math.sqrt(n) % 1 == 0){
            return true;
        }
        else return false;
    }
    
    public static void main(String[] args) {
        new P046_Goldbach().run();
    }
}
