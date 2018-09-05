package topcoder.set1;

import java.util.HashMap;

public class DessertMaker {

    public int countBananaSplits(String[] ingredients) {
        int banana = 0, ice = 0;
        HashMap<String, Integer> others = new HashMap<String, Integer>();
        for (String s : ingredients) {
            if (s.equals("banana")) {
                banana++;
            } else if (s.equals("ice cream")) {
                ice++;
            } else {
                if (others.containsKey(s)) {
                    others.put(s, others.get(s) + 1);
                } else {
                    others.put(s, 1);
                }
            }
        }
        int c = 1;
        for (String s : others.keySet()) {
                c *= others.get(s) + 1;
        }
        return banana * ice * (c - 1);
    }

    public static void main(String[] args) {
        String[] s = {"foam", "apple", "whipped cream", "apple", "mushroom", 
"apple core", "ice cream", "ice cream", "banana", "giraffe", 
"mushroom", "spare tire", "ice cream", "banana", "foam", 
"wrench", "paper", "cherry", "alarm clock", "football" ,"apple", 
"apple"};
        DessertMaker d = new DessertMaker();
        System.out.println(d.countBananaSplits(s));
    }
}
