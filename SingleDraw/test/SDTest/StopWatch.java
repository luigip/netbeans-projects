package SDTest;
public class StopWatch {
    //used for performance testing only!

    private long startTime = 0;
    private long stopTime = 0;
    private boolean running = false;


    public void start() {
        this.startTime = System.currentTimeMillis();
        this.running = true;
    }


    public void stop() {
        this.stopTime = System.currentTimeMillis();
        this.running = false;
    }


    //elaspsed time in milliseconds
    public long getElapsedTime() {
        long elapsed;
        if (running) {
             elapsed = (System.currentTimeMillis() - startTime);
        }
        else {
            elapsed = (stopTime - startTime);
        }
        return elapsed;
    }


    //elaspsed time in seconds
    public float getElapsedTimeSecs() {
        float elapsed;
        if (running) {
            elapsed = ((System.currentTimeMillis() - startTime) / 1000f);
        }
        else {
            elapsed = ((stopTime - startTime) / 1000f);
        }
        return elapsed;
    }
}


