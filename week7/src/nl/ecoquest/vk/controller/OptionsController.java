package nl.ecoquest.vk.controller;

<<<<<<< HEAD
=======
import java.awt.Color;
>>>>>>> GUIAngela
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
=======
import java.util.LinkedHashMap;
import java.util.Map;
>>>>>>> GUIAngela

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.*;

import nl.ecoquest.vk.model.*;

/**
 * OptionsController is the controller meant to control the options window
 * @author Angela
 *
 */
public class OptionsController extends AbstractController implements ChangeListener, ActionListener{

	private static final long serialVersionUID = 1L;
	private String name;

	/**
	 * Create the controller.
	 * Model is a parameter because we need to edit it.
	 * @param model
	 */
	public OptionsController(SimulatorModel model){
		super(model);
	}
	
	/**
	 * Handle the events generated by the JSpinners'
	 * Values are directly committed
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		Object source = e.getSource();
		
		if(source instanceof JSpinner){
			JSpinner spinner = (JSpinner) e.getSource();
			name = spinner.getName();
			if(name.startsWith("rabbit")){
				rabbitEvents();
			}else if(name.startsWith("fox")){
				foxEvents();
			}else if(name.startsWith("bear")){
				bearEvents();
			}else if(name.startsWith("hunter")){
				hunterEvents();
			}
		}
	}
	
	//TODO update fields in animal
	
	private void rabbitEvents(){
		if("rabbitBreedingAge".equals(name)){
			System.out.println("rabbit breeding age changed!");
		}else if ("rabbitMaxAge".equals(name)){
			System.out.println("rabbit max age changed!");
		}else if ("rabbitBabyChance".equals(name)){
			System.out.println("rabbit baby chance changed!");
		}else if ("rabbitMaxBabies".equals(name)){
			System.out.println("rabbit litter size has changed");
		}else if ("rabbitFoodValue".equals(name)){
			System.out.println("rabbit food value changed");
		}
		
	}


	private void foxEvents() {
		if("foxBreedingAge".equals(name)){
			System.out.println("fox breeding age changed!");
		}else if ("foxMaxAge".equals(name)){
			System.out.println("fox max age changed!");
		}else if ("foxBabyChance".equals(name)){
			System.out.println("fox baby chance changed!");
		}else if ("foxMaxBabies".equals(name)){
			System.out.println("fox litter size has changed");
		}else if ("foxFoodValue".equals(name)){
			System.out.println("fox food value changed");
		}
	}

	private void bearEvents() {
		if("bearBreedingAge".equals(name)){
			System.out.println("bear breeding age changed!");
		}else if ("bearMaxAge".equals(name)){
			System.out.println("bear max age changed!");
		}else if ("bearBabyChance".equals(name)){
			System.out.println("bear baby chance changed!");
		}else if ("bearMaxBabies".equals(name)){
			System.out.println("bear litter size has changed");
		}else if ("bearFoodValue".equals(name)){
			System.out.println("bear food value changed");
		}
	}
	
	private void hunterEvents() {
		JFrame hunter = new JFrame();
		JLabel noChoice = new JLabel("Hunters have no option but to KILL");
		noChoice.setHorizontalAlignment(SwingConstants.CENTER);
		noChoice.setFont(new Font("Serif", Font.PLAIN, 35));
		hunter.add(noChoice);
		hunter.pack();
		hunter.setLocationRelativeTo(null);
		hunter.setVisible(true);
		hunter.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * Handle the events generated by the close button and the JComboBox
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		
		if(source instanceof JComboBox){
			JComboBox box = (JComboBox) e.getSource();
			String name = box.getName();
			String value = (String) box.getSelectedItem();
			if(name.startsWith("rabbit")){
				if (value.equals("Yes")){
					/*Rabbit poorRabbit = new Rabbit();
					poorRabbit.setSick();
					*/
					System.out.println("Rabbits can get sick!");
				}else{
					System.out.println("Rabbits can't get sick");
				}
			}
		}else if(source instanceof JButton){
			JButton button = (JButton) e.getSource();
			String name = button.getName();
			if(name.equals("Close")){
				Window windowAncestor = SwingUtilities.getWindowAncestor(button); 
				windowAncestor.dispose();
			}
		}
	}
}
	


