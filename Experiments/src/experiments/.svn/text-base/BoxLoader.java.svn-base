package experiments;


import java.io.FileInputStream;
import java.io.ObjectInputStream;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class BoxLoader {
    public static void main(String[] args) {
        new BoxLoader().loadFile();
    }
    void loadFile(){
        try {
            FileInputStream fi = new FileInputStream("resources/Foo.ser");
            ObjectInputStream os = new ObjectInputStream(fi);
            Box restoredBox = (Box) os.readObject();
            System.out.println("Box height: " + restoredBox.getHeight());
            System.out.println("Box width: " + restoredBox.getWidth());
        } catch (Exception e) {e.printStackTrace();
        }


    }
}
