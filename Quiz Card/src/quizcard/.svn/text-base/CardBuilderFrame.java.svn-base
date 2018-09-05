package quizcard;

import javax.swing.JFileChooser;

public class CardBuilderFrame extends javax.swing.JFrame {

    public CardBuilderFrame() {
        initComponents();
        panel = new CardBuilderPanel();
        getContentPane().add(panel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemNewSet = new javax.swing.JMenuItem();
        itemSave = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        itemNewSet.setText("New set");
        itemNewSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNewSetActionPerformed(evt);
            }
        });
        jMenu1.add(itemNewSet);

        itemSave.setText("Save...");
        itemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSaveActionPerformed(evt);
            }
        });
        jMenu1.add(itemSave);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSaveActionPerformed
       JFileChooser fileChooser = new JFileChooser();
       fileChooser.showSaveDialog(this);
       panel.saveCards(fileChooser.getSelectedFile());

    }//GEN-LAST:event_itemSaveActionPerformed

    private void itemNewSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNewSetActionPerformed
        panel.newSet();
    }//GEN-LAST:event_itemNewSetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemNewSet;
    private javax.swing.JMenuItem itemSave;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
    private CardBuilderPanel panel;
}
