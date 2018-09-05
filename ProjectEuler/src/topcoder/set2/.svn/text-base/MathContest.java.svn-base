package topcoder.set2;

public class MathContest {
    public int countBlack(String ballSequence, int repetitions){
        int blackCount = 0;
        int blen = ballSequence.length();
        final int len = blen * repetitions;
        boolean[] seq = new boolean[len];
        char[] bs = ballSequence.toCharArray();
        for (int i = 0; i < repetitions; i++) {
            for(int j = 0; j < bs.length; j++){
                seq[i * blen + j] = (bs[j] == 'W');
            }
        }
        int hi = len - 1;
        int lo = 0;
        boolean whiteIsTrue = true;
        boolean reversed = false;
        while (hi >= lo) {
            boolean ball;
            if(reversed){
                ball = seq[hi];
                hi--;
            }else{
                ball = seq[lo];
                lo++;
            }
            if(ball ^ whiteIsTrue){
                blackCount++;
                whiteIsTrue = !whiteIsTrue;
            }else{
                reversed = !reversed;
            }
        }
        return blackCount;
    }
    
    public static void main(String[] args) {
        MathContest m = new MathContest();
        String b = "WBWWWBWWBBBBWBWWWBWBWWWWWBWWWWBBWWBW";
//        String b = "BW";
        int reps = 1387;
//        int reps = 10;
        System.out.println(m.countBlack(b, reps));
    }
}
