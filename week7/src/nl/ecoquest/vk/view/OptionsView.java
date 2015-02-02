package nl.ecoquest.vk.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import nl.ecoquest.vk.controller.OptionsController;
import nl.ecoquest.vk.model.SimulatorModel;

public class OptionsView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private SimulatorModel model;
	private ArrayList<JComponent> spinners = new ArrayList<JComponent>();
	private ArrayList<JComponent> boxes = new ArrayList<JComponent>();

	/**
	 * Create the frame.
	 */
	public OptionsView(SimulatorModel model) {
		this.model = model;
		this.setTitle("Options");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		addTabbedPanel();
		addRabbitPanel();
		addFoxPanel();
		addBearPanel();
		addHunterPanel();
		
		addButtons();
		addIcons();
	}
	
	private void addTabbedPanel(){
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}
	
	private void addRabbitPanel(){
		JPanel rabbitPanel = new JPanel();
		rabbitPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Rabbits", null, rabbitPanel, "Edit the rabbits");
		rabbitPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblRabbitBreedingAge = new JLabel("Breeding Age");
		lblRabbitBreedingAge.setHorizontalAlignment(SwingConstants.TRAILING);
		rabbitPanel.add(lblRabbitBreedingAge);
		
		JSpinner rabbitBreedingAge = new JSpinner();
		rabbitBreedingAge.setName("rabbitBreedingAge");
		lblRabbitBreedingAge.setLabelFor(rabbitBreedingAge);
		rabbitBreedingAge.addChangeListener(new OptionsController(model));
		rabbitPanel.add(rabbitBreedingAge);
		
		JLabel lblRabbitMaxAge = new JLabel("Max Age");
		lblRabbitMaxAge.setHorizontalAlignment(SwingConstants.TRAILING);
		rabbitPanel.add(lblRabbitMaxAge);
		
		JSpinner rabbitMaxAge = new JSpinner();
		rabbitMaxAge.setName("rabbitMaxAge");
		lblRabbitMaxAge.setLabelFor(rabbitMaxAge);
		rabbitMaxAge.addChangeListener(new OptionsController(model));
		rabbitPanel.add(rabbitMaxAge);
		
		JLabel lblRabbitBabyChance = new JLabel("Baby Chance");
		lblRabbitBabyChance.setHorizontalAlignment(SwingConstants.TRAILING);
		rabbitPanel.add(lblRabbitBabyChance);
		
		JSpinner rabbitBabyChance = new JSpinner();
		rabbitBabyChance.setName("rabbitBabyChance");
		rabbitBabyChance.addChangeListener(new OptionsController(model));
		lblRabbitBabyChance.setLabelFor(rabbitBabyChance);
		rabbitPanel.add(rabbitBabyChance);
		
		JLabel lblRabbitMaxBabies = new JLabel("Max Babies");
		lblRabbitMaxBabies.setHorizontalAlignment(SwingConstants.TRAILING);
		rabbitPanel.add(lblRabbitMaxBabies);
		
		JSpinner rabbitMaxBabies = new JSpinner();
		rabbitMaxBabies.setName("rabbitMaxBabies");
		rabbitMaxBabies.addChangeListener(new OptionsController(model));
		lblRabbitMaxBabies.setLabelFor(rabbitMaxBabies);
		rabbitPanel.add(rabbitMaxBabies);
		
		JLabel lblRabbitFoodValue = new JLabel("Food Value");
		lblRabbitFoodValue.setHorizontalAlignment(SwingConstants.TRAILING);
		rabbitPanel.add(lblRabbitFoodValue);
		
		JSpinner rabbitFoodValue = new JSpinner();
		rabbitFoodValue.setName("rabbitFoodValue");
		rabbitFoodValue.addChangeListener(new OptionsController(model));
		lblRabbitFoodValue.setLabelFor(rabbitFoodValue);
		rabbitPanel.add(rabbitFoodValue);
		
		JLabel lblRabbitsickness = new JLabel("Sickness");
		lblRabbitsickness.setHorizontalAlignment(SwingConstants.TRAILING);
		rabbitPanel.add(lblRabbitsickness);
		
		JComboBox rabbitSickBox = new JComboBox();
		rabbitSickBox.setName("rabbitSick");
		rabbitSickBox.addActionListener(new OptionsController(model));
		lblRabbitsickness.setLabelFor(rabbitSickBox);
		rabbitSickBox.setToolTipText("Can the animal get sick?");
		rabbitSickBox.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		rabbitSickBox.setSelectedIndex(1);
		rabbitPanel.add(rabbitSickBox);
		
		spinners.add(rabbitBreedingAge);
		spinners.add(rabbitMaxAge);
		spinners.add(rabbitBabyChance);
		spinners.add(rabbitMaxBabies);
		spinners.add(rabbitFoodValue);
		
		boxes.add(rabbitSickBox);
	}

	private void addFoxPanel(){
		JPanel foxPanel = new JPanel();
		foxPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Foxes", null, foxPanel, "Edit the foxes");
		foxPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblFoxBreedingAge = new JLabel("Breeding Age");
		lblFoxBreedingAge.setHorizontalAlignment(SwingConstants.TRAILING);
		foxPanel.add(lblFoxBreedingAge);
		
		JSpinner foxBreedingAge = new JSpinner();
		foxBreedingAge.setName("foxBreedingAge");
		foxBreedingAge.addChangeListener(new OptionsController(model));
		lblFoxBreedingAge.setLabelFor(foxBreedingAge);
		foxPanel.add(foxBreedingAge);
		
		JLabel lblFoxMaxAge = new JLabel("Max Age");
		lblFoxMaxAge.setHorizontalAlignment(SwingConstants.TRAILING);
		foxPanel.add(lblFoxMaxAge);
		
		JSpinner foxMaxAge = new JSpinner();
		foxMaxAge.setName("foxMaxAge");
		foxMaxAge.addChangeListener(new OptionsController(model));
		lblFoxMaxAge.setLabelFor(foxMaxAge);
		foxPanel.add(foxMaxAge);	
							
		JLabel lblFoxBabyChance = new JLabel("Baby Chance");
		lblFoxBabyChance.setHorizontalAlignment(SwingConstants.TRAILING);
		foxPanel.add(lblFoxBabyChance);
		
		JSpinner foxBabyChance = new JSpinner();
		foxBabyChance.setName("foxBabyChance");
		foxBabyChance.addChangeListener(new OptionsController(model));
		lblFoxBabyChance.setLabelFor(foxBabyChance);
		foxPanel.add(foxBabyChance);
		
		
		JLabel lblFoxMaxBabies = new JLabel("Max Babies");
		lblFoxMaxBabies.setHorizontalAlignment(SwingConstants.TRAILING);
		foxPanel.add(lblFoxMaxBabies);
		
		JSpinner foxMaxBabies = new JSpinner();
		foxMaxBabies.setName("foxMaxBabies");
		foxMaxBabies.addChangeListener(new OptionsController(model));
		lblFoxMaxBabies.setLabelFor(foxMaxBabies);
		foxPanel.add(foxMaxBabies);
		
		JLabel lblFoxFoodValue = new JLabel("Food Value");
		lblFoxFoodValue.setHorizontalAlignment(SwingConstants.TRAILING);
		foxPanel.add(lblFoxFoodValue);
		
		JSpinner foxFoodValue = new JSpinner();
		foxFoodValue.setName("foxFoodValue");
		foxFoodValue.addChangeListener(new OptionsController(model));
		lblFoxFoodValue.setLabelFor(foxFoodValue);
		foxPanel.add(foxFoodValue);
		
		spinners.add(foxBreedingAge);
		spinners.add(foxMaxAge);
		spinners.add(foxBabyChance);
		spinners.add(foxMaxBabies);
		spinners.add(foxFoodValue);
	}
	
	private void addBearPanel(){
		JPanel bearPanel = new JPanel();
		bearPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Bears", null, bearPanel, "RAWR!");
		bearPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblBearBreedingAge = new JLabel("Breeding Age");
		lblBearBreedingAge.setHorizontalAlignment(SwingConstants.TRAILING);
		bearPanel.add(lblBearBreedingAge);
		
		JSpinner bearBreedingAge = new JSpinner();
		bearBreedingAge.setName("bearBreedingAge");
		bearBreedingAge.addChangeListener(new OptionsController(model));
		bearPanel.add(bearBreedingAge);
		
		JLabel lblBearMaxAge = new JLabel("Max Age");
		lblBearMaxAge.setBackground(Color.WHITE);
		lblBearMaxAge.setHorizontalAlignment(SwingConstants.TRAILING);
		bearPanel.add(lblBearMaxAge);
		
		JSpinner bearMaxAge = new JSpinner();
		bearMaxAge.setName("bearMaxAge");
		bearMaxAge.addChangeListener(new OptionsController(model));
		bearPanel.add(bearMaxAge);
		
		JLabel lblBearBabyChance = new JLabel("Baby Chance");
		lblBearBabyChance.setHorizontalAlignment(SwingConstants.TRAILING);
		bearPanel.add(lblBearBabyChance);
		
		JSpinner bearBabyChance = new JSpinner();
		bearBabyChance.setName("bearBabyChance");
		bearBabyChance.addChangeListener(new OptionsController(model));
		bearPanel.add(bearBabyChance);
		
		JLabel lblBearMaxBabies = new JLabel("Max Babies");
		lblBearMaxBabies.setHorizontalAlignment(SwingConstants.TRAILING);
		bearPanel.add(lblBearMaxBabies);
		
		JSpinner bearMaxBabies = new JSpinner();
		bearMaxBabies.setName("bearMaxBabies");
		bearMaxBabies.addChangeListener(new OptionsController(model));
		bearPanel.add(bearMaxBabies);
		
		JLabel lblBearFoodValue = new JLabel("Food Value");
		lblBearFoodValue.setHorizontalAlignment(SwingConstants.TRAILING);
		bearPanel.add(lblBearFoodValue);
		
		JSpinner bearFoodValue = new JSpinner();
		bearFoodValue.setName("bearFoodValue");
		bearFoodValue.addChangeListener(new OptionsController(model));
		bearPanel.add(bearFoodValue);
		
		spinners.add(bearBreedingAge);
		spinners.add(bearMaxAge);
		spinners.add(bearBabyChance);
		spinners.add(bearMaxBabies);
		spinners.add(bearFoodValue);
	}

	private void addHunterPanel(){
		JPanel hunterPanel = new JPanel();
		hunterPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Hunters", null, hunterPanel, "\"Is that a rifle in your pants or are you just happy to see me?\"");
		hunterPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblPlaceholderText = new JLabel("Hunter have no options to change");
		lblPlaceholderText.setHorizontalAlignment(SwingConstants.CENTER);
		hunterPanel.add(lblPlaceholderText);
		
		JSpinner hunterPlaceHolder = new JSpinner();
		hunterPlaceHolder.setName("hunterPlaceHolder");
		hunterPlaceHolder.addChangeListener(new OptionsController(model));
		hunterPanel.add(hunterPlaceHolder);
		
		spinners.add(hunterPlaceHolder);
	}
	
	private void addButtons(){
		JPanel btnContainer = new JPanel();
		contentPane.add(btnContainer, BorderLayout.SOUTH);
		btnContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel btnPane = new JPanel();
		btnContainer.add(btnPane);
		btnPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnClose = new JButton("Close");
		btnClose.setName("Close");
		btnClose.addActionListener(new OptionsController(model));
		btnPane.add(btnClose);
		
//		JButton btnReset = new JButton("Reset");
//		btnReset.setName("Reset");
//		btnReset.addActionListener(new OptionslqController());
//		btnPane.add(btnReset);
//		btnReset.setHorizontalAlignment(SwingConstants.RIGHT);
	}
	
	private void addIcons(){
		
		try{
			Icon iconRabbit = new ImageIcon(getClass().getResource("images/iconRabbit.png"));
			Icon iconFox = new ImageIcon(getClass().getResource("images/iconFox.png"));
			Icon iconBear = new ImageIcon(getClass().getResource("images/iconBear.png"));
			Icon iconHunter = new ImageIcon(getClass().getResource("images/iconHunter.png"));
			
			tabbedPane.setIconAt(0, iconRabbit);
			tabbedPane.setIconAt(1, iconFox);
			tabbedPane.setIconAt(2, iconBear);
			tabbedPane.setIconAt(3, iconHunter);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<JComponent> getSpinners(){
		return spinners;
	}
	
	public List<JComponent> getComboBox(){
		return boxes;
	}
	
}
