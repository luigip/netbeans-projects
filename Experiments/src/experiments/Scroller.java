package experiments;

public class Scroller {

    public static void main(String[] args) throws Exception {
        
        String s = System.console().readLine("Enter a string: ");
		  //String s = new java.util.Scanner(System.in).nextLine();
        while(true){
            System.out.print("\r" + s);
            Thread.sleep(100);
            s = s.substring(1) + s.substring(0,1);
        }
    }
}

