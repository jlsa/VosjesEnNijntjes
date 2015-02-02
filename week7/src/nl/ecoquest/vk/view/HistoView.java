package nl.ecoquest.vk.view;

import nl.ecoquest.vk.model.SimulatorModel;
import nl.ecoquest.vk.simulation.Updateable;

/**
 * HistoView is a representation of the data the simulation outputs
 * in a simple histogram
 * @author Angela
 *
 */

public class HistoView extends AbstractView implements Updateable{

	private static final long serialVersionUID = 1L;
//TODO fix HistoView
	public HistoView(SimulatorModel model) {
		super(model);

//		JFreeChart histoChart = createChart(createDataset());
//		JPanel histoPanel = new ChartPanel(histoChart);
//		histoPanel.setVisible(true);
//		this.add(histoPanel);
//		this.setVisible(true);
	}
	
//	private IntervalXYDataset createDataset(){
//		XYSeries series = new XYSeries("Histogram");
//		//TODO fix dataset
//		series.add(1.0, 40.0);
//		series.add(5.0, 734.6);
//		series.add(12.5, 23.5);
//		series.add(45.7, 345.8);
//		XYSeriesCollection dataset = new XYSeriesCollection(series);
//		return dataset;
//	}
//	
//	private JFreeChart createChart(IntervalXYDataset dataset){
//		JFreeChart chart = ChartFactory.createXYBarChart(
//				"Histogram",
//				"X",
//				false,
//				"Y",
//				dataset,
//				PlotOrientation.VERTICAL,
//				true,
//				true,
//				false
//				);
//		XYPlot plot = (XYPlot) chart.getPlot();
//		IntervalMarker target = new IntervalMarker(400.0, 700.0);
//        target.setLabel("Target Range");
//        target.setLabelFont(new Font("SansSerif", Font.ITALIC, 11));
//        target.setLabelAnchor(RectangleAnchor.LEFT);
//        target.setLabelTextAnchor(TextAnchor.CENTER_LEFT);
//        target.setPaint(new Color(222, 222, 255, 128));
//        plot.addRangeMarker(target, Layer.BACKGROUND);
//        return chart;    
//	}

	@Override
	public void update() {
		super.updateView();		
	}

}
