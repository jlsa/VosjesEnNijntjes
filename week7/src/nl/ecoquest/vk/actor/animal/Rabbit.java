package nl.ecoquest.vk.actor.animal;

import nl.ecoquest.vk.actor.Actor;
import nl.ecoquest.vk.actor.Sickness;
import nl.ecoquest.vk.*;

public class Rabbit extends Animal implements Actor, Sickness{
	
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
	    }
	    
	 
	    public void act(List<Actor> newRabbits)
	    {
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
	    
	    public void incrementAge()
	    {
	        age++;
	        if(age > maxAge) {
	        	setInActive();
	        }
	    }
	    
	    private void giveBirth(List<Actor> newRabbits)
	    {
	        // New rabbits are born into adjacent locations.
	        // Get a list of adjacent free locations.
	        Field field = getField();
	        List<Location> free = field.getFreeAdjacentLocations(getLocation());
	        int births = breed();
	        for(int b = 0; b < births && free.size() > 0; b++) {
	            Location loc = free.remove(0);
	            Rabbit young = new Rabbit(false, field, loc);
	            newRabbits.add((Actor) young);
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

	    /**
	     * A rabbit can breed if it has reached the breeding age.
	     * @return true if the rabbit can breed, false otherwise.
	     */
	    public boolean canBreed()
	    {
	        return age >= breedingAge;
	    }
	    
	    public int getFoodValue(){
	    	return foodValue;
	    }
	    
	    public int setFoodValue(int foodValue){
	    	foodValue = this.foodValue;
	    }
	    
	    public void tryToEscape()
	    {
	    	
	    }	
	    
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
			// TODO Auto-generated method stub
			
		}


		@Override
		public void spreadSickness() {
			// TODO Auto-generated method stub
			
		}


		@Override
		public boolean isActive() {
			// TODO Auto-generated method stub
			return false;
		}


		@Override
		public void act() {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void setInActive() {
			// TODO Auto-generated method stub
			
		}


		@Override
		public Location getLocation() {
			// TODO Auto-generated method stub
			return null;
		}


		@Override
		public void setLocation(Location newLocation) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void setField() {
			// TODO Auto-generated method stub
			
		}


		@Override
		public Field getField() {
			// TODO Auto-generated method stub
			return null;
		}
	    }
}
