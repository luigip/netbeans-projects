//package cattledrive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class OOP4_Lookup {

    private static final HashMap<Integer, Thing> things = new HashMap<Integer, Thing>();

    static {
        things.put(101, new Video("Back to the Future", 108, "PG"));
        things.put(102, new Video("Double Dare", 79, "18"));
        things.put(111, new Video("Toy Story", 90, "U"));
        things.put(112, new BookOnTape("Wuthering Heights", "Emily Bronte", "Eddie Izzard"));
        things.put(213, new BookOnTape("Dracula", "Bram Stoker", "Leonard Nimoy"));
        things.put(333, new Furniture("Drawers", 120, "Wood"));
        things.put(312, new Furniture("Table", 90, "Metal"));
    }

    public static void main(String[] args) {
        // Take serial number and write item information to console
        displayItems();
        System.out.println("\"q\" to quit; \"i\" for item list");
        while (true) {
            int serial = getInput();
            if (serial != -1) {
                if (things.keySet().contains(serial)) {
                    System.out.println("Serial: " + serial + things.get(serial).getDescription() + "\n");
                } else {
                    System.out.println("Item number not recognized");
                }
            }
        }
    }

    private static int getInput() {
        int i = -1;
        System.out.print("Enter item serial: ");
        Scanner sc = new Scanner(System.in);
        String token = sc.next();
        if (token.equals("q")) {
            System.exit(0);
        }
        if (token.equals("i")) {
            displayItems();
        } else {
            try {
                i = Integer.parseInt(token);
            } catch (Exception e) {
                System.out.println("Command not recognized");
            }
        }
        return i;
    }

    private static void displayItems() {
        ArrayList<Integer> arr = new ArrayList<Integer>(things.keySet());
        Collections.sort(arr);
        System.out.println("Available items: " + arr);
    }
}

abstract class Thing {

    int serial;

    public abstract String getDescription();
}

class Video extends Thing {

    private String title;
    private int length;
    private String certificate;

    public Video(String title, int length, String certificate) {
        this.title = title;
        this.length = length;
        this.certificate = certificate;
    }

    @Override
    public String getDescription() {
        return ("\nVideo\nTitle: " + title + "\nLength: " + length
                + "\nCert: " + certificate);
    }
}

class BookOnTape extends Thing {

    private String title;
    private String author;
    private String narrator;

    public BookOnTape(String title, String author, String narrator) {
        this.title = title;
        this.author = author;
        this.narrator = narrator;
    }

    @Override
    public String getDescription() {
        return ("\nBook on tape\nTitle: " + title + "\nAuthor: " + author
                + "\nNarrator: " + narrator);
    }
}

class Furniture extends Thing {

    private String type;
    private int size;
    private String material;

    public Furniture(String type, int size, String material) {
        this.type = type;
        this.size = size;
        this.material = material;
    }

    @Override
    public String getDescription() {
        return ("\nFurniture\nType: " + type + "\nSize: " + size
                + "\nMaterial: " + material);
    }
}