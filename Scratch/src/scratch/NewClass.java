package scratch;

import java.util.Scanner;

public class NewClass {
    
    public static void main(String[] args) {
        Scanner lines = new Scanner(System.in);
        System.out.println("Enter gender");
        String genderInput = lines.nextLine();
        while(!genderInput.equals("stop")) {
            System.out.println("Enter two numbers");
            String s = getInput(lines, "[0-9]* [0-9]*");
            Scanner sc = new Scanner(s).useDelimiter(" ");
            System.out.printf("%s %s %n", sc.nextInt() + 1, sc.nextInt() -1);
            genderInput = lines.nextLine();
        }         
    }
    
    static String getInput(Scanner lines, String regex) {      
        System.out.println("parsing");
                
        String s = lines.nextLine();
        while (!s.matches(regex)) {
            System.out.println("Invalid input; please try again");
            s = lines.nextLine();
        }
        return s;
    }

}

