package topcoder.set1;

import java.util.HashMap;
import java.util.LinkedList;

public class Nestings {

    public int howDeep(String nested) {
        HashMap<String, String> markers = new HashMap<String, String>();
        markers.put("<", ">");
        markers.put("(", ")");
        markers.put("[", "]");
        markers.put("{", "}");
        markers.put("/*", "*/");
        
        int maxlevel = 0;
        LinkedList<String> openMarkers = new LinkedList<String>();

        boolean valid = true;

        for (int i = 0; valid && i < nested.length(); i++) {
            String currStr = nested.substring(i, i + 1);
            char currChar = nested.charAt(i);
            // check for 2-character marker
            if (i + 1 < nested.length() && ((currStr.equals("/") && nested.substring(i + 1, i + 2).equals("*"))
                    || (currStr.equals("*") && nested.substring(i + 1, i + 2).equals("/")))) {
                currStr = nested.substring(i, i + 2);
                i++;
            }
            
            if (markers.containsKey(currStr)) {
                // found open marker
                openMarkers.add(currStr);
//                System.out.println("adding " + levelMarkers.getLast() + "\nlevel = " + levelMarkers.size());
                maxlevel = Math.max (maxlevel, openMarkers.size());
            } else if (markers.containsValue(currStr)) {
                // found close marker
                if(openMarkers.size() > 0 && currStr.equals(markers.get(openMarkers.getLast()))){
//                    System.out.println("removing " + levelMarkers.getLast());
                    openMarkers.removeLast();
                }
                else{
                    valid = false;
//                    System.out.println("close marker out of place: " + currStr);
                }
            } else if (Character.isLetter(currChar)) {
                continue;
            } else {
                valid = false;
//                System.out.println("invalid letter " + currChar);
            }
        }
        if(openMarkers.size() > 0){
            valid = false;
//            System.out.println("Failed due to unclosed markers: " + levelMarkers);
        }
        return valid ? maxlevel : -1;
    }

    public static void main(String[] args) {
        Nestings n = new Nestings();
        System.out.println(n.howDeep("]["));
    }
}
