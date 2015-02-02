package nl.ecoquest.vk.controller;

import javax.swing.*;

import nl.ecoquest.vk.model.*;

@SuppressWarnings("serial")
public abstract class AbstractController extends JPanel {
	protected SimulatorModel model;
	
	public AbstractController(SimulatorModel model) {
		this.model=model;
	}
}
