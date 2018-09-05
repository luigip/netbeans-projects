package cattledrive;


public class J3_Leap {

    public static void main(String[] args) {
        int yr = 0;

        try {
            yr = Integer.valueOf(args[0]);
        } catch (Exception e) {
            System.out.println("Year must be an integer");
            System.exit(1);
        }

        boolean isLeap = false;
        if (yr % 4 == 0) {
            isLeap = true;
        }
        if (yr % 100 == 0) {
            isLeap = false;
        }
        if (yr % 400 == 0) {
            isLeap = true;
        }

        if (isLeap) {
            System.out.println("leap year!");
        } else {
            System.out.println("not a leap year!");
        }

    }
}
