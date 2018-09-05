/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SDTest;

import java.util.Comparator;
import java.util.Arrays;
/**
 *
 * @author Rhys
 */
public class tryout {
    public static void main(String[] args){
        String a = "abc";
        String b = "defg";
        String c = "aijkl";
        String[] lst = {a,b,c};
        Arrays.sort(lst, StringLengthComparator.INSTANCE);
        for (int i = 0; i < 3; i++) {
        System.out.println(lst[i]);
        }
        assert 1 == 2;
    }
}

class StringLengthComparator implements Comparator<String>{
    private StringLengthComparator(){}
    public static final StringLengthComparator INSTANCE =
            new StringLengthComparator();
    public int compare(String s1, String s2){
        return s1.length() - s2.length();
    }
}