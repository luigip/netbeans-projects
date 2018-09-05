package topcoder.set1;

public class Hawaiian {
    public String[] getWords(String sentence){
        String lets = "aeiouhklmnpw";
        String ret = "";
        String[] words = sentence.split(" ");
        for(String word : words){
            boolean valid = true;
            for(char c : word.toCharArray()){
                if(lets.indexOf(Character.toLowerCase(c)) == -1) valid = false;
            }
            if(valid) ret += word + " ";
        }
        return ret.length() == 0 ? new String[0] : ret.split(" ");
    }
    
//    public static void main(String[] args) {
//        Hawaiian h = new Hawaiian();
//        for(String s : h.getWords("Hawaii is an island")){
//            System.out.println(s);
//        }
//    }
}
