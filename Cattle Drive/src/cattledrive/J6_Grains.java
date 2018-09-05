package cattledrive;


import java.math.BigInteger;

//package cattle.drive;
public class J6_Grains {

    public static void main(String[] args) {
        BigInteger b = BigInteger.ONE;
        for (int i = 1; i <= 64; i++) {
            System.out.println("square " + i + ":  " + b.toString() + " grains");
            b = b.multiply(new BigInteger("2"));
        }
    }
}
