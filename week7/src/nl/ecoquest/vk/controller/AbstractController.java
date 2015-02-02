package nl.ecoquest.vk.controller;

import javax.swing.JPanel;

import nl.ecoquest.vk.model.SimulatorModel;

@SuppressWarnings("serial")
public abstract class AbstractController extends JPanel {
	protected SimulatorModel model;
	
	public AbstractController(SimulatorModel model) {
		this.model=model;
	}
}
