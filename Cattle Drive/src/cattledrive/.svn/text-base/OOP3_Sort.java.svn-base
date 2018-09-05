package cattledrive;

import com.javaranch.common.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OOP3_Sort {

    private static final ArrayList<String> names = new ArrayList<String>();

    static {
        try {
            TextFileIn in = new TextFileIn("names.txt");
            boolean done = false;
            while (!done) {
                String s = in.readLine();
                if (s == null) {
                    done = true;
                } else {
                    if (!s.isEmpty()) names.add(s);
                }
            }
            in.close();
        } catch (Exception e) {
            System.out.println("Error reading input file");
        }
    }

    public static void main(String[] args) {
        Collections.sort(names);
        for (String n : names) {
            System.out.println(n);
        }
        System.out.println();
        Collections.sort(names, new SurnameCompare());
        for (String n : names) {
            System.out.println(n);
        }
    }
}

class SurnameCompare implements Comparator<String> {

    @Override
    public int compare(String one, String two) {
        String surname1 = one.split(" ")[1];
        String surname2 = two.split(" ")[1];
        return surname1.compareTo(surname2);
    }
}