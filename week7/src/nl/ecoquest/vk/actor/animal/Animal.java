package nl.ecoquest.vk.actor.animal;

import java.util.*;
import nl.ecoquest.vk.actor.*;
import nl.ecoquest.vk.simulation.*;

/**
 * A class representing shared characteristics of animals.
 *
 * @author Jeroen, Joel en Angela
 * @since 
 * @version 2015-02-01
 */

public abstract class Animal implements Actor 
{
	// The breeding age of the animal
	protected int breedingAge = 5;
	// The max age of the animal
    protected int maxAge = 40;
    // The breeding probability
    protected double breedingProbability = 0.85;
    // The max litter size of the animal
    protected int maxLitterSize = 4;
    // The food value if being eaten.
    protected int foodValue = 1;
    // The age of the animal
    protected int age = 1;
    
    // The food level of the animal
    protected int foodLevel = 100;
    // The max food level
    protected int maxFoodLevel = 100;
    // The alive/active state of the animal
    protected boolean alive = true;
    
    // Random
    protected Random rand = Randomizer.getRandom();
    
    // Field on which the animal resides
    private Field field;
    // The location the animal has on the field.
    private Location location;
    
    /**
     * Animal constructor. (Abstract)
     * @param field
     * @param location
     */
    public Animal(Field field, Location location) {
    	this.field = field;
    	this.location = location;
    }
    
    /**
     * Increment the age of the animal. If reached
     * max age then the animal dies!
     */
    public void incrementAge()
    {
        age++;
        if(age > maxAge) {
        	setInActive();
        }
    }
    /**
     * Increment the hunger of the animal. If reached
     * zero foodlevel then the animal dies!
     */
    public void incrementHunger()
    {
        foodLevel--;
        if(foodLevel <= 0) {
            setInActive();
        }
    }
    
    /**
     * Checks and returns if the animal can breed
     * @return true if animal can breed else false.
     */
    public boolean canBreed()
	{
	    return age >= breedingAge;
	}
	/**
	 * Get the food value if being eaten
	 * @return the food value
	 */
	public int getFoodValue() {
		return foodValue;
	}
	 
	/**
	 * Set the food value to a new food value
	 * @param foodValue
	 */
	public void setFoodValue(int foodValue){
		this.foodValue = foodValue;
	}
	/**
	 * All animals need to find food. 
	 * It returns the location of the animal 
	 * if it found it's pray
	 * @return location
	 */
    public abstract Location findFood();
    /**
     * Give birth to new animals!
     * @param newActors
     */
    public abstract void giveBirth(List<Actor> newActors);
    /**
     * Return how many smaller animals can be born
     * @return amount of new animals
     */
    public abstract int breed();
    
    /**
     * If attacked the animal can try to escape!
     * @return true if escaped, false if failed to escape
     */
    public abstract boolean tryToEscape();
    
    @Override
	public boolean isActive() {
		if(alive == true){
			return true;
		}
		return false;
	}

	@Override
	public void setInActive() {
		alive = false;
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
	public Field getField() {
		return field;
	}
	
	@Override
	public void setField(Field field) {
		this.field = field;
	}
}
