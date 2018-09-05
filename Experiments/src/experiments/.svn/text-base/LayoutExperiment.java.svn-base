package experiments;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LayoutExperiment {
    JTextArea area;
    JScrollPane scrollPane;

    public static void main(String[] args) {
        new LayoutExperiment().buildGui();
    }
    void buildGui(){
        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {System.out.println("Could not set look and feel");
        }

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(BorderLayout.EAST, panel);

        JButton button1 = new JButton("Click me");
        JButton button2 = new JButton("Me too");
        panel.add(button1);
        panel.add(button2);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                area.append("Button clicked \n");
                JScrollBar vScrollBar = scrollPane.getVerticalScrollBar();
                vScrollBar.setValue(vScrollBar.getMaximum());
            }
        });

        JPanel leftPanel = new JPanel();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        leftPanel.setLayout(flowLayout);
         
        frame.add(BorderLayout.CENTER, leftPanel);
        //leftPanel.setAlignmentY(JPanel.LEFT_ALIGNMENT);

        
        JLabel label = new JLabel("Type here");
        JTextField field = new JTextField(20);
        leftPanel.add(label);
        leftPanel.add(field);
        field.setText("This is my text");
        field.selectAll();
        field.requestFocus();

        area = new JTextArea(10, 20);
        area.setLineWrap(true);
        scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setViewportView(area);
        leftPanel.add(scrollPane);
        area.setText("This is just a test");
        
        frame.setVisible(true);
    }



}
