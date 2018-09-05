package projecteuler;

import java.util.ArrayList;

class P015_grid implements Runnable{
    int size = 20;
    public void run(){
        ArrayList<ArrayList<Long>> lineList = new ArrayList<ArrayList<Long>>();
        for (int i = 0; i <= 2 * size; i++) {
            ArrayList<Long> line = new ArrayList<Long>();
            line.add(1L);

            for (int j = 1; j <= i; j++){
                long value = lineList.get(i - 1).get(j - 1);
                if (j < i) value += lineList.get(i - 1).get(j);
                line.add(value);
            }
            lineList.add(line);
        }
        System.out.println(lineList.get(size * 2).get(size));
    }
    
    
    public static void main(String[] args) {
        new P015_grid().run();
    }
}