package nl.ecoquest.vk.actor.human;

import java.util.List;

import nl.ecoquest.vk.actor.*;
import nl.ecoquest.vk.simulation.Field;
import nl.ecoquest.vk.simulation.Location;

public abstract class Human implements Actor {
	private Field field;
	private Location location;
	private boolean active;
	
	public Human(Field field, Location location) {
		this.field = field;
		this.location = location;
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
