import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Pizzeria extends JFrame implements ActionListener
{
	//declaring necessary ComboBoxes, labels and button
	private JComboBox pizzaComboBox, sizeComboBox, toppingsComboBox;
	private JLabel  labelpizzaComboBox, labelsizeComboBox, labelToppingCheckBox;
	private JButton submitButton;
	
	//Checkbox Components
	//private JCheckBox toppingCheese = new JCheckBox("Cheese - free!!", null, false);
    //private JCheckBox toppingBeef = new JCheckBox("Beef - $1.00", null, false);
    //private JCheckBox toppingBacon = new JCheckBox("Bacon - $1.00", null, false);
    //private JCheckBox toppingMushrooms = new JCheckBox("Mushrooms - $1.00", null, false);
    //private JCheckBox toppingBroccoli = new JCheckBox("Broccoli - $1.00", null, false);
    
    //Arrays for ComboBoxes
	private String [] pizzaOptions = {"Pepperoni - $7.00", "Cheese Deluxe - $6.00", "Meat Supreme - $7.00", "Vegan - $6.50", "Pineapple - $6.50"};
	private String [] pizzaSizeOptions = {"Small - $7.00", "Medium - $9.00","Large - $11.00", "Extra Large - $13.00"};
	private String[] pizzaToppings = {"Cheese - free!!","Beef - $1.00","Bacon - $1.00","Mushrooms - $1.00","Broccoli - $1.00"};
	
	//Variables for Calculations
	
	String selectedPizza, selectedSize, selectedTopping;
	double priceOfPizza, priceOfSize, priceOfTopping, netTotal;
	
	//Container created for layout
	private Container content = getContentPane();
	
	public Pizzeria() //storage class
	{
		//customizing the frame
		this.setTitle("HFX Pizzeria");
		this.setSize(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBackground(Color.white);
		this.setLayout(null);
		
		//welcome message
		JOptionPane.showMessageDialog(null, "Welcome to HFX Pizzeria!");
		
		//customizations for Pizza Options
		labelpizzaComboBox = new JLabel("Please Choose Your Pizza:");
		labelpizzaComboBox.setBounds(20,20,180,30);
		labelpizzaComboBox.setHorizontalAlignment(JLabel.CENTER);;
		labelpizzaComboBox.setOpaque(true);
		
		pizzaComboBox = new JComboBox(pizzaOptions);
		pizzaComboBox.setBounds(220,25,200,20);
		
		pizzaComboBox.addActionListener(this);
		
		//customizations for Pizza Size Options
		labelsizeComboBox = new JLabel("Please Choose Your Size:");
		labelsizeComboBox.setBounds(20,100,180,30);
		labelsizeComboBox.setHorizontalAlignment(JLabel.CENTER);;
		labelsizeComboBox.setOpaque(true);
		
		sizeComboBox = new JComboBox(pizzaSizeOptions);
		sizeComboBox.setBounds(220,105,200,20);
		
		sizeComboBox.addActionListener(this);
		
		//customizations for Toppings
		labelToppingCheckBox = new JLabel("Please Choose Toppings:");
		labelToppingCheckBox.setBounds(20,180,180,30);
		labelToppingCheckBox.setHorizontalAlignment(JLabel.CENTER);;
		labelToppingCheckBox.setOpaque(true);
		
		toppingsComboBox = new JComboBox(pizzaToppings);
		toppingsComboBox.setBounds(220,185,200,20);
		
		toppingsComboBox.addActionListener(this);
		
		//Submit Button
		submitButton = new JButton("Submit");
		submitButton.setBounds(220,300,180,30);
		submitButton.addActionListener(this);
		
		//Adding the components to container
		content.add(pizzaComboBox);
		content.add(sizeComboBox);
		content.add(toppingsComboBox);
		content.add(labelpizzaComboBox);
		content.add(labelsizeComboBox);
		content.add(labelToppingCheckBox);
		content.add(submitButton);
		content.setBackground(Color.white);
		
		//making frame visible
		this.setVisible(true);
		
		
		
		
	}
	
	//Functional Aspect of Pizzeria App

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()== pizzaComboBox) //for selection in Pizza List 
		{
			selectedPizza = pizzaComboBox.getSelectedItem().toString(); //converting selection to string
			pizzaComboBox.setSelectedItem(selectedPizza); //storing selection as String
			switch(selectedPizza) //assigning prices for different selections
			{
			  case "Pepperoni - $7.00":
			    priceOfPizza = 7.00;
			    break;
			  case "Cheese Deluxe - $6.00":
				priceOfPizza = 6.00;
			    break;
			  case  "Meat Supreme - $7.00":
			    priceOfPizza = 7.00;
				break;
			  case "Vegan - $6.50":
				priceOfPizza = 6.50;
				break;
			  case "Pineapple - $6.50":
				priceOfPizza = 6.50;
				break;
			  default:
			    priceOfPizza = 0.00;
			    break;
			}
			
		}
		
		if (e.getSource()== sizeComboBox) //for selecting size of Pizza
		{
			selectedSize = sizeComboBox.getSelectedItem().toString(); //converting selection to String
			sizeComboBox.setSelectedItem(selectedSize); //storing selected option as string
			//assigning prices for different sizes
			switch(selectedSize) 
			{
			  case "Small - $7.00":
			    priceOfSize = 7.00;
			    break;
			  case "Medium - $9.00":
				priceOfSize = 9.00;
			    break;
			  case "Large - $11.00":
				priceOfSize = 11.00;
				break;
			  case "Extra Large - $13.00":
				priceOfSize = 13.00;
				break;
			  default:
				priceOfSize = 0.00;
			    break;
			}
		}

		if (e.getSource()== toppingsComboBox) //selecting toppings
		{
			selectedTopping = toppingsComboBox.getSelectedItem().toString(); //converting topping selection to string
			toppingsComboBox.setSelectedItem(selectedTopping); //saving selected topping option as string
			//assigning different prices for different toppings
			switch(selectedTopping) 
			{
			  case "Cheese - free!!":
				priceOfTopping = 0.00;
			    break;
			  case "Beef - $1.00":
				priceOfTopping = 1.00;
			    break;
			  case "Bacon - $1.00":
				priceOfTopping = 1.00;
				break;
			  case "Mushrooms - $1.00":
				 priceOfTopping = 1.00;
				break;
			  case "Broccoli - $1.00":
				priceOfTopping = 1.00;
				break;
			  default:
				priceOfTopping = 0.00;
			    break;
			}
		}
		if (e.getSource()== submitButton) //Final Submit Button Functionality
		{
			netTotal = priceOfPizza + priceOfSize + priceOfTopping; //sumtotal of prices
			//Displaying Results
			JOptionPane.showMessageDialog(null, "Your total bill is: $ " +String.format("%.2f", netTotal));
		}
		
		
		
	}
	
}