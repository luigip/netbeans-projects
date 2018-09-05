package projecteuler;

public class P036_palindrome_binary implements Runnable {

    public void run() {
        int sum = 0;
        for (int i = 1; i < 1000000; i++) {
            if (isPalindrome(i, 2) && isPalindrome(i, 10)){
                sum += i;
//                System.out.println(i);
            }
        }
        System.out.println(sum);
    }

    static boolean isPalindrome(int r, int radix) {
        char[] num = Integer.toString(r,radix).toCharArray();
        for (int i = 0; i < num.length / 2; i++) {
            if (num[i] != num[num.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        new P036_palindrome_binary().run();
    }
    
}
