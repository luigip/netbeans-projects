package life;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class LifeApp {

    LifePanel lp;
    private Timer t;
    private JButton goBtn;
    private JButton clearBtn;
    private JButton resetBtn;
    private JButton inputBtn;
    private SpeedPanel sp;
    
    private int delayMs = 500;

    public static void main(String[] args) {
        LifeApp a = new LifeApp();
    }

    public LifeApp() {
        buildGUI();
    }

    final void buildGUI() {
        t = new Timer(delayMs, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                lp.iterate();
            }
        });
        
        final JFrame f = new JFrame("Life");

        goBtn = new JButton("Go!");

        goBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (t.isRunning()) {
                    t.stop();
                    goBtn.setText("Go!");
                } else {
                    lp.save();
                    t.start();
                    goBtn.setText("Stop!");
                }
            }
        });
        
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                lp.clear();
                t.stop();
                goBtn.setText("Go!");
            }
        });
        
        resetBtn = new JButton("Reset");
        resetBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                lp.restore();
            }
        });
        
        inputBtn = new JButton("Input");
        inputBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                InputFrame inf = new InputFrame(LifeApp.this);
                inf.setLocationRelativeTo(f);
                inf.display();
                lp.setMouse(false);
            }
        });
        
        lp = new LifePanel();
        sp = new SpeedPanel();
        
        JPanel ctrlPanel = new JPanel(new GridLayout(1, 5));
        ctrlPanel.add(goBtn);
        ctrlPanel.add(resetBtn);
        ctrlPanel.add(clearBtn);
        ctrlPanel.add(inputBtn);
        ctrlPanel.add(sp);
        
        f.add(lp, BorderLayout.CENTER);
        f.add(ctrlPanel, BorderLayout.SOUTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
    class SpeedPanel extends JPanel{
        private JButton btnFaster = new JButton("+");
        private JButton btnSlower = new JButton("-");
        private JTextField txtSpeed = new JTextField();
        private double speedsecs = delayMs / 1000.0;
        
        public SpeedPanel() {
            btnSlower.setPreferredSize(new Dimension(50, 30));
            btnFaster.setPreferredSize((new Dimension(50, 30)));
            txtSpeed.setPreferredSize(new Dimension(50, 30));
            add(btnSlower);
            add(txtSpeed);
            add(btnFaster);
     
            txtSpeed.setHorizontalAlignment(JTextField.CENTER);
            setSpeed(1);
            
            btnFaster.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setSpeed(1.5);
                }
            });
            btnSlower.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    setSpeed(1.0 / 1.5);
                }
            });
        }
        private void setSpeed(double factor){
            speedsecs = speedsecs * factor;
            delayMs = (int)(speedsecs * 1000);
            txtSpeed.setText(String.format("%.3f", speedsecs));
            t.setDelay(delayMs);
        }
    }
}
