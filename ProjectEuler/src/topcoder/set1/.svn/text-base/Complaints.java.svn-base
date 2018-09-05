package topcoder.set1;

public class Complaints {
    public static void main(String[] args) {
        Complaints c = new Complaints();
        int[] line = {1,2,3,4,5};
        System.out.println(c.howMany(line));
    }
    public int howMany(int[] line){
        int count = 0;
        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < i; j++) {
                if(line[j] < line[i]) count++;
            }
        }
        return count;
    }    
}
