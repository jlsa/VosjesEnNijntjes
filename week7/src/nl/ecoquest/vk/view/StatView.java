package nl.ecoquest.vk.view;

import java.awt.Color;
import java.awt.Graphics;

<<<<<<< HEAD
import nl.ecoquest.vk.actor.*;
import nl.ecoquest.vk.actor.animal.*;
import nl.ecoquest.vk.actor.environment.*;
import nl.ecoquest.vk.actor.human.*;
import nl.ecoquest.vk.model.*;
=======
import nl.ecoquest.vk.model.SimulatorModel;
>>>>>>> GUIAngela

@SuppressWarnings("serial")
public class StatView extends AbstractView {
	
	private int cirkelSize = 150;
	
	public StatView(SimulatorModel model) {
		super(model);
		setSize(300, 300);
	}
	
	@Override
	public void updateView() {
		super.updateView();
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		int pieSize = 300;
		g.fillRect(0, 0, pieSize, pieSize);
		//float rC = (float) model.getCount(Rabbit.class);
		/*float fC = (float)this.model.getCount(Fox.class);
		float bC = (float)this.model.getCount(Bear.class);
		float hC = (float)this.model.getCount(Hunter.class);
		float gC = (float)this.model.getCount(Grass.class);
		*/
		/*float total = rC + fC + bC + hC + gC;

		float temp = 0.0f;

		temp = (3.6f * ((rC/total)*100));
		int rA = Math.round(temp);

		temp = (3.6f * ((fC/total)*100));
		int fA = Math.round(temp);

		temp = (3.6f * ((bC/total)*100));
		int bA = Math.round(temp);

		temp = (3.6f * ((hC/total)*100));
		int hA = Math.round(temp);

		temp = (3.6f * ((gC/total)*100));
		int gA = Math.round(temp);

		g.setColor(this.model.getColor(Rabbit.class));
		g.fillArc((this.getWidth()-this.cirkelSize)/2, (this.getHeight()-this.cirkelSize)/2, this.cirkelSize, this.cirkelSize, 0, rA);
		g.setColor(this.model.getColor(Fox.class));
		g.fillArc((this.getWidth()-this.cirkelSize)/2, (this.getHeight()-this.cirkelSize)/2, this.cirkelSize, this.cirkelSize, rA, fA);
		g.setColor(this.model.getColor(Bear.class));
		g.fillArc((this.getWidth()-this.cirkelSize)/2, (this.getHeight()-this.cirkelSize)/2, this.cirkelSize, this.cirkelSize, (fA + rA) , bA);
		g.setColor(this.model.getColor(Hunter.class));
		g.fillArc((this.getWidth()-this.cirkelSize)/2, (this.getHeight()-this.cirkelSize)/2, this.cirkelSize, this.cirkelSize, (fA + rA + bA) , hA);
		g.setColor(this.model.getColor(Grass.class));
		g.fillArc((this.getWidth()-this.cirkelSize)/2, (this.getHeight()-this.cirkelSize)/2, this.cirkelSize, this.cirkelSize, (fA + rA + bA + hA) , gA);
		*/
		/*
		int[][] state = model.getField();
		
		if(state == null) return;
		
		float c1 = 0.0f;
		float c2 = 0.0f;
		float c3 = 0.0f;
		float c4 = 0.0f;
		float non = 0.0f;
		for(int i = 0; i < state.length; i++) {
			for(int j = 0; j < state[i].length; j++) {
				if(state[i][j] == 1) {
					c1++;
				}
				if(state[i][j] == 2) {
					c2++;
				}
				if(state[i][j] == 3) {
					c3++;
				}
				if(state[i][j] == 4) {
					c4++;
				}
				if(state[i][j] == 0) {
					non++;
				}
			}
		}
		
		float total = c1 + c2 + c3 + c4 + non;
		float temp = 0.0f;
		
		temp = (3.6f * ((c1/total) * 100));
		int begin1 = 0;
		int end1 = Math.round(temp);
		
		temp = (3.6f * ((c2/total) * 100));
		int begin2 = end1;
		int end2 = Math.round(temp);
		
		temp = (3.6f * ((c3/total) * 100));
		int begin3 = end1 + end2;
		int end3 = Math.round(temp);
		
		temp = (3.6f * ((c4/total) * 100));
		int begin4 = end1 + end2 + end3;
		int end4 = Math.round(temp);
		
		temp = (3.6f * ((non/total) * 100));
		int beginNon = end1 + end2 + end3 + end4;
		int endNon = Math.round(temp);
		
		
		int x = (300 - pieSize) / 2;
		int y = (300 - pieSize) / 2;
		int width = pieSize;
		int height = pieSize;
		g.setColor(Color.blue);
		g.fillArc(x, y, width, height, begin1, end1);
		
		g.setColor(Color.red);
		g.fillArc(x, y, width, height, begin2, end2);
		
		g.setColor(Color.pink);
		g.fillArc(x, y, width, height, begin3, end3);
		
		g.setColor(Color.green);
		g.fillArc(x, y, width, height, begin4, end4);
		
		g.setColor(Color.lightGray);
		g.fillArc(x, y, width, height, beginNon, endNon);
		
		*/
	}
}
