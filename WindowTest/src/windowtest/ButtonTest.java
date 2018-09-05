
package windowtest;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;


public class ButtonTest {
    public static void main(String[] args) {
                try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        //            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {
            e.printStackTrace();
        }
        JButton b1 = new JButton("Button 1");
        JButton b2 = new JButton("Button 2");

        JPanel p1 = new JPanel();
        p1.add(b1);
        framePanel(p1);

        JPanel p2 = new JPanel();
        p2.add(b2);    
        framePanel(p2);
    }

    public static void framePanel(JPanel panel) {

        JFrame frame = new JFrame("Test Frame");
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
