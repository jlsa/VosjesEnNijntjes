package nl.ecoquest.vk.view;

import nl.ecoquest.vk.model.SimulatorModel;
import nl.ecoquest.vk.simulation.Updateable;

/**
 * PieView is a representation of the data model outputs
 * in a simple pie chart
 * @author Angela
 *
 */
public class PieView extends AbstractView implements Updateable{
	
	private static final long serialVersionUID = 1L;
//TODO fix PieView
	public PieView(SimulatorModel model){
		super(model);
		

		this.setVisible(true);
	}
	

	@Override
	public void update() {
		super.updateView();		
	}
}