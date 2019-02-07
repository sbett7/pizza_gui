package asgn2GUIs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.filechooser.FileNameExtensionFilter;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a dummy class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Michael De Closey and Sean Betts
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	
	//GUI CONSTANTS
	private static final long serialVersionUID = 6436579188974173747L;
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	
	private PizzaRestaurant restaurant;
	
	//PANELS
	private JPanel pnlButtons;
	private JTabbedPane tabPnlPizza;
	
	//WIDGETS
	private JFileChooser fc;
	private JButton btnFileChooser;
	private JButton btnReset;
	
	//DATA PANELS FOR TABBED PANE
	private DataTablePanel<Pizza> pnlPizzaData;
	private DataTablePanel<Customer> pnlCustomerData;
	private PizzaCalculationsPanel pnlPizzaCalcs;
	
	//TAB INDEXES
	private final int CUSTOMER_DATA_TAB = 0;
	private final int PIZZA_DATA_TAB = 1;
	private final int CALCULATIONS_TAB = 2;
	
	private final int NO_TAB_SELECTED = -1;	
	
		
	private String[] pizzaColumnNames = new String[]{
			"Order Number", "Pizza Type", "Quantity", "Order Price", "Order Cost", "Order Profit"
		};
	
	private String[] customerColumnNames = new String[]{
			"Order Number", "Name", "Mobile Number", "Delivery Type", "X Location", "Y Location", "Distance From Store"
		};
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		super(title);
		restaurant = new PizzaRestaurant();
	}
	
	@Override
	public void run() {
		createGUI();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == btnFileChooser){
			int returnValue = fc.showOpenDialog(this);
			
			if(returnValue == JFileChooser.APPROVE_OPTION){
				EnableLogDataView(fc.getSelectedFile().getPath());
			} 
		} else if (event.getSource() == btnReset){
			resetGUI();
			JOptionPane.showMessageDialog(this,"The interface has successfully been reset.");
		} 
	}
	
	/**
	 * Sets GUI parameters and adds panels and widgets to the frame.
	 */
	private void createGUI(){
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		pnlPizzaData = new PizzaDataTablePanel(pizzaColumnNames);
		pnlCustomerData = new CustomerDataTablePanel(customerColumnNames);			
		pnlPizzaCalcs = new PizzaCalculationsPanel();
		
		tabPnlPizza = initialiseTabbedPane();
		pnlButtons = createPanel(Color.WHITE);
		
		this.getContentPane().add(tabPnlPizza, BorderLayout.CENTER);
		this.getContentPane().add(pnlButtons, BorderLayout.SOUTH);
		
		fc = initialiseFileChooser();
		btnFileChooser = initialiseButton("Select File");
		btnFileChooser.setEnabled(true);
		btnReset = initialiseButton("Reset");
		
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.weightx = 100;
		constraints.weighty = 100;
				
		addToPanel(pnlButtons, btnFileChooser,constraints,0,0,2,1);
		addToPanel(pnlButtons, btnReset,constraints,1,0,2,1);
		
		this.repaint();
		this.setVisible(true);
	}

	/**
	 * Instantiates a JPanel with a specific colour.
	 * @param c A Colour object that is used to set the panel colour.
	 * @return An instantiated JPanel of the inputed colour.
	 */
	private JPanel createPanel(Color c){
		JPanel pnlTemp = new JPanel();
		pnlTemp.setBackground(c);
		
		return pnlTemp;
	}
	
	/**
	 * Instantiates a JFileChooser object.
	 * @return An initialised JFileChooser object.
	 */
	private JFileChooser initialiseFileChooser(){
		//set file chooser to read-only and list only text files
		UIManager.put("FileChooser.readOnly", Boolean.TRUE);
		JFileChooser fcTemp = new JFileChooser();
		FileNameExtensionFilter fFilter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		
		fcTemp.setFileFilter(fFilter);
		fcTemp.setCurrentDirectory(new File(System.getProperty("user.dir") + "\\logs"));		
		
		return fcTemp;
	}
	
	/**
	 * Initialises a button with the specified text.
	 * @param btnText A string to set the button's text.
	 * @return An instantiated button.
	 */
	private JButton initialiseButton(String btnText){
		JButton btn = new JButton();
		btn.setText(btnText);
		btn.addActionListener(this);
		btn.setEnabled(false);
		return btn;
	}
	
	/**
	* A convenience method to add a component to given grid bag
	* layout locations. Code due to Cay Horstmann
	*
	* @param c the component to add
	* @param constraints the grid bag constraints to use
	* @param x the x grid position
	* @param y the y grid position
	* @param w the grid width of the component
	* @param h the grid height of the component
	*/
	private void addToPanel(JPanel jp,Component c, GridBagConstraints
	constraints,int x, int y, int w, int h) {
	constraints.gridx = x;
	constraints.gridy = y;
	constraints.gridwidth = w;
	constraints.gridheight = h;
	jp.add(c, constraints);
	}
	
	/**
	 * Imports and processes the log file with the inputed file path.
	 * Displays a message dialogue in case
	 * @param filePath A string pointing to the file path of the log file.
	 */
	private void importLogFile(String filePath){
		try {
			restaurant.processLog(filePath);
			JOptionPane.showMessageDialog(this,"The data has been imported successfully.");
		} catch (CustomerException e) {
			resetGUI();
			JOptionPane.showMessageDialog(this,e.getMessage() + "\nThe interface has been reset.",
					"Customer Exception",JOptionPane.ERROR_MESSAGE);
		} catch (PizzaException e) {
			resetGUI();
			JOptionPane.showMessageDialog(this,e.getMessage() + "\nThe interface has been reset.",
					"Pizza Exception",JOptionPane.ERROR_MESSAGE);
		} catch (LogHandlerException e) {
			resetGUI();
			JOptionPane.showMessageDialog(this,e.getMessage() + "\nThe interface has been reset.",
					"LogHandler Exception",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Enables the Tab Panel to access data. Locks the File Chooser Button.
	 * Enables the Reset Button. 
	 * @param fileName the name of the file to be imported
	 */
	private void EnableLogDataView(String fileName){
		btnReset.setEnabled(true);
		btnFileChooser.setEnabled(false);
		
		tabPnlPizza.setEnabled(true);
		importLogFile(fileName);
	}
	
	/**
	 * Initialises a JTabbedPane object with the tabs related to the pizza data.
	 * @return A instantiated JTabbedPane.
	 */
	private JTabbedPane initialiseTabbedPane(){
		JTabbedPane tabPnl = new JTabbedPane();
		tabPnl.add("Customer Details", pnlCustomerData);
		tabPnl.add("Pizza Orders", pnlPizzaData);
		tabPnl.add("Day Summary", pnlPizzaCalcs);
		
		tabPnl.setSelectedIndex(NO_TAB_SELECTED); // no page selected
		tabPnl.setEnabled(false);
		
		tabPnl.addChangeListener(new ChangeListener() {
			//on tab clicked load data if tab is empty
			@Override
			public void stateChanged(ChangeEvent e) {
				switch(tabPnl.getSelectedIndex()){
					case CUSTOMER_DATA_TAB:
						if(pnlCustomerData.isEmpty()){
							populateCustomerTable();
						}
						break;
					case PIZZA_DATA_TAB:
						if(pnlPizzaData.isEmpty()){
							populatePizzaTable();
						}
						break;
					case CALCULATIONS_TAB:
						if(pnlPizzaCalcs.isEmpty()){
							displayCalculations();
						}
						break;
				}
			}
		});
		return tabPnl;
	}
	
	/**
	 * Populates the customer table tab with pizza information.
	 */
	private void populatePizzaTable(){
		for (int pizzaIndex = 0; pizzaIndex < restaurant.getNumPizzaOrders();
				pizzaIndex++){
			try {
				pnlPizzaData.addRow(pizzaIndex + 1, restaurant.getPizzaByIndex(pizzaIndex));
			} catch (PizzaException e) {
				resetGUI();
				JOptionPane.showMessageDialog(this,e.getMessage() + "\nThe interface has been reset.",
						"Pizza Exception",JOptionPane.ERROR_MESSAGE);
				
			}
		}
	}
	
	/**
	 * Populates the pizza table tab with pizza information.
	 */
	private void populateCustomerTable(){
		for (int customerIndex = 0; customerIndex < restaurant.getNumCustomerOrders();
				customerIndex++){
			try {
				pnlCustomerData.addRow(customerIndex + 1, restaurant.getCustomerByIndex(customerIndex));
			} catch (CustomerException e) {
				resetGUI();
				JOptionPane.showMessageDialog(this,e.getMessage() + "\nThe interface has been reset.",
						"Customer Exception",JOptionPane.ERROR_MESSAGE);
				
			}
		}
	}
	
	/**
	 * Displays the total profit and delivery distance on the Pizza Calculation panel.
	 */
	private void displayCalculations(){
		pnlPizzaCalcs.setPizzaTextFields(restaurant.getTotalProfit(),
				restaurant.getTotalDeliveryDistance());
	}
	
	/**
	 * Removes all data from the GUI and resets the position and access to the GUI
	 * until another log file had been accessed.
	 */
	private void resetGUI(){
		pnlPizzaData.resetTableData();
		pnlCustomerData.resetTableData();
		pnlPizzaCalcs.resetTextFields();
		
		btnFileChooser.setEnabled(true);
		btnReset.setEnabled(false);
		
		//disable tabbed panel and set current page to 'no page'
		tabPnlPizza.setSelectedIndex(NO_TAB_SELECTED);
		tabPnlPizza.setEnabled(false);
		
		restaurant.resetDetails();
	}
	
}
