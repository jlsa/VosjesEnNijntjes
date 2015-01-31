package nl.ecoquest.vk.actor;

public interface Actor {
	
	public boolean isActive();
	
	public void act(List<Actor>);
	
	public void setInActive();
	
	public Location getLocation();
   	
	public void setLocation(Location newLocation);
	
	public void setField(Field);
	
	public Field getField();
}
