package topcoder.set2;

public class BrokenElevator {

    int time = 0;
    char[][] pl;
    int x, y;
    int[] finish = new int[2];
    int[] start = new int[2];

    public int wayTime(String[] plan) {
        y = plan.length;
        x = plan[0].length();
        pl = new char[x][y];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                pl[j][i] = plan[i].charAt(j);
                if (pl[j][i] == 'S') {
                    start[0] = j;
                    start[1] = i;
                }
                if (pl[j][i] == 'F') {
                    finish[0] = j;
                    finish[1] = i;
                }
            }
        }
        return move(start[0], start[1], 0);
    }

    int move(int xpos, int ypos, int t) {
        if (pl[xpos][ypos] == 'F') {
            return t;
        }
        else if(finish[1] == ypos){
            // on same floor
            if(finish[0] < xpos){
                return move(xpos - 1, ypos, t + 2);
            } else return move(xpos + 1, ypos, t + 2);
        }
        else if(finish[1] < ypos){
            // below finish
            if(pl[xpos][ypos - 1] == '|'){
                // go up
                return move(xpos, ypos - 2, t + 3);
            }else{
                // move along
                boolean left = false;
                for(int i = 0; !left && i < xpos; i++){
                    if(pl[i][ypos - 1] == '|') left = true;
                }
                if(left) return move(xpos - 1, ypos, t + 2);
                else return move(xpos + 1, ypos, t + 2);
            }
        }
        else {
            // above finish
            if(pl[xpos][ypos + 1] == '|'){
                // go down
                return move(xpos, ypos + 2, t + 1);
            }else{
                // move along
                boolean left = false;
                for(int i = 0; !left && i < xpos; i++){
                    if(pl[i][ypos + 1] == '|') left = true;
                }
                if(left) return move(xpos - 1, ypos, t + 2);
                else return move(xpos + 1, ypos, t + 2);
            }            
        }
    }
    
    public static void main(String[] args) {
        BrokenElevator b = new BrokenElevator();
        String[] p = {"#F###", "...|.", "#####", ".|...", "####S"};
        System.out.println(b.wayTime(p));
    }
}
