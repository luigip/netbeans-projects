package topcoder.set1;

import java.awt.Point;

public class EnclosingRectangle {

    public int smallestArea(String[] X, String[] Y) {
        String xvals = "", yvals = "";
        String[] xarr, yarr;

        for (String s : X) {
            xvals += s;
        }
        for (String s : Y) {
            yvals += s;
        }
        xarr = xvals.split("\\s+");
        yarr = yvals.split("\\s+");

        Point[] points = new Point[xarr.length];
        int xmax = 0, ymax = 0;
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(Integer.parseInt(xarr[i]), Integer.parseInt(yarr[i]));
        }

        int half = (points.length + 1) / 2;
        int minArea = Integer.MAX_VALUE;
        for (Point p1 : points) {
            for (Point p2 : points) {
                for (Point p3 : points) {
                    for (Point p4 : points) {
                        if (    p1.x <= p2.x && p1.x <= p3.x && p1.x <= p4.x &&
                                p2.x >= p3.x && p2.x >= p4.x &&
                                p3.y <= p1.y && p3.y <= p2.y && p3.y <= p4.y &&
                                p4.y >= p1.y && p4.y >= p2.y) {
                            int x1 = p1.x - 1, x2 = p2.x + 1;
                            int y1 = p3.y - 1, y2 = p4.y + 1;
                            
                            int area = (x2 - x1) * (y2 - y1);
                            int[] dims = {x1, x2, y1, y2};
                            int enc = enclosed(dims, points);

                            if (enc >= half && area < minArea) {
                                minArea = area;
                            }
                        }
                    }
                }
            }
        }

        return minArea;
    }

    private int enclosed(int[] dims, Point[] points) {
        int count = 0;
        for (Point p : points) {
            if (p.x > dims[0] && p.x < dims[1] && p.y > dims[2] && p.y < dims[3]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        EnclosingRectangle e = new EnclosingRectangle();
        String[] X = {"5481    3318      5721      9019 ",
            "1618       9762  1654     2275 ",
            "5361    307 6833             9456  ",
            "7473 6088 9685 2725"};
        String[] Y = {"1181     7762        3889    7015 ",
            "    5445   9063        2510           8229 ",
            "   4390      6454   9197    708 ",
            "  2221    9012     2665      8308"};
//        String[] X = { "100", " 200" };
//        String[] Y = { "100 2", "00" };
        System.out.println(e.smallestArea(X, Y));
    }
}
