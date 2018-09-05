package topcoder.set1;

public class SwitchingBits {
    
    int[][] cache;
    
    public int minSwitches(String[] s){
        String str = "";
        for(String a : s) str += a;
        int c = getChanges(str);
        
        return (c + 1) / 2;
    }
    
   
    private int getChanges(String s){
        char f = s.charAt(0);
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != f){
                count++;
                f = s.charAt(i);
            }
        }
        return count;
    }

}
