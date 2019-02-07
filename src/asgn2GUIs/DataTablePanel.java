package asgn2GUIs;

import java.awt.BorderLayout;

import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 * This class provides an abstract JPanel class that hosts a JTable used to display either Customer or 
 * Pizza data from the Restaurant's log file.  It will create a table model based off of the inputed 
 * string array. 
 * 
 * @author Michael De Closey and Sean Betts
 * @param <T> The expected type for this class is either the Pizza or Customer class.
 *
 */
public abstract class DataTablePanel<T> extends JPanel{
	
	//TABLE FIELDS
	private JTable tblData;
	private DefaultTableModel model;
	
	//NUMBER OF ROWS TO DISPLAY
	private final int NO_ROWS = 0;
	
	//DOUBLE TYPE FORMATTER
	private DecimalFormat format = new DecimalFormat("0.00");
	
	
	/**
	 * Creates a JPanel with a table that displays either Pizza or Customer data.
	 * @param columnNames A string array containing the names of all of the columns required in the table.
	 */
	public DataTablePanel(String[] columnNames) {
		this.setLayout(new BorderLayout());
		
		model = new DefaultTableModel(columnNames, NO_ROWS) {
			@Override
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		
		tblData = initialiseDataTable();
		
		this.add(new JScrollPane(tblData));

	}
	
	protected String formatDoubleToString(double data){
		return format.format(data);
	}
	
	/**
	 * Initialises a JTable object using the PizzaDataTableModel.
	 * @return An instantiated JTable object.
	 */
	private JTable initialiseDataTable(){
		JTable table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getTableHeader().setReorderingAllowed(false);
		
		return table;
		
	}
	
	/**
	 * Resets the number of rows in the table to zero.
	 */
	public void resetTableData(){
		model.setRowCount(NO_ROWS);
	}
	
	/**
	 * Determines if any data has been inputed into the table.
	 * @return Returns true if the number of rows is equal to 0.
	 */
	public boolean isEmpty(){
		return model.getRowCount() == 0;
	}
	
	public void selectRow(int row){
		ListSelectionModel selectModel = tblData.getSelectionModel();
		selectModel.setSelectionInterval(row, row);
	}
	
	/**
	 * Adds the inputed data to a row in the data table.
	 * @param index The position of the object within the log file.
	 * @param rowData The type object that is to be added to the table.
	 */
	public abstract void addRow(int index, T rowData);
	
	/**
	 * Converts the desired object's fields to strings and returns them as a string array.
	 * @param index The position of the object within the log file.
	 * @param rowData The type object that will have its fields converted to string format.
	 * @return A String array containing the necessary fields to add to the table.
	 */
	protected abstract String[] convertTypeToStringArray(int index, T rowData);
	
	/**
	 * Adds a string array of row data to the table model.
	 * @param rowData the string array to be entered into the table.
	 */
	protected void addRowToTable(String[] rowData){
		model.addRow(rowData);
	}
	
	/**
	 * Converts a double to a string and returns it in the format "0.00".
	 * @param data the double to be formatted.
	 * @return A string in the format "0.00".
	 */
	protected String formatDouble(double data){
		return format.format(data);
	}
}
