package nl.ecoquest.vk.actor.environment;

import java.util.List;

import nl.ecoquest.vk.actor.Actor;
import nl.ecoquest.vk.simulation.Field;
import nl.ecoquest.vk.simulation.Location;

/**
 * Grass grows where no other actors are.
 * It is a food resource for the rabbit
 */
public class Grass implements Actor {
	// The active state of grass
	private boolean active;
	// The field on which the grass grows
	private Field field;
	// The location on the field the grass grows
	private Location location;
	
	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void act(List<Actor> newActors) {
		// do nothing yet
		// it doesnt know what to do yet!
	}

	@Override
	public void setInActive() {
		active = false;
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
	public void setField(Field field) {
		this.field = field;
	}

	@Override
	public Field getField() {
		return field;
	}
	
}
