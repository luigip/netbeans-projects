package topcode.TCHS;

public class S19_250 {
    public double bestScore(int[] payout, int prob) {
        double max = 0;
        int n = payout.length;
        for (int i = 0; i < n; i++) {
            double score = 0;
            for (int j = n + i - 1; j <= n + i + 1; j++) {
                if(i + n != j && n > 1){
                    score += (1 - prob / 100.0) / 2 * payout[j % n];
                }
            }
            score += prob / 100.0 * payout[i];
            max = Math.max(max, score);
        }
        return max;
    }
    
    public static void main(String[] args) {
        S19_250 s = new S19_250();
        int[] a = {16,99,96,26,71,9,89,43,11,41,58,84,27,8,17,54,26,36,87}
;
        int prob = 66;
        System.out.println(s.bestScore(a, prob));
    }
}
