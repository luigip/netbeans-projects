package topcoder.set1;

public class Xox {
    public int count(String text){
        boolean[] u = new boolean[text.length()];
        int c = 0;
        for (int i = 0; i < text.length() - 2; i++) {
            if(text.substring(i, i + 3).equals("xox")){
                for (int j = 0; j < 3; j++) {
                    if(u[i+j] == false){
                        c++;
                    }
                    u[i+j] = true;
                }
            }
        }
        return c;
    }
}
