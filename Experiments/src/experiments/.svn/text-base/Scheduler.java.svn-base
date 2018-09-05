package experiments;

public class Scheduler {
    public static String schedule (int n) {
        StringBuilder sb = new StringBuilder();
        boolean[][] matches = new boolean[n][n];
        int matchCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n-1; j > i; j--) {
                matches[i][j] = true;
                matchCount++;
            }
        }
        while(matchCount > 0){
            boolean[] playing = new boolean[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(matches[i][j] && !playing[i] && !playing[j]) {
                        sb.append("Team ").append(i + 1).append(" vs Team ").append(j + 1).append("\n");
                        matches[i][j] = false;
                        matchCount--;
                        playing[i] = true; playing[j] = true;
                        break;
                    }
                }
            }
            if(matchCount > 0) sb.append("----------------\n");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        try { 
            int teams = Integer.parseInt(args[0]);
            System.out.println(schedule(teams));       
        } catch (Exception e){
            System.out.println("Error: argument must be an integer");
        }
    }
}
