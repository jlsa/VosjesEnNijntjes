package nl.ecoquest.vk.main;

import java.util.ArrayList;

import nl.ecoquest.vk.controller.ToolbarController;
import nl.ecoquest.vk.model.SimulatorModel;
import nl.ecoquest.vk.simulation.PopulationGenerator;
import nl.ecoquest.vk.simulation.Updateable;
import nl.ecoquest.vk.view.DefaultView;
import nl.ecoquest.vk.view.FieldView;
import nl.ecoquest.vk.view.StatisticsView;

/**
 * The main class, this is the glue of the MVC pattern 
 * and updates everything that needs to be updated
 * @author Joel Hoekstra, Angela Nieboer
 *
 */
public class Main implements Runnable {
	private DefaultView screen;
	private SimulatorModel model; 
	private ToolbarController toolbarController;
	private FieldView fieldView;
	private StatisticsView statsView;
	private PopulationGenerator populationGenerator;
	
	// list with updateable objects
	private ArrayList<Updateable> updateableObjects;

	
	public Main() {
		updateableObjects = new ArrayList<Updateable>();
		
		model = new SimulatorModel();
		populationGenerator = PopulationGenerator.getInstance();
		populationGenerator.setModel(model);
		fieldView = new FieldView(model);
		screen = new DefaultView(model, fieldView);
		statsView = new StatisticsView(model);
		toolbarController = new ToolbarController(model, screen, statsView);
		
		updateableObjects.add(screen);
		updateableObjects.add(statsView);
		
		screen.setVisible(true);
		model.reset();
		
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
