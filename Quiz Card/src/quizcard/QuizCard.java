package quizcard;

import java.io.*;
import java.util.ArrayList;

public class QuizCard implements Serializable {
    private String question;
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public static void writeFile(ArrayList<QuizCard> list, File file){
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
            for(QuizCard card:list){
                os.writeObject(card);
            }
            os.close();
        } catch (Exception e) {System.out.println("File writing error.");
        }
    }
    public static ArrayList<QuizCard> loadFile(File file){
        ArrayList<QuizCard> list = new ArrayList<QuizCard>();
        try {
            ObjectInputStream os = new ObjectInputStream(new FileInputStream(file));
            QuizCard item = null;
            while((item = (QuizCard) os.readObject()) != null){
            list.add(item);
            }
        } catch (Exception e) {System.out.println("File loading error.");
        }
        return list;
    }


}
