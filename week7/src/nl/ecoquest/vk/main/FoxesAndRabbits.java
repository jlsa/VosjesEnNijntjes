package nl.ecoquest.vk.main;

import javax.swing.JFrame;

import nl.ecoquest.vk.controller.*;
import nl.ecoquest.vk.logic.*;
import nl.ecoquest.vk.view.*;

public class FoxesAndRabbits {
	private JFrame screen;
	private AbstractView fieldView;
	private AbstractView statView;
	private FRLogic frLogic;
	private AbstractController initController;
	private AbstractController runController;
	
	public FoxesAndRabbits()
	{
		frLogic = new FRLogic();
		initController = new InitController(frLogic);
		runController = new RunController(frLogic);
		
		fieldView = new FieldView(frLogic);
		statView = new StatView(frLogic);
		
		screen = new JFrame("Foxes and Rabbits the simulation");
		screen.setSize(1024, 768);
		screen.setLocation(0, 0);
		screen.setResizable(false);
		screen.setLayout(null);
		
		screen.getContentPane().add(fieldView);
		screen.getContentPane().add(statView);
		screen.getContentPane().add(initController);
		screen.getContentPane().add(runController);
		
		fieldView.setBounds(10, 10, (1024/2)-10, 560);
		statView.setBounds((1024/2)+10, 10, 200, 200);
		runController.setBounds(10, 600, 450, 50);
		initController.setBounds(512+20+210, 10, 90, 130);
		
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setVisible(true);
	}
}
