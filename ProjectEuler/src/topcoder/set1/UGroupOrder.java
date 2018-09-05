package topcoder.set1;

import java.util.ArrayList;

public class UGroupOrder {

    public int[] findOrders(int N) {
        // find relatively prime numnbers
        ArrayList<Integer> orders = new ArrayList<Integer>();
        for (int i = 1; i < N; i++) {
            boolean relPr = true;
            for (int j = 2; relPr && j <= i; j++) {
                if (N % j == 0 && i % j == 0) {
                    relPr = false;
                }
            }
            if (relPr) {
                int order = 1;

                boolean found = false;
                while (!found) {
                    long k = i;
                    for (int j = 1; j < order; j++) {
                        k *= i;
                        k = k % N;
                    }
                    if (k % N == 1) {
                        orders.add(order);
                        found = true;
                    }
                    order++;

                }
            }
        }

        // apparently there's no easy way to convert an ArrayList<Integer> to an int[]
        int[] ret = new int[orders.size()];
        for (int i = 0; i < orders.size(); i++) {
            ret[i] = orders.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] ug = new UGroupOrder().findOrders(51);
        for (int i : ug) {
            System.out.println(i);
        }
    }
}
