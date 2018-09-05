//package cattledrive;

import java.util.Arrays;
import java.util.HashMap;

public class OOP2_nlm {
    private static final HashMap<String, Integer> map = new HashMap<String, Integer>();
    static final String[] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static final String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", 
                            "sixteen", "seventeen", "eighteen", "nineteen"};
    static final String[] ties = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    static{
        for(int i = 0; i <10; i++){
            map.put(ones[i], i);
            map.put(teens[i], i + 10);
            if (i >= 2) map.put(ties[i], i * 10);
        }
    }
    
    public static void main(String[] args) {
        if (args.length != 2){
            System.out.println("Usage: OOP2_nlm number1 number2");
            System.exit(0);
        }
        try {
            int a = toInt(args[0]);
            int b = toInt(args[1]);
            System.out.println(a * b);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static int toInt(String s) throws Exception{
        int value;
        if (map.containsKey(s)) {
            value = map.get(s);
        } else {
            String[] words = s.split("-");
            if (words.length != 2 
                    || !map.containsKey(words[0]) || !map.containsKey(words[1]) 
                    || !Arrays.asList(ties).contains(words[0]) ) 
                throw new Exception("Number \"" + s + "\" not recognized");
            value = map.get(words[0]) + map.get(words[1]);
        }
        return value;
    }
}