/**
 * 
 */
package nl.ecoquest.vk.view;

import nl.ecoquest.vk.model.SimulatorModel;
import nl.ecoquest.vk.simulation.Updateable;

/**
 * @author Angela
 *
 */
public class TextView extends AbstractView implements Updateable{

	private static final long serialVersionUID = 1L;
	private SimulatorModel model;

	public TextView(SimulatorModel model) {
		super(model);
		this.model = model;
	}
	
	private void splitText(SimulatorModel model){
		String data = model.getPopulationDetails();
		String[] lines = data.split(" ");
		
		System.out.println(model.getStepsTaken());
		for(int i = 0; i <= lines.length; i+=3){
			System.out.print(lines[i]);
			System.out.print(": ");
			System.out.print(lines[i] + "\n");			
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		splitText(model);
	}

}
