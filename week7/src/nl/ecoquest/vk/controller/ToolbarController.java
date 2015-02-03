package nl.ecoquest.vk.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import nl.ecoquest.vk.model.SimulatorModel;
import nl.ecoquest.vk.view.DefaultView;
import nl.ecoquest.vk.view.OptionsView;
import nl.ecoquest.vk.view.StatisticsView;

public class ToolbarController extends AbstractController {

	private static final long serialVersionUID = 1L;
	private DefaultView view;
	private OptionsView options;
	private StatisticsView stats;
	
	public ToolbarController(SimulatorModel model, DefaultView view, StatisticsView stats) {
		super(model);
		this.view = view;
		this.stats = stats;
		options = new OptionsView(model);
		addButtonListeners();
		
	}

	private void addButtonListeners(){
		view.addActionListeners(new Run(), new OneStep(), new Step100(), new Stop(), new Reset(), new Stats(), new Options());
	}
	
	private class Run implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.simulateInfinite();
		}
		
	}
	
	private class OneStep implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.simulate(1);
		}
		
	}
	
	private class Step100 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.simulate(100);
			
		}
		
	}
	
	private class Stop implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.stop();
		}
		
	}
	private class Reset implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.reset();
		}
		
	}
	
	private class Stats implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			stats.setVisible(true);
		}
		
	}
	
	private class Options implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			options.setVisible(true);
			
		}
		
	}

}
