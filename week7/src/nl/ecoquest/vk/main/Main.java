package nl.ecoquest.vk.main;

import java.util.ArrayList;

import javax.swing.JFrame;

import nl.ecoquest.vk.model.*;
import nl.ecoquest.vk.simulation.Updateable;
import nl.ecoquest.vk.view.*;
import nl.ecoquest.vk.controller.*;

public class Main {
	private JFrame screen;
	private SimulatorModel model; 
	private AbstractView fieldView;
	private AbstractView statView;
	private SimulatorController controller;
	
	private ArrayList<Object> updateableObjects;
	
	public Main() {
		updateableObjects = new ArrayList<Object>();
		model = new SimulatorModel(this);
		controller = new SimulatorController(model);
		screen = new JFrame("Foxes and Rabbits the simulation");
		screen.setSize(800, 600);
		screen.setLocationRelativeTo(null);
		screen.setResizable(false);
		screen.setLayout(null);
		
		fieldView = new FieldView(model);
		statView = new StatView(model);
		
		screen.getContentPane().add(fieldView);
		screen.getContentPane().add(statView);
		screen.getContentPane().add(controller);
		
		fieldView.setBounds(0, 0, 300, 300);
		statView.setBounds(300, 0, 300, 300);
		controller.setBounds(0, 300, 300, 300);
		
		
		updateableObjects.add(controller);
		
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setVisible(true);
	}
	
	/**
	 * Updates all classes with an update method
	 */
	public void update() {
		for(Object obj : updateableObjects) {
			if(obj instanceof Updateable) {
				Updateable updateableObject = (Updateable) obj;
				updateableObject.update();
			}
		}
	}
}
