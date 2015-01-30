package nl.ecoquest.vk.model;


import java.util.*;
import java.awt.Color;

import nl.ecoquest.vk.model.AbstractModel;
import nl.ecoquest.vk.simulation.*;
import nl.ecoquest.vk.view.FieldView;
import nl.ecoquest.vk.actor.*;
import nl.ecoquest.vk.actor.animal.*;


/**
 * A predator-pray simulator model, based on a rectangular field
 * containing actors living by made up rules
 * @author Joel Hoekstra
 * @since 2015-01-28
 * @version 2015-01-28
 */
public class SimulatorModel extends AbstractModel implements Runnable
{
	private double FOX_CREATION_PROBABILITY = 0.05;
	private double RABBIT_CREATION_PROBABILITY = 0.08;
	
	private static final Color EMPTY_COLOR = Color.WHITE;
	private static final Color UNKNOWN_COLOR = Color.GRAY;
	
	// The number of steps the simulation has to run
	private int numOfSteps = 100;
	
	// List of actors in the field
	private List<Actor> actors;
	// The current field
	private Field field;
	
	// the field statistics
	private FieldStats fieldStats;
	
	// The current step of the simulation
	private int step;
	
	
	private boolean run;
	private boolean runInfinite;
	
	// the time in microseconds the thread sleeps each cycle (Cannot be lower then 10)
	private int sleepTime = 10; // 1000 is 1 second
	
	private LinkedHashMap<Class<?>, Color> colors;
		
	public SimulatorModel() 
	{
		actors = new ArrayList<Actor>();
		colors = new LinkedHashMap<Class<?>, Color>();
		fieldStats = new FieldStats();
		field = new Field(150, 150);
		run = false;
		runInfinite = false;
		
		// set the color of each actor that is on the field
		colors.put(Fox.class, Color.ORANGE); // foxes are red/orange in nature
		colors.put(Rabbit.class, Color.DARK_GRAY); // gray/brown rabbits
	}
	
	public void simulate(int steps) 
	{
		if(steps <= 0) { return; }
		if(run) { return; }
		numOfSteps = steps;
		run = true;
		new Thread(this).start();
	}
	
	public void simulateInfinite() {
		runInfinite = true;
		if(run) { return; }
		run = true;
		new Thread(this).start();
	}
	
	private void simulateOneStep() {
		// do 1 step
		step++;
		System.out.println("steps: " + step);
		
		// provide space for newborn animals
		List<Actor> newActors = new ArrayList<Actor>();
		
		try {
			// let all actors act
			for(Iterator<Actor> it = actors.iterator(); it.hasNext();)  {
				Actor actor = it.next();
				actor.act(newActors);
				if(!actor.isActive()) {
					it.remove();
				}
			}
			
			actors.addAll(newActors);
			notifyViews();
		} catch(Exception e) {
			System.err.println(e);
		}
	}
	
	public void stop() 
	{
		run = false;
	}
	
	/**
	 * Reset the simulation to a starting position
	 */
	public void reset()
	{
		step = 0;
		actors.clear();
		populate();
		notifyViews();
	}
	
	/**
	 * Return the field
	 * @return field
	 */
	public Field getField() 
	{
		return field;
	}
	/**
	 * Random populate the field with Actors
	 */
	private void populate() 
	{
		Random rand = Randomizer.getRandom();
		field.clear();
		for(int row = 0; row < field.getDepth(); row++) {
			for(int col = 0; col < field.getWidth(); col++) {
				if(rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
					Location location = new Location(row, col);
					Fox fox = new Fox(field, location);
					actors.add(fox);
				}
				if(rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
					Location location = new Location(row, col);
					Rabbit rabbit = new Rabbit(field, location);
					actors.add(rabbit);
				}
			}
		}
		
		update();
	}
	
	/**
	 * Updates the Simulation, counts and renders etc.
	 */
	public void update()
	{
		if(views.size() > 0) {
			if(!views.get(0).isVisible()) {
				views.get(0).setVisible(true);
			}
			fieldStats.reset();
			
			views.get(0).preparePaint();
			
			for(int row = 0; row < field.getDepth(); row++) {
				for(int col = 0; col < field.getWidth(); col++) {
					Object actor = field.getObjectAt(row, col);
					if(actor != null) {
						render(col, row, getColor(actor.getClass()));
						fieldStats.incrementCount(actor.getClass());
					} else {
						render(col, row, EMPTY_COLOR);
					}
				}
			}
			
			fieldStats.countFinished();	

			if(views.get(0) instanceof FieldView) {
				FieldView fieldView = (FieldView)views.get(0);
				fieldView.repaint();
			}
		}
		
		notifyViews();
		System.out.println("updating");
		
	}
	
	private void render(int col, int row, Color color) {
		if(views.size() > 0) {
			if(views.get(0) instanceof FieldView) {
				FieldView view = (FieldView)views.get(0);
				view.g.setColor(color); //(col, row, color);
				view.g.fillRect(col * view.xScale, row * view.yScale, view.xScale-1, view.yScale-1);
			}
		}
	}
	
	private Color getColor(Class<?> actorClass) {
		Color c = colors.get(actorClass);
		if(c == null) {
			return UNKNOWN_COLOR;
		} else {
			return c;
		}
	}

	@Override
	public void run() {
		if(!runInfinite) {
			for(int i=0;i<numOfSteps && run;i++) {
				simulateOneStep();
				update();
				try {
					if(sleepTime <= 10) {
						sleepTime = 10;
					}
					Thread.sleep(sleepTime);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			while(run && runInfinite) {
				simulateOneStep();
				update();
				try {
					if(sleepTime <= 10) {
						sleepTime = 10;
					}
					Thread.sleep(sleepTime);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		run = false;
	}
	
	
	/**
	 * Returns the amount of steps the simulation currently has walked through
	 * @return int
	 */
	public int getStepsTaken() {
		return step;
	}
	
	/**
	 * Returns the populations details
	 * @return the population details in format
	 */
	public String getPopulationDetails() {
		return fieldStats.getPopulationDetails(field);
	}
	
	
}
