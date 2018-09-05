package experiments;

import java.io.*;

public class Box implements Serializable{
    private int height;
    private int width;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public static void main(String[] args) {
        Box myBox = new Box();
        myBox.setHeight(20);
        myBox.setWidth(50);

        try {
            FileOutputStream fs = new FileOutputStream("resources/Foo.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(myBox);
            os.close();


        } catch (Exception e) {e.printStackTrace();
        }

    }

}
