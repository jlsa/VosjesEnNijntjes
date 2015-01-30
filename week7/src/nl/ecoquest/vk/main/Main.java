package nl.ecoquest.vk.main;

import java.util.ArrayList;

import javax.swing.JFrame;

import nl.ecoquest.vk.model.*;
import nl.ecoquest.vk.simulation.Updateable;
import nl.ecoquest.vk.view.*;
import nl.ecoquest.vk.controller.*;

/**
 * The main class, this is the glue of the MVC pattern 
 * and updates everything that needs to be updated
 * @author Joel Hoekstra
 *
 */
public class Main implements Runnable {
	private JFrame screen;
	private SimulatorModel model; 
	private AbstractView fieldView;
	private AbstractView statView;
	private SimulatorController controller;
	
	private ArrayList<Updateable> updateableObjects;
	
	public Main() {
		updateableObjects = new ArrayList<Updateable>();
		model = new SimulatorModel();
		controller = new SimulatorController(model);
		screen = new JFrame("Predator- pray simulator");
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
		
		// yes, this is an endless loop on purpose!
		new Thread(this).start();
	}
	
	/**
	 * Updates all classes with an update method
	 */
	private void update() {
		for(Updateable obj : updateableObjects) {
			obj.update();
		}
	}

	@Override
	public void run() {
		while(true) {
			update();
			try {
				Thread.sleep(10);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
