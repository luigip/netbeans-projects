package projecteuler;

public class P033_fractions implements Runnable{
    @Override
    public void run(){
        for (int d = 10; d <100; d++){
            for (int n = 10; n < d; n++){

                double value = (double)n / d;

                int n1 = n / 10;
                int n2 = n % 10;
                int d1 = d / 10;
                int d2 = d % 10;

                if ((n1 == d1 && (double)n2 / d2 == value
                  || n1 == d2 && (double)n2 / d1 == value
                  || n2 == d1 && (double)n1 / d2 == value
                  || n2 == d2 && (double)n1 / d1 == value)

                  && !(n2 == 0 && d2 ==0) // remove trivial cases
                  ){

                    System.out.println(n + " / " + d);
                }
            }
        }
    }

	
    public static void main(String[] args) {
        new P033_fractions().run();
    }
}
