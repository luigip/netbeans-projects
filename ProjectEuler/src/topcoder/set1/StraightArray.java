package topcoder.set1;

import java.util.Arrays;

public class StraightArray {
    public int howManyMore(int[] nums){
        Arrays.sort(nums);
        boolean[][] next5 = new boolean[nums.length][5];
        int max =  0;
        
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < 4; j++) {
                if(Arrays.binarySearch(nums, nums[i] + j + 1) > 0){
                    next5[i][j] = true;
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        return 4 - max;
    }
    
    public static void main(String[] args) {
        StraightArray s = new StraightArray();
        int[] nums = {1000, 1005, 1010, 1015, 995, 990, 985};
        System.out.println(s.howManyMore(nums));
                
    }
    
}
