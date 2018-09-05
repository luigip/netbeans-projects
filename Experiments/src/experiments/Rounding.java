package experiments;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class Rounding {
    public static void main(String[] args) {
        double n = 999999777777777777777888888888888888888888888888888888.1234d;
    BigDecimal m = new BigDecimal("235.97999999993036");
        double rounded = (long)(n * 100)/100d;
        BigDecimal rounded2 = m.setScale(2, RoundingMode.DOWN);
        double roundedNum = Math.floor(n * 100.0)/100.0;
        double roundedNum2 = Math.signum(n)*( Math.floor(Math.abs(n) * 100.0) / 100.0);
        System.out.println(rounded);
        System.out.println(rounded2);
        System.out.println(roundedNum);
        System.out.println(roundedNum2);

    }
}

