import java.util.*;

/**
 * The acting interface :)
 * @author Joel Hoekstra
 * @since 2015-01-22
 * @version 1
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
