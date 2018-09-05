package experiments;

public class FunctionTest {
   
    public static void main(String[] args) {
        final double a = 1.5;
        final int b = 2;
        
        
        System.out.println(new Fn(){{
            if(a > b) rtn(a); else rtn(b);
        }});

    
    }
}



class Fn{
    private Number value;
    public void rtn(Number n){
        value = n;
    }
    @Override
    public String toString(){
        return String.valueOf(value);
    }
}