package topcode.TCHS;

public class S21_250 {
    public int matchAddress(String address1, String address2) {
        String a1 = address1.replace(" ", "").toLowerCase();
        int a1l = a1.length();
        String a2 = address2.replace(" ", "").toLowerCase();
        int a2l = a2.length();
        if(a1.equals(a2)) return -1;
        int diff = -1;
        for (int i = 0; i < Math.min(a1l, a2l); i++) {
            if(a1.charAt(i) != a2.charAt(i)) return i;
        }
        return Math.min(a1l, a2l);
    }
}
