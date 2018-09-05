package topcoder.set1;

import java.util.Arrays;

//For TCHS SRM 3 
public class BestSeller {

    public String findBestSeller(String[] items) {
        Arrays.sort(items);
        String lastItem = "";
        String mostPop = "";
        int countThis = 0;
        int max = 0;
        for (int i = 0; i < items.length; i++) {
            if (!items[i].equals(lastItem)) {
                countThis = 0;
            }
            countThis++;
            if (countThis > max) {
                max = countThis;
                mostPop = items[i];
            }
            lastItem = items[i];
        }
        return mostPop;
    }

    public static void main(String[] args) {
        String[] input = {"icecream", "peanuts", "peanuts", "chocolate", "candy", "chocolate", "icecream", "apple"};
        System.out.println(
                new BestSeller().findBestSeller(input));
    }
}
