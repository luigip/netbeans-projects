package topcoder.set1;

import java.util.ArrayList;

public class KidsWordGame {

    public int getCheater(String[] first, String[] second, String[] third) {
        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            if (i < first.length) {
                words.add(first[i]);
            } else {
                break;
            }
            if (i < second.length) {
                words.add(second[i]);
            } else {
                break;
            }
            if (i < third.length) {
                words.add(third[i]);
            } else {
                break;
            }
        }

        int n = 0;
        boolean valid = true;
        while (n < (words.size() - 1)) {

            if (isValid(words.get(n), words.get(n + 1))) {
                n++;
            } else {
                int cheat = n % 3 + 1;
                return cheat;
            }
        }
        return -1;
    }

    boolean isValid(String a, String b) {
        if (a.length() == 0) {
            return b.length() == 1;
        }
        if (b.length() == 0) return false;
        if (b.substring(1).equals(a) || b.substring(0, b.length() - 1).equals(a)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] a = {""};
        String[] b = {""};
        String[] c = {""};
        KidsWordGame k = new KidsWordGame();
        System.out.println(k.getCheater(a, b, c));
    }
}
