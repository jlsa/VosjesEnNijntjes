package nl.ecoquest.vk.controller;
import java.awt.event.*;

import javax.swing.*;

import nl.ecoquest.vk.logic.*;

public class InitController extends AbstractController implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JTextField size;
	private JTextField degree;
	private JButton init;
	
	public InitController(FRLogic frLogic) {
		super(frLogic);
		setSize(90, 130);
		size = new JTextField("123");
		degree = new JTextField("0.5");
		
		init = new JButton("Init");
		init.addActionListener(this);
		
		this.setLayout(null);
		add(size);
		add(degree);
		add(init);
		
		size.setBounds(10, 10, 70, 30);
		degree.setBounds(10, 50, 70, 30);
		init.setBounds(10, 90, 70, 30);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			int sizeField = parseSize();
			float degreeField = parseDegree();
			frLogic.setSize(sizeField);
			frLogic.setDegree(degreeField);
			frLogic.randomInit();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private int parseSize() throws NumberFormatException {
		return Integer.parseInt(size.getText());
	}
	
	private float parseDegree() throws NumberFormatException {
		return Float.parseFloat(degree.getText());
	}
}
