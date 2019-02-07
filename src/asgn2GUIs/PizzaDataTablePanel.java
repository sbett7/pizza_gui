package asgn2GUIs;

import asgn2Pizzas.Pizza;

/**
 * This class is the subclass of the DataTablePanel. This class stores Pizza data inside
 * of its table.
 * 
 * @author Michael De Closey and Sean Betts
 *
 */
public class PizzaDataTablePanel extends DataTablePanel<Pizza> {
	
	public PizzaDataTablePanel(String[] columnNames) {
		super(columnNames);
	}

	

	@Override
	public String[] convertTypeToStringArray(int index, Pizza rowData) {
		
		return new String[]{
				Integer.toString(index),
				rowData.getPizzaType(), 
				Integer.toString(rowData.getQuantity()),
				super.formatDouble(rowData.getOrderPrice()),
				super.formatDouble(rowData.getOrderCost()),
				super.formatDouble(rowData.getOrderProfit())
		};
	}



	@Override
	public void addRow(int index, Pizza rowData) {
		super.addRowToTable(convertTypeToStringArray(index, rowData));
	}	
}