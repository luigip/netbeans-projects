package projecteuler;

/**
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * <p><b>Find the largest palindrome made from the product of two 3-digit numbers.</b>
 */
public class P004_palindrome implements Runnable {

    public void run() {
        for (int k = 0; k < 10; k++) {


            int highest = 0;
            for (int i = 100; i < 1000; i++) {
                for (int j = 100; j < 1000; j++) {
                    int r = i * j;
                    if (isPalindrome3(r) && r > highest) {
                        highest = r;
                    }
                }
            }
            System.out.println(highest);
        }
    }
    // Using this method takes 0.078713 s

    static boolean isPalindrome(int r) {
        char[] num = String.valueOf(r).toCharArray();
        for (int i = 0; i < num.length / 2; i++) {
            if (num[i] != num[num.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
    // This one takes 0.220848 s !!!

    static boolean isPalindrome2(int r) {
        String n1 = String.valueOf(r);
        String n2 = new StringBuffer(n1).reverse().toString();
        if (n1.equals(n2)) {
            return true;
        } else {
            return false;
        }
    }
    // Marginally the fastest

    static boolean isPalindrome3(int b) {
        int a = b;
        int r = 0;
        while (a >= 1) {
            r = r * 10 + a % 10;
            a = a / 10;
        }
        if (r == b) {
            return true;
        } else {
            return false;
        }
    }
}
