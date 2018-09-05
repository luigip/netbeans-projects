package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class P018_triangle implements Runnable{
    String filename = "P067_triangle.txt";
    public void run(){
        ArrayList<ArrayList<Node>> triangle = loadTriangle();
        int rows = triangle.size();
        for (Node n : triangle.get(rows - 1)){
            n.bestSum = n.value;
        }
        for (int i = rows - 2; i >= 0; i--) {
            for (Node n : triangle.get(i)){
                int valA = triangle.get(i + 1).get(n.index).bestSum;
                int valB = triangle.get(i + 1).get(n.index + 1).bestSum;
                n.bestSum = n.value + Math.max(valA, valB);
            }
        }
        System.out.println(triangle.get(0).get(0).bestSum);

    }

    ArrayList<ArrayList<Node>> loadTriangle(){
        ArrayList<ArrayList<Node>> triangle = new ArrayList<ArrayList<Node>>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null){
                ArrayList<Node> a = new ArrayList<Node>();
                String[] nums = line.split(" ");
                  for (int i = 0; i < nums.length; i++){
                    Node n = new Node();
                    n.value = Integer.parseInt(nums[i]);
                    n.index = i;
                    a.add(n);
                }
                triangle.add(a);
            }
        } catch (Exception e) { System.out.println("File read error");
        }
        return triangle;
    }

    class Node{
        int value;
        int bestSum;
        int index;
    }


    public static void main(String[] args) {
        new P018_triangle().run();
    }
}
