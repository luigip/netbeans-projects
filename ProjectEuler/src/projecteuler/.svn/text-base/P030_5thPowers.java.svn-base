package projecteuler;

public class P030_5thPowers implements Runnable{
    @Override
    public void run(){
        int total = 0;
        for (int i = 2; i < 1000000; i++){
            int sum = 0;
            for (char c : String.valueOf(i).toCharArray()){
                sum += Math.pow((double)Character.getNumericValue(c), 5);
            }
            if (sum == i){
                System.out.println(i);
                total += i;
            }
        }
        System.out.println("Total: " + total);
    }

	
    public static void main(String[] args) {
        new P030_5thPowers().run();
    }
}
