
package projecteuler;

import java.util.ArrayList;
import java.util.List;


public class P002_fibb implements Runnable{
    public void run(){
        List<Integer> list = new ArrayList<Integer>();
        int f = 0;
        int sum = 2;

        list.add(1);
        list.add(2);
        int count = 2;

        while(true){
            f = list.get(count - 2) + list.get(count - 1);
            if (f <= 4000000){
                list.add(f);
            }else break;
            count++;
            if(f%2 == 0) sum += f;
        }
        System.out.println(sum);
    }
}
