package scratch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class NanoTimer {

    private double TARGET_DELAY_NS;
    private int POLL_FREQ_MS;
    private long updates = 0;
    private int cycles;
    private int cyclesLast = 0;
    private boolean isRunning = false;
    private boolean stopping = false;
    private boolean doneInitializing = false;
    private double dummy;
    private final PublicTimer PUBLIC_TIMER = new PublicTimer();
    
    // Swing's Timer class's method to fire events is protected, so we need to extend it
    // to fire off events manually
    private class PublicTimer extends Timer {
        
        private PublicTimer(){
            super(Integer.MAX_VALUE, null);
        }
        
        public void fireActionPerformedPublic () {
            fireActionPerformed(new ActionEvent(NanoTimer.this, 0, ""));
        }
    }
    
    private class QuickTimer implements Runnable {

        @Override
        public void run() {
            while (!stopping) {
                updates++;
                if(doneInitializing) {
                    PUBLIC_TIMER.fireActionPerformedPublic();
                }
                for (int i = 0; i < cycles; i++) {
                    dummy = i/7;
                }
            }
            stopping = false;
            isRunning = false;
            doneInitializing = false;
        }
    }    
    
    private Timer rateChecker = new Timer(POLL_FREQ_MS, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            cyclesLast = cycles;
            double delay = POLL_FREQ_MS * 1000.0 / updates;
            double ratio = delay / TARGET_DELAY_NS;
            cycles /= ratio;
            
            float cyclesRatio = ((float) cyclesLast) / cycles;
            if(cyclesRatio < 1.1 && cyclesRatio > 0.9)
                doneInitializing = true;
//            System.out.println("TARGET DELAY" + TARGET_DELAY_NS);
//            System.out.printf("Updates: %d in %d ms. Actual delay = %.1f ns%n", updates, POLL_FREQ_MS, delay );
            updates = 0;
        }
    });

    public NanoTimer(int delayNanos) {
        this(delayNanos, null);
    }
    
    public NanoTimer(int delayNanos, ActionListener al) {
        this(delayNanos, 100, al);
    }
    
    public NanoTimer(int delayNanos, int pollFreqMillis, ActionListener al){
        if(pollFreqMillis * 1000 / delayNanos < 10) {
            throw new IllegalArgumentException("Poll frequency must be 10 times or greater than the delay");
        }
        TARGET_DELAY_NS = delayNanos;
        POLL_FREQ_MS = pollFreqMillis;
        rateChecker.setDelay(POLL_FREQ_MS);
        cycles = (int)(500 * TARGET_DELAY_NS);
         addActionListener(al);
    }

    public void start(){
        if(!isRunning) {
            Thread nanoThread = new Thread(new QuickTimer());
            nanoThread.start();
            rateChecker.start();
            isRunning = true;
        }
    }
    
    public void stop(){
        if(isRunning) {
            stopping = true;
            rateChecker.stop();
        }
    }
    
    public int getPollMs() { return POLL_FREQ_MS; }
    public void setPollMs(int POLL_FREQ_MS) { 
        if(POLL_FREQ_MS * 1000 / TARGET_DELAY_NS < 10) {
            throw new IllegalArgumentException("Poll frequency must be 10 times or greater than the delay");
        }
        doneInitializing = false;
        this.POLL_FREQ_MS = POLL_FREQ_MS; 
        rateChecker.setDelay(POLL_FREQ_MS);
     }
    public double getDelayNs() { return TARGET_DELAY_NS; }
    public void setDelayNs(double TARGET_DELAY_NS) { this.TARGET_DELAY_NS = TARGET_DELAY_NS; }    
    public void addActionListener(ActionListener al) {PUBLIC_TIMER.addActionListener(al); }
    public void removeActionListener(ActionListener al) {PUBLIC_TIMER.removeActionListener(al); }
}   

class NanoTimerTest {   

    public static void main(String[] args) {
        NanoTimer n = new NanoTimer(200);
        final TestListener tl = new TestListener();
        
        Timer t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tl.getUpdate();
            }
        });
        n.addActionListener(tl);
        t.start();
        n.start();
        sleep();
        System.out.println("Change poll");
        n.setPollMs(50);
        sleep();
        sleep();
        System.out.println("Change delay");
        n.setDelayNs(2);
        sleep();
        System.out.println("stopping");
        n.stop();
        sleep();
        System.out.println("starting");
        n.start();
        sleep();
        System.out.println("removing ActionListener");
        n.removeActionListener(tl);
        sleep();
        System.out.println("adding ActionListener");
        n.addActionListener(tl);
    }
    
    static void sleep() {try{Thread.sleep(3000);}catch(Exception e){}}
    
}

class TestListener implements ActionListener {

    private int count = 0;
    private long t0 = System.currentTimeMillis();

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
    }

    public void getUpdate() {
        long t1 = System.currentTimeMillis();
        System.out.printf("TestListener received %d events in %.2f seconds%n", count, (t1 - t0) / 1e3);
        count = 0;
        t0 = t1;
    }
}