package nl.ecoquest.vk.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import nl.ecoquest.vk.model.SimulatorModel;
import nl.ecoquest.vk.simulation.Updateable;

@SuppressWarnings("serial")
public class SimulatorController extends AbstractController implements ActionListener, Updateable {
	
	private JButton stepOne;
	private JButton stepHundred;
	private JLabel stepsTaken, populationDetails;
	private JButton stopSteps;
	
	public SimulatorController(SimulatorModel model) {
		super(model);	
		stepsTaken = new JLabel("Step: ");
		populationDetails = new JLabel("Population: ");
		
		stepOne = new JButton("One step");
		stepOne.addActionListener(this);
		stepHundred = new JButton("Hundred steps");
		stepHundred.addActionListener(this);
		
		stopSteps = new JButton("Stop");
		stopSteps.addActionListener(this);
		
		this.setLayout(null);
		add(stepsTaken);
		add(populationDetails);
		add(stepOne);
		add(stepHundred);
		add(stopSteps);
		
		stepsTaken.setBounds(0, 0, 100, 50);
		stepOne.setBounds(0, 50, 100, 50);
		stepHundred.setBounds(0, 100, 100, 50);
		stopSteps.setBounds(0, 150, 100, 50);
		populationDetails.setBounds(0, 200, 300, 50);
		
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
		
		if(e.getSource() == stopSteps) {
			model.stop();
		}
	}
	
	/**
	 * Updates the label with the amount of steps it already runs
	 */
	@Override
	public void update()  {
		stepsTaken.setText("Steps: " + model.getStepsTaken());
		populationDetails.setText("Population: " + model.getPopulationDetails());
	}

}
