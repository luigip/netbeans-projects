package scratch2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Spiral {

    static final int xsize = 10;
    static final int ysize = 8;
    JTextArea text = new JTextArea(xsize, ysize);
    
    
    public void animate(){
        
    }

    public void display() {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame f = new JFrame("Spiral");
                f.add(text);





                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.pack();
                f.setVisible(true);
            }
        });
    }
    
    class Grid {
        char[][] data = new char[xsize][ysize];
        public Grid(int x, int y, int xd. int yd) {
            boolean done = false;
            
            while(!done) {
                int xn = 
            }
        }

        
    }
    
    public static void main(String[] args) {
        Spiral s = new Spiral();
        s.display();
    }
}
