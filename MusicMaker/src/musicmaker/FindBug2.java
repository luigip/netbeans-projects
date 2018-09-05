package musicmaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class FindBug2 {

    JButton midiButton;
    JFrame frame;
    JPanel panel;
    int x = 140, y = 10;

    public static void main(String[] args) {
        new FindBug2().runGui();
    }

    public void runGui() {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        midiButton = new JButton("Make a note");
        midiButton.addActionListener(new MidiListener());
        frame.add(BorderLayout.EAST, midiButton);

        panel = new MyDrawPanel();
        frame.add(BorderLayout.CENTER, panel);

        frame.setSize(500, 500);
        frame.setVisible(true);

        moveBall();
    }

    public void moveBall(){
        x = 40;
        for (y = 10; y <= 200; y = y + 3){
            try{Thread.sleep(50);
            }catch (Exception ex){}
            panel.repaint();
        }
    }

    class MyDrawPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.fillOval(x, y, 60, 60);
        }
    }
    class MidiListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            moveBall();
        }
    }
}

