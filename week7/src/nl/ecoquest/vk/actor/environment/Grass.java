package nl.ecoquest.vk.actor.environment;

import java.util.*;

import nl.ecoquest.vk.actor.Actor;
import nl.ecoquest.vk.actor.animal.Fox;
import nl.ecoquest.vk.simulation.Field;
import nl.ecoquest.vk.simulation.Location;
import nl.ecoquest.vk.simulation.Randomizer;

/**
 * Grass grows where no other actors are.
 * It is a food resource for the rabbit
 */
public class Grass implements Actor {
	// The active state of grass
	private boolean active;
	// The field on which the grass grows
	private Field field;
	// The location on the field the grass grows
	private Location location;
	// The breeding probability
    protected double growthProbability;
	
	private int age;
	private int maxAge = 10;
	private int growAge;
	private int growthSize = 4;
	
	private Random rand = Randomizer.getRandom();
	
	public Grass(Field field, Location location) {
		this.field = field;
		setLocation(location);
		active = true;
		age = 0;
		growAge = 0;
		growthProbability = 1f;
	}
	
	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void act(List<Actor> newActors) {
		incrementAge();
		if(isActive()) {
			grow(newActors);
			// Move towards a source of food if found.
            Location newLocation = getLocation();//hunt();
            if(newLocation == null) { 
                // No food found - try to move to a free location.
                newLocation = getField().freeAdjacentLocation(getLocation());
            }
            // See if it was possible to move.
            if(newLocation != null) {
                setLocation(newLocation);
            }
		}
	}

	private void incrementAge() {
		age++;
		if(age >= maxAge) {
			setInActive();
		}
	}
		
	@Override
	public void setInActive() {
		active = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
	}

	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public void setLocation(Location newLocation) {
		if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
	}

	@Override
	public void setField(Field field) {
		this.field = field;
	}

	@Override
	public Field getField() {
		return field;
	}
	
	/**
	 * Grow to another location
	 */
	private void grow(List<Actor> newActors) {
		Field field = getField();
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
	    
        int growth = getGrowth();
	    for(int b = 0; b < growth && free.size() > 0; b++) {
	    	Location loc = free.remove(0);
	        Grass young = new Grass(field, loc);
	        newActors.add(young);
		}
	}
	
	public int getGrowth()
	{
		int growths = 0;
	    if(canGrow() && rand.nextDouble() <= growthProbability) {
	    	growths = rand.nextInt(growthSize) + 1;
	    }
	    return growths;
	}
	
	/**
     * Checks and returns if the grass can grow
     * @return true if grass can grow else false.
     */
    public boolean canGrow()
	{
	    return age >= growAge;
	}
	
}
