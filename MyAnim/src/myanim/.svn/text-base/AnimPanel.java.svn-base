package myanim;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class AnimPanel extends javax.swing.JPanel {
    private static final double g = 9.81*70;
    private static final int DELAY = 500;
    ArrayList<Shape> shapes = new ArrayList<Shape>();

    public AnimPanel() {
        initComponents();
        Timer timer = new Timer(DELAY, new TimerListener());
        timer.start();
        
    }

    protected void newShape(Shapes s){
        Shape n = ShapeFactory.getShape(s);
        shapes.add(n);
        n.setPosX(Math.random() * this.getWidth());
        n.setPosY(0);
        n.setVelX(0);
        n.setVelY(0);
        n.setBounce(0.8);
        n.setSizeX(50);
        n.setSizeY(50);
        n.setColor(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
//        System.out.println("this.getHeight: "+ this.getHeight());
    }
    public void updatePositions(){
        for(Shape sh : shapes){
            if(!sh.isAtRest()){
                //Total energy / unit mass = constant = (1/2)u^2 + gh
                double KE = (0.5)*Math.pow(sh.getVelY(), 2);
                double PE = g*(this.getHeight() - sh.getPosY() - sh.getSizeY());
                System.out.println("KE: "+ KE+" PE: "+PE +" Total: "+ (KE+PE));
                //update y pos: s = ut + (1/2)at^2
                double newPosY = sh.getPosY() +
                        sh.getVelY()*(DELAY/1000d) + (0.5) * g * Math.pow((DELAY/1000d),2);
                    if(newPosY + sh.getSizeY() > this.getHeight()){
                        double u = sh.getVelY();
                        System.out.println("newPosY:" + newPosY);
                        System.out.println("u:" + u);
                        System.out.println("posY: " + sh.getPosY());
                        //IMPACT
                        // s = distance to impact, pixels

                        double s = this.getHeight() - sh.getPosY() - sh.getSizeY();
                        System.out.println("s: " + s);

                        // v^2 = u^2 + 2as
                        double impactV = Math.sqrt(Math.pow(u,2) + 2 * g * s);
                        System.out.println("impactV: " + impactV);

                        // t = (v - u) / a
                        double impactTime = (impactV - u) / g;

                        double remainderTime = DELAY/1000d - impactTime;

                        //s = ut + (1/2)at^2
                        double newY = (this.getHeight() - sh.getSizeY()
                                + (sh.getBounce() * (-impactV) * remainderTime
                                + (1 / 2) * g * Math.pow(remainderTime, 2)));
                        System.out.println("newY: " + newY);
                        sh.setPosY(newY);
                        //v = u + at
                        sh.setVelY(sh.getBounce()*(-impactV) + g * remainderTime);
                        //If time for bounce to complete < time interval, do not bounce
                        System.out.println("2 * impactV * sh.getBounce() / g: " +2 * impactV * sh.getBounce() / g);
                        System.out.println(DELAY / 1000d + "\n");
                        if(2 * impactV * sh.getBounce() / g < DELAY / 1000d){
                            sh.setPosY(this.getHeight() - sh.getSizeY());
                            sh.setVelY(0);
                            sh.setAtRest(true);
                        }

                    }else{
                        sh.setPosY(newPosY);
                        sh.setVelY(sh.getVelY() + g * (DELAY/1000d));
                }
            }
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for(Shape sh : shapes){
            g2.setColor(sh.getColor());
            g2.drawOval((int)sh.getPosX(), (int)sh.getPosY(), (int)sh.getSizeX(), (int)sh.getSizeY());
        }
    }

    class TimerListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            updatePositions();
            repaint();
        }

    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(204, 255, 204));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
