package nl.ecoquest.vk.actor;

public interface Actor {
	
	public boolean isActive();
	
	public void act(List<Actor>);
	
	public void setInActive();
	
	public Location getLocation()
	{
		
		return location;
	    
	};
   	
	public void setLocation(Location newLocation)
	{
        if(Location != null) {
            field.clear(Location);
        }
        Location = newLocation;
        field.place(this, newLocation);
    }
	
	public void setField(Field);
	
	public Field getField()
	{
        return field;
    }
}
