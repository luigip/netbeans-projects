package codebat;

class MaxMirror {

    public static void main(String args[]) {
        int[] test = {1, 2, 3, 2, 1};
        MaxMirror ts = new MaxMirror();
//        for (int i : ts.reverse(test)) {
//            System.out.println(i);
//        }
//        int[] s = {1,2,3,5};
//        System.out.println(ts.contains(test, s));
        System.out.println(ts.maxMirror(test));
    }

    public int maxMirror(int[] nums) {
        int max = 0;
        int[] rev = reverse(nums);
        System.out.println("orig arr " + printArr(nums));
        System.out.println("rev arr  " + printArr(rev));
        for (int i = 0; i < nums.length; i++) {
            for (int len = 1; i + len <= nums.length; len++) {
                int[] search = new int[len];
                for (int j = 0; j < len; j++) {
                    search[j] = nums[i + j];
                }
                System.out.println("Searching for " + printArr(search));
                if (search.length > max && contains(rev, search)) {
                    max = search.length;
                }
            }
        }
        return max;
    }

    boolean contains(int[] c, int[] s) {
        boolean found = false;
        for (int i = 0; !found && i <= c.length - s.length; i++) {
            found = true;
            for (int j = 0; found && j < s.length; j++) {
                if (c[i + j] != s[j]) {
                    found = false;
                }
            }
        }
        return found;
    }

    int[] reverse(int[] a) {
        int[] rev = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            rev[rev.length - 1 - i] = a[i];
        }
        return rev;
    }
    
    String printArr(int[] a){
        String s = "";
        for(int i : a){
            s += (i + " ");
        }
        return s;
    }
}