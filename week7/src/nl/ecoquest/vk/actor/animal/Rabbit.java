package nl.ecoquest.vk.actor.animal;

import java.util.List;

import nl.ecoquest.vk.actor.*;
import nl.ecoquest.vk.simulation.Field;
import nl.ecoquest.vk.simulation.Location;

public class Rabbit extends Animal {
	
	public Rabbit(Field field, Location location) {
		super(field, location);
	}
	
	@Override
	public void act(List<Actor> newActors) {
		if(isActive()) {
			Location newLocation = getField().freeAdjacentLocation(getLocation());
			if(newLocation != null) {
                setLocation(newLocation);
            }
		}
	}
}
