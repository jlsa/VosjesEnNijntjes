package nl.ecoquest.vk.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import nl.ecoquest.vk.model.SimulatorModel;

public class DefaultView extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private AbstractView fieldView;
	
	/**
	 * Create the frame.
	 * @param SimulatorModel
	 */
	public DefaultView(SimulatorModel model) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setResizable(false);
		
		//add menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0));
		mnFile.add(mntmQuit);
		
		JMenu mnLegend = new JMenu("Legend");
		menuBar.add(mnLegend);
		
		JMenuItem mntmLegend = new JMenuItem("Legend");
		mntmLegend.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, 0));
		mnLegend.add(mntmLegend);
		
		//add panel with content
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		fieldView = new FieldView(model);
		//JPanel PLACEHOLDER_FOR_FIELDVIEW = new JPanel();
		//PLACEHOLDER_FOR_FIELDVIEW.setBackground(new Color(255, 204, 255));
		contentPane.add(fieldView, BorderLayout.CENTER);
		fieldView.setLayout(new BorderLayout(0, 0));
		
		JPanel stepPanel = new JPanel();
		fieldView.add(stepPanel, BorderLayout.NORTH);
		
		JPanel populationPanel = new JPanel();
		fieldView.add(populationPanel, BorderLayout.SOUTH);
		
		JPanel westPane = new JPanel();
		contentPane.add(westPane, BorderLayout.WEST);
		
		JPanel westContent = new JPanel();
		westPane.add(westContent);
		westContent.setLayout(new BorderLayout(0, 0));
		
		JPanel PLACEHOLDER_FOR_LOGO = new JPanel();
		westContent.add(PLACEHOLDER_FOR_LOGO, BorderLayout.CENTER);
		PLACEHOLDER_FOR_LOGO.setBackground(new Color(255, 255, 204));
		
		JPanel buttonPanel = new JPanel();
		westContent.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JButton btnRun = new JButton("Run");
		buttonPanel.add(btnRun);
		
		JButton btnStep = new JButton("1 Step");
		buttonPanel.add(btnStep);
		
		JButton btnSteps = new JButton("100 Steps");
		buttonPanel.add(btnSteps);
		
		JButton btnStop = new JButton("Stop");
		buttonPanel.add(btnStop);
		
		JSeparator separator = new JSeparator();
		buttonPanel.add(separator);
		
		JButton btnStatistics = new JButton("Statistics");
		buttonPanel.add(btnStatistics);
		
		JButton btnOptions = new JButton("Options");
		buttonPanel.add(btnOptions);
		
	}


}
