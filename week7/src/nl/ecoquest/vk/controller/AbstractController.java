package nl.ecoquest.vk.controller;

import javax.swing.*;
import nl.ecoquest.vk.logic.*;
public abstract class AbstractController extends JPanel {
	protected FRLogic frLogic;
	
	public AbstractController(FRLogic frLogic) {
		this.frLogic=frLogic;
	}
}
