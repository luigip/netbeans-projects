package projecteuler;

public class P028_spiral implements Runnable{
    @Override
    public void run(){
        final int SIZE = 1001;

        int sum = 1;
        int n = 1;
        for (int len = 2; len <= SIZE; len += 2){
            for (int side = 0; side < 4; side++){
                n += len;
                sum += n;
            }
        }
        System.out.println(sum);
    }

	
    public static void main(String[] args) {
        new P028_spiral().run();
    }
}
