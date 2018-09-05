package cattledrive;

public class J4a_Say {

    static final int MIN = 0;
    static final int MAX = 99;

    public static void main(String[] args) {
        int num = 0;
        try {
            num = Integer.valueOf(args[0]);
        } catch (Exception e) {
            System.out.println("Input must be an integer");
            System.exit(0);
        }
        if (num < MIN || num > MAX) {
            System.out.println("Input must be in range " + MIN + " to " + MAX);
            System.exit(0);
        }
        System.out.println(getNumString(num));
    }

    static String getNumString(int num) {
        String asString = null;
        if (num < 10) {
            asString = getOnes(num);
        }
        if (num >= 10 && num < 20) {
            asString = getTeens(num);
        }
        if (num >= 20 && num < 100) {
            asString = getTen(num);
            if (num % 10 != 0) {
                asString += "-" + getOnes(num);
            }
        }
        return asString;
    }

    static String getOnes(int num) {
        String[] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        return ones[num % 10];
    }

    static String getTeens(int num) {
        String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        return teens[num - 10];
    }

    static String getTen(int num) {
        String[] ten = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        return ten[num % 100 / 10];
    }
}
