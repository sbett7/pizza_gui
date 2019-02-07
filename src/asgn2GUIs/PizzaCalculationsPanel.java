package asgn2GUIs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * This class provides a JPanel that displays the restaurant's total profits 
 * and distance traveled as text.
 * 
 * 
 * @author Michael De Closey and Sean Betts
 *
 */
public class PizzaCalculationsPanel extends JPanel {

	//TEXT FIELDS
	private JTextField txtProfit;
	private JTextField txtDistanceTravelled;
	
	//LABELS
	private JLabel lblProfit;
	private JLabel lblDistanceTravelled;
	
	//PANELS TO HOLD WIDGETS
	private JPanel pnlLabels;
	private JPanel pnlTextFields;
	
	//DOUBLE TYPE FORMATTER
	private static DecimalFormat format = new DecimalFormat("0.00");
	
	/**
	 * Creates a new panel that will display the pizza restaurant's total profits
	 * and distance traveled, based off of the inputed log file.
	 */
	public PizzaCalculationsPanel() {
		
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		constraints.anchor = GridBagConstraints.CENTER;
		
		pnlLabels = initialisePanel();
		pnlTextFields = initialisePanel();
		
		lblProfit = initialiseLabels("Total Profits: ");
		lblDistanceTravelled = initialiseLabels("Distance Travelled: ");
		
		txtProfit = initialiseTextField();
		txtDistanceTravelled = initialiseTextField();
		
		addToPanel(pnlLabels, lblProfit, constraints, 0, 1, 2, 1);
		constraints.insets = new Insets(20, 0, 0, 0);
		addToPanel(pnlLabels, lblDistanceTravelled, constraints, 0, 2, 2, 1);
		
		constraints.insets = new Insets(0, 0, 0, 0);
		addToPanel(pnlTextFields, txtProfit, constraints, 0, 1, 2, 1);
		constraints.insets = new Insets(20, 0, 0, 0);
		addToPanel(pnlTextFields, txtDistanceTravelled, constraints, 0, 2, 2, 1);
		
		constraints.insets = new Insets(20, 0, 0, 0);
		addToPanel(this, pnlLabels, constraints, 1, 1, 1, 1);
		constraints.insets = new Insets(20, 20, 0, 0);
		addToPanel(this, pnlTextFields, constraints, 3, 1, 1, 1);
		
	}
	

	/**
	 * Sets the text in the text fields with the total profits and distance traveled.
	 * @param totalProfits The total profits that the restaurant has made.
	 * @param totalDistanceTraveled The total euclidean distance that has been traveled.
	 */
	public void setPizzaTextFields(double totalProfits, double totalDistanceTraveled){
		txtProfit.setText(format.format(totalProfits));
		txtDistanceTravelled.setText(format.format(totalDistanceTraveled));
	}
	
	/**
	 * Resets the text fields to empty strings.
	 */
	public void resetTextFields(){
		txtProfit.setText("");
		txtDistanceTravelled.setText("");
	}
	
	/**
	 * Determines if any data has been inputed into the text field.
	 * @return Returns true if the number of rows is equal to 0.
	 */
	public boolean isEmpty(){
		return txtProfit.getText().equals("");
	}
	
	
	/**
	 * Initialises a JLabel with the inputed string.
	 * @param title A string that is to be displayed by the JLabel.
	 * @return An instantiated JLabel object.
	 */
	private JLabel initialiseLabels(String title){
		JLabel lbl = new JLabel(title);
		lbl.setPreferredSize(new Dimension(120, 20));
		lbl.setOpaque(true);
		//lbl.setBounds(50, 50, 50, 50);
		return lbl;
	}
	
	/**
	 * Initialises a JTextField.
	 * @return An instantiated JTextField object.
	 */
	private JTextField initialiseTextField(){
		JTextField txtField = new JTextField();
		
		txtField.setBounds(50, 20, 70, 20);
		txtField.setEditable(false);
		txtField.setBackground(Color.WHITE);
		txtField.setHorizontalAlignment(SwingConstants.RIGHT);
		txtField.setPreferredSize(new Dimension(80, 20));
		
		return txtField;
	}
	
	/**
	 * Initialises a JPanel using a GridBagLayout.
	 * @return An instantiated JPanel object.
	 */
	private JPanel initialisePanel(){
		JPanel pnlTemp = new JPanel();
		pnlTemp.setLayout(new GridBagLayout());
		pnlTemp.setOpaque(true);
		
		return pnlTemp;
	}
	
	/**
	*
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
}
