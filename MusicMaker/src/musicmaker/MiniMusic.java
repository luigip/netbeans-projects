package musicmaker;
import javax.sound.midi.*;


public class MiniMusic {
    Sequencer player;
    Sequence seq;
    public void initialize(){
        try{
            player = MidiSystem.getSequencer();
            player.open();
            seq = new Sequence(Sequence.PPQ, 4);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * Plays a note
     */
    public void play(int pitch, int velocity, int length, int instrument){
        try {
            Track track = seq.createTrack();

            ShortMessage m = new ShortMessage();
            m.setMessage(ShortMessage.PROGRAM_CHANGE, 1, instrument, 0);
            MidiEvent inst = new MidiEvent(m, 1);

            ShortMessage msg1 = new ShortMessage();
            msg1.setMessage(ShortMessage.NOTE_ON, 1, pitch, velocity);
            MidiEvent noteOn = new MidiEvent(msg1, 1);

            ShortMessage msg2 = new ShortMessage();
            msg2.setMessage(ShortMessage.NOTE_OFF, 1, pitch, 50);
            MidiEvent noteOff = new MidiEvent(msg2, length);

            track.add(inst);
            track.add(noteOn);
            track.add(noteOff);
            player.setSequence(seq);
            player.start();

            seq.deleteTrack(track);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
