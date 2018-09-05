package topcoder.set1;

import static java.lang.Math.*;

public class TVSize {

    public int[] calcSize(int diagonal, int height, int width) {

        double H =  sqrt(pow(diagonal, 2) / (1 + pow((double) width / height, 2))) + 0.0000000001;
        double W =  sqrt(pow(diagonal, 2) / (1 + pow((double) height / width, 2))) + 0.0000000001;

        int[] ret = {(int)H, (int)W};
        return ret;
    }
    
    
    public static void main(String[] args) {
        int[] r = new TVSize().calcSize(679, 65, 72);
        for(int i : r) System.out.println(i);
    }
}
