package nl.ecoquest.vk.view;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import nl.ecoquest.vk.model.SimulatorModel;

public class GraphView extends AbstractView {

	private static final long serialVersionUID = 1L;

	public GraphView(SimulatorModel model) {
		super(model);

		JFreeChart graph = lineChart(createDataset());
		JPanel graphPanel = new ChartPanel(graph);
		graphPanel.setVisible(true);
	}
	
	private DefaultCategoryDataset createDataset(){
	      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	      dataset.addValue( 15 , "Rabits" , "1970" );
	      dataset.addValue( 30 , "Foxes" , "1980" );
	      dataset.addValue( 60 , "Bears" ,  "1990" );
	      dataset.addValue( 300 , "Hunters" , "2014" );
	      return dataset;
	   }
	
    private JFreeChart lineChart(DefaultCategoryDataset dataset){
    	JFreeChart chart = ChartFactory.createLineChart(
            "Line chart",
            "Years","Number of Schools",
            createDataset(),
            PlotOrientation.VERTICAL,
            true,true,false);
		return chart;
    }
}
