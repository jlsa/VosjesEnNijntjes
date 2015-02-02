package nl.ecoquest.vk.actor.animal;

import java.util.Iterator;
import java.util.List;

import nl.ecoquest.vk.actor.*;
import nl.ecoquest.vk.actor.environment.*;
import nl.ecoquest.vk.simulation.*;

/**
 * The bear is a verocious animal. It kills all rabbits, foxes and tries to runaway from the poaching hunters!
 * @author Jeroen, Angela en Joel
 * @version 2015-02-01
 */
public class Bear extends Animal implements Actor {
	/**
	 * Constructor of the bear. Sets the default values 
	 * @param field
	 * @param location
	 */
	public Bear(Field field, Location location)
	{
		super(field, location);
		alive = true;	
		breedingAge = 20;
		maxAge = 200;
		breedingProbability = 0.07;
		maxLitterSize = 2;
		foodValue = 18;
		age = 1;
		maxFoodLevel = 18;
		foodLevel = 18;
	}
	
	@Override
	public void act(List<Actor> newActors)
	{
		incrementAge();
		if(isActive()) {
			giveBirth(newActors);            
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

		incrementHunger();
	}
	
	@Override
	public void incrementAge()
	{
		age++;
		if(age > maxAge) {
			setInActive();
		}
	}
	
	@Override
	public void incrementHunger()
	{
		foodLevel--;
		if(foodLevel <= 0) {
			setInActive();
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
			if(actor instanceof Fox) {
				Fox fox = (Fox) actor;
				if(fox.isActive()) { 
					if(!fox.tryToEscape()) {
						fox.setInActive();
						foodLevel += fox.getFoodValue();
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
	public void giveBirth(List<Actor> newBears)
	{
		// New foxes are born into adjacent locations.
		// Get a list of adjacent free locations.
		Field field = getField();
		List<Location> free = field.getFreeAdjacentLocations(getLocation());
		int births = breed();
		for(int b = 0; b < births && free.size() > 0; b++) {
			Location loc = free.remove(0);
			Bear young = new Bear(field, loc);
			newBears.add(young);
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
	
	@Override
	public boolean canBreed()
	{
		return age >= breedingAge;
	}		
}
