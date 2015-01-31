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
//	private AbstractView fieldView;
//	private AbstractView statView;
//	private SimulatorController controller;
	
	// list with updateable objects
	private ArrayList<Updateable> updateableObjects;
	private OptionsView options;
	private LegendView legend;
//	private PieView pieChart;

	
	public Main() {
/*		// instantiate
		updateableObjects = new ArrayList<Updateable>();
		model = new SimulatorModel();
		controller = new SimulatorController(model);
		screen = new JFrame("Predator- pray simulator");
		fieldView = new FieldView(model);
		statView = new StatView(model);
		
		// setup
		screen.setSize(1024, 768);
		screen.setLocationRelativeTo(null);
		screen.setResizable(false);
		screen.setLayout(null);
		
		
		// add
		screen.getContentPane().add(fieldView);
		screen.getContentPane().add(statView);
		screen.getContentPane().add(controller);
		updateableObjects.add(controller);
		
		// give positions
		fieldView.setBounds(0, 0, 300, 300);
		statView.setBounds(300, 0, 300, 300);
		controller.setBounds(0, 300, 300, 300);

		//
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setVisible(true);
		
		// start the simulation
		model.reset();
		
		// yes, this is an endless loop on purpose!
		new Thread(this).start();
*/
		model = new SimulatorModel();
		screen = new DefaultView(model);
		options = new OptionsView(model);
		legend = new LegendView();
		//pieChart = new PieView(model);
		screen.setVisible(true);
		options.setVisible(false);
		legend.setVisible(false);
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
