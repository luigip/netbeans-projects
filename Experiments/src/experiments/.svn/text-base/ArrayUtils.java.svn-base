package experiments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.Timer;
public class ArrayUtils {

    public static void print(String[] arr) {
        System.out.println("array: " + Arrays.toString(arr) + " size: " + arr.length);
    }

    public static String[] reverse(String[] arr) {
        List<String> list = Arrays.asList(arr);
        Collections.reverse(list);
        return (String[]) list.toArray();
    }

    public static ArrayList<String> toArrayList(String[] arr) {
        return new ArrayList<String>( Arrays.asList(arr));
    }

    public static void main(String[] args) {
        String[] arr = {"one", "two", "three", "four", "five"};
        ArrayList<String> list = ArrayUtils.toArrayList(arr);
        System.out.println(list);
    }
}
