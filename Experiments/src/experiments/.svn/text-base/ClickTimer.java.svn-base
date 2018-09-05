package experiments;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ClickTimer implements Runnable{

    JFrame frame = new JFrame("Click Timer");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Click here");
    JButton button = new JButton("");
    JTextArea textArea = new JTextArea(10, 20);
    JScrollPane scrollPane = new JScrollPane(textArea);
    long lastTime;

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            ClickTimer n = new ClickTimer();
            new Thread(n).start();
        }
    }
    public void run(){
        buildGUI();
    }
    public void buildGUI() {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 300);
        frame.add(panel);

        BoxLayout panelLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(panelLayout);

        label.setFont(label.getFont().deriveFont(18f));
        button.setText("click");
        panel.add(label);
        panel.add(button);
        panel.add(scrollPane);

        scrollPane.getViewport().setView(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                long now = System.currentTimeMillis();
                textArea.append("Time to click: " + (now - lastTime) / 1000f + " seconds\n");
                lastTime = now;
            }
        });

        lastTime = System.currentTimeMillis();
        frame.setVisible(true);

    }
}
