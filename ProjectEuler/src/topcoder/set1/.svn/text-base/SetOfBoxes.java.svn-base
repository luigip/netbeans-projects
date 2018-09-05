package topcoder.set1;

import java.util.ArrayList;
import java.awt.Point;
import static java.lang.Math.*;

public class SetOfBoxes {

    public double countThrow(String[] boxes, int inBox) {
        ArrayList<Triangle> triangles = new ArrayList<Triangle>();
        for (String s : boxes) {
            String[] points = s.split("[. ]");
            Point[] p = new Point[3];
            for (int i = 0; i < 3; i++) {
                p[i] = new Point(Integer.parseInt(points[2 * i]), Integer.parseInt(points[2 * i + 1]));
            }
            Triangle t = new Triangle(p[0], p[1], p[2]);

            for (Triangle u : triangles) {
                if (bIsInA(u, t)) {
                    t.level = Math.max(t.level, u.level + 1);
                }
                if(bIsInA(t, u)){
                    u.level++;
                }
            }
            triangles.add(t);
        }
        double levelArea = 0;
        for (Triangle t : triangles) {
            if (t.level == inBox) {
                levelArea += t.getArea();
            }
            if (t.level == inBox + 1) {
                levelArea -= t.getArea();
            }
        }

        return inBox == 0 ? (10000 + levelArea) / 10000
                : levelArea / 10000;
    }

    private static boolean bIsInA(Triangle a, Triangle b) {
        boolean bIsInA = (a.includesPoint(b.p1) && a.includesPoint(b.p2) && a.includesPoint(b.p3));
        return bIsInA;
    }
}

class Triangle {

    Point p1, p2, p3;
    int level = 1;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public double getArea() {
        return (double) abs(p1.x * p2.y + p2.x * p3.y + p3.x * p1.y - p1.x * p3.y - p3.x * p2.y - p2.x * p1.y) / 2;
    }

    public boolean includesPoint(Point p) {
        // If P in ABC,
        // Area PAB+Area PBC +Area PAC=Area ABC
        double ABC = getArea();
        double PAB = new Triangle(p, p1, p2).getArea();
        double PBC = new Triangle(p, p2, p3).getArea();
        double PAC = new Triangle(p, p1, p3).getArea();
        return abs(ABC - (PAB + PBC + PAC)) < 0.000000001;
    }

    public static void main(String[] args) {
        SetOfBoxes s = new SetOfBoxes();
//        Triangle t1 = new Triangle(new Point(1, 0), new Point(3, 3), new Point(0, 2));
//        Triangle t2 = new Triangle(new Point(2, 1), new Point(2, 8), new Point(1, 3));
//        Point p1 = new Point(2, 3);
//        System.out.println(t1.getArea());
//        System.out.println(t1.includesPoint(p1));

        String[] in = {"30.30 40.30 30.40", "29.29 42.29 29.42", "28.28 44.28 28.44", "27.27 46.27 27.46", "26.26 48.26 26.48", "25.25 50.25 25.50", "24.24 52.24 24.52", "23.23 54.23 23.54", "22.22 56.22 22.56", "21.21 58.21 21.58", "20.20 60.20 20.60", "19.19 62.19 19.62", "18.18 64.18 18.64", "17.17 66.17 17.66", "16.16 68.16 16.68", "15.15 70.15 15.70", "14.14 72.14 14.72", "13.13 74.13 13.74", "12.12 76.12 12.76", "11.11 78.11 11.78", "10.10 80.10 10.80", "9.9 82.9 9.82", "8.8 84.8 8.84", "7.7 86.7 7.86", "6.6 88.6 6.88", "5.5 90.5 5.90", "4.4 92.4 4.92", "3.3 94.3 3.94", "2.2 96.2 2.96", "1.1 98.1 1.98", "28.94 34.68 97.76", "66.52 74.30 54.67", "99.100 61.91 76.85", "68.67 96.22 84.57", "79.85 100.80 92.86", "96.18 78.46 78.36", "89.52 89.71 82.63", "77.75 43.77 41.90", "55.85 76.81 75.76", "96.7 99.9 100.61", "93.10 93.20 72.40", "70.45 66.60 70.46", "10.93 39.95 2.99", "98.2 76.24 62.42", "92.67 95.74 94.53", "100.95 83.89 73.83", "51.99 45.90 72.98", "96.58 92.47 98.62", "93.40 88.51 92.39", "25.88 19.81 19.83"};
        System.out.println(s.countThrow(in, 2));
    }
}