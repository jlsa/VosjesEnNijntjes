package nl.ecoquest.vk.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import nl.ecoquest.vk.actor.animal.Bear;
import nl.ecoquest.vk.actor.animal.Fox;
import nl.ecoquest.vk.actor.animal.Rabbit;
import nl.ecoquest.vk.actor.human.Hunter;
import nl.ecoquest.vk.model.SimulatorModel;

public class LegendView extends AbstractView {

	private static final long serialVersionUID = 1L;
	private static HashMap<String, Color> KNOWNCOLORS = new HashMap<String, Color>();
	private JPanel contentPane;
	private JFrame frame;
	private LinkedHashMap<Class<?>, Color> colors;
	
    static {
        KNOWNCOLORS.put("black",     Color.black);
        KNOWNCOLORS.put("darkgray",  Color.darkGray);
        KNOWNCOLORS.put("lightgray", Color.lightGray);
        KNOWNCOLORS.put("white",     Color.white);
        KNOWNCOLORS.put("red",       Color.red);
        KNOWNCOLORS.put("blue",      Color.blue);
        KNOWNCOLORS.put("green",     Color.green);
        KNOWNCOLORS.put("pink",      Color.pink);
        KNOWNCOLORS.put("cyan",      Color.cyan);
        KNOWNCOLORS.put("purple",    Color.magenta);
        KNOWNCOLORS.put("orange",    Color.orange);
        KNOWNCOLORS.put("yellow",    Color.yellow);
    }


	/**
	 * Create the frame.
	 * @param model The simulator model
	 */
	public LegendView(SimulatorModel model) {
		super(model);
		frame = new JFrame("Legend");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
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
		
		JLabel lblRabbitColour = new JLabel();
		JLabel lblFoxColour = new JLabel();
		JLabel lblBearColour = new JLabel();
		JLabel lblHunterColour = new JLabel();
		
		colors = model.getColors();
		for(Map.Entry<Class<?>, Color> entry : colors.entrySet()){
			Color color = entry.getValue();
			String name = getBestColorName(color);
			if(entry.getKey() == Rabbit.class){
				lblRabbitColour.setText(name);
			}else if(entry.getKey() == Fox.class){
				lblFoxColour.setText(name);
			}else if(entry.getKey() == Bear.class){
				lblBearColour.setText(name);
			}else if(entry.getKey() == Hunter.class){
				lblHunterColour.setText(name);
			}
		}				
		
		colourPanel.add(lblRabbitColour);
		colourPanel.add(lblFoxColour);
		colourPanel.add(lblBearColour);
		colourPanel.add(lblHunterColour);

		frame.setSize(getPreferredSize());
		frame.pack();
	}
	
	public static String getBestColorName(Color c){
        int dist, diff = Integer.MAX_VALUE;
        String colorName = toHex(c);
        Color c2;

        for (String name : KNOWNCOLORS.keySet()) {
            c2 = KNOWNCOLORS.get(name);
            dist = Math.abs(c.getRed() - c2.getRed())
                    + Math.abs(c.getGreen() - c2.getGreen()) 
                    + Math.abs(c.getBlue() - c2.getBlue())
                    + Math.abs(c.getAlpha() - c2.getAlpha());

            if (dist < diff) {
                diff = dist;
                colorName = name; 
            }
        }

        return colorName;
	}
	
    static public int getColorValue(Color c) {
        return (c.getAlpha() << 24) 
            | (c.getRed() << 16)
            | (c.getGreen() << 8) 
            | (c.getBlue()); 
    }

    static public String toHex(Color c) {
        StringBuilder b = new StringBuilder();
        if (c.getAlpha() < 255) {
            b.append(padLeft(Integer.toString(c.getAlpha(), 16), 2));
        }
        b.append(padLeft(Integer.toString(c.getRed(), 16), 2));
        b.append(padLeft(Integer.toString(c.getGreen(), 16), 2));
        b.append(padLeft(Integer.toString(c.getBlue(), 16), 2));

        return b.toString();
    }
    
    static private String padLeft(String s, int n) {
    	if (n <= 0){
    		return s;
    	}
    	int noOfSpaces = n * 2;
    	StringBuilder output = new StringBuilder(s.length() + noOfSpaces);
    	while (noOfSpaces > 0){
    		output.append("0");
    		noOfSpaces--;
    	}
    	output.append(s);
        //return String.format("%1$#" + n + "s", s).replace(" ", "0");
    	return output.toString();
    }
	
	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}
}
