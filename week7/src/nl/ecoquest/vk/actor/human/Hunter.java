package nl.ecoquest.vk.actor.human;

import java.util.Iterator;
import java.util.List;

import nl.ecoquest.vk.actor.Actor;
import nl.ecoquest.vk.actor.animal.Bear;
import nl.ecoquest.vk.actor.animal.Fox;
import nl.ecoquest.vk.actor.animal.Rabbit;
import nl.ecoquest.vk.actor.environment.Grass;
import nl.ecoquest.vk.simulation.Field;
import nl.ecoquest.vk.simulation.Location;

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
	/**
	 * The hunter has one purpose in life. To hunt!
	 * @return New location of the hunter. Can be null
	 */
	public Location hunt()
	{
		Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Object actor = field.getObjectAt(where);
            if(actor instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) actor;
                if(!rabbit.tryToEscape()) {
	                if(rabbit.isActive()) { 
	                    rabbit.setInActive();
	                    return where;
	                }
                }
            }
            if(actor instanceof Bear) {
                Bear bear = (Bear) actor;
                if(!bear.tryToEscape()) {
	                if(bear.isActive()) { 
	                    bear.setInActive();
	                    return where;
	                }
                }
            }
            if(actor instanceof Fox) {
                Fox fox = (Fox) actor;
                if(!fox.tryToEscape()) {
	                if(fox.isActive()) { 
	                    fox.setInActive();
	                    return where;
	                }
                }
            }
            if(actor instanceof Grass) {
            	Grass grass = (Grass) actor;
            	if(grass.isActive()) {
            		grass.setInActive();
            		return where;
            	}
            }
        }
        return null;
	}
}
