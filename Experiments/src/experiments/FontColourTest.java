package experiments;

import javax.swing.JFrame;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.MutableAttributeSet;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextPane;

public class FontColourTest {

    public FontColourTest() {
        JFrame f = new JFrame();
        JTextPane tp = new JTextPane();
        MutableAttributeSet attrs = tp.getInputAttributes();
        StyledDocument doc = tp.getStyledDocument();      
        
        tp.setEditable(false);
        tp.setText("hello\ntesting");
        tp.setFont(new Font("Consolas", Font.PLAIN, 12));

        for (int i = 0; i < tp.getText().length(); i++) {
            if(i % 2 == 0) {
                StyleConstants.setForeground(attrs, Color.red);
            }
            else{
                StyleConstants.setForeground(attrs, Color.green);
            }
            doc.setCharacterAttributes(i, 1, attrs, false);
        }
//        tp.setCharacterAttributes(attrs, true);
//        StyleConstants.setForeground(attrs, Color.blue);
//        try {
//            doc.insertString(0, "12345", attrs);
//        } catch (Exception e) {
//            System.out.println("Exception while inserting String");
//        }
//        tp.setCharacterAttributes(attrs, true);
        
        ////////
        f.add(tp, BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(200, 200);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new FontColourTest();
    }
}