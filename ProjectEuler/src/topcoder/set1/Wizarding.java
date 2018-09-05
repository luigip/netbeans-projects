package topcoder.set1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Wizarding {
    // kind of gave up on this one... got a bit complicated
    public String counterspell(String spell, String rules) {
        char[] sp = spell.toCharArray();
        char[] ru = rules.toCharArray();
        HashSet<Integer> powerset = new HashSet<Integer>(77077);
        powerset.add(1);
        HashMap<Integer, char[]> powermap = new HashMap<Integer, char[]>();
        powermap.put(1, new char[0]);
        for (int j = 0; j < sp.length; j++) {
            System.out.println("***  j = " + j);
            HashSet<Integer> newvals = new HashSet<Integer>();
            for (int n : powerset) {
                char[] c = powermap.get(n);
                // keep same
                int m = n * (sp[j] - 'A' + 1) % 77077;
                boolean swapOld = false;
                if (powermap.containsKey(m)
                        && (powermap.get(m).length > c.length + 1
                        || powermap.get(m).length == c.length + 1
                        && arrToString(powermap.get(m)).compareTo(arrToString(c) + sp[j]) > 0)) {
                    swapOld = true;
                    System.out.println("swapping old: " + m + " " + arrToString(powermap.get(m))
                            + " for " + arrToString(c) + sp[j]);
                }

                if (!powerset.contains(m) || swapOld) {

                    char[] chars = new char[c.length + 1];
                    System.arraycopy(c, 0, chars, 0, c.length);
                    chars[chars.length - 1] = sp[j];
                    if (swapOld) {
                        powermap.remove(m);
                    } else {
                        newvals.add(m);
                    }
                    powermap.put(m, chars);
                }
                // change
                char switchedChar = ru[sp[j] - 'A'];
                if (switchedChar - 'A' >= 0 && switchedChar - 'A' < 26) {
                    int p = n * (switchedChar - 'A' + 1) % 77077;
                    swapOld = false;
                    if (powermap.containsKey(p)
                            && (powermap.get(p).length > c.length + 1
                            || powermap.get(p).length == c.length + 1
                            && arrToString(powermap.get(m)).compareTo(arrToString(c) + switchedChar) > 0)) {
                        swapOld = true;
                    }
                    if (!powerset.contains(p) || swapOld) {
                        char[] chars = new char[c.length + 1];
                        System.arraycopy(c, 0, chars, 0, c.length);
                        chars[chars.length - 1] = switchedChar;
                        if (swapOld) {
                            powermap.remove(p);
                        }
                        else {
                            newvals.add(p);
                        }
                        powermap.put(p, chars);
                    }
                }
                // omit
                // do nothing
            }
            powerset.addAll(newvals);
        }
        TreeSet<Integer> tree = new TreeSet<Integer>(powerset);
        int max = tree.last();
        String result = arrToString(powermap.get(max));
        
        //Ensure result not all blanks
        if(powermap.get(max).length == 0){
            result = String.valueOf(sp[sp.length - 1]);
        }
        return result;
    }

    static String arrToString(char[] c) {
        StringBuilder sb = new StringBuilder();
        for (char ch : c) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Wizarding w = new Wizarding();

//        String s = new Wizarding().counterspell("ABCDEABCDEABC", "ACBDESKADSLOEDDDASDBADEDAE");
//        String s = new Wizarding().counterspell("ABCDE", "ZYXXYXZZXYXXZZXZYYXZZZX---");
//        String s = new Wizarding().counterspell("A", "AD-FKNJKAXCKJFGTOJ-AFDASD-");
        String s = new Wizarding().counterspell("ABCDEFGHIJKLM", "ZZZZZZZZZZZZZZZZZZZZZZZZZZ");
        System.out.println(s);

//        System.out.println(w.getPower("CCDECCECC"));
//        System.out.println(w.getPower("CCCCDEECC"));
    }
    
    static int getPower(String s){
        int total = 1;
        for(char c : s.toCharArray()){
            total *= (c - 'A' + 1) % 77077;
        }
        return  total;
    }
}
