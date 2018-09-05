package topcoder.set1;

public class FussySleeper {

    public int[] nextTime(int[] currentTime, int elephants) {
        int hrs = currentTime[0], mins = currentTime[1];
        do {
            mins++;
            if (mins >= 60) {
                hrs++;
                if (hrs >= 24) {
                    hrs %= 24;
                }
            }
            mins %= 60;
            } while((hrs * 100 + mins) % elephants != 0);
        return new int[]{hrs, mins};
    }
}
