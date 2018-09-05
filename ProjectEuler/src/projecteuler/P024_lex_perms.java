package projecteuler;

import java.util.ArrayList;
import java.util.List;

public class P024_lex_perms implements Runnable{
    @Override
    public void run(){
        final int NUM_DIGITS = 10;
        final int PERMS = 1000000;

        int remPerms = PERMS - 1;
        List<Integer> digits = new ArrayList<Integer>();
        for (int i = 0; i < NUM_DIGITS; i++) {
            digits.add(i);
        }

        for (int i = NUM_DIGITS; i > 0; i--) {
            int fact = (int)P020_factorial.factorial(i-1);
            int nth = remPerms / fact;
            System.out.print(digits.remove(nth));
            remPerms = remPerms % fact;
        }
        System.out.println("");
    }

	
    public static void main(String[] args) {
        new P024_lex_perms().run();
    }
}
