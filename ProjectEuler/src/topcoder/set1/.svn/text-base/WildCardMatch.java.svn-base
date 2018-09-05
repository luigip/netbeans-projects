package topcoder.set1;

import java.util.Arrays;

public class WildCardMatch {

    int[][] cache;

    public int minimalChanges(String file, String pattern) {
        if (file.length() == 0) return pattern.length();
        if (pattern.length() == 0) return file.length();
        
        cache = new int[file.length() + 1][pattern.length() + 1];
        for(int[] a: cache) Arrays.fill(a, -1);
        return change(file, pattern, 0, 0);
    }

    private int change(String file, String pattern, int fOffset, int pOffset) {
        int cval;
        
        // We need to add pattern.length() characters.
        if (file.length() == 0) {
            return pattern.length();
        }

        // We need to remove file.length() characters.
        if (pattern.length() == 0) {
            return file.length();
        }
        cval = cache[fOffset + 1][pOffset + 1];
        int a = (cval != -1) ? cval : change(file.substring(1), pattern.substring(1), fOffset + 1, pOffset + 1);
        cache[fOffset + 1][pOffset + 1] = a;
        
        // If the first letters match, then the outcome is the same as the minimal
        // changes needed for the two strings without the initial characters.
        if (file.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '?') {
            return a;
        }
        cval = cache[fOffset + 1][pOffset];
        int b = (cval != -1) ? cval : change(file.substring(1), pattern, fOffset + 1, pOffset);
        cache[fOffset + 1][pOffset] = b;
        
        cval = cache[fOffset][pOffset + 1];
        int c = (cval != -1) ? cval : change(file, pattern.substring(1), fOffset, pOffset + 1);
        cache[fOffset][pOffset + 1] = c;

        // In all other cases, we need to see how many changes are needed to get
        // from the file name to the pattern with the file name minus one character;
        // with the pattern minus one character; or with both minus one character.

        int min = (a <= b) ? a : b;
        min = (min <= c) ? min : c;

        // We find the smallest of these three cases, and add 1 for the change of a
        // character we need for case a; or the removal of a character we need for
        // case b; or the addition of a character we need for case c.

        return min + 1;
    }

    public static void main(String... args) {
        WildCardMatch match = new WildCardMatch();
        System.out.println(match.minimalChanges("qelelhqhghglheqlghhghqeeggeqgegheeglgggleg", "qelelqghglheqlq?ghhhghql?egeqegheeglggglg?eg"));
    }
}