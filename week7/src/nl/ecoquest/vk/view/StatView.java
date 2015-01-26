package nl.ecoquest.vk.view;

import java.awt.*;

import nl.ecoquest.vk.logic.FRLogic;

public class StatView extends AbstractView {
	public StatView(FRLogic frLogic) {
		super(frLogic);
		setSize(200, 200);
	}
	
	@Override
	public void updateView() {
		super.updateView();
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 200, 200);
		int[][] state = frLogic.getState();
		
		if(state == null) return;
		
		float count = 0;
		for(int i = 0; i < state.length; i++) {
			for(int j = 0; j < state[i].length; j++) {
				if(state[i][j] == 1) {
					count++;
				}
			}
		}
		
		int angle = (int)(360 * (count / (state.length*state.length)));
		g.setColor(Color.blue);
		g.fillArc(10, 10, 180, 180, 0, angle);
		g.setColor(Color.lightGray);
		g.fillArc(10, 10, 180, 180, angle, 360-angle);
	}
}
