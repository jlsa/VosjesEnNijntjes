package nl.ecoquest.vk.view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import nl.ecoquest.vk.model.SimulatorModel;
import nl.ecoquest.vk.simulation.Updateable;

/**
 * StatisticsView is an aggregate of the views generated by
 * PieView, HistoView, GraphView, TextView
 * @author Angela
 *
 */
public class StatisticsView extends JFrame implements Updateable{


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private AbstractView pieView;
	private AbstractView histoView;
	private AbstractView textView;
	private AbstractView graphView;
	private SimulatorModel model;

	/**
	 * Create the frame.
	 * @param model The simulator model
	 */
	public StatisticsView(SimulatorModel model) {
		this.model = model;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 0, 0));
		
		addViews();
	}

	@Override
	public void update() {
		repaint();
	}
	
	private void addViews(){
		pieView = new PieView(model);
		pieView.setVisible(true);
		contentPane.add(pieView);
		
		histoView = new HistoView(model);
		histoView.setVisible(true);
		contentPane.add(histoView);
		
		textView = new TextView(model);
		histoView.setVisible(true);
		contentPane.add(textView);
		
		graphView = new GraphView(model);
		graphView.setVisible(true);
		contentPane.add(graphView);
		
		setSize(getPreferredSize());
	}

}
