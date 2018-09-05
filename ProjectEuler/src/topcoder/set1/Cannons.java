package topcoder.set1;

public class Cannons {

    public String getDirections(int[] x, int[] y) {
        int len = x.length;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {

            boolean added = false;
            boolean blocker = false;
            for (int j = 0; !blocker && j < len; j++) {
                if (x[j] == x[i] && y[j] < y[i]) {
                    blocker = true;
                }
            }
            if (!blocker) {
                sb.append('D');
                added = true;
            }
            blocker = false;
            for (int j = 0; !blocker && !added && j < len; j++) {
                if (x[j] < x[i] && y[j] == y[i]) {
                    blocker = true;
                }
            }
            if (!blocker && !added) {
                sb.append('L');
                added = true;
            }
            blocker = false;
            for (int j = 0; !blocker && !added && j < len; j++) {
                if (x[j] > x[i] && y[j] == y[i]) {
                    blocker = true;
                }
            }
            if (!blocker && !added) {
                sb.append('R');
                added = true;
            }
            blocker = false;
            for (int j = 0; !blocker && !added && j < len; j++) {
                if (x[j] == x[i] && y[j] > y[i]) {
                    blocker = true;
                }
            }
            if (!blocker && !added) {
                sb.append('U');
                added = true;
            }
            if (!added) {
                return "";
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Cannons c = new Cannons();
        int[] a = {1, 2, 2, 4};
        int[] b = {2, 1, 3, 2};
        System.out.println(c.getDirections(a, b));
    }
}
