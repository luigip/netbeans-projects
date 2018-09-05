package topcode.TCHS;

public class S19_500 {
    public String buyXGetY(String regular, String sale) {
        int ym = priceCents(sale);
        int xm = priceCents(regular);
        int g = gcd(ym, xm - ym);
        int X = ym / g;
        int Y = (xm - ym) / g; 
        
        return "BUY " + X + " GET " + Y + " FREE";
    }
    
    private int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
    private int priceCents(String s){
        int dol = Integer.parseInt(s.split("\\.")[0].substring(1));
        int cent = Integer.parseInt(s.split("\\.")[1]);
        return dol * 100 + cent;
    }
    
    public static void main(String[] args) {
        String reg = "$12.34";
        String sal = "$8.64";
        System.out.println(new S19_500().buyXGetY(reg, sal));
    }
}
