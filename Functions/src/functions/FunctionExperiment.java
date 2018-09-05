package functions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FunctionExperiment {
    
    public static final Function1<Integer, String> alphaValue = new Function1<Integer, String>() {
        @Override public Integer apply(String arg1) 
        {            
            int n = 0;
            for(char c : arg1.toLowerCase().toCharArray()) {
                n += c - 'a' + 1; 
            }
            return n;
        }
    };
    
    public static final Function1<String, String> reverse = new Function1<String, String>() {
        @Override public String apply(String arg1) 
        {
            StringBuilder sb = new StringBuilder(arg1);
            return sb.reverse().toString();
        }
    };
    
    public static final Function1<Integer, String> length = new Function1<Integer, String>() {
        @Override public Integer apply(String n) 
        {
            return n.length();
        }
    };
    
    // Function factory
    public static Function1<Character, String> charAt (final int n) {
        return new Function1<Character, String>() {
            @Override public Character apply(String arg1) 
            {
                return arg1.charAt(n);
            }
        };}
            
    static <T, A> List<T> map (List<? extends A> lst, Function1<T, A> f){
        List<T> n = new LinkedList<T>();
        for(A i : lst) {
            n.add(f.apply(i));
        }        
        return n;
    }
    
    static <T> List<T> filter (List<? extends T> lst, Function1<Boolean, T> f) {
        List<T> n = new LinkedList<T>();
        for(T i : lst) {
            if(f.apply(i)) n.add(i);
        }        
        return n;        
    }
    
    public static <T> List<T> List(T... x) {
        List<T> r = new LinkedList<T>();
        r.addAll(Arrays.asList(x));
        return r;
    }
     
    public static void main(String[] args) {

        List<String> lst = List("Joey", "Ann", "Barry");
        
        print(  length.apply("Great!!")              // 7
             ,  map(lst, length)                     // [4, 3, 5]
             ,  map(lst, reverse)                    // [yeoJ, nnA, yrraB]
             ,  map(lst, alphaValue)                 // [55, 29, 64]
             ,  map(map(lst, reverse), charAt(1))   // [e, n, r]
                
             ,  filter (lst, new Function1<Boolean, String>() {
                    @Override public Boolean apply(String arg1) {
                        return alphaValue.apply(arg1) > 30;       // [Joey, Barry]
                }})   
             ); 
        
        List<Integer> lst2 = List(12, 7, 19);
        List<Double> lst3 = List(1.2, 2.5, 4.);
        
        print(  
             
                
             );
    }
    
    // Doesn't do anything special, just saves typing...
    private static void print(Object... x) { for(Object i : x) System.out.println(i); }
}


