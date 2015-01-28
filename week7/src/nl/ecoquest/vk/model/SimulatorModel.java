package nl.ecoquest.vk.model;

import nl.ecoquest.vk.model.AbstractModel;
import nl.ecoquest.vk.simulation.*;

public class SimulatorModel extends AbstractModel {
	public SimulatorModel() {
		
	}
	
	public int[][] getField() {
		Randomizer r = new Randomizer();
		int size = 50;
		int[][] state = new int[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				state[i][j] = r.getRandom().nextInt(5);
			}
		}
		return state;
	}
}
