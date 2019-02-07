package asgn2Restaurant;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/**
 *
 * A class that contains methods that use the information in the log file to return Pizza 
 * and Customer object - either as an individual Pizza/Customer object or as an
 * ArrayList of Pizza/Customer objects.
 * 
 * @author Michael De Closey and Sean Betts
 *
 */
public class LogHandler {
	
	//SPLIT ARRAY CONSTANTS
	private final static String COMMA = ",";
	private final static int EXPECTED_LINE_LENGTH = 9;
	
	//INDEXES FOR SPLIT STRING ARRAY
	private final static int ORDER_TIME = 0;
	private final static int DELIVERY_TIME = 1;
	private final static int CUSTOMER_NAME = 2;
	private final static int CUSTOMER_MOBILE_NUMBER = 3;
	private final static int CUSTOMER_TYPE = 4;
	private final static int CUSTOMER_LOCATION_X = 5;
	private final static int CUSTOMER_LOCATION_Y = 6;
	private final static int PIZZA_CODE = 7;
	private final static int QUANTITY = 8;
	

	/**
	 * Returns an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file.
	 * @param filename The file name of the log file
	 * @return an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file. 
	 * @throws CustomerException If there was an issue generating a Customer object, based off of the exceptions described in the Customer class.
	 * @throws LogHandlerException If the log file or one of the expected parameters is empty/null or if they cannot be converted to the
	 * necessary data type.
	 * 
	 */
	public static ArrayList<Customer> populateCustomerDataset(String filename) throws CustomerException, LogHandlerException{
		String line = new String();
		ArrayList<Customer> list = new ArrayList<Customer>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			while((line = reader.readLine()) != null){
				list.add(createCustomer(line));
			}
			
			reader.close();
		} catch (IOException e) {
			throw new LogHandlerException("LogHandler Exception: Cannot open log file with file name of " + filename);
		}

		return list;
	}		

	/**
	 * Returns an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file.
	 * @param filename The file name of the log file
	 * @return an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file.
	 * @throws PizzaException If there was an issue generating a Customer object, based off of the exceptions described in the Pizza class.
	 * @throws LogHandlerException  If the log file or one of the expected parameters is empty/null or if they cannot be converted to the
	 * necessary data type.
	 */
	public static ArrayList<Pizza> populatePizzaDataset(String filename) throws PizzaException, LogHandlerException{
		String readLine = new String();
		ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
		
		try{
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			while((readLine = reader.readLine()) != null){
				pizzaList.add(createPizza(readLine));
			}
			
			reader.close();
		} catch(IOException e){
			throw new LogHandlerException("LogHandler Exception : Cannot open log file with file name of " + filename);
		}
		return pizzaList;
	}		

	
	/**
	 * Creates a Customer object by parsing the  information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line A line from the log file
	 * @return A Customer object containing the information from the line in the log file
	 * @throws CustomerException If there was an issue generating a Customer object, based off of the exceptions described in the Customer class.
	 * @throws LogHandlerException If there was a problem parsing the line from the log file and converting them to the necessary data types.
	 * Or if the line does not contain all of the necessary components or if any of the components are empty.
	 */
	public static Customer createCustomer(String line) throws CustomerException, LogHandlerException{
		
		if(line == null || line.isEmpty()){
			throw new LogHandlerException("LogHandlerException: The inputed line is empty or does not exist.");
		}
		
		String lineComponents[] = line.split(COMMA);
		
		if(lineComponents.length !=EXPECTED_LINE_LENGTH){
			throw new LogHandlerException("LogHandlerException: The inputed line is incomplete.");
		} 
		for (String component : lineComponents){
			if(component.isEmpty()){
				throw new LogHandlerException("One or more of the inputed fields is empty.");
			}
		}
		
		Customer customer = CustomerFactory.getCustomer(lineComponents[CUSTOMER_TYPE],
		lineComponents[CUSTOMER_NAME],
		lineComponents[CUSTOMER_MOBILE_NUMBER],
		convertStringToInt(lineComponents[CUSTOMER_LOCATION_X]),
		convertStringToInt(lineComponents[CUSTOMER_LOCATION_Y]));
		
		return customer;
	}
	
	/**
	 * Creates a Pizza object by parsing the information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line A line from the log file
	 * @return A Pizza object containing the information from the line in the log file
	 * @throws PizzaException If there was an issue generating a Customer object, based off of the exceptions described in the Pizza class.
	 * @throws LogHandlerException If there was a problem parsing the line from the log file and converting them to the necessary data types.
	 * Or if the line does not contain all of the necessary components or if any of the components are empty.
	 */
	public static Pizza createPizza(String line) throws PizzaException, LogHandlerException{
		String lineComponents[] = line.split(COMMA);
		
		if (line.isEmpty() || line == null){
			throw new LogHandlerException("LogHandler Exception: Input line is empty or null");
		} else if (lineComponents.length != EXPECTED_LINE_LENGTH){
			throw new LogHandlerException("LogHandler Exception: Input line is incomplete");
		}
		
		for (String input : lineComponents){
			if (input.isEmpty()){
				throw new LogHandlerException("Part of the input line is empty.");
			}
		}
		Pizza pizza = PizzaFactory.getPizza(lineComponents[PIZZA_CODE], 
				convertStringToInt(lineComponents[QUANTITY]), 
				convertStringToTime(lineComponents[ORDER_TIME]),
				convertStringToTime(lineComponents[DELIVERY_TIME]));
		return pizza;
	}
	
	
	/**
	 * Converts the string to an integer.
	 * @param intString A string that is to be converted to an integer.
	 * @return The string in Integer form.
	 * @throws LogHandlerException If the string cannot be converted to an integer or the string is null.
	 */
	private static int convertStringToInt(String intString) throws LogHandlerException{
		try{
			return Integer.parseInt(intString);
		} catch(NumberFormatException e){
			throw new LogHandlerException("LogHandlerException Thrown: The parsed string cannot be converted to an integer");
		} catch(NullPointerException e){
			throw new LogHandlerException("LogHandlerException Thrown: The inputed integer String is null");
		}
	}
	
	/**
	 * Converts the string to a LocalTime object.
	 * @param time A string that contains the time to be converted to a LocalTime.
	 * @return The converted LocalTime.
	 * @throws LogHandlerException If the string is not of the correct format or the string is null.
	 */
	private static LocalTime convertStringToTime(String time) throws LogHandlerException{
		try{
			return LocalTime.parse(time);
		} catch(DateTimeParseException e){
			throw new LogHandlerException("LogHandlerException Thrown: The parsed string cannot be converted to a LocalTime");
		} catch(NullPointerException e){
			throw new LogHandlerException("LogHandlerException Thrown: The inputted time String is null");
		}
	}

}
