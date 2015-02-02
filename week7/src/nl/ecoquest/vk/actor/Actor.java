package nl.ecoquest.vk.actor;

import java.util.*;
import nl.ecoquest.vk.simulation.*;

/**
 * The actor interface makes sure every actor at least
 * knows how to act, where it is on the field and if it's active or not.
 * 
 * @author Jeroen, Joel en Angela
 * @since 
 * @version 2015-02-01
 */
public interface Actor {
	
	/**
	 * Check if the actor is active or not.
	 * @return true if active, false if not active
	 */
	public boolean isActive();
	
	/**
     * Make this actor act - that is: make it do
     * whatever it wants/needs to do.
     * @param newActors A list to receive newly born actors.
     */
	public void act(List<Actor> newActors);
	
	/**
	 * Sets the actor inactive.
	 */
	public void setInActive();
	
	/**
	 * Gets the current location on the field.
	 * @return the current location
	 */
	public Location getLocation();
   	
	/**
     * Place the actor at the new location in the given field.
     * @param newLocation The actor's new location.
     */
	public void setLocation(Location newLocation);
	
	/**
	 * Sets the field on which the actor resides.
	 * @param field
	 */
	public void setField(Field field);
	
	/**
	 * Gets the field on which the actor resides.
	 * @return field
	 */
	public Field getField();
}
