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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 0, 0));
		
		pieView = new pieView(model);
		//JPanel PLACEHOLDER_FOR_PIEVIEW = new JPanel();
		contentPane.add(pieView);
		
		histoView = new HistoView(model);
		//JPanel PLACEHOLDER_FOR_HISTOVIEW = new JPanel();
		contentPane.add(histoView);
		
		textView = new textView(model);
		//JPanel PLACEHOLDER_FOR_TEXTVIEW = new JPanel();
		contentPane.add(textView);
		
		graphView = new graphView(model);
		//JPanel PLACEHOLDER_FOR_GRAPH_VIEW = new JPanel();
		contentPane.add(graphView);
	}

}
