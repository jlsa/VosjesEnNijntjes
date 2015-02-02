package nl.ecoquest.vk.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import nl.ecoquest.vk.model.SimulatorModel;
import nl.ecoquest.vk.view.LegendView;


public class MenubarController extends AbstractController implements ActionListener{

	private static final long serialVersionUID = 1L;
	private LegendView legendView;

	public MenubarController(SimulatorModel model){
		super(model);
		legendView = new LegendView(model);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Quit"){
			System.exit(0);
		}else if (e.getActionCommand() == "Legend"){
			legendView.getFrame().setVisible(true);
		}
		
	}
}
