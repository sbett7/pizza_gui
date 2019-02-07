package asgn2GUIs;

import java.text.DecimalFormat;

import asgn2Customers.Customer;

/**
 * This class is the subclass of the DataTablePanel. This class stores Customer data inside
 * of its table.
 * 
 * @author Michael De Closey and Sean Betts
 *
 */
public class CustomerDataTablePanel extends DataTablePanel<Customer>{
	
	public CustomerDataTablePanel(String[] columnNames) {
		super(columnNames);
		
	}

	@Override
	public String[] convertTypeToStringArray(int index, Customer rowData) {
		return new String[]{
				Integer.toString(index),
				rowData.getName(), 
				rowData.getMobileNumber(),
				rowData.getCustomerType(),
				Integer.toString(rowData.getLocationX()),
				Integer.toString(rowData.getLocationY()),
				super.formatDouble(rowData.getDeliveryDistance())
		};
	}
	
	@Override
	public void addRow(int index, Customer rowData){
		super.addRowToTable(convertTypeToStringArray(index, rowData));
	}
}
