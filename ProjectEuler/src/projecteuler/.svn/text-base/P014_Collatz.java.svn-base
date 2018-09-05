
package projecteuler;


public class P014_Collatz implements Runnable {
    //Without array cache: 3.72s
    //With cache: 0.256s


    long[] collatz = new long[1000001];

    public void run(){
        int maxLength = 0;
        long maxi = 0;

        // Choose starting numbers up to 1m
        for (long i = 1; i <= 1000000; i++) {
            int chainLength = 1;
            long j = i;
           mainloop:
            // For each number, loop until it = 1
            while (j != 1){
                if (j < i && collatz[(int)j] != 0){
                    chainLength += collatz[(int)j] - 1;
                    break mainloop;
                }
                j = (j % 2 == 0) ? j/2 : 3 * j + 1;
                chainLength++;
            }
            collatz[(int)i] = chainLength;
//            System.out.println("i = " + i + " length: " + chainLength);
//            if (i % 10000 == 0) System.out.println(i);
            if(chainLength > maxLength) {
                maxLength = chainLength;
                maxi = i;
            }

        }
        System.out.println(maxLength + " at " + maxi);
    }

    public static void main(String[] args) {
        new P014_Collatz().run();
    }
}
