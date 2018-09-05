package experiments;

public class TestLog {

    public static void main(String[] args) {
        for (int i = 10, j = 2; i < Integer.MAX_VALUE / 10; i *= 10, j++) {
            System.out.println("i - 1 = " + (i - 1) + " has " + (j - 1) + " digits");
            System.out.println("(int)(log10(i - 1) + 1) = " + (((int)(Math.log10(i - 1))) + 1));
            System.out.println("i = " + i + " has " + j + " digits");
            System.out.println("(int)(log10(i) + 1) = " + (((int)(Math.log10(i))) + 1));
            System.out.println();
        }
    }
}
