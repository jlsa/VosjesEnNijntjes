package nl.ecoquest.vk.view;

import javax.swing.JPanel;

import nl.ecoquest.vk.model.SimulatorModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 * @author Angela
 *
 */
public class PieView extends AbstractView {
	
	private static final long serialVersionUID = 1L;

	public PieView(SimulatorModel model){
		super(model);
		
		JFreeChart pieChart = createChart(createDataset(model));
		JPanel piePanel = new ChartPanel(pieChart);
		piePanel.setVisible(true);
	}
	
	private PieDataset createDataset(SimulatorModel model){
		String population = model.getPopulationDetails();
		String[] splitPopulation = population.split(" ");
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		for(int i = 0; i < splitPopulation.length; i += 3){
			dataset.setValue(splitPopulation[i], Double.parseDouble(splitPopulation[i+2]));
		}		
		return dataset;
	}
	
	private JFreeChart createChart(PieDataset dataset){
		JFreeChart chart = ChartFactory.createPieChart(
				"Pie Chart",
				dataset,
				true,
				true,
				false
		);
		return chart;
	}
}