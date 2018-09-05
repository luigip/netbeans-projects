package scratch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Java7TimerTest {

    public static void main(String[] args) {
        System.out.print("Enter delay in ms: ");
        int delay = new java.util.Scanner(System.in).nextInt();
        System.out.printf("Expecting %.1f events per second %n", 1000d/delay);
        
        Timer t = new Timer(delay, new ActionListener() {
            long time0 = System.currentTimeMillis();
            int count = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                long time1 = System.currentTimeMillis();
                if(time1 >= time0 + 1000) {
                    System.out.println(count + " events in " + (time1-time0)/1e3 + " s");
                    time0 = time1;
                    count = 0;
                }
            } 
        });  
        t.start();
        try {
            Thread.sleep(10000);
        } catch (Exception e) { }
    }
}

