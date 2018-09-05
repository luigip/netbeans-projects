
package projecteuler;


public class P009_pythagTriplet implements Runnable{
    public void run() {
        final int target = 1000;

        for (int a = 1; a <= target; a++) {
            for (int b = 1; b <= target; b++){
                for (int c = 1; c <= target; c++){
                    if (a * a + b * b == c * c){
                        if (a + b + c == target){
                            System.out.println(a * b * c);
//                            System.out.println(a + " " + b + " " + c);
                            return;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new P009_pythagTriplet().run();
    }
}
