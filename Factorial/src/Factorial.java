
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;


public class Factorial {
    //long result;
    public static BigInteger getFactorial(int n){
        if(n == 0) return new BigInteger("1");
        return getFactorial(n - 1).multiply(BigInteger.valueOf(n));
    }

    public static void main(String[] args) {

        for (int i = 0; i <= 100; i++) {
            System.out.println("Factorial of " + i + " is " + getFactorial(i));
        }
    }

}
