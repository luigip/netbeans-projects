package topcoder.set1;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AboutDialog {

    private static MyData getData() {
        JTextArea text0 = new JTextArea(10, 20);
        JTextField text1 = new JTextField(10);

        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("String 0: "));
        panel.add(text0);
        panel.add(new JLabel("String 1: "));
        panel.add(text1);

        int result = JOptionPane.showConfirmDialog(null, panel, "Data Entry", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            return new MyData(text0.getText(), text1.getText());
        }
        return null;
    }

    public static void main(String[] args) {
        MyData m = getData();
        System.out.println(m.string0 + "\n" + m.string1);
    }
}

class MyData {

    final String string0;
    final String string1;

    public MyData(String str0, String str1) {
        string0 = str0;
        string1 = str1;
    }
}