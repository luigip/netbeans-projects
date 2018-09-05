import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.*;
import javax.sound.midi.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;


public class BeatBox {
    JFrame frame = new JFrame("Beatbox");
    JPanel background = new JPanel();
    JButton tempoUp = new JButton("Tempo Up");
    JButton tempoDown = new JButton("Tempo Down");
    JButton start = new JButton("Start");
    JButton stop = new JButton("Stop");
    JTextField bpm = new JTextField(5);
    String[] patchNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal",
        "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap",
        "Low-mid Tom", "High Agogo", "Open Hi Conga"};
    int[] patchNums = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};
    int NUMBER_OF_BEATS = 16;
    int NUMBER_OF_PATCHES = patchNums.length;
    JCheckBox[][] checkBoxes = new JCheckBox[NUMBER_OF_PATCHES][NUMBER_OF_BEATS];
    MidiEvent[][][] midiEvents = new MidiEvent[NUMBER_OF_PATCHES][NUMBER_OF_BEATS][2];

    Sequencer sequencer;
    Sequence sequence;
    Track track = null;

    public static void main(String[] args) {
        BeatBox b = new BeatBox();
        b.setupGUI();
    }

    public void setupGUI(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(background);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        JPanel right = new JPanel(new BorderLayout());

        GridLayout leftGridLayout = new GridLayout(NUMBER_OF_PATCHES, 1, 0, 2);
        JPanel left = new JPanel(leftGridLayout);
        left.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        buttonBox.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        GridLayout centerGridLayout = new GridLayout(NUMBER_OF_PATCHES, NUMBER_OF_BEATS, 1, 2);
        
        JPanel center = new JPanel(centerGridLayout);
        background.setLayout(new BorderLayout());
        background.add(BorderLayout.EAST, right);
        background.add(BorderLayout.WEST, left);
        background.add(BorderLayout.CENTER, center);

        buttonBox.add(tempoUp);
        buttonBox.add(tempoDown);
        buttonBox.add(start);
        buttonBox.add(stop);
        
        JPanel bpmPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        bpmPanel.add(new JLabel("BPM:"));
        bpmPanel.add(bpm);
        
        right.add(BorderLayout.SOUTH, bpmPanel);
        right.add(BorderLayout.NORTH, buttonBox);

        for(int i =0 ; i < patchNums.length; i++){
            left.add(new JLabel(patchNames[i]));
            for(int b = 0; b < NUMBER_OF_BEATS; b++){
                checkBoxes[i][b] = new JCheckBox();
                center.add(checkBoxes[i][b]);
                checkBoxes[i][b].addItemListener(new BoxListener(i, b));
                
                midiEvents[i][b][0] = makeEvent(ShortMessage.NOTE_ON, 9, patchNums[i], 100, b);
                midiEvents[i][b][1] = makeEvent(ShortMessage.NOTE_OFF, 9, patchNums[i], 100, b + 1);
            }
        }

        tempoUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sequencer.setTempoFactor(sequencer.getTempoFactor()*1.03f);
                updateBPM();
            }
        });

        tempoDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sequencer.setTempoFactor(sequencer.getTempoFactor()/1.03f);
                updateBPM();
            }
        });

        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                makeTrack();
                try {
                    sequencer.setSequence(sequence);
                } catch (Exception ex) {System.out.println("Could not set sequence");
                }       
                sequencer.start();
            }
        });

        stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sequencer.stop();
            }
        });
        initSequencer();
        //-----------------------------
        frame.pack();
        frame.setVisible(true);
        //-----------------------------
    }

    public void updateBPM(){
        bpm.setText(String.format("%.0f", sequencer.getTempoInBPM()*sequencer.getTempoFactor()));
    }

    public void initSequencer(){
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            sequencer.setTempoInBPM(120);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            track = sequence.createTrack();
            updateBPM();
        } catch (Exception e) {e.printStackTrace();
        }
    }
    public void makeTrack(){
        sequence.deleteTrack(track);
        track = sequence.createTrack();
        try {
            for (int patch = 0; patch < NUMBER_OF_PATCHES; patch++) {
                for(int beat = 0; beat < NUMBER_OF_BEATS; beat++){
                    if(checkBoxes[patch][beat].isSelected()){
                    track.add(midiEvents[patch][beat][0]);
                    track.add(midiEvents[patch][beat][1]);
                    }
                }
            }
            track.add(makeEvent(176,1,20,0,16));  //control change 20 undefined
        } catch (Exception e) {e.printStackTrace();
        }
    }

    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
        MidiEvent event = null;
        ShortMessage sm = new ShortMessage();
        try {
            sm.setMessage(comd, chan, one, two);
            event = new MidiEvent(sm, tick);
        } catch (Exception e) {
        }
        return event;
    }
    
    class BoxListener implements ItemListener{
        int patchIndex;
        int beatIndex;
        
        public BoxListener(int patch, int beat) {
            patchIndex = patch;
            beatIndex = beat;
        }
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED){
                //System.out.println(patchNames[patchIndex] + "ON, beat " + beatIndex);
                track.add(midiEvents[patchIndex][beatIndex][0]);
                track.add(midiEvents[patchIndex][beatIndex][1]);
            }
            else{
                //System.out.println(patchNames[patchIndex] + "OFF, beat " + beatIndex);
                track.remove(midiEvents[patchIndex][beatIndex][0]);
                track.remove(midiEvents[patchIndex][beatIndex][1]);
            }
        }
    }

}
