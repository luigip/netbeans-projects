package cattledrive;

import com.javaranch.common.*;

public class OOP1_DaysOld {
    public static void main(String[] args) {
        String[] input = args[0].split("-");
        int year = Integer.parseInt(input[0]);
        int month = Integer.parseInt(input[1]);
        int day = Integer.parseInt(input[2]);
        
        GDate today = new GDate();
        JDate todayJ = new JDate(today);
        
        GDate born = new GDate(year, month, day);
        JDate bornJ = new JDate(born);
  
        int count = 0;
        while(!bornJ.equals(todayJ)){
            bornJ.inc();
            count++;
        }
//        while(count != 10000){
//            todayJ.dec();
//            count--;
//        }
        
//        int count2 = 0;
//        JDate bornJ = new JDate(new GDate(1977, 07, 16));
//        while(count2++ < 23456){
//            bornJ.inc();
//        }
        
        System.out.println("You were born on " + born.getLongFormat());
        System.out.println("Today is " + today.getLongFormat());
        System.out.println("You are now " + count + " days old.");
//        System.out.println("You will be 23456 on " + bornJ.getLongFormat());
    }
}
