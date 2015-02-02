package nl.ecoquest.vk.view;

import nl.ecoquest.vk.model.SimulatorModel;
import nl.ecoquest.vk.simulation.Updateable;

/**
 * GraphView is a representation of the data model outputs
 * in a simple line chart
 * @author Angela
 *
 */

public class GraphView extends AbstractView implements Updateable{

	private static final long serialVersionUID = 1L;

	//TODO fix histogram
	public GraphView(SimulatorModel model) {
		super(model);

		this.setVisible(true);
	}
	

	@Override
	public void update() {
		super.updateView();		
	}
}
