package experiments;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListAdd {
    
    static List<Integer> add2 (List<Integer> lst) throws Exception {
        List<Integer> res = lst.getClass().newInstance();
        for (Integer i : lst) res.add(i + 2);
        return res;
    }
    
    // Let's test it with some obscure list type!
    //
//    public static void main(String[] args) throws Exception {
//        List<Integer> t = new CopyOnWriteArrayList<Integer> ();
//        for (int i : new int[]{1,2,3}) t.add(i);
//        
//        List<Integer> res = add2(t);
//        
//        assert ( t.  equals( Arrays.asList(1,2,3)) );
//        assert ( res.equals( Arrays.asList(3,4,5)) );
//        assert ( res.getClass() == t.getClass() );
//    }
    
    public static void main(String[] args) throws Exception{
        List<Integer> t = new CopyOnWriteArrayList<Integer> ();
        for (int i : new int[]{1,2,3}) t.add(i);
        
        List<Integer> res = add3(t);
        System.out.println(res);
        System.out.println(res.getClass());
        ArrayList<Integer> a = new ArrayList<Integer>();
//        System.out.println(a.getClass() == List<Integer>.class);
    }
    
    static <T extends List<Integer>> T add3 (T lst) {
        T res;
        try {
            res = (T) lst.getClass().newInstance();
            
        } catch (InstantiationException e) {
            throw new IllegalArgumentException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        for (Integer i : lst) res.add(i + 2);
        return res;
    }    
    
    
//    static List<Integer> add2 (List<Integer> lst) {
//        List<Integer> res;
//        if(lst instanceof LinkedList) res = new LinkedList<Integer>();
//        else if(lst instanceof Vector) res = new Vector<Integer>();
//        else if(lst instanceof Stack) res = new Stack<Integer>();       
//        else res = new ArrayList<Integer>();
//             
//        for (Integer i : lst) res.add(i + 2);
//        return res;
//    }
    


}
