package nl.ecoquest.vk.actor.animal;

import java.util.List;

import nl.ecoquest.vk.actor.Actor;

public abstract class Animal implements Actor {
	
	private boolean active;
	
	public Animal() {
		active = true;
	}
	
	@Override
	public void act(List<Actor> newActors) {
		
	}

	@Override
	public boolean isActive() {
		return active;
	}

}
