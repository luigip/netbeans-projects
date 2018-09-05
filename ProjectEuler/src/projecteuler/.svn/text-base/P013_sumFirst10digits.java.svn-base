
package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;

/**
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
 * @author Rhys
 */
public class P013_sumFirst10digits implements Runnable{

    public void run(){
        BigInteger total = new BigInteger("0");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("P0130input.txt"));
        } catch (Exception e) {
            System.out.println("Could not read file");
            return;
        }

        try {
            String lineString = null;
            while ((lineString = br.readLine()) != null) {
                BigInteger line = new BigInteger(lineString);
                total = total.add(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error reading line\n");
        }

        System.out.println(total.toString().substring(0, 10));
    }

    public static void main(String[] args) {
        new P013_sumFirst10digits().run();
    }
}
