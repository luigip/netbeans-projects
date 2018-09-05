package cattledrive;

//package cattle.drive;

public class J4b_Say {

    static final long MIN = 0;
    static final long MAX = 999999999999L;

    public static void main(String[] args) {
        long num = 0;
        try {
            num = Long.valueOf(args[0]);
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

    static String getNumString(long num) {
        long billions = num % 1000000000000L / 1000000000;
        long millions = num % 1000000000 / 1000000;
        long thousands = num % 1000000 / 1000;
        long units = num % 1000 / 1;

        StringBuilder s = new StringBuilder();
        if (billions > 0) {
            s.append(getHundreds(billions)).append(" billion");
        }
        if (millions > 0) {
            if (num >= 1000000000) {
                s.append(", ");
            }
            s.append(getHundreds(millions)).append(" million");
        }
        if (thousands > 0) {
            if (num >= 1000000) {
                s.append(", ");
            }
            s.append(getHundreds(thousands)).append(" thousand");
        }
        if (units > 0) {
            if (num >= 1000) {
                if (units >= 100) {
                    s.append(", ");
                } else {
                    s.append(" and ");
                }
            }
            s.append(getHundreds(units));

        }
        if (num == 0) {
            s.append(parseOnes(0));
        }
        return s.toString();
    }

    static String parseOnes(long num) {
        String[] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        return ones[(int) (num % 10)];
    }

    static String parseTeens(long num) {
        String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        return teens[(int) (num % 10)];
    }

    static String parseTens(long num) {
        String[] ten = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        return ten[(int) (num % 100 / 10)];
    }

    static String getHundreds(long num) {
        //returns a number from 1 to 999
        StringBuilder s = new StringBuilder();
        if (num >= 100) {
            s.append(parseOnes(num % 1000 / 100));
            s.append(" hundred");
            if (num % 100 != 0) {
                s.append(" and ");
            }
        }
        if (num % 100 != 0) {
            s.append(getTens(num % 100));
        }
        return s.toString();

    }

    static String getTens(long num) {
        //return a number from 1 to 99
        StringBuilder s = new StringBuilder();
        if (num >= 20 && num < 100) {
            s.append(parseTens(num));
            if (num % 10 != 0) {
                s.append("-").append(parseOnes(num));
            }
        }
        if (num >= 10 && num < 20) {
            s.append(parseTeens(num));
        }
        if (num < 10) {
            s.append(parseOnes(num));
        }
        return s.toString();
    }
}