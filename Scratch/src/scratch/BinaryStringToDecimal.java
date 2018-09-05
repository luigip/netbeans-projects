package scratch;

public class BinaryStringToDecimal {
    public static int parseBinary(String s) {
        if(s.length() > 31) 
            throw new IllegalArgumentException("Binary too long");        
        int result = 0;
        int multiplier = 1;
        for(int i = s.length() - 1; i >= 0; i--) {
            int digit = s.charAt(i) - '0';
            if(digit < 0 || digit > 1) 
                throw new NumberFormatException("Invalid digits detected");
            result += digit * multiplier;
            multiplier *= 2;
        }
        return result;
    }

    public static void askForInput() {
        while (true) {
            System.out.print("Plz to be entering some binary > ");
            String s = new java.util.Scanner(System.in).nextLine();
            if(s.equals("q"))
                break;
            try {
                System.out.println("Decimal equivalent: " + String.valueOf(parseBinary(s)));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(parseBinary("101")); // 5
        System.out.println(parseBinary("10101010")); // 170
        try {
            System.out.println(parseBinary("10301"));  // Invalid digit
        }
        catch(NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        askForInput();
        int[] a = {1,2,3};
    }  
    
}
