package projecteuler;

public class P112_Bouncy implements Runnable {

    @Override
    public void run() {
        int i = 100;
        int numTrue = 0;
        while((double)numTrue / i < 0.99){
            i++;
            if(isBouncy(i)) numTrue++;
        }
        System.out.println(i);
    }
    
    static boolean isBouncy(int i){
        if(i < 100) return false;
        
        int dir = 0;
        int lastDig;
        boolean isBouncy = false;
        while(!isBouncy && i >= 10){
            lastDig = i % 10;
            i /= 10;
            if      (i % 10 > lastDig && dir != -1)  dir = 1;
            else if (i % 10 < lastDig && dir != 1)   dir = -1;
            else if (i % 10 != lastDig )             isBouncy = true;
        }
        return isBouncy;
    }
    
    public static void main(String[] args) {
        new P112_Bouncy().run();
    }
}
