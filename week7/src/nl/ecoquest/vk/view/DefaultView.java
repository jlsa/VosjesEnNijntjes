package nl.ecoquest.vk.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
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

import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Action;

public class DefaultView extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private AbstractView fieldView;
	private JButton btnRun;
	private JButton btnStep;
	private JButton btnSteps;
	private JButton btnStop;
	private JButton btnStatistics;
	private JButton btnOptions;
	private JPanel buttonPanel;
	private JPanel westContent;
	
	/**
	 * Create the frame.
	 * @param SimulatorModel
	 */
	public DefaultView(SimulatorModel model) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 768);
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
		
		fieldView = new FieldView(model);
		contentPane.add(fieldView, BorderLayout.CENTER);
		fieldView.setLayout(new BorderLayout(0, 0));
		
		JPanel stepPanel = new JPanel();
		fieldView.add(stepPanel, BorderLayout.NORTH);
		
		JPanel populationPanel = new JPanel();
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
		mnFile.add(mntmQuit);
		
		JMenu mnLegend = new JMenu("Legend");
		menuBar.add(mnLegend);
		
		JMenuItem mntmLegend = new JMenuItem("Legend");
		mntmLegend.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, 0));
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
	
	public List<JButton> getButtons(){
		List<JButton> buttons = new LinkedList<JButton>();
		buttons.add(btnRun);
		buttons.add(btnStep);
		buttons.add(btnSteps);
		buttons.add(btnStop);
		buttons.add(btnStatistics);
		buttons.add(btnOptions);
		return buttons;
	}
}
