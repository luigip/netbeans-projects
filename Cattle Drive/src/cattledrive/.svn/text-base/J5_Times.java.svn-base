package cattledrive;

//package cattle.drive;

public class J5_Times {

    public static void main(String[] args) {
        //header
        System.out.print("   ");
        for (int x = 0; x < 10; x++) {
            System.out.print(parseNum(x));
        }
        System.out.println();

        for (int y = 0; y < 10; y++) {
            System.out.print(parseNum(y));
            for (int x = 0; x < 10; x++) {
                System.out.print(parseNum(x * y));
            }
            System.out.println("");
        }
    }

    static String parseNum(int a) {
        String s = String.valueOf(a);
        return ("   ".substring(s.length()) + s);
    }
}
