package topcoder.set1;

import java.util.Arrays;
import java.util.HashMap;

public class CompositionTimeSignature {

    public String getTimeSignature(String duration) {
        HashMap<Character, Integer> dur = new HashMap<Character, Integer>();
        dur.put('W', 16);
        dur.put('H', 8);
        dur.put('Q', 4);
        dur.put('E', 2);
        dur.put('S', 1);

        int total16 = 0; // in sixteenth notes
        for (char c : duration.toCharArray()) {
            total16 += dur.get(c);
        }
        int sigs[] = new int[4];
        boolean[] valid = new boolean[4];
        sigs[0] = 6; //3/8
        sigs[1] = 8; // 2/4
        sigs[2] = 12; // 3/4
        sigs[3] = 16; //4/4

        for (int d = 0; d < 4; d++) {
            valid[d] = true;
            if (total16 % sigs[d] != 0) {
                valid[d] = false;
            }
        }
        int time = 0;
        int[] spanning = new int[4];

        for (int i = 0; i < 4; i++) {
            if (!valid[i]) {
                spanning[i] = Integer.MAX_VALUE;
                continue;
            }
            for (char c : duration.toCharArray()) {
                int startNextBar = ((time / sigs[i]) + 1) * sigs[i];
                int endThisNote = time += dur.get(c);
                if (startNextBar <  endThisNote){
                    spanning[i]++;
                }
            }
        }

        int[] span2 = new int[spanning.length];
        System.arraycopy(spanning, 0, span2, 0, spanning.length);
        Arrays.sort(span2);
        int least = span2[0];

        if (span2[0] == Integer.MAX_VALUE) {
            return "?/?";
        }

        if (spanning[0] == least) {
            return "3/8";
        } else if (spanning[1] == least) {
            return "2/4";
        } else if (spanning[2] == least) {
            return "3/4";
        } else if (spanning[3] == least) {
            return "4/4";
        }

        return "";
    }

    public static void main(String[] args) {
        CompositionTimeSignature c = new CompositionTimeSignature();
        System.out.println(c.getTimeSignature("S"));
    }
}
