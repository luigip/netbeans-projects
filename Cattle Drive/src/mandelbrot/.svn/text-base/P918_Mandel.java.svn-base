package mandelbrot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * ASCII Mandelbrot - Problem 918 from UVa Online Judge
 * @author Rhys
 */
public class P918_Mandel {

    static int numGraphs;
    static String[] inputStrings;
    
    final char[] CHARS;
    final double MINI;
    final double MAXI;
    final double MINR;
    final double MAXR;
    final double PRECI;
    final double PRECR;

    public static void main(String[] args) {
        // Read input file named in arguments
        try {
            readInput(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file");
            return;
        }
        // Initialize new graphs and draw them
        for (int i = 0; i < numGraphs; i++) {
            P918_Mandel a = new P918_Mandel(i);
            a.draw();
            if(i < numGraphs - 1) System.out.println();
        }
    }

    static void readInput(String filename) throws FileNotFoundException {
        // Read in input as lines, to be stored in inputStrings
        Scanner sc = new Scanner(new File(filename));
        numGraphs = sc.nextInt();
        inputStrings = new String[numGraphs];
        sc.nextLine();
        for (int i = 0; i < numGraphs; i++) {
            inputStrings[i] = sc.nextLine();
        }
    }

    public P918_Mandel(int graphNumber) {
        // Initialize the graph instance with values from the input string
        Scanner sc = new Scanner(inputStrings[graphNumber]);
        CHARS = sc.next().replace("\"", "").concat(" ").toCharArray();
        MINI = sc.nextDouble();
        MAXI = sc.nextDouble();
        PRECI = sc.nextDouble();
        MINR = sc.nextDouble();
        MAXR = sc.nextDouble();
        PRECR = sc.nextDouble();
        sc.close();
    }

    void draw() {
        // Create lines of symbols by stepping through the graph range
        // Work out rows and columns in advance so rounding does not affect number
        int rows = (int)Math.floor((MAXI - MINI)/PRECI + 1.00001);
        int cols = (int)Math.floor((MAXR - MINR)/PRECR + 1.00001);
        
        double im, re;
        for (int i = 0; i < rows; i++) {
            im = MINI + i * PRECI;
            StringBuilder line = new StringBuilder();
            for (int r = 0; r < cols; r++) {
                re = MINR + r * PRECR;
                line.append(CHARS[getIterations(re, im)]);
            }
            System.out.println(line.toString());
        }
    }

    static int getIterations(final double cr, final double ci) {
        // Iteration is Z -> Z^2 + C
        // Here, Re(C) = cr, Im(C) = ci
        // Z starts at 0, and Re(Z) = zr, Im(Z) = zi
        // Returns number of iterations up to 12 where mag(Z) <= 2
        int count = 0;
        boolean overTwo = false;
        double zr = 0;
        double zi = 0;

        for (int j = 0; !overTwo && j < 12; j++) {
            
            double zrnew = zr * zr - zi * zi + cr;
            double zinew = 2 * zr * zi + ci;
            zr = zrnew;
            zi = zinew;

            if (mag(zr, zi) > 2) overTwo = true;
            else count++;
        }
        return count;
    }

    static double mag(double r, double i) {
        // Returns magnitude of the complex number
        return Math.sqrt(r * r + i * i);
    }
}
