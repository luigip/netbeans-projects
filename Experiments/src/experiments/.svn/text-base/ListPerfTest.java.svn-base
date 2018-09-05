
package experiments;

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
        LinkedList[] linkedLists = new LinkedList[100000];
        for (int i = 0; i < 100000; i++) {
            linkedLists[i] = new LinkedList();
            for (int j = 0; j < 100; j++) {
                linkedLists[i].add(j);
            }
        }
        long time = System.nanoTime();
        for(LinkedList list : linkedLists){
//            list.remove(50);
            list.addFirst(0);
//            list.removeLast();
        }
        System.out.printf("LinkedList = %,d %n" , System.nanoTime() - time);
    }

    void testArray(){
        ArrayList[] arrayLists = new ArrayList[100000];
        for (int i = 0; i < 100000; i++) {
            arrayLists[i] = new ArrayList();
            for (int j = 0; j < 100; j++) {
                arrayLists[i].add(j);
            }
        }
        long time = System.nanoTime();
        for(ArrayList list : arrayLists){
//            list.remove(50);
            list.add(0,0);
//            list.remove(99);
        }
        System.out.printf("ArrayList = %,d %n" , System.nanoTime() - time);
    }
}
