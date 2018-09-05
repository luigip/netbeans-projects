package myanim;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Util {

    public static void framePanel(JPanel panel){
        final JFrame frame = new JFrame("Test Frame");
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

}