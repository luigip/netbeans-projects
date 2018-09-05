/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ball;
import java.awt.*;
import javax.swing.*;


public class Bounce extends JFrame{
    public Bounce(){
        super ("Tennis");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BouncePanel boing = new BouncePanel();
//        Container pane = getContentPane();
//        pane.add(boing);
//        setContentPane(pane);
        add(boing);
        setVisible(true);
    }

    public static void main(String[] args){
        Bounce frame = new Bounce();
    }
}
