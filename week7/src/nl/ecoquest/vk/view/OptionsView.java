package nl.ecoquest.vk.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import nl.ecoquest.vk.model.SimulatorModel;

public class OptionsView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public OptionsView(SimulatorModel model) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Icon iconRabbit = new ImageIcon(getClass().getResource("images/iconRabbit.png"));
		Icon iconFox = new ImageIcon(getClass().getResource("images/iconFox.png"));
		Icon iconBear = new ImageIcon(getClass().getResource("images/iconBear.png"));
		Icon iconHunter = new ImageIcon(getClass().getResource("images/iconHunter.png"));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel rabbitPanel = new JPanel();
		rabbitPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Rabbits", iconRabbit, rabbitPanel, "Edit the rabbits");
		rabbitPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblRabbitBreedingAge = new JLabel("Breeding Age");
		lblRabbitBreedingAge.setHorizontalAlignment(SwingConstants.TRAILING);
		rabbitPanel.add(lblRabbitBreedingAge);
		
		JSpinner rabbitBreedingAge = new JSpinner();
		lblRabbitBreedingAge.setLabelFor(rabbitBreedingAge);
		rabbitPanel.add(rabbitBreedingAge);
		
		JLabel lblRabbitMaxAge = new JLabel("Max Age");
		lblRabbitMaxAge.setHorizontalAlignment(SwingConstants.TRAILING);
		rabbitPanel.add(lblRabbitMaxAge);
		
		JSpinner rabbitMaxAge = new JSpinner();
		lblRabbitMaxAge.setLabelFor(rabbitMaxAge);
		rabbitPanel.add(rabbitMaxAge);
		
		JLabel lblRabbitBabyChance = new JLabel("Baby Chance");
		lblRabbitBabyChance.setHorizontalAlignment(SwingConstants.TRAILING);
		rabbitPanel.add(lblRabbitBabyChance);
		
		JSpinner rabbitBabyChance = new JSpinner();
		lblRabbitBabyChance.setLabelFor(rabbitBabyChance);
		rabbitPanel.add(rabbitBabyChance);
		
		JLabel lblRabbitMaxBabies = new JLabel("Max Babies");
		lblRabbitMaxBabies.setHorizontalAlignment(SwingConstants.TRAILING);
		rabbitPanel.add(lblRabbitMaxBabies);
		
		JSpinner rabbitMaxBabies = new JSpinner();
		lblRabbitMaxBabies.setLabelFor(rabbitMaxBabies);
		rabbitPanel.add(rabbitMaxBabies);
		
		JLabel lblRabbitFoodValue = new JLabel("Food Value");
		lblRabbitFoodValue.setHorizontalAlignment(SwingConstants.TRAILING);
		rabbitPanel.add(lblRabbitFoodValue);
		
		JSpinner rabbitFoodValue = new JSpinner();
		lblRabbitFoodValue.setLabelFor(rabbitFoodValue);
		rabbitPanel.add(rabbitFoodValue);
		
		JLabel lblRabbitsickness = new JLabel("Sickness");
		lblRabbitsickness.setHorizontalAlignment(SwingConstants.TRAILING);
		rabbitPanel.add(lblRabbitsickness);
		
		JComboBox rabbitSickBox = new JComboBox();
		lblRabbitsickness.setLabelFor(rabbitSickBox);
		rabbitSickBox.setToolTipText("Can the animal get sick?");
		rabbitSickBox.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		rabbitSickBox.setSelectedIndex(1);
		rabbitPanel.add(rabbitSickBox);
		
		JPanel foxPanel = new JPanel();
		foxPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Foxes", iconFox, foxPanel, "Edit the foxes");
		foxPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblFoxBreedingAge = new JLabel("Breeding Age");
		lblFoxBreedingAge.setHorizontalAlignment(SwingConstants.TRAILING);
		foxPanel.add(lblFoxBreedingAge);
		
		JSpinner foxBreedingAge = new JSpinner();
		lblFoxBreedingAge.setLabelFor(foxBreedingAge);
		foxPanel.add(foxBreedingAge);
		
		JLabel lblFoxMaxAge = new JLabel("Max Age");
		lblFoxMaxAge.setLabelFor(rabbitMaxAge);
		lblFoxMaxAge.setHorizontalAlignment(SwingConstants.TRAILING);
		foxPanel.add(lblFoxMaxAge);
		
		JSpinner foxMaxAge = new JSpinner();
		foxPanel.add(foxMaxAge);
		
		JLabel lblFoxBabyChance = new JLabel("Baby Chance");
		lblFoxBabyChance.setLabelFor(rabbitBabyChance);
		lblFoxBabyChance.setHorizontalAlignment(SwingConstants.TRAILING);
		foxPanel.add(lblFoxBabyChance);
		
		JSpinner foxBabyChance = new JSpinner();
		foxPanel.add(foxBabyChance);
		
		JLabel lblFoxMaxBabies = new JLabel("Max Babies");
		lblFoxMaxBabies.setHorizontalAlignment(SwingConstants.TRAILING);
		foxPanel.add(lblFoxMaxBabies);
		
		JSpinner foxMaxBabies = new JSpinner();
		lblFoxMaxBabies.setLabelFor(foxMaxBabies);
		foxPanel.add(foxMaxBabies);
		
		JLabel lblFoxFoodValue = new JLabel("Food Value");
		lblFoxFoodValue.setHorizontalAlignment(SwingConstants.TRAILING);
		foxPanel.add(lblFoxFoodValue);
		
		JSpinner foxFoodValue = new JSpinner();
		lblFoxFoodValue.setLabelFor(foxFoodValue);
		foxPanel.add(foxFoodValue);
		
		JPanel bearPanel = new JPanel();
		bearPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Bears", iconBear, bearPanel, "RAWR!");
		bearPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblBearBreedingAge = new JLabel("Breeding Age");
		lblBearBreedingAge.setHorizontalAlignment(SwingConstants.TRAILING);
		bearPanel.add(lblBearBreedingAge);
		
		JSpinner bearBreedingAge = new JSpinner();
		bearPanel.add(bearBreedingAge);
		
		JLabel lblBearMaxAge = new JLabel("Max Age");
		lblBearMaxAge.setBackground(Color.WHITE);
		lblBearMaxAge.setHorizontalAlignment(SwingConstants.TRAILING);
		bearPanel.add(lblBearMaxAge);
		
		JSpinner bearMaxAge = new JSpinner();
		bearPanel.add(bearMaxAge);
		
		JLabel lblBearBabyChance = new JLabel("Baby Chance");
		lblBearBabyChance.setHorizontalAlignment(SwingConstants.TRAILING);
		bearPanel.add(lblBearBabyChance);
		
		JSpinner bearBabyChance = new JSpinner();
		bearPanel.add(bearBabyChance);
		
		JLabel lblBearMaxBabies = new JLabel("Max Babies");
		lblBearMaxBabies.setHorizontalAlignment(SwingConstants.TRAILING);
		bearPanel.add(lblBearMaxBabies);
		
		JSpinner bearMaxBabies = new JSpinner();
		bearPanel.add(bearMaxBabies);
		
		JLabel lblBearFoodValue = new JLabel("Food Value");
		lblBearFoodValue.setHorizontalAlignment(SwingConstants.TRAILING);
		bearPanel.add(lblBearFoodValue);
		
		JSpinner bearFoodValue = new JSpinner();
		bearPanel.add(bearFoodValue);
		
		JPanel hunterPanel = new JPanel();
		hunterPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Hunters", iconHunter, hunterPanel, "\"Is that a rifle in your pants or are you just happy to see me?\"");
		hunterPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblPlaceholderText = new JLabel("PLACEHOLDER TEXT");
		lblPlaceholderText.setHorizontalAlignment(SwingConstants.CENTER);
		hunterPanel.add(lblPlaceholderText);
		
		JSpinner hunterPlaceHolder = new JSpinner();
		hunterPanel.add(hunterPlaceHolder);
		
		JPanel btnContainer = new JPanel();
		contentPane.add(btnContainer, BorderLayout.SOUTH);
		btnContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel btnPane = new JPanel();
		btnContainer.add(btnPane);
		btnPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnSet = new JButton("Set");
		btnPane.add(btnSet);
		
		JButton btnReset = new JButton("Reset");
		btnPane.add(btnReset);
		btnReset.setHorizontalAlignment(SwingConstants.RIGHT);
	}

}
