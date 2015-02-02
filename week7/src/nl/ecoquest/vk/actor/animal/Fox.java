package nl.ecoquest.vk.actor.animal;


import nl.ecoquest.vk.actor.Actor;
import nl.ecoquest.vk.actor.environment.Grass;
import nl.ecoquest.vk.simulation.*;

import java.util.Iterator;
import java.util.List;

/**
 * The keen, funny, beautiful foxes!
 * @author Jeroen, Angela en Joel
 * @version 2015-02-01
 */
public class Fox extends Animal implements Actor {
	
	/**
	 * The fox constructor
	 * @param field
	 * @param location
	 */
	 public Fox(Field field, Location location)
	    {
	        super(field, location);
	        breedingAge = 10;
	        maxAge = 150;
	        breedingProbability = 0.12;//0.11;
	        maxLitterSize = 3;
	        foodValue = 6;
	        age = rand.nextInt(maxAge);
	        maxFoodLevel = 9;
	        foodLevel = rand.nextInt(foodValue);
	    }
	 
	 @Override
	 public void act(List<Actor> newFoxes)
	    {
	        incrementHunger();
	        incrementAge();
	        if(isActive()) {
	            giveBirth(newFoxes);            
	            // Move towards a source of food if found.
	            Location newLocation = findFood();
	            if(newLocation == null) { 
	                // No food found - try to move to a free location.
	                newLocation = getField().freeAdjacentLocation(getLocation());
	            }
	            // See if it was possible to move.
	            if(newLocation != null) {
	                setLocation(newLocation);
	            }
	            else {
	                // Overcrowding.
	                setInActive();
	            }
	        }

	    }
	 
	 
	 @Override
	 public Location findFood()
	    {
	        Field field = getField();
	        List<Location> adjacent = field.adjacentLocations(getLocation());
	        Iterator<Location> it = adjacent.iterator();
	        while(it.hasNext()) {
	            Location where = it.next();
	            Object actor = field.getObjectAt(where);
	            if(actor instanceof Rabbit) {
	                Rabbit rabbit = (Rabbit) actor;
	                if(rabbit.isActive()) {
	                	if(!rabbit.tryToEscape()) {
		                    rabbit.setInActive();
		                    foodLevel += rabbit.getFoodValue();
	                	}
	                    return where;
	                }
	            }
	            if(actor instanceof Grass) {
					Grass grass = (Grass) actor;
					if(grass.isActive()) {
						grass.setInActive();
						return where;
					}
				}
	        }
	        return null;
	    }
	 @Override
	 public void giveBirth(List<Actor> newFoxes)
	    {
	        // New foxes are born into adjacent locations.
	        // Get a list of adjacent free locations.
	        Field field = getField();
	        List<Location> free = field.getFreeAdjacentLocations(getLocation());
	        int births = breed();
	        for(int b = 0; b < births && free.size() > 0; b++) {
	            Location loc = free.remove(0);
	            Fox young = new Fox(field, loc);
	            newFoxes.add(young);
	        }
	    }
	 @Override
	 public int breed()
	 {
		 int births = 0;
	        if(canBreed() && rand.nextDouble() <= breedingProbability) {
	            births = rand.nextInt(maxLitterSize) + 1;
	        }
	        return births;
	    }
}
