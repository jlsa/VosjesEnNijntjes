package nl.ecoquest.vk.main;

import javax.swing.JFrame;
import nl.ecoquest.vk.model.*;
import nl.ecoquest.vk.view.*;

public class Main {
	private JFrame screen;
	private SimulatorModel model; 
	private AbstractView fieldView;
	private AbstractView statView;
	
	public Main() {
		model = new SimulatorModel();
		screen = new JFrame("Foxes and Rabbits the simulation");
		screen.setSize(800, 600);
		screen.setLocationRelativeTo(null);
		screen.setResizable(false);
		screen.setLayout(null);
		
		fieldView = new FieldView(model);
		statView = new StatView(model);
		
		
		screen.getContentPane().add(fieldView);
		screen.getContentPane().add(statView);
		
		fieldView.setBounds(0, 0, 300, 300);
		statView.setBounds(300, 0, 300, 300);
		
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setVisible(true);
	}
}
