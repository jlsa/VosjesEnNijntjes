package nl.ecoquest.vk.actor.animal;

public abstract class Animal implements Actor {
	protected int breedingAge = 5;
    protected int maxAge = 40;
    protected double breedingProbability = 0.85;
    protected int maxLitterSize = 4;
    protected int foodValue = 1;
    protected int age = 1;
    protected int foodLevel = 100;
    protected int maxFoodLevel = 100;
    protected boolean alive = true;
    
    public void incrementAge() {}
    
    public void incrementHunger() {}
    
    public Location findFood() {
    	return null;
    }
    
    public void giveBirth(){}
   
    public int breed() {}
    
    public boolean canBreed() {
    	return false;
    }
    
    public void tryToEscape() {}
}
