package topcoder.set2;

import java.util.Arrays;

public class ScrabFortune {
/*
     * This solution doesn't quite work since we need to return the alphabetically-first 
     * solution with fewest moves, even if that doesn't remove the most letters
     */
    public String getMin(String pool, String[] board, int threshold) {
        int[] bccount = new int[26];
        boolean[] pcs = new boolean[26];
        for (String s : board) {
            for (char c : s.toCharArray()) {
                bccount[c - 'a']++;
            }
        }
        for(char c : pool.toCharArray()) pcs[c - 'a'] = true;
        String letters = "";
        int maxind = 0;
        int numLeft = count(bccount);

        while (maxind >= 0 && numLeft > threshold) {
            int max = 0;
            maxind = -1;
            for (int j = 0; j < 26; j++) {
                if (bccount[j] > max && pcs[j]) {
                    maxind = j;
                    max = bccount[j];
                }
            }
            if(maxind >=0){
                numLeft -= max;
                bccount[maxind] = 0;
                letters += ((char) ('a' + maxind));
            }
        }
        if (numLeft > threshold) {
            return "IMPOSSIBLE";
        }
        char[] lsort = letters.toCharArray();
        Arrays.sort(lsort);
        String ret = "";
        for(char c : lsort) ret += c;
        return ret;
    }

    private static int count(int[] a) {
        int c = 0;
        for (int n : a) {
            c += n;
        }
        return c;
    }

    public static void main(String[] args) {
        ScrabFortune s = new ScrabFortune();
        String pool = "fpsctyba";
        String[] board = {"scrab",
            "fortune",
            "is",
            "fun"};
        int threshold = 10;
        System.out.println(s.getMin(pool, board, threshold));
    }
}
