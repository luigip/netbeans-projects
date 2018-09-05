package projecteuler;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class P042_triangleWords implements Runnable {

    static final ArrayList<String> words = new ArrayList<String>();
    static final TreeSet<Integer> triNums = new TreeSet<Integer>();
    static int n = 1;

    static {
        triNums.add(1);
        try {
            Scanner sc = new Scanner(new File("P042_words.txt")).useDelimiter(",");
            while (sc.hasNext()) {
                String word = sc.next().replace("\"", "");
                words.add(word);
            }
        } catch (Exception e) {
            System.out.println("Error reading file");
        }
    }

    @Override
    public void run() {
        int triCount = 0;
        for (String w : words) {
            int wordValue = wordValue(w);
            if(triNums.last() < wordValue){
                addNumbers(wordValue);
            }
            if (triNums.contains(wordValue)) {
                triCount++;
                System.out.println("Triangle word: " + w + " Value = " + wordValue);
            }
        }
        System.out.println(triCount);
    }

    static private void addNumbers(int upto) {
        int tri = 0;
        while (tri < upto) {
            n++;
            tri = n * (n + 1) / 2;
            triNums.add(tri);
        }
    }

    static private int wordValue(String w) {
        int wv = 0;
        for (char c : w.toCharArray()) {
            wv += Character.getNumericValue(c) - 9;
        }
        return wv;
    }

    public static void main(String[] args) {
        new P042_triangleWords().run();
    }
}
