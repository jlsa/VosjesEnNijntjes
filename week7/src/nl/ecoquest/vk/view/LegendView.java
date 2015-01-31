package nl.ecoquest.vk.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class LegendView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public LegendView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 150, 125);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel namePanel = new JPanel();
		contentPane.add(namePanel);
		namePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblRabbits = new JLabel("Rabbits:");
		lblRabbits.setHorizontalAlignment(SwingConstants.TRAILING);
		namePanel.add(lblRabbits);
		
		JLabel lblFoxes = new JLabel("Foxes:");
		lblFoxes.setHorizontalAlignment(SwingConstants.TRAILING);
		namePanel.add(lblFoxes);
		
		JLabel lblBears = new JLabel("Bears:");
		lblBears.setHorizontalAlignment(SwingConstants.TRAILING);
		namePanel.add(lblBears);
		
		JLabel lblHunters = new JLabel("Hunters:");
		lblHunters.setHorizontalAlignment(SwingConstants.TRAILING);
		namePanel.add(lblHunters);
		
		JPanel colourPanel = new JPanel();
		contentPane.add(colourPanel);
		colourPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblRabbitColour = new JLabel("colour1");
		colourPanel.add(lblRabbitColour);
		
		JLabel lblFoxColour = new JLabel("colour2");
		colourPanel.add(lblFoxColour);
		
		JLabel lblBearColour = new JLabel("colour3");
		colourPanel.add(lblBearColour);
		
		JLabel lblHunterColour = new JLabel("colour4");
		colourPanel.add(lblHunterColour);
	}

}
