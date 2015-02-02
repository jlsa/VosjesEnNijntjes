package nl.ecoquest.vk.actor.animal;

import java.util.Iterator;
import java.util.List;

import nl.ecoquest.vk.actor.Actor;
import nl.ecoquest.vk.actor.Sickness;
import nl.ecoquest.vk.actor.environment.Grass;
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
	private int sicknessLevel = 0;
	private int maxSicknessLevel = 15;
	private float infectionRate;
	
	public Rabbit(Field field, Location location)
	{
		super(field, location);
		breedingAge = 5;
		maxAge = 40;
		breedingProbability = 0.12;
		maxLitterSize = 4; 
		foodValue = 3;
		age = rand.nextInt(maxAge);
		foodLevel = 4;
		maxFoodLevel = 20;
		sicknessLevel = 0;
		infectionRate = 0.0f;
		
		// random chance if the rabbit is sick or not
		int sickChance = rand.nextInt(100) + 1;
		if(sickChance < 50) {
			//setSick();
			sick = false;
		} else {
			sick = false;
		}
	}
		
	@Override
	public void act(List<Actor> newRabbits)
	{
		incrementAge();
		
		if(isActive()) {
			incrementSickness();
		}
		
		if(isActive()) {
            if(getSicknessLevel() < (maxSicknessLevel/2)) {
            	giveBirth(newRabbits);   
            }
            
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
			return sick;
		}


		@Override
		public void setSick() {
			sick = true;
			sicknessLevel = 0;
			infectionRate = 0.001f;
		}


		@Override
		public void incrementSickness() {
			if(isSick()) {
				sicknessLevel+=2;
				infectionRate += 0.01f;
				//spreadSickness();
				if(sicknessLevel >= maxSicknessLevel) {
					setInActive();
				}
			}
			if(getSicknessLevel() >= maxSicknessLevel ) {
				setInActive();
			}
		}


		@Override
		public void spreadSickness() {
			//System.out.println("Spread sickness");
			Field field = getField();
			List<Location> adjacent = field.adjacentLocations(getLocation());
			if(adjacent != null) {
				for(int i = 0; i < adjacent.size(); i++) {
					Object actor = field.getObjectAt(adjacent.get(i));
					if(actor instanceof Rabbit) {
						Rabbit rabbit = (Rabbit) actor;
						if(!rabbit.isSick()) {
							rabbit.setSick();
						}
					}
				}
			}
			
		}

		@Override
		public Location findFood() {
			Field field = getField();
			List<Location> adjacent = field.adjacentLocations(getLocation());
			Iterator<Location> it = adjacent.iterator();
			while(it.hasNext()) {
				Location where = it.next();
				Object actor = field.getObjectAt(where);
				if(actor instanceof Grass) {
					Grass grass = (Grass) actor;
					if(grass.isActive()) {
						foodLevel += 2;
						grass.setInActive();
						return where;
					}
				}
			}
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
