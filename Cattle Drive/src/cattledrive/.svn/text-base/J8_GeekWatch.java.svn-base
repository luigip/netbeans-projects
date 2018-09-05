package cattledrive;

//package cattle.drive;

import java.util.Date;

public class J8_GeekWatch {
    public static void main(String[] args) {
        int chan = Integer.parseInt(args[0]);
        long now = System.currentTimeMillis();
        String ret = null;
        
        switch (chan){
            case 0: ret = "Milliseconds since January 1, 1970:  " + String.valueOf(now); break;
            case 1: ret = "Seconds since January 1, 1970:  " + String.valueOf(now / 1000); break;
            case 2: ret = "Days since January 1, 1970:  " + String.valueOf(now / 1000 / 60 / 60 / 24); break;
            case 3: ret = "Current date and time: " + String.format("%tc", new Date()); break;
        }
        System.out.println(ret);
    }
}
