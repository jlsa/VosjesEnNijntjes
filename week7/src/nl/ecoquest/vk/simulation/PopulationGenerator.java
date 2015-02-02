package nl.ecoquest.vk.simulation;

/**
 * The PopulationGenerator exists to generate the population
 * This is a Singleton
 * @author Angela
 *
 */

public class PopulationGenerator {
	
	private static PopulationGenerator instance = null;
	
	/**
	 * We only want one instance of PopulationGenerator
	 */
	private PopulationGenerator(){}
	
	public static PopulationGenerator getInstance(){
		if(instance == null){instance = new PopulationGenerator();}
		return instance;
	}
	
	public static void generate(){
		
	}
	
<<<<<<< HEAD
	public static void setNewValues(){
		
	}
	
=======
>>>>>>> GUIAngela
}
