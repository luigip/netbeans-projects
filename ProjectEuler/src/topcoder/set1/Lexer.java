package topcoder.set1;

import java.util.Arrays;
import java.util.LinkedList;

public class Lexer {
    public String[] tokenize(String[] tokens, String input){
        LinkedList<String> ret = new LinkedList<String>();
        for (int i = 0; i < input.length(); i++) {
            int longest = 0;
            for(String t : tokens){
                if(t.length() > longest && i + t.length() <= input.length()){
                    if(input.substring(i, i + t.length()).equals(t)){
                        if(longest > 0){
                            ret.removeLast();
                        }
                        ret.add(t);
                        longest = t.length();
                    }
                }
            }
            i += Math.max(longest - 1 , 0);
        }
        String[] arr = ret.toArray(new String[]{});
        
        return arr;
    }
    
    
    public static void main(String[] args) {
        String[] tokens = {"wow","wo","w"};
        String[] tok =  new Lexer().tokenize(tokens, "awofwwofowwowowowwwooo");
        System.out.println(Arrays.asList(tok));
    }
}
