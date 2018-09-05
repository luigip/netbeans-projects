


package myappthatusesfreechart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class FunctionTest {
    public static void main(String[] args) {
        XYSeries series = new XYSeries("f(x)", true);
        for (double i = -4; i <= 4; i += 0.2) {
            series.add(i, Math.pow(i, 2) + 2);
        }
        XYSeriesCollection collection = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart("y = x^2", "x", "y", collection, PlotOrientation.VERTICAL, true, true, false);

        ChartFrame frame = new ChartFrame("Test", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
