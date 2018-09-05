package experiments;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SquaringTheBishop {
    private ArrayList<String> words = new ArrayList<String>(114000);
    
    public SquaringTheBishop() {
        try {
            loadWords();
        } catch (Exception e) {
            System.out.println("Failed to load words");
            System.exit(1);
        }
    }
    
    private void loadWords() throws Exception{
        Scanner sc = new Scanner(new File("..\\..\\mwords\\113809of.fic"));
        while(sc.hasNext()){
            String s = sc.next();
            if(s.matches("[A-Za-z]+")) words.add(s);
        }
    }
    
    public void find(final String input){
        int len = input.length();
        for (int i = 1; i < len - 1; i++) {
            
        }
    }
//    private boolean tryWord(String start, int len){
//        if(start.length() == len) return words.contains(start);
//        
//    }
    
    
    
    public static void main(String[] args) {
        new SquaringTheBishop().find("FOG");
    }
}
