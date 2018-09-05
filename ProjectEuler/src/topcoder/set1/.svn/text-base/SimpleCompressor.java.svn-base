package topcoder.set1;

public class SimpleCompressor {
    public String uncompress(String toUncompress){
        StringBuilder res = new StringBuilder();
        if(toUncompress.indexOf('[') == -1){
            return toUncompress;
        }
        int open = toUncompress.indexOf('[');
        int close = toUncompress.indexOf(']');
        while (toUncompress.indexOf('[', open + 1) != -1 && toUncompress.indexOf('[', open + 1) < close){
            open = toUncompress.indexOf('[', open + 1);
            if(open == -1) throw new RuntimeException("open = -1!!");
        }
        String start = toUncompress.substring(0, open);
        String end = toUncompress.substring(close + 1);
        res.append(start);
        String mid = toUncompress.substring(open + 1, close);
        int times = Character.getNumericValue(mid.charAt(0));
        for (int i = 0; i < times ; i++) {
            res.append(uncompress(mid.substring(1)));
        }
        res.append(end);
        
        return res.toString().indexOf('[') == -1 ? res.toString() : uncompress(res.toString());
    }
    
    public static void main(String[] args) {
        String s = "MIPFVP[5KJTT]KVWSFVLQJRUOBPIPHHQTFW[4[8XGO]]SXYGCA";
        System.out.println(new SimpleCompressor().uncompress(s));
    }
}
