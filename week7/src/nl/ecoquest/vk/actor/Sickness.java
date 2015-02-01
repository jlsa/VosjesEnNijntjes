package nl.ecoquest.vk.actor;

/**
 * The sickness interface. This can be added to every actor.
 * When it is implemented the animal can get sick and spread
 * the sickness.
 * 
 * @author Jeroen, Joel en Angela
 * @since 
 * @version 2015-02-01
 */
public interface Sickness {

	/**
	 * Returns if the actor is sick or not
	 * @return true if sick else false
	 */
	public boolean isSick();
	
	/**
	 * Make the animal sick
	 */
	public void setSick();
	
	/**
	 * Lets the actor get sicker and sicker
	 */
	public void incrementSickness();
	
	/**
	 * Spread the sickness
	 */
	public void spreadSickness();
}
