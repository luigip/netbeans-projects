package topcoder.set1;

import java.util.ArrayList;
import java.util.Collections;

public class MatchMaker {

    public String[] getBestMatches(String[] members, String currentUser, int sf) {
        ArrayList<Match> matches = new ArrayList<Match>();
        String[] currData = null;
        for (String mem : members) {
            String[] data = mem.split(" ");
            if (data[0].equals(currentUser)) {
                currData = data;
            }
        }
        for (String mem : members) {
            String[] data = mem.split(" ");
            if (!data[0].equals(currentUser) && data[1].equals(currData[2])) {
                int answers = 0;
                for (int i = 3; i < currData.length; i++) {
                    if (currData[i].equals(data[i])) {
                        answers++;
                    }
                }
                if (answers >= sf) {
                    Match m = new Match(answers,data[0]);
                    
                    matches.add(m);
                    System.out.println(data[0] + " " + answers);
                }
            }
        }
        Collections.sort(matches);
        String[] r = new String[matches.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = matches.get(i).name;
        }
        return r;
    }

    class Match implements Comparable<Match> {

        int score;
        String name;
        Match(int score, String name){
            this.score = score; this.name = name;
        }

        public int compareTo(Match o) {
            return o.score - this.score;
        }
        
    }

    public static void main(String[] args) {
        String[] mem = {"BETTY F M A A C C B B C A D A", "TOM M F A D C A C A C A D A", "SUE F M D D D D C B C A D D", "ELLEN F M A A C A A C C D D A", "JOE M F A A C A B A A A A A", "ED M F A D D A B D C B D B", "SALLY F M C D A B D D D D D D", "MARGE F M A A C C B B C D A C", "BOB M F A B C D B B C C A A", "BILLY M M A A A A A A A A A A", "BRIAN M F B B B B B B B B B B", "GEORGE M F C C C C C C C C C C", "MARY F M D D D D D D D D D D", "JERRY M F D A D A D A D A D A", "STEVE M F C B C C A B D D A D", "MIKE M F C A B C A B C A B B", "SARA F F A B C D A B C D A B", "KELLY F M D C B A D C B A D C", "TIM M F D D C C B B A A A A", "JILL F M B B B C C C D D A A"};
        String[] val = new MatchMaker().getBestMatches(mem, "MARGE", 5);
        for (String s : val) {
            System.out.println(s);
        }
    }
}
