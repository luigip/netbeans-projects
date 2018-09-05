package experiments;

public class HaveAConversation {
    
    public static void main(String[] args) {
        pr("Enter your name");
        pr("Hello " + rd());
        pr("What's the weather like?");
        pr("Great, I like it when it's " + rd() + ".");
        pr("Do you know the meaning of life?");
        if(rd().equals("42")) pr("Correct! Your computer lives another day.");
        else pr("Wrong... deleting all your files!");
    }
    
    static void pr(String s) { System.console().writer().println(s); }
    static String rd() { return System.console().readLine(); }
}
