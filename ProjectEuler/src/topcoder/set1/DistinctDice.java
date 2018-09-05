package topcoder.set1;

import java.util.Arrays;

public class DistinctDice {
    public int getDistinct(String[] dice){
        boolean[] distinct = new boolean[dice.length];
        Arrays.fill(distinct, true);
        int distCount = 0;
        for (int i = 0; i < dice.length; i++) {
            if(!distinct[i]) continue;
            String d1 = dice[i];
            boolean same = false;
            for (int j = i + 1; j < dice.length; j++) {
                String d2 = dice[j];
                if(d2.charAt(0) == d1.charAt(0)) same = match(d1, d2);
                if(d2.charAt(1) == d1.charAt(0)) same = match(d1, rotateBack(rotateBack(d2)));
                if(d2.charAt(2) == d1.charAt(0)) same = match(d1, rotateLeft(d2));
                if(d2.charAt(3) == d1.charAt(0)) same = match(d1, rotateLeft(rotateLeft(rotateLeft(d2))));
                if(d2.charAt(4) == d1.charAt(0)) same = match(d1, rotateBack(rotateBack(rotateBack(d2))));
                if(d2.charAt(5) == d1.charAt(0)) same = match(d1, rotateBack(d2));
                
                if(same) distinct[j] = false;
            }
        }
        for(boolean b : distinct) if(b) distCount++;
        return distCount;
    }
    
    private String rotateLeft(String d){
        StringBuilder sb = new StringBuilder();
        sb.append(d.charAt(2)).append(d.charAt(3)).append(d.charAt(1)).append(d.charAt(0)).append(d.charAt(4)).append(d.charAt(5));
        return sb.toString();
    }
    
    private String rotateBack(String d){
        StringBuilder sb = new StringBuilder();
        sb.append(d.charAt(5)).append(d.charAt(4)).append(d.charAt(2)).append(d.charAt(3)).append(d.charAt(0)).append(d.charAt(1));
        return sb.toString();        
    }
    
    private String rotate(String d){
        StringBuilder sb = new StringBuilder();
        sb.append(d.charAt(0)).append(d.charAt(1)).append(d.charAt(4)).append(d.charAt(5)).append(d.charAt(3)).append(d.charAt(2));
        return sb.toString();         
    }
    
    private boolean match(String d1, String d2){
         return (d1.equals(d2) || d1.equals(rotate(d2)) || d1.equals(rotate(rotate(d2))) ||
                d1.equals(rotate(rotate(rotate(d2)))));
    }
    
    public static void main(String[] args) {
        String[] s = {"514623", "142635", "452316", "526134", "514326", "125346", "215463", "352461", "416523", "631245", "246513", "215364", "546123", "452163", "564321", "462153", "543261", "642531", "352164", "314652", "134562", "326541", "521346", "513264", "361542", "412365", "146253", "462315"};
        
        DistinctDice d = new DistinctDice();
        System.out.println(d.getDistinct(s));
    }
}
