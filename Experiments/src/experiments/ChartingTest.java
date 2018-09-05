
package experiments;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class ChartingTest {
    final double v = 20;    // initial velocity of particles
    final double g = -9.81; // gravitational acceleration
    final double h = 100;   // height of explosion
    static final double PI = Math.PI;

    XYSeriesCollection coll = new XYSeriesCollection();

    public static void main(String[] args) {
        ChartingTest p = new ChartingTest();
        p.go();
    }

    public void go(){
        drawGraph();
    }

    public void drawGraph(){

        for (double theta = -Math.PI/2d; theta <= Math.PI / 2d; theta += Math.PI/10d){
            addXYseries(theta);
        }
        JFreeChart chart = ChartFactory.createXYLineChart(
                null, null, null, coll, PlotOrientation.VERTICAL, true, true, true);

        chart.getXYPlot().getDomainAxis().setRange(-100, 150);
        chart.getXYPlot().getRangeAxis().setRange(-110, 40);

        ChartFrame frame = new ChartFrame("Test", chart);
        frame.pack();
        frame.setVisible(true);
    }

    public void addXYseries(double theta){
        XYSeries series = new XYSeries(String.format("%.2f", theta), false);
        for (double y = 20; y  >= -100; y -= 1) {

            double x = getMaxX(theta, y);
            series.add(x, y);
        }
        coll.addSeries(series);
    }

    public double getMaxX(double theta, double y) {

        double maxX = v * Math.cos(theta)
                * (-v * Math.sin(theta) / g
                + Math.sqrt(2 * y / g + Math.pow(v * Math.sin(theta) / g, 2)));
        return maxX;
    }
}
