package nl.ecoquest.vk.view;

import javax.swing.JTextArea;

import nl.ecoquest.vk.model.SimulatorModel;
import nl.ecoquest.vk.simulation.Updateable;

/**
 * Textview is a simple view of the current simulation.
 * It's job is to simply print the population.
 * @author Angela 
 *  
 */
public class TextView extends AbstractView implements Updateable{
//TODO fix TextView
	private static final long serialVersionUID = 1L;
	private SimulatorModel model;
	private JTextArea textArea;

	public TextView(SimulatorModel model) {
		super(model);
		this.setVisible(true);
	}
	

	@Override
	public void update() {
		//TODO add update method
	}

}
