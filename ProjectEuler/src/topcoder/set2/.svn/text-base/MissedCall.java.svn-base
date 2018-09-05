package topcoder.set2;

public class MissedCall {

    public int waitingTime(int N, int songDuration, int delay) {
        int t = 0;
        for (int i = 0; i < N; i++) {
            t += songDuration;
            for (int j = 0; j < 5; j++) {
                if (t % delay == 0) return t;
                t++;
            }
        }
        while (true) {
            if (t % delay == 0) return t;
            t++;
        }
    }
}
