
package quizcard;

import javax.swing.JFileChooser;

public class CardViewerFrame extends javax.swing.JFrame {

    public CardViewerFrame() {
        initComponents();
        panel = new CardViewerPanel();
        add(panel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemLoad = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        itemLoad.setText("Load...");
        itemLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLoadActionPerformed(evt);
            }
        });
        jMenu1.add(itemLoad);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLoadActionPerformed
       JFileChooser fileChooser = new JFileChooser();
       fileChooser.showOpenDialog(this);
       panel.loadCards(fileChooser.getSelectedFile());

    }//GEN-LAST:event_itemLoadActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CardViewerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemLoad;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
    private CardViewerPanel panel;
}
