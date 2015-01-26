package nl.ecoquest.vk.controller;

import java.awt.event.*;

import javax.swing.*;

import nl.ecoquest.vk.exception.*;
import nl.ecoquest.vk.logic.*;

public class RunController extends AbstractController implements ActionListener 
{
	private JButton stepOne;
	private JTextField steps;
	private JButton startSteps;
	private JButton stepHundred;
	private JButton stepLong;
	private JButton stopSteps;
	private JLabel stepsTaken;
	
	public RunController(FRLogic frLogic) {
		super(frLogic);
		setSize(450, 50);
			
		stepsTaken = new JLabel("Step: "); 
		
		stepOne = new JButton("One step");
		stepOne.addActionListener(this);
		
		steps = new JTextField("100");
		
		startSteps = new JButton("Start");
		startSteps.addActionListener(this);
		
		stopSteps = new JButton("Stop");
		stopSteps.addActionListener(this);
		
		this.setLayout(null);
		add(stepsTaken);
		
		add(stepOne);
		add(steps);
		add(startSteps);
		add(stopSteps);
		
		stepsTaken.setBounds(400, 10, 70, 30);
		stepOne.setBounds(50, 10, 70, 30);
		steps.setBounds(140, 10, 70, 30);
		startSteps.setBounds(229, 10, 70, 30);
		stopSteps.setBounds(319, 10, 70, 30);
		
		setVisible(true);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == stepOne) {
			try {
				frLogic.doStep();
			} catch(FRException ex) {
				ex.getStackTrace();
			}
			return;
		}
		
		if(e.getSource() == startSteps) {
			try {
				int steps = parseSteps();
				if(steps < 1 || steps > 1000) {
					throw new FRException("Illigal number of steps");	
				}
				frLogic.doSteps(steps); //.doSteps(steps);
			} catch(Exception ex) {
				ex.printStackTrace();
			}
			return;
		}
		
		if(e.getSource() == stopSteps) {
			frLogic.stopSteps();
		}
	}
	
	private int parseSteps() throws NumberFormatException {
		return Integer.parseInt(steps.getText());
	}
	
	public void setSteps() {
		stepsTaken.setText("Steps: " + frLogic.getStepsTaken());
		System.out.println("steps: " + frLogic.getStepsTaken());
	}
}
