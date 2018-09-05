package projecteuler;

import java.util.ArrayList;

public class P021_amicable implements Runnable{
    public void run(){
        int upto = 10000;
        PossAmic[] nums = new PossAmic[upto + 1];
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
        }
        int total = 0;
        for (int i = 2; i < nums.length; i++){
            if (nums[i].sumDivisors != nums[i].number
                    && nums[i].sumDivisors <= upto
                    && nums[i].number == nums[nums[i].sumDivisors].sumDivisors){
                nums[i].isAmic = true;
                System.out.println("Amicable numbers: " + nums[i].number + ", " + nums[i].sumDivisors);
                total += nums[i].number;
            }
        }
        System.out.println("Total: " + total);
    }

    class PossAmic{
        int number;
        ArrayList<Integer> divisors = new ArrayList<Integer>();
        int sumDivisors;
        boolean isAmic;
    }


    public static void main(String[] args) {
        new P021_amicable().run();
    }
}
