package nl.ecoquest.vk.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import nl.ecoquest.vk.view.LegendView;


public class MenubarController implements ActionListener{

	private static final long serialVersionUID = 1L;
	private LegendView legendView = new LegendView();

	public MenubarController(){
		System.out.println("add menubar controller");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Quit"){
			System.out.println("Quit");
			System.exit(0);
		}else if (e.getActionCommand() == "Legend"){
			System.out.println("show legend");
			legendView.setVisible(true);
		}
		
	}
}
