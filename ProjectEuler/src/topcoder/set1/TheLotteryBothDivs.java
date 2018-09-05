package topcoder;

public class TheLotteryBothDivs {
    public double find(String[] goodSuffixes){
        String [] gs = goodSuffixes.clone();
        for(int j = 0; j < goodSuffixes.length; j++){
            for(int i = 0; i < gs.length; i++){
                if(gs[i].length() > 0 && !(i == j) && gs[j].endsWith(gs[i])){
                    gs[j] = "";
                }
            }
        }
        int chances = 0;
        for(String s: gs){
            if(s.length() > 0)
              chances += Math.pow(10, 9 - s.length());
        }
        return chances / 1000000000d;
    }
    
    public static void main(String[] args) {
        TheLotteryBothDivs t = new TheLotteryBothDivs();
        String[] s = {"47", "58", "4747", "502"};
        System.out.println(t.find(s));
    }
}
