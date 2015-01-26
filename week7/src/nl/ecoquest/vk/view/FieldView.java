package nl.ecoquest.vk.view;

import java.awt.*;
import nl.ecoquest.vk.logic.*;

public class FieldView extends AbstractView {
	
	private int w = 600;
	private int h = 600;
	private static final long serialVersionUID = 1L;

	public FieldView(FRLogic frLogic) {
		super(frLogic);
		setSize(w, h);
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, w, h);
		g.setColor(Color.blue);
			
		int[][] state = frLogic.getState();
		
		if(state == null) {
			return;
		}
		
		int margin = 0;//200 - state.length * 2;
		for(int i = 0; i < state.length; i++) {
			for(int j = 0; j < state[i].length; j++) {
				if(state[i][j] == 1) {
					g.fillRect(margin+4*i, margin+4*j, 3, 3);
				}
			}
		}
	}
}
