package nl.ecoquest.vk.view;

import javax.swing.*;
import nl.ecoquest.vk.logic.*;

public abstract class AbstractView extends JPanel 
{
	private static final long serialVersionUID = 1L;
	protected FRLogic frLogic;
	
	public AbstractView(FRLogic frLogic) {
		this.frLogic = frLogic;
		frLogic.addView(this);
	}
	
	public FRLogic getModel() {
		return frLogic;
	}
	
	public void updateView() {
		repaint();
	}
}
