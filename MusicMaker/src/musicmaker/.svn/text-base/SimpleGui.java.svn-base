package musicmaker;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class SimpleGui {
    static final MiniMusic mm = new MiniMusic();
    static{mm.initialize();}
    JButton midiButton;
    JButton repButton;
    JFrame frame;
    JPanel panel;
    int x = 140, y = 10;


    public static void main(String[] args) {
        new SimpleGui().runGui();
    }

    public void runGui() {

        try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){
        }
        frame = new JFrame();
        midiButton = new JButton("Make a note");
        midiButton.addActionListener(new MidiListener());
        repButton = new JButton("Kick");
        repButton.addActionListener(new RepaintListener());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(BorderLayout.SOUTH ,repButton);
        frame.add(BorderLayout.EAST, midiButton);
        panel = new MyDrawPanel();
        frame.add(BorderLayout.CENTER, panel);
        frame.setSize(500, 500);
        frame.setVisible(true);

        dropBall();
    }

    public void dropBall(){
        x = 140;
        for (y = 10; y <= 200; y = y + 3){
            try{Thread.sleep(50);}catch (Exception e){}
            panel.repaint();
        }
    }

    class RepaintListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            panel.repaint();
        }
    }
    class MidiListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            mm.play(50,100,10,1);
        }
    }

    class MyDrawPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g1){
            super.paintComponent(g1);
            Graphics2D g = (Graphics2D) g1;
            g.setColor(Color.orange);
            g.fillRect(20,50,100,100);
            Image image = new ImageIcon(getClass().getResource("south park avatar 2.jpg")).getImage();
            g.drawImage(image, 30, 4, this);
            g.setColor(Color.BLACK);
            g.fillRoundRect(100, 100, 100, 100, 10, 10);
            g.setColor(new Color((int)(Math.random()*256), (int)(Math.random()*256),
                    (int)(Math.random()*256), 255));
            g.fillOval(x, y, 60, 60);
            g.setPaint(new GradientPaint(80, 80, Color.blue, 140, 140, Color.orange, true));
            g.fillOval(60, 150, 100, 60);

        }
    }
}
