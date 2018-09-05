
package SDTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import singledraw.*;


public class another {
    public static void main(String[] args){
        testReadFile.doStuff();
    }
}


class testReadFile{
// input / output and performance testing
    static void doStuff(){
        String path = "C:\\Users\\Rhys\\Documents\\NetBeansProjects\\SingleDraw\\testfiles\\";
        String inputFile = "vbaout.txt";
       // String inputFile = "straightflush.txt";
        String outputFile = "javaout.txt";

        StopWatch sw = new StopWatch();
        sw.start();

        Deck deck = new Deck();
        ArrayList<CHand> list = new ArrayList<CHand>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(path + inputFile));
            String line = null;
            while ((line = br.readLine()) != null){
                String[] cardnums = line.split(";");
                CHand hand = new CHand();
                for (int i = 0; i<5; i++){
                    String [] cardElements = cardnums[i].split(",");
                    CCard aCard = deck.getCard(Integer.parseInt(cardElements[0]), Integer.parseInt(cardElements[1]));
                    hand.setOneCard(i, aCard);
                }
                hand.determineHandStrength(GameType.LOWBALL);
                list.add(hand);
            }
            System.out.println("time to read in " + sw.getElapsedTimeSecs());
            br.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        sw.start();
        Collections.sort(list);
        System.out.println("sort " + sw.getElapsedTimeSecs());
        sw.start();
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + outputFile));
            for(CHand c:list){
                writer.write(c.toString());
                writer.newLine();
            }
            writer.close();
        }
        catch(Exception e){System.out.println("Couldn't output");}
        System.out.println("output " + sw.getElapsedTimeSecs());
    }

}