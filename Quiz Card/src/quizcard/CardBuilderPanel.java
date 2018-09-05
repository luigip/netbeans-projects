package quizcard;

import java.io.File;
import java.util.ArrayList;

public class CardBuilderPanel extends javax.swing.JPanel {
    ArrayList<QuizCard> list = new ArrayList<QuizCard>();

    public CardBuilderPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        answerArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        nextCardButton = new javax.swing.JButton();

        jLabel1.setText("Question:");

        questionArea.setColumns(20);
        questionArea.setRows(5);
        jScrollPane1.setViewportView(questionArea);

        answerArea.setColumns(20);
        answerArea.setRows(5);
        jScrollPane2.setViewportView(answerArea);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Answer:");

        nextCardButton.setText("Next Card");
        nextCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextCardButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(nextCardButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel2)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextCardButton)
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nextCardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextCardButtonActionPerformed
        //Save contents of Question and Answer boxes and clear contents
        QuizCard card = new QuizCard();
        card.setQuestion(questionArea.getText());
        card.setAnswer(answerArea.getText());
        list.add(card);
        questionArea.setText("");
        answerArea.setText("");

    }//GEN-LAST:event_nextCardButtonActionPerformed
    public void saveCards(File file){
        QuizCard.writeFile(list, file);
    }
    public void newSet(){
        questionArea.setText("");
        answerArea.setText("");
        list.clear();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea answerArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton nextCardButton;
    private javax.swing.JTextArea questionArea;
    // End of variables declaration//GEN-END:variables

}
