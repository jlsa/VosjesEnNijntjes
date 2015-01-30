package nl.ecoquest.vk.view;

import javax.swing.*;

import nl.ecoquest.vk.model.*;

public abstract class AbstractView extends JPanel 
{
	private static final long serialVersionUID = 1L;
	protected SimulatorModel model;
	
	public AbstractView(SimulatorModel model) {
		this.model = model;
		model.addView(this);
	}
	
	public SimulatorModel getModel() {
		return model;
	}
	
	public void updateView() {
		repaint();
	}
	
	public void preparePaint() {}
	

}
