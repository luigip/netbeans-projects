package projecteuler;

public class P031_coins_in_200p implements Runnable {

    @Override
    public void run() {
//        long t = System.nanoTime();
        long combos = 0;
//        int count = 0;
        for (int p200 = 0; p200 <= 1; p200++) {
            for (int p100 = 0; p100 <= 2; p100++) {
                for (int p50 = 0; p50 <= 4; p50++) {
                    for (int p20 = 0; p20 <= 10; p20++) {
                        for (int p10 = 0; p10 <= 20; p10++) {
                            for (int p5 = 0; p5 <= 40; p5++) {
                                for (int p2 = 0; p2 <= 100; p2++) {
//                                    count++;
                                    if (200 * p200 +
                                       100 * p100 +
                                       50  * p50  +
                                       20  * p20  +
                                       10  * p10  +
                                       5   * p5   +
                                       2   * p2 <= 200) {
                                       combos++;
                                    } else break;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(combos);
//        System.out.println((System.nanoTime()-t)/1e6 + " ms");
    }

    public static void main(String[] args) {
        
        new P031_coins_in_200p().run();
       
    }
}
