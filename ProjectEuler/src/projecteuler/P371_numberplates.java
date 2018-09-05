package projecteuler;

public class P371_numberplates implements Runnable {

    public void run() {
        
        double plast = 0;
        double pn = 0;
        double exp = 0;
        double sumprob = 0;
        int i = 0;
        for (i = 2; i <= 1000; i++) {
            pn = (i - 1) /1000.0 * (1 - sumprob);
            System.out.println(i + " " + pn);
            exp += i * pn;
            sumprob += pn;
            plast = pn;
        }
        
        System.out.println(exp);
        System.out.println(pn);
        System.out.println(plast);
        System.out.println(sumprob);
        System.out.println(pn - plast);
        System.out.println(i);
        
        
        
    }
    
    public static void main(String[] args) {
        new P371_numberplates().run();
    }
}
