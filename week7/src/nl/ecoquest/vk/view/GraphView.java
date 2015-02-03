package nl.ecoquest.vk.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Iterator;

import nl.ecoquest.vk.actor.animal.Fox;
import nl.ecoquest.vk.actor.environment.Grass;
import nl.ecoquest.vk.model.SimulatorModel;
import nl.ecoquest.vk.simulation.FieldStats;
import nl.ecoquest.vk.simulation.Updateable;

/**
 * GraphView is a representation of the data model outputs
 * in a simple line chart
 * @author Angela, Joel
 */

public class GraphView extends AbstractView implements Updateable {

	private static final long serialVersionUID = 1L;

	private FieldStats stats;
	
	public GraphView(SimulatorModel model) {
		super(model);

		stats = model.getFieldStats();
		this.setVisible(true);
	}

	@Override
	public void update() {
		super.updateView();
	}
}
