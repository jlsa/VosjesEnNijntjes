package nl.ecoquest.vk.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.Layer;
import org.jfree.ui.RectangleAnchor;
import org.jfree.ui.TextAnchor;

import nl.ecoquest.vk.model.SimulatorModel;

public class HistoView extends AbstractView {

	public HistoView(SimulatorModel model) {
		super(model);

		JFreeChart histoChart = createChart(createDataset());
		JPanel histoPanel = new ChartPanel(histoChart);
		histoPanel.setVisible(true);
	}
	
	private IntervalXYDataset createDataset(){
		XYSeries series = new XYSeries("Histogram");
		//TODO fix dataset
		series.add(1.0, 40.0);
		series.add(5.0, 734.6);
		series.add(12.5, 23.5);
		series.add(45.7, 345.8);
		XYSeriesCollection dataset = new XYSeriesCollection(series);
		return dataset;
	}
	
	private JFreeChart createChart(IntervalXYDataset dataset){
		JFreeChart chart = ChartFactory.createXYBarChart(
				"Histogram",
				"X",
				false,
				"Y",
				dataset,
				PlotOrientation.VERTICAL,
				true,
				true,
				false
				);
		XYPlot plot = (XYPlot) chart.getPlot();
		IntervalMarker target = new IntervalMarker(400.0, 700.0);
        target.setLabel("Target Range");
        target.setLabelFont(new Font("SansSerif", Font.ITALIC, 11));
        target.setLabelAnchor(RectangleAnchor.LEFT);
        target.setLabelTextAnchor(TextAnchor.CENTER_LEFT);
        target.setPaint(new Color(222, 222, 255, 128));
        plot.addRangeMarker(target, Layer.BACKGROUND);
        return chart;    
	}

}
