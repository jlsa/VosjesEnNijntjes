package nl.ecoquest.vk.simulation;

import java.util.LinkedHashMap;
import java.util.List;

import nl.ecoquest.vk.actor.Actor;
import nl.ecoquest.vk.actor.animal.Animal;
import nl.ecoquest.vk.actor.animal.Rabbit;
import nl.ecoquest.vk.actor.animal.Fox;
import nl.ecoquest.vk.actor.animal.Bear;
import nl.ecoquest.vk.model.SimulatorModel;

/**
 * The PopulationGenerator exists to generate the population
 * This is a Singleton
 * @author Angela, Joel
 *
 */
public class PopulationGenerator 
{
	private static PopulationGenerator instance = null;
	private SimulatorModel model;
	private LinkedHashMap<String, Number> rabbitSettings;
	private LinkedHashMap<String, Number> foxSettings;
	private LinkedHashMap<String, Number> bearSettings;
	private LinkedHashMap<String, Number> hunterSettings;
	
	/**
	 * We only want one instance of PopulationGenerator
	 */
	private PopulationGenerator(){
		rabbitSettings = new LinkedHashMap<String, Number>();
		rabbitSettings.put("breedingAge", Integer.valueOf(Rabbit.breedingAge));
		rabbitSettings.put("maxAge", Integer.valueOf(Rabbit.maxAge));
		rabbitSettings.put("breedingProbability", Double.valueOf(Rabbit.breedingProbability));
		rabbitSettings.put("maxLitterSize", Integer.valueOf(Rabbit.maxLitterSize));
		rabbitSettings.put("foodValue", Integer.valueOf(Rabbit.foodValue));
		
		foxSettings = new LinkedHashMap<String, Number>();
		foxSettings.put("breedingAge", Integer.valueOf(Fox.breedingAge));
		foxSettings.put("maxAge", Integer.valueOf(Fox.maxAge));
		foxSettings.put("breedingProbability", Double.valueOf(Fox.breedingProbability));
		foxSettings.put("maxLitterSize", Integer.valueOf(Fox.maxLitterSize));
		foxSettings.put("foodValue", Integer.valueOf(Fox.foodValue));
		
		bearSettings = new LinkedHashMap<String, Number>();
		bearSettings.put("breedingAge", Integer.valueOf(Bear.breedingAge));
		bearSettings.put("maxAge", Integer.valueOf(Bear.maxAge));
		bearSettings.put("breedingProbability", Double.valueOf(Bear.breedingProbability));
		bearSettings.put("maxLitterSize", Integer.valueOf(Bear.maxLitterSize));
		bearSettings.put("foodValue", Integer.valueOf(Bear.foodValue));
		
		hunterSettings = new LinkedHashMap<String, Number>();
	}
	
	/**
	 * Get the instance of population generator. There can only be ONE!
	 * @return instance
	 */
	public static PopulationGenerator getInstance(){
		if(instance == null){instance = new PopulationGenerator();}
		return instance;
	}
	
	/**
	 * This method generates a new instance from the given  
	 * @param actorClass
	 * @param field
	 * @param location
	 * @return
	 */
	public static Animal generateAnimal(Class<?> actorClass, Field field, Location location){
		Animal actor = null;
		if(actorClass == Rabbit.class) {
			actor = new Rabbit(field, location);
		} else if(actorClass == Fox.class) {
			actor = new Fox(field, location);
		} else if(actorClass == Bear.class) {
			actor = new Bear(field, location);
		}
		
		if(actor != null) {
			actor.setBreedingAge(getInstance().getBreedingAge(actorClass));
			actor.setMaxAge(getInstance().getMaxAge(actorClass));
			actor.setBreedingProbability(getInstance().getBreedingProbability(actorClass));
			actor.setMaxLitterSize(getInstance().getMaxLitterSize(actorClass));
			actor.setFoodValue(getInstance().getFoodValue(actorClass));
		}
		return actor;
	}
	
	/**
	 * Sets the breeding age of the animal
	 * @param actorClass
	 * @param breedingAge
	 */
	public void setBreedingAge(Class<?> actorClass, int breedingAge) {
		if(actorClass == Rabbit.class) {
			rabbitSettings.put("breedingAge", Integer.valueOf(breedingAge));
		}
		if(actorClass == Fox.class) {
			foxSettings.put("breedingAge", Integer.valueOf(breedingAge));
		}
		if(actorClass == Bear.class) {
			bearSettings.put("breedingAge", Integer.valueOf(breedingAge));
		}
		updateActors();
	}
	
	/**
	 * Gets the user defined values for breeding age
	 * @param actorClass
	 * @return the breeding age for the given actor
	 */
	public int getBreedingAge(Class<?> actorClass) {
		int returnValue = 0;
		if(actorClass == Rabbit.class) {
			returnValue = rabbitSettings.get("breedingAge").intValue();
		}
		if(actorClass == Fox.class) {
			returnValue = foxSettings.get("breedingAge").intValue();
		}
		if(actorClass == Bear.class) {
			returnValue = bearSettings.get("breedingAge").intValue();
		}
		return returnValue;
	}
	
	public void setMaxAge(Class<?> actorClass, int maxAge) {
		if(actorClass == Rabbit.class) {
			rabbitSettings.put("maxAge", Integer.valueOf(maxAge));
		}
		if(actorClass == Fox.class) {
			foxSettings.put("maxAge", Integer.valueOf(maxAge));
		}
		if(actorClass == Bear.class) {
			bearSettings.put("maxAge", Integer.valueOf(maxAge));
		}
		updateActors();
	}
	
