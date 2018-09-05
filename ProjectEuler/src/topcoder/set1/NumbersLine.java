package topcoder.set1;

public class NumbersLine {
    public int getLeast(String line, int givenNumber){
        String[] nums = line.split(" ");
        int res = Integer.MAX_VALUE;
        for(String s : nums){
            if(s.length() == 0) continue;
            int i = Integer.parseInt(s);
            if(i > givenNumber) res = Math.min(res, i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
