package experiments;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelSwapDemoFrame extends javax.swing.JFrame {

    /** Creates new form PanelSwapDemoFrame */
    public PanelSwapDemoFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(255, 255, 204));
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        panel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                final PanelSwapDemoFrame f = new PanelSwapDemoFrame();

                f.setVisible(true);

                final JPanel p1 = new JPanel();
                final JPanel p2 = new JPanel();

                p1.add(new JLabel("panel 1"));
                p2.add(new JLabel("JPanel number 2"));

                f.addPanel(p1);

                new Timer(1000, new ActionListener() {

                    private JPanel current = p1;

                    public void actionPerformed(ActionEvent e) {
                        if (current == p1) {
                            f.swapPanels(p1, p2);
                            current = p2;
                        } else {
                            f.swapPanels(p2, p1);
                            current = p1;
                        }
                    }
                }).start();
            }
        });
    }

    public void addPanel(JPanel p) {
        panel.add(p);
    }

    public void swapPanels(JPanel a, JPanel b) {
        panel.remove(a);
        panel.add(b);
        panel.validate();
        panel.repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}