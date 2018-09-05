/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package musicmaker;
import javax.swing.*;
import java.awt.*;



public class MyDrawPanel extends JPanel{
    @Override
    public void paintComponent(Graphics g1){
        Graphics2D g = (Graphics2D) g1;
        g.setColor(Color.orange);
        g.fillRect(20,50,100,100);
        Image image = new ImageIcon(getClass().getResource("south park avatar 2.jpg")).getImage();
        g.drawImage(image, 30, 4, this);
        g.setColor(Color.BLACK);
        g.fillRoundRect(100, 100, 100, 100, 10, 10);
        g.setColor(new Color((int)(Math.random()*256), (int)(Math.random()*256),
                (int)(Math.random()*256), 255));
        g.fillOval(80, 80, 60, 60);
        g.setPaint(new GradientPaint(80, 80, Color.blue, 140, 140, Color.orange, true));
        g.fillOval(60, 150, 100, 60);
        //g.rotate(-Math.PI/4);
        //g.scale(2, 3);
        //g.shear(1, 0);
        //g.drawImage(image, 30, 50 , this);
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jp = new MyDrawPanel();
        
        jf.setSize(400, 400);
        
        jf.add(jp);

        jf.setVisible(true);
    }

}
