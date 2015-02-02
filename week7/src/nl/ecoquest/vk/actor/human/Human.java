package nl.ecoquest.vk.actor.human;

import java.util.List;

import nl.ecoquest.vk.actor.*;
import nl.ecoquest.vk.simulation.Field;
import nl.ecoquest.vk.simulation.Location;

/**
 * A human is just to abstract. It definitely is an actor
 * @author Jeroen, Angela en Joel
 * @version 2015-02-01
 */
public abstract class Human implements Actor {
	// The field on which the human exists
	private Field field;
	// The location on the field the human stands
	private Location location;
	// The active state of the human
	private boolean active;
	
	/**
	 * Constructor
	 * @param field
	 * @param location
	 */
	public Human(Field field, Location location) {
		this.field = field;
		setLocation(location);
		active = true;
	}
	
	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void act(List<Actor> newActors) {
		
	}

	@Override
	public void setInActive() {
		active = false;
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
	

}
