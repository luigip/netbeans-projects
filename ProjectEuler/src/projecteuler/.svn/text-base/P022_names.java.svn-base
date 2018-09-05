package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//sort names into alphabetical order
//work out alphabetical value
//mulitiply value by position in list
//sum scores

public class P022_names implements Runnable{

    // don't really need HashMap since char can be cast to int
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    {
        char[] chars = ("ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
        for (int i = 0; i < 26; i++) {
            map.put(chars[i], i);
        }
    }

    @Override
    public void run(){
        String input = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader("P022_names.txt"));
            input = br.readLine();
            br.close();
        } catch (Exception e) {System.out.println("ERROR");
        }
        // could just do it as an array and use Arrays.sort()
        // also, it's easier just to replaceAll the the ""s before splitting
        List<String> names = Arrays.asList(input.split(","));
        for (int i = 0; i < names.size(); i++) {
            String n = names.get(i);
            n = n.replace("\"", "");
            names.set(i, n);
        }
        Collections.sort(names);

        int totalScore = 0;
        for (int i = 0; i < names.size(); i++) {
            int value = 0;
            for (char c : names.get(i).toCharArray()) {
                value += map.get(c) + 1;
            }
            totalScore += value * (i + 1);
        }
        System.out.println("total score " + totalScore);


    }

    public static void main(String[] args) {
        new P022_names().run();
    }
}
