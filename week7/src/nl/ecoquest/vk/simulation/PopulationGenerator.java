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
		rabbitSettings.put("breedingAge", Integer.valueOf(5));
		rabbitSettings.put("maxAge", Integer.valueOf(40));
		rabbitSettings.put("breedingProbability", Double.valueOf(0.12));
		rabbitSettings.put("maxLitterSize", Integer.valueOf(4));
		rabbitSettings.put("foodValue", Integer.valueOf(4));
		
		foxSettings = new LinkedHashMap<String, Number>();
		foxSettings.put("breedingAge", Integer.valueOf(10));
		foxSettings.put("maxAge", Integer.valueOf(150));
		foxSettings.put("breedingProbability", Double.valueOf(0.12));
		foxSettings.put("maxLitterSize", Integer.valueOf(2));
		foxSettings.put("foodValue", Integer.valueOf(6));
		
		bearSettings = new LinkedHashMap<String, Number>();
		bearSettings.put("breedingAge", Integer.valueOf(20));
		bearSettings.put("maxAge", Integer.valueOf(200));
		bearSettings.put("breedingProbability", Double.valueOf(0.07));
		bearSettings.put("maxLitterSize", Integer.valueOf(2));
		bearSettings.put("foodValue", Integer.valueOf(18));
		
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
	 * @param actorClass The actor class
	 * @param field The field on which the animal should reside
	 * @param location The position on the field
	 * @return A new Animal
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
	 * @param actorClass The actor class
	 * @param breedingAge The breeding age
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
	 * @param actorClass The actor class
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
	
	/**
	 * Set the max age to all actors of type
	 * @param actorClass The actor class
	 * @param maxAge The max age
	 */
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
	 * @param actorClass The actor class
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
	
	/**
	 * Set breeding probability
	 * @param actorClass The actor class
	 * @param breedingProbability The probability percentage
	 */
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
	 * @param actorClass The breeding class
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
	
	/**
	 * Set the max litter size
	 * @param actorClass the actor class
	 * @param maxLitterSize the max amount of offspring
	 */
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
	 * @param actorClass The actor class
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
	
	/**
	 * Set the foodvalue of an actor
	 * @param actorClass The actor class
	 * @param foodValue The food value
	 */
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
	 * @param actorClass The actor class
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
	 * @param model The simulator model
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