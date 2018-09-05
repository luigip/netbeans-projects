package topcoder.set1;

public class WallRepair {
    public int bricksRequired(String[] wallRows){
        int count = 0;
        for (int i = 0; i < wallRows[0].length(); i++) {
            boolean hasBrick = false;
            for (int j = 0; j < wallRows.length; j++) {
                if(wallRows[j].charAt(i) == 'X') hasBrick = true;
                else if(hasBrick) count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        String []s = {
"..X...X.....",
"....X.X...XX",
"...........X",
"..X.......X."};
        WallRepair w = new WallRepair();
        System.out.println(w.bricksRequired(s));
                
    }
}
