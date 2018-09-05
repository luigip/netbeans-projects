package topcoder.set1;

public class ExcitingGame {
    public int howMany(int nClassmates, int nTimes, int who){
        int count = 0;
        int pers = 0;
        for (int i = 0; i < nTimes; i++) {
            pers = i % nClassmates;
            if (pers == who && (i + 1) % 3 == 0){
                count++;
            }
        }
        return count;
    }
}
