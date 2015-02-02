package nl.ecoquest.vk.view;

import javax.swing.JPanel;

import nl.ecoquest.vk.model.SimulatorModel;

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
