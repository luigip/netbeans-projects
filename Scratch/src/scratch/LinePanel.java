package scratch;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LinePanel extends JPanel {

    private int quarter = 0;
    private Polygon[] triangles = new Polygon[4];
    private int number = 15;
    private Dimension lastSize = null;

    private void updateTriangles() {
        int x = getSize().width / number, y = getSize().height / number;
        triangles[0] = new Polygon(new int[]{0, x, x}, new int[]{0, 0, y}, 3);
        triangles[1] = new Polygon(new int[]{x, x, 0}, new int[]{0, y, y}, 3);
        triangles[2] = new Polygon(new int[]{x, 0, 0}, new int[]{y, y, 0}, 3);
        triangles[3] = new Polygon(new int[]{0, 0, x}, new int[]{y, 0, 0}, 3);
        lastSize = getSize();
    }

    public void rotate() {
        quarter = (quarter + 1) % 4;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if (!getSize().equals(lastSize)) {
            updateTriangles();
        }
        
        double dx = (double) getWidth() / number;
        double dy = (double) getHeight() / number;
        
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
        
                float c = 1 - (float) (i * j) / number / number;
                g2.setColor(new Color(c, c * 0.5f, c * 0.5f));
                
                g2.fillPolygon(triangles[quarter]);

                if (j == number - 1) g2.translate(dx, -dy * (number - 1));
                else g2.translate(0, dy);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }
    
    public void setup() {
        Timer t = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rotate();
                repaint();
            }
        });
        t.start();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame();
                LinePanel l = new LinePanel();
                l.setup();
                f.add(l);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.pack();
                f.setVisible(true);
            }
        });
    }
}
