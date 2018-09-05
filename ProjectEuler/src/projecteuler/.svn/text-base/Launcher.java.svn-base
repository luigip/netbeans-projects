
package projecteuler;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import myutil.Tools;
import myutil.WrapLayout;

public class Launcher implements Runnable{

    public Launcher(){}

    public void run(){
        launchSimple();
//        launchFrameGo();
    }

    public void launchFrameGo(){
        final LaunchFrame frame = new LaunchFrame();
        frame.setDefaultCloseOperation(LaunchFrame.EXIT_ON_CLOSE);

        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public void launchSimple(){
        //create panel for simple frame and resize to n buttons across
        ButtonPanel panel = new ButtonPanel();
        int buttonsXcount = 5;
        int buttonsYcount = (int)Math.ceil((double)panel.getComponentCount()/buttonsXcount);
        int panelY = (panel.getComponent(0).getPreferredSize().height + 20) * buttonsYcount + 20;
        int panelX = buttonsXcount * (panel.getComponent(0).getPreferredSize().width + 10) + 10;
        panel.setPreferredSize(new Dimension(panelX, panelY));
        Tools.framePanel(panel);
    }
}


class ButtonPanel extends JPanel {

    ArrayList<Class> classList;

    public ButtonPanel() {
        WrapLayout layout = new WrapLayout(WrapLayout.LEADING, 10, 20);
        setLayout(layout);

        // Retrieve classes from package
        try {
            classList = (ArrayList<Class>) Tools.getClasses(this.getClass().getPackage().getName());
        } catch (Exception e) {System.out.println("Error retrieving class list");
        }
        // Remove classes we don't want to launch
        String[] removeClasses = {
            "Main",
            "Launcher",
            "LaunchFrame",
            "LaunchFrameSimple",
            "ButtonPanel",
            "primespeed",
            "NumberToWords",
            "Common",
            "NewClass"
        };
        String thisPackage = this.getClass().getPackage().getName();
        for (String name : removeClasses){
            try {
                Class toRemove = Class.forName(thisPackage + "." + name);
                classList.remove(toRemove);
            } catch (Exception e) {System.out.println("Could not remove class \"" + name + "\"");
            }
        }
        // Make buttons with class name label
        for (Class c : classList) {
            String[] a = c.getName().split("\\.");
            String label = a[a.length - 1];
            JButton button = new JButton(label);
            button.setPreferredSize(new Dimension(180, 60));
            button.setFont(button.getFont().deriveFont(16f));
            button.addActionListener(new LaunchButtonListener(c));

            add(button);
        }

    }// close constructor

    class LaunchButtonListener implements ActionListener{
        Class target;

        public LaunchButtonListener(Class c) {
            target = c;
        }

        public void actionPerformed(ActionEvent e) {

            if (Runnable.class.isAssignableFrom(target)) {
                try {
                    Runnable r = (Runnable) target.newInstance();
                    LaunchWorker lw = new LaunchWorker(r);
                    lw.execute();

                } catch (Exception ex) {
                    System.out.println("Error launching " + target);
                }
            } else {
                System.out.println("Target class not Runnable");
            }

        }
    }

    class LaunchWorker extends SwingWorker<Void, Void> {

        private Runnable r;
        private long startTime, endTime;

        public LaunchWorker(Runnable r) {
            this.r = r;
        }

        @Override
        protected Void doInBackground() throws Exception {
            startTime = System.nanoTime();
            r.run();
            return null;
        }

        @Override
        protected void done() {
            // Note: error of approx 0.032 s in this benchmark, after 4 warm-up runs
            endTime = System.nanoTime();
            System.out.printf("Class " + r.getClass().getName() + ": time = %f s (-~0.032 s)%n",
                    (endTime - startTime) / 1000000000d);
        }

    }

}// close ButtonPanel

