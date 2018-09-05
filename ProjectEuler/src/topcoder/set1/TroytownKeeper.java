package topcoder.set1;

public class TroytownKeeper {

    public int limeLiters(String[] maze) {
        int x = maze[0].length();
        int y = maze.length;
        Block[][] blocks = new Block[x][y];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                char c = maze[i].charAt(j);
                if (c == '#') {
                    blocks[j][i] = Block.WALL;
                }
                if (c == '.') {
                    blocks[j][i] = Block.INVISSPACE;
                }
            }
        }
        boolean anyMoreVisible = true;
        while (anyMoreVisible) {
            anyMoreVisible = false;
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (blocks[j][i] == Block.INVISSPACE) {
                        // check surrounding blocks
                        for (int k = i - 1; k <= i + 1; k++) {
                            for (int l = j - 1; l <= j + 1; l++) {
                                if (k < 0 || k >= y || l < 0 || l >= x || blocks[l][k] == Block.VISSPACE) {
                                    // is next to visible space
                                    if (k == i || l == j) {
                                        // is same row / column
                                        if (blocks[j][i] != Block.VISSPACE) {
                                            blocks[j][i] = Block.VISSPACE;
                                            anyMoreVisible = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        int paintable = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (blocks[j][i] == Block.WALL) {
                    // check surrounding blocks
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1; l++) {
                            if (k < 0 || k >= y || l < 0 || l >= x || blocks[l][k] == Block.VISSPACE) {
                                if (k == i || l == j) {
                                    // paintable wall
                                    paintable++;
                                }
                            }
                        }
                    }
                }
            }
        }

        return paintable;
    }

    enum Block {

        WALL, VISSPACE, INVISSPACE
    }

    public static void main(String[] args) {
        TroytownKeeper t = new TroytownKeeper();
        String[] m = {"######"
,"#....."
,"#..#.."
,"#....."
,"######"};
        int p = t.limeLiters(m);
        System.out.println(p);
    }
}