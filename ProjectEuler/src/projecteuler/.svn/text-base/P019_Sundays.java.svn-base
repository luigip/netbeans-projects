package projecteuler;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * You are given the following information, but you may prefer to do some research for yourself.<br><br>

    * 1 Jan 1900 was a Monday.
    * Thirty days has September,
      April, June and November.
      All the rest have thirty-one,
      Saving February alone,
      Which has twenty-eight, rain or shine.
      And on leap years, twenty-nine.
    * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.<br><br>

How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

 * @author Rhys
 */

public class P019_Sundays implements Runnable{
    public void run(){
        Calendar cal = new GregorianCalendar(1901, Calendar.JANUARY, 1);
        int count = 0;
        for (int year = 1901; year <= 1902; year++){
            for (int month = 1; month <= 12; month++){
                cal.add(Calendar.MONTH, 1);
                if (cal.get(Calendar.DAY_OF_WEEK) == 1){
                    System.out.println(cal.toString());
                    count++;
                }
            }
        }
        System.out.println(count);       
    }
    
    public static void main(String[] args) {
        new P019_Sundays().run();
    }
}