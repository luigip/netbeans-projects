package projecteuler;

public class P005_Java {

    public static void main(String[] args) {
        long t = System.nanoTime();
        new P005_Java().find();
        System.out.println(System.nanoTime() - t);
    }

     boolean isDivis(int x) {
        int i = 1;
        while (i <= 20) {
            if (x % i != 0) return false;
            i += 1;
        }
        return true;
    }
     void find() {
        int i = 2;
        boolean found = false;
        while (!found) {
            if (!isDivis(i)) {
                i += 2;
            } else {
                found = true;
                System.out.println(i);
            }
        }
    }
}
