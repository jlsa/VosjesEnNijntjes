package nl.ecoquest.vk.actor.animal;

import Bear;
import Field;
import Fox;
import Location;
import Rabbit;

import java.util.Iterator;
import java.util.List;

import nl.ecoquest.vk.actor.Actor;

public class Bear extends Animal implements Actor {
	 public Bear(Field field, Location location)
	    {
	        super(field, location);
	        breedingAge = 20;
	        maxAge = 200;
	        breedingProbability = 0.01;
	        maxLitterSize = 2;
	        foodValue = 15;
	        age = 0;
	        maxFoodLevel = 100;
	        foodLevel = 100;
	        alive = true;
	        
	    }
	 
	 public void act(List<Actor> newActors)
	    {
	        incrementAge();
	        incrementHunger();
	        if(super.isActive()) {
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
	 
	 public Location findFood()
	    {
	        Field field = getField();
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
	                    return where;
	                }
	            }
	            if(animal instanceof Fox) {
	                Fox fox = (Fox) animal;
	                if(fox.isActive()) { 
	                    fox.setInActive();
	                    foodLevel = fox.getFoodValue();
	                    return where;
	                }
	            }
	        }
	        return null;
	    }
	 
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
	 
	 public int breed()
	    {
	        int births = 0;
	        if(canBreed() && rand.nextDouble() <= breedingProbability) {
	            births = rand.nextInt(maxLitterSize) + 1;
	        }
	        return births;
	    }
	 
	 public boolean canBreed()
	    {
	        return age >= breedingAge;
	    }
	    
	    public int getFoodValue(){
	    	return foodValue;
	    }
	    
	    public void setFoodValue(int foodValue){
	    	this.foodValue = foodValue;
	    }
	    
	    public void tryToEscape()
	    {
	    	
	    }	    
	    
	    @Override
		public boolean isActive() {
			if(alive == true){
				return true;
			}
			return false;
		}


		@Override
		public void act() {
			// TODO Auto-generated method stub
			
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
		public void setField() {
			// TODO Auto-generated method stub
			
		}


		@Override
		public Field getField() {
			return field;
		}
}
