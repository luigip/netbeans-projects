package projecteuler;

public class P038_pandigital_concat implements Runnable {

    public void run() {
        int panDigitalMax = 0;
        for (int i = 1; i < 10000; i++) {
            String res = "";
            for (int n = 1; n <= 9; n++) {
                res += String.valueOf(i * n);
                if (res.length() == 9) {
                    if (isPandigital(res) && n > 1) {
                        if (Integer.valueOf(res) > panDigitalMax) {
                            panDigitalMax = Integer.valueOf(res);
                        }
                    }
                    break;
                }
                if (res.length() > 9) {
                    break;
                }
            }
        }
        System.out.println("panDigitalMax: " + panDigitalMax);
    }
    
    public static boolean isPandigital(String res) {
        char[] c = res.toCharArray();
        boolean isPanDigital = true;
        boolean[] digits = new boolean[9];
        for (int j = 0; j < 9; j++) {
            int d = Character.getNumericValue(c[j]);
            if (d !=0 && digits[d - 1] == false) {
                digits[d - 1] = true;
            } else {
                isPanDigital = false;
                break;
            }
        }
        return isPanDigital;
    }

    public static void main(String[] args) {
        new P038_pandigital_concat().run();
    }
}
