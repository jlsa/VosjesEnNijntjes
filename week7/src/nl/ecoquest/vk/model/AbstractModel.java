package nl.ecoquest.vk.model;

import java.util.ArrayList;
import java.util.List;

import nl.ecoquest.vk.view.AbstractView;

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