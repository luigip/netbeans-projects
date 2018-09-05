package topcoder.set1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HowEasy {

    public static int pointVal(String problemStatement) {
        Pattern p1 = Pattern.compile("\\s[A-Za-z]+\\.?\\s");
        Pattern p2 = Pattern.compile("\\A[A-Za-z]+\\.?\\s");
        Pattern p3 = Pattern.compile("\\A[A-Za-z]+\\.?\\Z");
        Pattern p4 = Pattern.compile("\\s[A-Za-z]+\\.?\\Z");
        Matcher m1 = p1.matcher(problemStatement);
        Matcher m2 = p2.matcher(problemStatement);
        Matcher m3 = p3.matcher(problemStatement);
        Matcher m4 = p4.matcher(problemStatement);

        Matcher[] matchers = {m1, m2, m3, m4};
        int count = 0;
        int chars = 0;
        for (Matcher m : matchers) {
            while (m.find()) {
                int start = m.start();
                int end = m.end();
                String word = problemStatement.subSequence(start, end).toString().trim();
                if(word.charAt(word.length() - 1) == '.'){
                    word = word.substring(0, word.length() - 1);
                }
                chars += word.length();
                count++;
            }
        }
        int avlen;
        if (count == 0) {
            avlen = 0;
        } else {
            avlen = chars / count;
        }
        int points;
        if (avlen <= 3) {
            points = 250;
        } else if (avlen == 4 || avlen == 5) {
            points = 500;
        } else {
            points = 1000;
        }
        return points;
    }

    public static void main(String[] args) {
//        System.out.println(pointVal("hi. hello. y.o you2. uou32s"));
        System.out.println(pointVal("aaa."));
    }
}
