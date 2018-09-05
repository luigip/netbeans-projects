
package projecteuler;
/**
 *
 * @author Rhys
 */


public class P006_natural {
    public static void main(String[] args) {
        int a = 0, b = 0;
        for (int i = 1; i <= 100; i++) {
            a += Math.pow(i, 2);
            b += i;
        }
        System.out.printf("%,.0f%n", Math.pow(b, 2) - a);

    }

}
