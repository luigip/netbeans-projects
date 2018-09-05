package cattledrive;


public class J1b_Hundred {

    public static void main(String[] args) {
        String s = args[0];
        int count = 0;
        int col = 0;
        while (count < 100) {
            if (col + s.length() >= 80) {
                System.out.println(s);
                col = 0;
            } else {
                System.out.print(s + " ");
                col += s.length() + 1;
            }
            count++;
        }
        
    }
}
