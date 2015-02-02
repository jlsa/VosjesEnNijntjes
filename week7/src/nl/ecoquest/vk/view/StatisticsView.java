package nl.ecoquest.vk.view;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import nl.ecoquest.vk.model.SimulatorModel;

public class StatisticsView extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private AbstractView pieView;
	private AbstractView histoView;
	private AbstractView textView;
	private AbstractView graphView;

	/**
	 * Create the frame.
	 * @param SimulatorModel
	 */
	public StatisticsView(SimulatorModel model) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 0, 0));
		
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
	}

}
