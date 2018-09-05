package scratch;

import java.util.ArrayList;
import java.util.List;

public class Abcd {

    public static void main(String[] args) {
        List<Abcd> a = test1("a");
        a = null;
        List<Abcd> b = test1("b");
         b = null;
        List<Abcd> c = test1("c");
        List<Abcd> d = test1("d");
    }

    static List<Abcd> test1(String id) {
        List<Abcd> lst = new ArrayList<Abcd>();
        try {
            for (int i = 0; i < 17000000; i++) {
                lst.add(new Abcd());
            }
        } catch (OutOfMemoryError e) {
            System.out.println(id + ": out of memory");
        } 
            System.out.println(id + ": created " + lst.size() + " abcs");
        return lst;
    }
}
