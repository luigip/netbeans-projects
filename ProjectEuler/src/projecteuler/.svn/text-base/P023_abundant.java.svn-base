package projecteuler;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class P023_abundant implements Runnable{
    @Override
    public void run(){
        int upto = 100;
//        int upto = 28123;
        PossAmic[] nums = new PossAmic[upto + 1];
        List<PossAmic> abundantNums = new ArrayList<PossAmic>();
        for (int i = 1; i < nums.length; i++){
            nums[i] = new PossAmic();
            nums[i].number = i;
            int jmax = i;
            for (int j = 1; j < jmax; j++){
                if (i % j == 0){
                    nums[i].divisors.add(j);
                    if (j != 1 && i / j != j) {
                        nums[i].divisors.add(i / j);
                    }
                    jmax = i / j;
                }
            }
            int sumDivisors = 0;
            if (nums[i].divisors != null) {
                for (Integer d : nums[i].divisors) {
                    sumDivisors += d;
                }
            }
            nums[i].sumDivisors = sumDivisors;
            if (sumDivisors > i) {
                nums[i].isAbundant = true;
                abundantNums.add(nums[i]);
//                System.out.println("Abundant number: " + i + " : Divisors: " + nums[i].divisors);
            }

        }

        int total = 0;
        for (int i = 1; i < nums.length; i++){
            // test if can be written as sum of 2 abundant numbers
            ListIterator<PossAmic> lit = abundantNums.listIterator();
            while (lit.hasNext()){
                int ab = lit.next().number;
                if (ab > i / 2) {
                    System.out.println(i + " is not sum of 2 abundant numbers");
                    total += i;
                    break;
                }
                if (nums[i - ab].isAbundant){
                    nums[i].isSumOf2Abundant = true;
//                    System.out.println(i + " is sum of " + ab + " and " + (i - ab));
                    break;
                }
            }
        }
        System.out.println("Total of number not sum of 2 abundant numbers: " + total);
    }

    class PossAmic{
        int number;
        ArrayList<Integer> divisors = new ArrayList<Integer>();
        int sumDivisors;
        boolean isAmic;

        boolean isAbundant;
        boolean isSumOf2Abundant;
    }

    public static void main(String[] args) {
        new P023_abundant().run();
    }
}
