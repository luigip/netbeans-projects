package topcoder.set2;

public class ComparerInator {

    public int makeProgram(int[] A, int[] B, int[] wanted) {
        boolean a = true, b = true, at = true, bt = true;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != wanted[i]) {
                a = false;
            }
            if (B[i] != wanted[i]) {
                b = false;
            }
            if ((A[i] < B[i] ? A[i] : B[i]) != wanted[i]) {
                at = false;
            }
            if ((A[i] < B[i] ? B[i] : A[i]) != wanted[i]) {
                bt = false;
            }
        }


        return (a || b) ? 1
                : (at || bt) ? 7 
                : -1;
    }
}
