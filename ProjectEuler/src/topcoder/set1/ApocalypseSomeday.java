package topcoder.set1;

public class ApocalypseSomeday {
    public int getNth(int n){
        int c = 0;
        int i = 665;
        while (c < n){
            i++;
            if(isBeastly(i)) c++;
        }
        return i;
    }
    
    boolean isBeastly(int n){
        while(n >= 666){
            if(n % 1000 == 666) return true;
            n = n / 10;
        }
        return false;
    }
}
