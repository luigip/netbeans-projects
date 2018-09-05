package topcoder.set1;

public class DigitalDisplay {
    public int waysToInterpret(String display){
        String[] s = display.split(":");
        int notHr = 0;
        for(String k: s){
            int j = Integer.parseInt(k);
            if(j == 0 || j > 12) notHr ++;
            if(j < 0 || j > 59) return 0;
        }
        
        return  notHr == 0 ? 6 :
                notHr == 1 ? 4 :
                notHr == 2 ? 2 : 
                             0;
    }
    
    public static void main(String[] args) {
        new DigitalDisplay().waysToInterpret("21:23:01");
    }
}
