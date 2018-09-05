package projecteuler;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

public class P026_recurring implements Runnable{
    static final int MIN_MATCH_LENGTH = 8;
    static final int MAX_STRING_LENGTH = 5000;
    static final int MAX_PATTERN_LENGTH = 1020;


    @Override
    public void run(){
        int maxPatternLength = 0;
        int maxPatternNumber = 0;

        // For each interger up to the maximum, divide by d
        for(int d = 2; d < 1000; d++){
            // determine length of recurring cycle
            BigDecimal result = BigDecimal.ONE.divide(
                    new BigDecimal(d), MAX_STRING_LENGTH, RoundingMode.DOWN);
            String resString = result.toString();

            Searcher[] searchers = new Searcher[MAX_PATTERN_LENGTH + 1];
            for (int i = 1; i <= MAX_PATTERN_LENGTH; i++) {
                searchers[i] = new Searcher(i);
            }

            int patternLength = -1;

            // Iterate over digits of decimal
            SEARCH:
            for (int pos = 2; pos < MAX_STRING_LENGTH; pos++){
                char currentChar = resString.charAt(pos);
  
                for (Searcher s : searchers){
                    if (s == null) continue;
//                    System.out.println(resString.length());
                    if (resString.charAt(pos + s.length) == currentChar){
                        s.matches.add(true);
                        if (s.matches.size() >= MIN_MATCH_LENGTH){
                            s.recursionFound = true;
                            patternLength = s.length;
                            System.out.println("Pattern length for 1/" + d +
                                  " = " + patternLength);
                            break SEARCH;
                        }
                    }
                    else s.matches.clear();
                }

            }
            if (patternLength > maxPatternLength) {
                maxPatternNumber = d;
                maxPatternLength = patternLength;
                System.out.println("NEW MAX!!!");
            }
        }
        System.out.println("Max pattern length: " + maxPatternLength + " for 1/" + maxPatternNumber);
    }

    class Searcher{
        int length;
        LinkedList<Boolean> matches = new LinkedList<Boolean>();
        boolean recursionFound;
        
        public Searcher(int length) {
            this.length = length;
        }
        
        
    }



    public static void main(String[] args) {
        new P026_recurring().run();
    }
}
