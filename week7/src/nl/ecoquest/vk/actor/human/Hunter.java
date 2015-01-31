package nl.ecoquest.vk.actor.human;

import nl.ecoquest.vk.actor.*;
import nl.ecoquest.vk.actor.animal.*;
import nl.ecoquest.vk.simulation.*;

import java.util.Iterator;
import java.util.List;

public class Hunter extends Human {
	/**
	 * Hunter constructor
	 * @param field the field the hunter is on
	 * @param location the location of the hunter on the field.
	 */
	public Hunter(Field field, Location location)
	{
		super(field, location);
	}
	/**
	 * @see Actor#act(java.util.List)
	 */
	@Override
	public void act(List<Actor> newActors) {
		if(isActive()) {
			// Move towards a source of food if found.
            Location newLocation = hunt();
            if(newLocation == null) { 
                // No food found - try to move to a free location.
                newLocation = getField().freeAdjacentLocation(getLocation());
            }
            // See if it was possible to move.
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // overcrowding
            	// hunters cant die!
            }
		}
	}

	public Location hunt()
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
                    return where;
                }
            }
            if(animal instanceof Bear) {
                Bear bear = (Bear) animal;
                if(bear.isActive()) { 
                    bear.setInActive();
                    return where;
                }
            }
            if(animal instanceof Fox) {
                Fox fox = (Fox) animal;
                if(fox.isActive()) { 
                    fox.setInActive();
                    return where;
                }
            }
        }
        return null;
	}
}
