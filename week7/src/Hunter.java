import java.util.Iterator;
import java.util.List;

/**
 * @author Joel Hoekstra
 * @since 2015-01-22
 * @version 2015-01-22
 */
public class Hunter implements Actor {

	private boolean active;
	private Location location;
	private Field field;
	/**
	 * Hunter constructor
	 * @param field the field the hunter is on
	 * @param location the location of the hunter on the field.
	 */
	public Hunter(Field field, Location location)
	{
		active = true;
		this.field = field;
		this.location = location;
	}
	/**
	 * @see Actor#act(java.util.List)
	 */
	@Override
	public void act(List<Actor> newActors) {
		if(isActive()) {
			// Move towards a source of food if found.
            Location newLocation = hunt();
            if(newLocation == null) { 
                // No food found - try to move to a free location.
                newLocation = getField().freeAdjacentLocation(getLocation());
            }
            // See if it was possible to move.
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // Overcrowding.
            	if(location != null) {
                    field.clear(location);
                    location = null;
                    field = null;
                }
            }
		}
	}

	public Location hunt()
	{
		Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if(animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if(rabbit.isAlive()) { 
                    rabbit.setDead();
                    return where;
                }
            }
            if(animal instanceof Bear) {
                Bear bear = (Bear) animal;
                if(bear.isAlive()) { 
                    bear.setDead();
                    return where;
                }
            }
            if(animal instanceof Fox) {
                Fox fox = (Fox) animal;
                if(fox.isAlive()) { 
                    fox.setDead();
                    return where;
                }
            }
        }
        return null;
	}
	
	/** 
	 * @see Actor#isActive()
	 */
	@Override
	public boolean isActive() {
		return active;
	}
	
	/**
     * Return the hunters location.
     * @return The hunters location.
     */
    protected Location getLocation()
    {
        return location;
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
    
    /**
     * Return the animal's field.
     * @return The animal's field.
     */
    protected Field getField()
    {
        return field;
    }
}
