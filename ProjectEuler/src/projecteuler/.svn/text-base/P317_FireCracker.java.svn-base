package projecteuler;

public class P317_FireCracker {
    final double v = 20;    // initial velocity of particles
    final double g = -9.81; // gravitational acceleration
    final double h = 100;   // height of explosion
    static final double PI = Math.PI;

    /*
     * I have no idea why this works and brings back the right answer. It shouldn't.
     * Need to take another look at this and work out what is going on!
     * 
     * I use a very convoluted method involving cutting the trajectory up into a number of steps and
     * iterations - but for some reason it brings back the right answer with just 1 step...
     */
    public P317_FireCracker(){
    }

    public static void main(String[] args) {
        P317_FireCracker p = new P317_FireCracker();
        p.go();
    }

    public void go(){
        // Trials are number of steps, number of arcs
        int[][] trials = {
//            {10, 10, 3},
//            {100, 10, 10},
            {1, 10, 8},
//            {10000, 10, 10},
//            {10000, 100, 10},
//            {10000, 10, 100},
//            {10000, 100, 100},
//            {30000, 1000},
//            {30000, 3000}
                            };
        for(int[] trial : trials){
            double volume = calculateVolume(trial[0], trial[1], trial[2]);
            System.out.printf("Total volume (%,d steps, %,d arcs, %,d iterations): %,5f %n",
                                    trial[0], trial[1], trial[2], volume);
        }
        
    }

    public double calculateVolume(int numSteps, int numArcs, int numIterations){

        double yMax = Math.pow(v, 2) / (-2 * g);
        double yStepSize = (yMax + 100) / numSteps;

        double[] maxX = new double[numSteps + 1];
        double totalVolume = 0;

        // Test for maximum range, x, at vertical steps y
        for (int yStepNum = 0; yStepNum <= numSteps; yStepNum++){
            double y = yStepNum * (yMax + 100) / numSteps - 100;

            double rangeHi = PI / 2;
            double rangeLo = -PI/2;

            // Try different angles, narrowing in on best by iterations
            for (int iter = 1; iter <= numIterations; iter++){
                double bestTheta = -1;
                double bestXthisIter = -1;
                double arcStepSize = (rangeHi - rangeLo) / numArcs;

                // Try different angles within range
                for (int arcStepNum = 0; arcStepNum <= numArcs; arcStepNum++){
                    double theta = rangeLo + arcStepSize * arcStepNum;

                    double x = getMaxX(theta, y);

                    if (x > bestXthisIter){
                        bestTheta = theta;
                        bestXthisIter = x;
                    }

                    if (x > maxX[yStepNum]){
                        //new maximum x for this y found
                        maxX[yStepNum] = x;
                    }
                }
                // if no valid angles found for this
                if (bestTheta == -1){
                    System.out.println("Break at iter = " + iter + "\nrangeLo = " + rangeLo + " rangeHi = " + rangeLo);
                    break;
                } // might want to improve this
                rangeLo = bestTheta - arcStepSize;
                rangeHi = bestTheta + arcStepSize;
            }

            if (yStepNum != 0){
                // Volume of disc at height y = thickness * average area of circles top and bottom of slice
                double sliceVolume = yStepSize *
                                        PI * (Math.pow(maxX[yStepNum], 2) + Math.pow(maxX[yStepNum - 1], 2)) / 2;
                System.out.println("Slice " + yStepNum + "Vol = " + sliceVolume);
                totalVolume += sliceVolume;
            }
        }
        return totalVolume;
    }

    public double getMaxX(double theta, double y){

       double maxX = v * Math.cos(theta)
                        * (-v * Math.sin(theta) / g
                            + Math.sqrt(2 * y / g + Math.pow(v * Math.sin(theta) / g, 2))
                          );
       return maxX;
    }


}
