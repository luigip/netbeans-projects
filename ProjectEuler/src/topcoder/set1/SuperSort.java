package topcoder.set1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SuperSort {

    public String wordSort(String sentence) {
        Pattern letters = Pattern.compile("[A-Za-z]+");
        Pattern punc = Pattern.compile("[^A-Za-z]+");

        Matcher lettMatcher = letters.matcher(sentence);
        Matcher puncMatcher = punc.matcher(sentence);

        ArrayList<String> letList = new ArrayList<String>();
        ArrayList<String> puncList = new ArrayList<String>();
        ArrayList<Integer> puncLocs = new ArrayList<Integer>();

        while (lettMatcher.find()) {
            letList.add(sentence.substring(lettMatcher.start(), lettMatcher.end()));
        }
        while (puncMatcher.find()) {
            puncLocs.add(puncMatcher.start());
            puncList.add(sentence.substring(puncMatcher.start(), puncMatcher.end()));
        }
        Collections.sort(letList);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(letList.size(), puncList.size()); i++) {
            if (puncLocs.size() > 0 && puncLocs.get(0).equals(0)) {
                sb.append(puncList.get(i));
                if (!(i >= letList.size())) {
                    sb.append(letList.get(i));
                }
            } else {
                if (letList.size() > 0) {
                    sb.append(letList.get(i));
                }
                if (!(i >= puncList.size())) {
                    sb.append(puncList.get(i));
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        SuperSort s = new SuperSort();
        System.out.println(s.wordSort("abcd"));
    }
}
