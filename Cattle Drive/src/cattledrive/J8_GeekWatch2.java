package cattledrive;

//package cattle.drive;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class J8_GeekWatch2 {
    public static void main(String[] args) {
        int chan = Integer.parseInt(args[0]);
        
        Calendar cal = Calendar.getInstance();
        long now = cal.getTimeInMillis();
        String ret = null;
        
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
        
        switch (chan){
            case 0: ret = "Milliseconds since January 1, 1970:  " + String.valueOf(now); break;
            case 1: ret = "Seconds since January 1, 1970:  " + String.valueOf(now / 1000); break;
            case 2: ret = "Days since January 1, 1970:  " + String.valueOf(now / 1000 / 60 / 60 / 24); break;
            case 3: ret = "Current date and time: " + sdf2.format(cal.getTime()); break;
        }
        System.out.println(ret);
    }
}
