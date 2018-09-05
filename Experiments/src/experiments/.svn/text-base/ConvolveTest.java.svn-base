package experiments;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ConvolveTest extends JPanel {

    BufferedImage[] spot_ARGB = new BufferedImage[2];
    BufferedImage[] spot_ARGB_PRE = new BufferedImage[2];
    
    // Create 2 BufferedImages of each type, one each for before and after
    // Draw a red spot on each "before" image
    // Make an 11x11 kernel for a box blur
    // Convolve the "before" images into the "afters"
    public ConvolveTest() {

        spot_ARGB[0] = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
        spot_ARGB[1] = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB_PRE);
        spot_ARGB_PRE[0] = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB_PRE);
        spot_ARGB_PRE[1] = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB_PRE);

        Graphics2D gs = spot_ARGB[0].createGraphics();
        Graphics2D gs_PRE = spot_ARGB_PRE[0].createGraphics();
        gs.setPaint(Color.RED);
        gs_PRE.setPaint(Color.RED);
        gs.fill(new Ellipse2D.Double(15, 15, 20, 20));
        gs_PRE.fill(new Ellipse2D.Double(15, 15, 20, 20));

        float[] vals = new float[121];
        Arrays.fill(vals, 1/121f);
        Kernel kernel = new Kernel(11, 11, vals);

        ConvolveOp cop = new ConvolveOp(kernel);
        cop.filter(spot_ARGB[0], spot_ARGB[1]);
        cop.filter(spot_ARGB_PRE[0], spot_ARGB_PRE[1]);
    }

    @Override
    // Copy images to the panel's graphics, ARGB on left, ARGB_PRE on right
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(spot_ARGB[0], 25, 10, null);
        g2.drawImage(spot_ARGB[1], 25, 60, null);
        g2.drawImage(spot_ARGB_PRE[0], 125, 10, null);             
        g2.drawImage(spot_ARGB_PRE[1], 125, 60, null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 120);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new ConvolveTest());
        f.pack();
        f.setVisible(true);
    }
}
