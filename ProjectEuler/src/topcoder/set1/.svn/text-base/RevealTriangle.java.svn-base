package topcoder.set1;

public class RevealTriangle {
    //SRM 404 DIV 1

    public String[] calcTriangle(String[] questionMarkTriangle) {
        for (int i = questionMarkTriangle.length - 1; i >= 0; i--) {
            boolean repeat = false;
            for (int j = 0; j < questionMarkTriangle.length - i; j++) {
                if (questionMarkTriangle[i].charAt(j) == '?') {
                    if (!(j == questionMarkTriangle.length - i - 1) && questionMarkTriangle[i].charAt(j + 1) != '?') {
                        int r = Character.getNumericValue(questionMarkTriangle[i].charAt(j + 1));
                        int b = Character.getNumericValue(questionMarkTriangle[i + 1].charAt(j));
                        int t = (b - r + 10) % 10;
                        questionMarkTriangle[i] = questionMarkTriangle[i].substring(0, j) + t + 
                                questionMarkTriangle[i].substring(j + 1);
                    }else if(!(j == 0) && questionMarkTriangle[i].charAt(j - 1) != '?'){
                        int l = Character.getNumericValue(questionMarkTriangle[i].charAt(j - 1));
                        int bl = Character.getNumericValue(questionMarkTriangle[i + 1].charAt(j - 1));
                        int t = (bl - l + 10) % 10;
                        questionMarkTriangle[i] = questionMarkTriangle[i].substring(0, j) + t + 
                                questionMarkTriangle[i].substring(j + 1);
                    }
                    else repeat = true;
                }
            }
            if(repeat) i++;
        }
        return questionMarkTriangle;
    }
    
    public static void main(String[] args) {
        String[] a = {"??5?", "??9", "?4", "6"};
        RevealTriangle r = new RevealTriangle();
        for( String s : r.calcTriangle(a)) System.out.println(s);
    }
}
