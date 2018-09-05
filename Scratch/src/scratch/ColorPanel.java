package scratch;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorPanel extends JPanel {

    private Color c = new Color(0);

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(c);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    public void animate() {
        new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c = new Color((c.getRGB() + 1000) % 16777216);
                repaint();
            }
        }).start();
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        ColorPanel j = new ColorPanel();
        f.add(j);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.animate();
        f.setVisible(true);

    }
}
