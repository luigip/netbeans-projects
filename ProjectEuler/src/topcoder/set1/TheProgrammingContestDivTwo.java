package topcoder;

import java.util.Arrays;

public class TheProgrammingContestDivTwo {
    public int[] find(int T, int[] requiredTime){
        int[] rt = requiredTime.clone();
        Arrays.sort(rt);
        int time = 0;
        int pen = 0;
        int i;
        for (i = 0; i < rt.length; i++) {
            if(time + rt[i] <= T) {
                time += rt[i];
                pen += time;
            }
            else break;
        }
        return new int[]{i, pen};
    }
}
