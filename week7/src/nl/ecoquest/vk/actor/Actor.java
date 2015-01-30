package nl.ecoquest.vk.actor;

import java.util.List;

/**
 * The acting interface :) Temp version currently to just have basic functionality
 * @author Joel Hoekstra
 * @since 2015-01-28
 * @version 2
 */
public interface Actor {
	/**
	 * Tells the actor to act.
	 * @param newActors
	 */
	public void act(List<Actor> newActors);
	/**
	 * Is the actor still active?
	 * @return true if actor is active else false.
	 */
	public boolean isActive();
}
