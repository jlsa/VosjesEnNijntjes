package nl.ecoquest.vk.actor.animal;

import java.util.List;

import nl.ecoquest.vk.actor.*;
import nl.ecoquest.vk.simulation.*;

public class Fox extends Animal {
	
	public Fox(Field field, Location location) {
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
