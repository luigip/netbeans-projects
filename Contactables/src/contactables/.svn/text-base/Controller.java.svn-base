package contactables;

import java.util.ArrayList;

public class Controller extends AbstractContact{
    private static long time0;

    public void go(){
        myID = "Controller #1";
        
        ArrayList<Contactable> allContactables = new ArrayList<Contactable>();
        allContactables.add(this);
        allContactables.add(new ConTest1("Bret"));
        allContactables.add(new ConTest1("Jemaine"));
        allContactables.add(new ConTest2("Murray"));
        allContactables.add(new ConTest2("Brahbra"));
        allContactables.add(new Controller("Controller #2"));
        
        linkContacts(allContactables);

        time0 = System.currentTimeMillis();

        for(Contactable c : allContactables){
            startThread(c);
        }
    }

    public static void linkContacts(ArrayList<Contactable> list){
        for(Contactable c : list){
            for(Contactable d: list){
                if(c != d){
                    c.link(d);
                }
            }
        }
    }

    public static void startThread(final Contactable c){
        (new Thread(){
            @Override
            public void run() {
                c.callRandomList();
            }
        }).start();
    }

    public static String getTime(){
        return String.format("%.1f", (System.currentTimeMillis() - time0)/1000f);
    }

    public Controller(){super();}
    public Controller(String name){super(name);}
}
