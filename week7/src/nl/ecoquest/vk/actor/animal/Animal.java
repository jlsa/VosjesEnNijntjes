package nl.ecoquest.vk.actor.animal;

import java.util.*;
import nl.ecoquest.vk.actor.*;
import nl.ecoquest.vk.simulation.*;

public abstract class Animal implements Actor {
	protected int breedingAge = 5;
    protected int maxAge = 40;
    protected double breedingProbability = 0.85;
    protected int maxLitterSize = 4;
    protected int foodValue = 1;
    protected int age = 1;
    protected int foodLevel = 100;
    protected int maxFoodLevel = 100;
    protected boolean alive = true;
    
    protected Random rand = Randomizer.getRandom();
    private Field field;
    private Location location;
    
    public Animal(Field field, Location location) {
    	this.field = field;
    	this.location = location;
    }

    public void incrementAge()
    {
        age++;
        if(age > maxAge) {
        	setInActive();
        }
    }
 
    public void incrementHunger()
    {
        foodLevel--;
        if(foodLevel <= 0) {
            setInActive();
        }
    }
    
    public boolean canBreed()
	{
	    return age >= breedingAge;
	}
	 
	public int getFoodValue() {
		return foodValue;
	}
	 
	public void setFoodValue(int foodValue){
		this.foodValue = foodValue;
	}
 
    public abstract Location findFood();
    
    public abstract void giveBirth(List<Actor> newActors);
   
    public abstract int breed();
    
    public abstract void tryToEscape();
    
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
