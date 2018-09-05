package topcode.TCHS;

import java.util.Arrays;
import static java.lang.Math.*;

public class S21_500 {

    public double[] find(double S, double[] translate, double R) {
        double T0 = translate[0], T1 = translate[1];

        double x = (-T0 * cos(R) + T1 * sin(R) - (S * sin(R) / (S * cos(R) - 1)) 
                * (T0 * sin(R) + T1 * cos(R)))
                / ((S * cos(R) - 1) + pow((S * sin(R)), 2) / (S * cos(R) - 1));
        double y = (T0 * sin(R) + T1 * cos(R) + (S * sin(R)) * x)
                / (1 - S * cos(R));
        return new double[]{x, y};
    }

//    public static void main(String[] args) {
//        S21_500 s = new S21_500();
//        double[] tr = {1, 0};
//        double[] ans = s.find(0.5, tr, 1.5707963267948966);
//        System.out.println(Arrays.toString(ans));
//    }
}
