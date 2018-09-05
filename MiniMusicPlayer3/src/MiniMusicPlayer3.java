import javax.sound.midi.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class MiniMusicPlayer3 {
    JFrame frame;
    MyDrawPanel panel;
    Sequencer sequencer;
    //ArrayList<RectShape> rectangles = new ArrayList<RectShape>();
    ArrayList<RectShapeDouble> rectangles = new ArrayList<RectShapeDouble>();
    int WINDOW_DIMENSION = 1000;

    public static void main(String[] args) {
        new MiniMusicPlayer3().go();
    }

    public void go(){

        setUpGUI();

        try{
            sequencer = MidiSystem.getSequencer();
            sequencer.addControllerEventListener(panel, new int[] {127});
            Sequence seq = new Sequence(Sequence.PPQ, 16);
            Track tr = seq.createTrack();

            for (int i = 0; i <= 48; i += 3) {
                tr.add(makeEvent(ShortMessage.NOTE_ON, 1, i + 40, 100, 5*i));
                tr.add(makeEvent(ShortMessage.CONTROL_CHANGE, 1, 127, 0, 5*i));
                tr.add(makeEvent(ShortMessage.NOTE_OFF, 1, i + 40, 100, (5*i) + 3));
            }

            sequencer.open();
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(130);
            sequencer.start();

        }catch (Exception e){
        }
    }

    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
        ShortMessage sm = new ShortMessage();
        try {
            sm.setMessage(comd, chan, one, two);

        } catch (Exception e) {
        }
        return new MidiEvent(sm, tick);
    }

    public void setUpGUI(){
        frame = new JFrame("Music Maker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new MyDrawPanel();
        frame.add(panel);

        frame.setSize(WINDOW_DIMENSION, WINDOW_DIMENSION);
        frame.setVisible(true);
    }

    class MyDrawPanel extends JPanel implements ControllerEventListener{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            for (RectShapeDouble r : rectangles){
                g2.setColor(r.color);
                int pw = getWidth();
                int ph = getHeight();
                //g2.fillRect(r.x1, r.y1, r.width, r.height);
                g2.fillRect((int)(r.x1*pw), (int)(r.y1*ph),
                        (int)(r.width*pw), (int)(r.height*ph));
            }
        }
        public void controlChange(ShortMessage message){
            rectangles.add(new RectShapeDouble());
            panel.repaint();
        }
    }

    class RectShape{
        int width, height, x1, y1;
        Color color;
        public RectShape(){
            width = random(WINDOW_DIMENSION/2);
            height = random(WINDOW_DIMENSION/2);
            x1 = random(WINDOW_DIMENSION - width);
            y1 = random(WINDOW_DIMENSION - height);
            color = randomColor();
        }
        public RectShape(int width, int height, int x1, int y1, Color color){
            this.width = width;
            this.height = height;
            this.x1 = x1;
            this.y1 = y1;
            this.color = color;
        }
        final int random(int i){
            return (int)(Math.random() * i);
        }
    }

    class RectShapeDouble{
        double width, height, x1, y1;
        Color color;
        public RectShapeDouble(){
            width = Math.random()/2;
            height = Math.random()/2;
            x1 = Math.random()*(1 - width);
            y1 = Math.random()*(1 - height);
            color = randomColor();
        }
        public RectShapeDouble(double width, double height, double x1, double y1, Color color){
            this.width = width;
            this.height = height;
            this.x1 = x1;
            this.y1 = y1;
            this.color = color;
        }
    }
    static int random(int i){
        return (int)(Math.random() * i);
    }
    static Color randomColor(){
        return new Color(random(256), random(256), random(256), random(128) + 128);
    }
}
