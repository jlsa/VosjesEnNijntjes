package nl.ecoquest.vk.model;

import nl.ecoquest.vk.view.*;

import java.util.*;

public abstract class AbstractModel {
	protected List<AbstractView> views;
	
	public AbstractModel() {
		views = new ArrayList<AbstractView>();
	}
	
	public void addView(AbstractView view) {
		views.add(view);
	}
	
	protected void notifyViews() {
		for(AbstractView view: views) {
			view.updateView();
		}
	}
	
}