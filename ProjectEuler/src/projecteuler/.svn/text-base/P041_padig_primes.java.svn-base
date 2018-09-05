package projecteuler;

public class P041_padig_primes implements Runnable {

    @Override
    public void run() {
        final int max = 10000000;
        boolean[] primes = Common.getPrimesSieveV3(max);
        for (int i = 3; i < max; i += 2) {
            if(primes[i] && isPandigital(String.valueOf(i))){
                System.out.println(i);
            }
        }
    }

    public static boolean isPandigital(String res) {
        char[] c = res.toCharArray();
        boolean isPanDigital = true;
        boolean[] digits = new boolean[9];
        for (int j = 0; j < c.length; j++) {
            int d = Character.getNumericValue(c[j]);
            if (d != 0 && d <= c.length
                    && digits[d - 1] == false) {
                digits[d - 1] = true;
            } else {
                isPanDigital = false;
                break;
            }
        }
        return isPanDigital;
    }

    public static void main(String[] args) {
        new P041_padig_primes().run();
//        System.out.println(isPandigital("0235"));
    }
}
