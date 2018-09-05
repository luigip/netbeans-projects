package topcode.TCHS;

public class S18_500 {

    public int getPoints(int[] x, int[] y) {
        int n = x.length;
        int maxpoints = 0;
        for (int i = 0; i < n; i++) {
            int points = 0;
            if (x[i] == 0 && y[i] == 0) {
                for (int j = 0; j < n; j++) {
                    if (x[j] == 0 && y[j] == 0) {
                        points++;
                    }
                }
            } else {
                double idir = Math.atan2((double) y[i], (double) x[i]);
                for (int j = 0; j < n; j++) {
                    if (x[j] == 0 && y[j] == 0) {
                        points++;
                        continue;
                    }
                    double jdir = Math.atan2((double) y[j], (double) x[j]);
                    if (Math.abs(jdir - idir ) < 0.00000000000001) {
                        points++;
                    }
                }
            }
            maxpoints = Math.max(maxpoints, points);
        }
        return maxpoints;
    }

    public static void main(String[] args) {
        S18_500 s = new S18_500();
        int[] a = {999999, 999998};
        int[] b = {1000000, 999999};
        System.out.println(s.getPoints(a, b));
    }
}
