package quizcard;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class QuizCardBuilder {
    CardBuilderFrame frameB;
    CardViewerFrame frameV;

    ArrayList<QuizCard> list = new ArrayList<QuizCard>();

    public void createGUI(){
        frameB = new CardBuilderFrame();
        frameB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameB.pack();
        frameB.setVisible(true);

        frameV = new CardViewerFrame();
        frameV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameV.pack();
        frameV.setLocation(frameB.getWidth(),0);
        frameV.setVisible(true);

    }

}
