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
	protected int breedingAge;
	// The max age of the animal
    protected int maxAge;
    // The breeding probability
    protected double breedingProbability;
    // The max litter size of the animal
    protected int maxLitterSize;
    // The food value if being eaten.
    protected int foodValue;
    // The age of the animal
    protected int age;
    
    // The food level of the animal
    protected int foodLevel;
    // The max food level
    protected int maxFoodLevel;
    // The alive/active state of the animal
    protected boolean alive;
    
    // Random
    protected Random rand = Randomizer.getRandom();
    
    // Field on which the animal resides
    protected Field field;
    // The location the animal has on the field.
    protected Location location;
    
    /**
     * Animal constructor. (Abstract)
     * @param field
     * @param location
     */
    public Animal(Field field, Location location) {
    	this.field = field;
    	setLocation(location);
    	alive = true;
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
	public void feed(int foodValue){
		int newFoodLevel = foodValue + this.foodLevel;
		if(newFoodLevel > maxFoodLevel) {
			newFoodLevel = maxFoodLevel;
		}
		this.foodLevel = newFoodLevel;
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
     * If attacked the animal can try to escape! It is still a chance! Small one that it succeeds
     * @return true if escaped, false if failed to escape
     */
    public final boolean tryToEscape() {
    	// if there are free adjacent locations then the
    	// math for this method is basic 10% run away chance 
    	// + 1% for every one free adjacent location
    	Location freeLocation = getField().freeAdjacentLocation(getLocation());
    	List<Location> free = getField().getFreeAdjacentLocations(getLocation());
    	if(free.size() > 0) {
    		int escapeChance = 10 + free.size();
	    	int tryChance = Randomizer.getRandom().nextInt(100) + 1;
	    	if(escapeChance >= tryChance) {
	    		// now move to another position!
	    		setLocation(freeLocation);
	    		return true;
	    	} else {
	    		return false;
	    	}
    	}
    	return false;
    }
    
    @Override
	public boolean isActive() {
		return alive;
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
