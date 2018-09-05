package myutil;

import java.util.*;
import java.util.regex.*;

public class Split {
    
    // demo of recursive function to insert newlines with regex of form " x"
    static String get(String input, Pattern p, String output) {
        Matcher m = p.matcher(input);
        return m.find()
            ? get(input.substring(m.start() + 1), p, output + input.substring(0, m.start()) + "\n")
            : output + input;
    }

     /**
     * Splits a String according to a regex, keeping the splitter at the end of each substring
     * @param input The input String
     * @param regex The regular expression upon which to split the input
     * @param offset Shifts the split point by this number of characters to the left: should be equal or less than the splitter length
     * @return An array of Strings
     */
    public static String[] splitAndKeep(String input, String regex, int offset) {
        ArrayList<String> res = new ArrayList<String>();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        int pos = 0;
        while (m.find()) {
            res.add(input.substring(pos, m.end() - offset));
            pos = m.end() - offset;
        }
        if(pos < input.length()) res.add(input.substring(pos));
        return res.toArray(new String[res.size()]);
    }
    
    /**
     * Splits a String according to a regex, keeping the splitter at the end of each substring
     * @param input The input String
     * @param regex The regular expression upon which to split the input
     * @return An array of Strings
     */
    public static String[] splitAndKeep(String input, String regex) {
        return splitAndKeep(input, regex, 0);
    }
    
    
    public static void main(String[] args) {

        String d = "Los Angeles 9/31-33 Rose St 7 br h $350,000 J M&C Bunker Hill";

        StringBuilder r = new StringBuilder();
        for (String s : d.split(" ")) {
            char c;
            if (!s.isEmpty() && ((c = s.charAt(0)) == '$'|| (c >= '0' && c <= '9'))) {
                r.append("\n");
            }
            r.append(s).append(" ");
        }

        System.out.println(r.toString());
        System.out.println("or:");
        
        Pattern p = Pattern.compile(" [0-9$]");
        Matcher m = p.matcher(d);
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        while(m.find()){
            sb.append(d.substring(pos, m.start())).append("\n");
            pos = m.start() + 1;
        }
        sb.append(d.substring(pos));
        
        System.out.println(sb.toString());
        
        System.out.println("\nRecursive:");
        System.out.println(get(d, p, ""));
        
        System.out.println("\nSplit and keep:");
        
        for (String s: splitAndKeep(d, "Ro", 2)) System.out.println(s);
        System.out.println(Arrays.asList(splitAndKeep(";123;sfdsf3;","[;]",1)));
        
        String[] theSplitString = d.split(" (?=[0-9$])");  
        for (String s: theSplitString) System.out.println(s);
    }    
}