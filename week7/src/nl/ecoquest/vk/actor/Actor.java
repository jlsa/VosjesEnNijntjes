package nl.ecoquest.vk.actor;

import java.util.*;
import nl.ecoquest.vk.simulation.*;

public interface Actor {
	
	public boolean isActive();
	
	public void act(List<Actor> newActors);
	
	public void setInActive();
	
	public Location getLocation();
   	
	public void setLocation(Location newLocation);
	
	public void setField(Field field);
	
	public Field getField();
}
