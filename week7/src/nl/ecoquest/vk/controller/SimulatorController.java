package nl.ecoquest.vk.controller;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import nl.ecoquest.vk.model.*;
import nl.ecoquest.vk.simulation.*;

@SuppressWarnings("serial")
public class SimulatorController extends AbstractController implements ActionListener, Updateable {
	
	private JButton stepOne;
	private JTextField steps;
	private JButton stepHundred;
	private JLabel stepsTaken;
	
	public SimulatorController(SimulatorModel model) {
		super(model);	
		setSize(300, 300);
		stepsTaken = new JLabel("Step: ");
		
		stepOne = new JButton("One step");
		stepOne.addActionListener(this);
		stepHundred = new JButton("Hundred steps");
		stepHundred.addActionListener(this);
		
		this.setLayout(null);
		add(stepsTaken);
		add(stepOne);
		add(stepHundred);
		stepsTaken.setBounds(0, 0, 100, 50);
		stepOne.setBounds(0, 50, 100, 50);
		stepHundred.setBounds(0, 100, 100, 50);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == stepOne) {
			model.simulate(1);
		}
		
		if(e.getSource() == stepHundred) {
			model.simulate(1000);
		}
	}
	
	/**
	 * Updates the label with the amount of steps it already runs
	 */
	@Override
	public void update()  {
		stepsTaken.setText("Steps: " + model.getStepsTaken());
	}

}
