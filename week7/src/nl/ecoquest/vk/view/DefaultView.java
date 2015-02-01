package nl.ecoquest.vk.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import nl.ecoquest.vk.controller.MenubarController;
import nl.ecoquest.vk.model.SimulatorModel;
import nl.ecoquest.vk.simulation.Updateable;

public class DefaultView extends JFrame implements Updateable{


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnRun;
	private JButton btnStep;
	private JButton btnSteps;
	private JButton btnStop;
	private JButton btnStatistics;
	private JButton btnOptions;
	private JPanel buttonPanel;
	private JPanel westContent;
	private JLabel stepCount;
	private JLabel population;
	private SimulatorModel model;
	
	/**
	 * Create the frame.
	 * @param SimulatorModel
	 */
	public DefaultView(SimulatorModel model, FieldView fieldView) {
		this.model = model;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		
		//add menubar
		JMenuBar menuBar = new JMenuBar();
		makeMenu(menuBar);

		//add panel with content
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(fieldView, BorderLayout.CENTER);
		fieldView.setLayout(new BorderLayout(0, 0));
		
		JPanel stepPanel = new JPanel();
		stepCount = new JLabel("Steps: " + model.getStepsTaken());
		stepPanel.add(stepCount);
		fieldView.add(stepPanel, BorderLayout.NORTH);
		
		JPanel populationPanel = new JPanel();
		population = new JLabel("Population: " + model.getPopulationDetails());
		populationPanel.add(population);
		fieldView.add(populationPanel, BorderLayout.SOUTH);
		
		JPanel westPane = new JPanel();
		contentPane.add(westPane, BorderLayout.WEST);
		
		westContent = new JPanel();
		westPane.add(westContent);
		westContent.setLayout(new BorderLayout(0, 0));
		
		JPanel PLACEHOLDER_FOR_LOGO = new JPanel();
		westContent.add(PLACEHOLDER_FOR_LOGO, BorderLayout.CENTER);
		PLACEHOLDER_FOR_LOGO.setBackground(new Color(255, 255, 204));
		
		addButtons();
		
	}
		
	private JMenuBar makeMenu(JMenuBar menuBar){
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0));
		mntmQuit.addActionListener(new MenubarController());
		mnFile.add(mntmQuit);
		
		JMenu mnLegend = new JMenu("Legend");
		menuBar.add(mnLegend);
		
		JMenuItem mntmLegend = new JMenuItem("Legend");
		mntmLegend.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, 0));
		mntmLegend.addActionListener(new MenubarController());
		mnLegend.add(mntmLegend);
		
		return menuBar;
	}
		
	private void addButtons(){
		buttonPanel = new JPanel();
		westContent.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnRun = new JButton("Run");
		buttonPanel.add(btnRun);
		
		btnStep = new JButton("1 Step");
		buttonPanel.add(btnStep);
		
		btnSteps = new JButton("100 Steps");
		buttonPanel.add(btnSteps);
		
		btnStop = new JButton("Stop");
		buttonPanel.add(btnStop);
		
		JSeparator separator = new JSeparator();
		buttonPanel.add(separator);
		
		btnStatistics = new JButton("Statistics");
		buttonPanel.add(btnStatistics);
		
		btnOptions = new JButton("Options");
		buttonPanel.add(btnOptions);
		}
	
	public void addActionListeners(ActionListener run, ActionListener oneStep, ActionListener step100, ActionListener stop, 
									ActionListener stats, ActionListener options){
		btnRun.addActionListener(run);
		btnStep.addActionListener(oneStep);
		btnSteps.addActionListener(step100);
		btnStop.addActionListener(stop);
		btnStatistics.addActionListener(stats);
		btnOptions.addActionListener(options);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		stepCount.setText("Steps: " + model.getStepsTaken());
		population.setText("Population: " + model.getPopulationDetails());
	}
}
