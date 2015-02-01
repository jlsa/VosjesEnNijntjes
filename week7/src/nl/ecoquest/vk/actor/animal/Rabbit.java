package nl.ecoquest.vk.actor.animal;

import java.util.List;

import nl.ecoquest.vk.actor.Actor;
import nl.ecoquest.vk.actor.Sickness;
import nl.ecoquest.vk.simulation.*;

/**
 * The rabbit is the lowest in the animal foodchain. 
 * 
 * @author Jeroen, Angela en Joel
 * @version 2015-02-01
 */
public class Rabbit extends Animal implements Sickness {
	// sick state
	public int sick;
	
	public Rabbit(Field field, Location location)
	{
		super(field, location);
		breedingAge = 5;
		maxAge = 40;
		breedingProbability = 0.85;
		maxLitterSize = 4;
		foodValue = 1;
		age = 0;
		foodLevel = 100;
		maxFoodLevel = 100;
		alive = true;
	}
		
	@Override
	public void act(List<Actor> newRabbits)
	{
		incrementAge();
		if(isActive()) {
			giveBirth(newRabbits);            
			// Try to move into a free location.
			Location newLocation = getField().freeAdjacentLocation(getLocation());
			if(newLocation != null) {
				setLocation(newLocation);
			} else {
				// Overcrowding.
				setInActive();
			}
		}
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
	public void giveBirth(List<Actor> newRabbits)
	{
		// New rabbits are born into adjacent locations.
		// Get a list of adjacent free locations.
		Field field = getField();
		List<Location> free = field.getFreeAdjacentLocations(getLocation());
		int births = breed();
		for(int b = 0; b < births && free.size() > 0; b++) {
			Location loc = free.remove(0);
			Rabbit young = new Rabbit(field, loc);
			newRabbits.add(young);
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
		public boolean isSick()
		{
			if(sick != 0){
				return true;
			}
			return false;
		}


		@Override
		public void setSick() {
			sick = 1;
			
		}


		@Override
		public void incrementSickness() {
			sick++;
			
		}


		@Override
		public void spreadSickness() {
			// TODO Auto-generated method stub
			
		}


		@Override
		public Location findFood() {
			/*Field field = getField();
			List<Location> adjacent = field.adjacentLocations(getLocation());
			Iterator<Location> it = adjacent.iterator();
			while(it.hasNext()) {
				Location where = it.next();
				Object animal = field.getObjectAt(where);
				if(animal instanceof Rabbit) {
					Rabbit rabbit = (Rabbit) animal;
					if(rabbit.isActive()) { 
						rabbit.setInActive();
						foodLevel = rabbit.getFoodValue();
						//return where;
					}
				}
				if(animal instanceof Fox) {
					Fox fox = (Fox) animal;
					if(fox.isActive()) { 
						fox.setInActive();
						foodLevel = fox.getFoodValue();
						//return where;
					}
				}
			}*/
			return null;
		}

		
}
