package experiments;

import java.awt.*;
import javax.swing.*;

public class ImageTest extends JPanel{
    private Image image = new ImageIcon("resources/can.jpg").getImage();

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
        g.setColor(Color.red);
        g.fillOval(100, 100, 50, 50);
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(image.getWidth(null), image.getHeight(null));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageTest it = new ImageTest();
        frame.add(it);
        frame.pack();
        frame.setVisible(true);
    }
}
