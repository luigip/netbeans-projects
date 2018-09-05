package projecteuler;

public class P034_curious implements Runnable {

    static int MAX = 10000000;

    @Override
    public void run() {
        int total = 0;
        for (int i = 10; i < MAX; i++) {
            int sum = 0;
            for (char c : String.valueOf(i).toCharArray()) {
                long fact = P020_factorial.factorial(Character.getNumericValue(c));
                sum += fact;
            }
            if (sum == i) {
                System.out.println("Curious: " + i);
                total += i;
            }
        }
        System.out.println(total);
    }

    public static void main(String[] args) {
        new P034_curious().run();
    }
}
