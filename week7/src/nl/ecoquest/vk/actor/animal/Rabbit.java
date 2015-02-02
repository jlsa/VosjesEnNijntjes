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
	private boolean sick;
	private int sicknessLevel;
	private int maxSicknessLevel = 100;
	private float infectionRate;
	
	public Rabbit(Field field, Location location)
	{
		super(field, location);
		breedingAge = 5;
		maxAge = 40;
		breedingProbability = 0.12;
		maxLitterSize = 1; // 4 is to much
		foodValue = 20;
		age = rand.nextInt(maxAge);
		foodLevel = 20;
		maxFoodLevel = 20;
		
		// random chance if the rabbit is sick or not
		int sickChance = rand.nextInt(100) + 1;
		if(sickChance < 10) {
			sick = true;
			sicknessLevel = 0;
			infectionRate = 0.0f;
		}
	}
		
	@Override
	public void act(List<Actor> newRabbits)
	{
		incrementHunger();
		incrementAge();
		if(isActive()) {
            giveBirth(newRabbits);            
            // Try to move into a free location.
            Location newLocation = getField().freeAdjacentLocation(getLocation());
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
		//System.out.println("Rabbit! Births: " + births + " free: " + free.size());
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
			return sick;
		}


		@Override
		public void setSick() {
			sick = true;
		}


		@Override
		public void incrementSickness() {
			sicknessLevel++;
			infectionRate += 0.01f;
			if(sicknessLevel >= maxSicknessLevel) {
				setInActive();
			}
		}


		@Override
		public void spreadSickness() {
			
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

		@Override
		public int getSicknessLevel() {
			return sicknessLevel;
		}

		@Override
		public double getInfectionRate() {
			return infectionRate;
		}

		
}
