package topcode.TCHS;

public class S20_500 {
    public String barcode(String zipCode) {
        StringBuilder sb = new StringBuilder();
        sb.append('H');
        String[] nums = new String[zipCode.length()];
        int tot = 0;
        int j = 0;
        for(char c : zipCode.toCharArray()){
            int i = Character.getNumericValue(c);
            tot += i;
            nums[j] = getBar(i);
            j++;            
        }
        for(String s : nums) sb.append(s);
        sb.append(getBar((10 - tot % 10) % 10));
        sb.append('H');
        return sb.toString();
    }
    private String getBar(int i){
        // unnecessary: just use an array!!
        String s;
        switch (i){
            case 0: s = "HHLLL"; break;
            case 1: s = "LLLHH"; break;
            case 2: s = "LLHLH"; break;
            case 3: s = "LLHHL"; break;
            case 4: s = "LHLLH"; break;
            case 5: s = "LHLHL"; break;
            case 6: s = "LHHLL"; break;
            case 7: s = "HLLLH"; break;
            case 8: s = "HLLHL"; break;
            case 9: s = "HLHLL"; break;
                default: s = "";
        }
        return s;
    }
}
