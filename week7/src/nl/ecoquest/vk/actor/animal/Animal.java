package nl.ecoquest.vk.actor.animal;

import java.util.List;

import nl.ecoquest.vk.actor.Actor;
import nl.ecoquest.vk.simulation.*;

public abstract class Animal implements Actor {
	
	private boolean active;
	
	protected Field field;
	protected Location location;
	
	public Animal(Field field, Location location) {
		active = true;
		this.field = field;
		this.location = location;
		field.place(this, location);
	}
	
	@Override
	public void act(List<Actor> newActors) {
		
	}

	@Override
	public boolean isActive() {
		return active;
	}

	protected Field getField() {
		return field;
	}
	
	/**
     * Place the animal at the new location in the given field.
     * @param newLocation The animal's new location.
     */
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
	
	protected Location getLocation() {
		return location;
	}	
}
