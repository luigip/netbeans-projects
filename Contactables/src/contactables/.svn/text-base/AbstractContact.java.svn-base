package contactables;

import java.util.ArrayList;

public abstract class AbstractContact implements Contactable{
    protected ArrayList<Contactable> myContacts = new ArrayList<Contactable>();
    protected String myID;
    protected static final long MAX_CALL_WAIT = 2000;

    public AbstractContact(String name) {myID = name;}
    public AbstractContact(){myID = "Anonymous";}

    @Override
    public void link (Contactable cont){
        myContacts.add(cont);
    }
    @Override
    public void contact(Contactable caller){
        System.out.println("After " + Controller.getTime() + " seconds, " + caller.getID()
                + " calls " + this.getID());
    }
    @Override
    public void callRandom(){
        int rand = (int) (Math.random()* myContacts.size());
        myContacts.get(rand).contact(this);
    }
    @Override
    public void callRandomList(){
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep((long)(MAX_CALL_WAIT * Math.random()));
            } catch (Exception e) {System.out.println("Could not sleep");}
            callRandom();
        }   
    }
    @Override
    public String getID(){
        return myID;
    }
}
