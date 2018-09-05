package topcoder.set1;

public class SpeedRadar {
    public double averageSpeed(int minLimit, int maxLimit, int[] readings){
        int total = 0;
        boolean faulty = false;
        int numSpeeding = 0;
        for (int i : readings) {
            
            if(i > maxLimit || i < minLimit){
                numSpeeding++;
            }
            else{total += i;}
        }
        double ave = (double)total / (readings.length - numSpeeding);
        if((double)numSpeeding / readings.length > 0.1) faulty = true;
        
        return faulty ? 0.0 : ave;
    }
            
}
