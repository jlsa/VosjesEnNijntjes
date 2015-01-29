package nl.ecoquest.vk.view;

import java.awt.*;
import nl.ecoquest.vk.model.*;

public class FieldView extends AbstractView {
	
	private int w = 300;
	private int h = 300;
	private static final long serialVersionUID = 1L;

	public FieldView(SimulatorModel model) {
		super(model);
		setSize(w, h);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, w, h);
		g.setColor(Color.blue);
		
		
		int[][] state = model.getField();
		
		if(state == null) {
			return;
		}
		
		int margin = 0;//200 - state.length * 2;
		for(int i = 0; i < state.length; i++) {
			for(int j = 0; j < state[i].length; j++) {
				if(state[i][j] == 1) {
					g.setColor(Color.blue);
					g.fillRect(margin+4*i, margin+4*j, 3, 3);
				}
				if(state[i][j] == 2) {
					g.setColor(Color.red);
					g.fillRect(margin+4*i, margin+4*j, 3, 3);
				}
				
				if(state[i][j] == 3) {
					g.setColor(Color.pink);
					g.fillRect(margin+4*i, margin+4*j, 3, 3);
				}
				
				if(state[i][j] == 3) {
					g.setColor(Color.green);
					g.fillRect(margin+4*i, margin+4*j, 3, 3);
				}
			}
		}
	}
}