	/**
	 * Gets the user defined values for breeding age
	 * @param actorClass
	 * @return the breeding age for the given actor
	 */
	public int getMaxAge(Class<?> actorClass) {
		int returnValue = 0;
		if(actorClass == Rabbit.class) {
			returnValue = rabbitSettings.get("maxAge").intValue();
		}
		if(actorClass == Fox.class) {
			returnValue = foxSettings.get("maxAge").intValue();
		}
		if(actorClass == Bear.class) {
			returnValue = bearSettings.get("maxAge").intValue();
		}
		return returnValue;
	}
	
	public void setBreedingProbability(Class<?> actorClass, double breedingProbability) {
		if(actorClass == Rabbit.class) {
			rabbitSettings.put("breedingProbability", Double.valueOf(breedingProbability));
		}
		if(actorClass == Fox.class) {
			foxSettings.put("breedingProbability", Double.valueOf(breedingProbability));
		}
		if(actorClass == Bear.class) {
			bearSettings.put("breedingProbability", Double.valueOf(breedingProbability));
		}
		updateActors();
	}
	
	/**
	 * Gets the user defined values for breeding age
	 * @param actorClass
	 * @return the breeding chance the given class has
	 */
	public double getBreedingProbability(Class<?> actorClass) {
		double returnValue = 0;
		if(actorClass == Rabbit.class) {
			returnValue = rabbitSettings.get("breedingProbability").doubleValue();
		}
		if(actorClass == Fox.class) {
			returnValue = foxSettings.get("breedingProbability").doubleValue();
		}
		if(actorClass == Bear.class) {
			returnValue = bearSettings.get("breedingProbability").doubleValue();
		}
		return returnValue;
	}
	
	public void setMaxLitterSize(Class<?> actorClass, int maxLitterSize) {
		if(actorClass == Rabbit.class) {
			rabbitSettings.put("maxLitterSize", Integer.valueOf(maxLitterSize));
		}
		if(actorClass == Fox.class) {
			foxSettings.put("maxLitterSize", Integer.valueOf(maxLitterSize));
		}
		if(actorClass == Bear.class) {
			bearSettings.put("maxLitterSize", Integer.valueOf(maxLitterSize));
		}
		updateActors();
	}
	/**
	 * Gets the user defined values for breeding age
	 * @param actorClass
	 * @return the max offspring the animal can have
	 */
	public int getMaxLitterSize(Class<?> actorClass) {
		int returnValue = 0;
		if(actorClass == Rabbit.class) {
			returnValue = rabbitSettings.get("maxLitterSize").intValue();
		}
		if(actorClass == Fox.class) {
			returnValue = foxSettings.get("maxLitterSize").intValue();
		}
		if(actorClass == Bear.class) {
			returnValue = bearSettings.get("maxLitterSize").intValue();
		}
		return returnValue;
	}
	
	public void setFoodValue(Class<?> actorClass, int foodValue) {
		if(actorClass == Rabbit.class) {
			rabbitSettings.put("foodValue", Integer.valueOf(foodValue));
		}
		if(actorClass == Fox.class) {
			foxSettings.put("foodValue", Integer.valueOf(foodValue));
		}
		if(actorClass == Bear.class) {
			bearSettings.put("foodValue", Integer.valueOf(foodValue));
		}
		updateActors();
	}
	
	/**
	 * Gets the food value if the given actor class is being eaten.
	 * @param actorClass
	 * @return the food value
	 */
	public int getFoodValue(Class<?> actorClass) {
		int returnValue = 0;
		if(actorClass == Rabbit.class) {
			returnValue = rabbitSettings.get("foodValue").intValue();
		}
		if(actorClass == Fox.class) {
			returnValue = foxSettings.get("foodValue").intValue();
		}
		if(actorClass == Bear.class) {
			returnValue = bearSettings.get("foodValue").intValue();
		}
		return returnValue;
	}
	
	/**
	 * Let the population generator know about the model
	 * so other methods can use it for updating their data to the actors
	 * @param model
	 */
	public void setModel(SimulatorModel model) {
		this.model = model;
	}
	
	/**
	 * Updates all actors with the new data
	 */
	public void updateActors() {
		if(model != null) {
			List<Actor> actors = model.getActors();
			for(int i = 0; i < actors.size(); i++) {
				if(actors.get(i) instanceof Animal) {
					if(actors.get(i) instanceof Rabbit) {
						Animal animal = (Animal) actors.get(i);
						animal.setBreedingAge(getBreedingAge(Rabbit.class));
						animal.setMaxAge(getMaxAge(Rabbit.class));
						animal.setBreedingProbability(getBreedingProbability(Rabbit.class));
						animal.setMaxLitterSize(getMaxLitterSize(Rabbit.class));
						animal.setFoodValue(getFoodValue(Rabbit.class));
					}
					if(actors.get(i) instanceof Fox) {
						Animal animal = (Animal) actors.get(i);
						animal.setBreedingAge(getBreedingAge(Fox.class));
						animal.setMaxAge(getMaxAge(Fox.class));
						animal.setBreedingProbability(getBreedingProbability(Fox.class));
						animal.setMaxLitterSize(getMaxLitterSize(Fox.class));
						animal.setFoodValue(getFoodValue(Fox.class));
					}
					if(actors.get(i) instanceof Bear) {
						Animal animal = (Animal) actors.get(i);
						animal.setBreedingAge(getBreedingAge(Bear.class));
						animal.setMaxAge(getMaxAge(Bear.class));
						animal.setBreedingProbability(getBreedingProbability(Bear.class));
						animal.setMaxLitterSize(getMaxLitterSize(Bear.class));
						animal.setFoodValue(getFoodValue(Bear.class));
					}
				}
			}
		}
	}
}