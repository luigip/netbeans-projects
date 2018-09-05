package topcoder.set1;

import java.util.*;


public class ListPerfTest {
    public static void main(String[] args) {
        ListPerfTest t = new ListPerfTest();
        t.testLinked();
        t.testArray();
        t.testLinked();
        t.testArray();
    }

    void testLinked(){
        LinkedList[] linkedLists = new LinkedList[50];
        for (int i = 0; i < 50; i++) {
            linkedLists[i] = new LinkedList();
            for (int j = 0; j < 100000; j++) {
                linkedLists[i].add(j);
            }
        }
        long time = System.nanoTime();
        for(LinkedList list : linkedLists){
            list.remove(50);
        }
        System.out.printf("LinkedList = %,d %n" , System.nanoTime() - time);
    }

        void testArray(){
        ArrayList[] arrayLists = new ArrayList[50];
        for (int i = 0; i < 50; i++) {
            arrayLists[i] = new ArrayList();
            for (int j = 0; j < 100000; j++) {
                arrayLists[i].add(j);
            }
        }
        long time = System.nanoTime();
        for(ArrayList list : arrayLists){
            list.remove(50);
        }
        System.out.printf("ArrayList = %,d %n" , System.nanoTime() - time);
    }
}