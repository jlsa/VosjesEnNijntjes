package nl.ecoquest.vk.logic;

import nl.ecoquest.vk.view.*;

import java.util.*;

public abstract class AbstractModel {
	private List<AbstractView> views;
	
	public AbstractModel() {
		views = new ArrayList<AbstractView>();
	}
	
	public void addView(AbstractView view) {
		views.add(view);
	}
	
	public void notifyViews() {
		for(AbstractView view: views) {
			view.updateView();
		}
	}
	
}
