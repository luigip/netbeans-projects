package topcoder.set1;

public class CityBuses {

    public int maximumFare(String[] blocks) {
        char[][] map = new char[blocks.length][];
        for (int i = 0; i < blocks.length; i++) {
            map[i] = blocks[i].toCharArray();
        }
        int max = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'B') {
                    for (int k = 0; k < map.length; k++) {
                        for (int l = 0; l < map[k].length; l++) {
                            if(map[k][l] == 'B'){
                                max = Math.max(max, Math.abs(Math.abs(i - k) + Math.abs(j -l)));
                            }
                            
                        }
                    }
                }
            }
        }
        return max;
    }
}
