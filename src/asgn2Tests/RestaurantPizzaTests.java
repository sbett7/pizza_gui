package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.time.LocalTime;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.*;
import asgn2Restaurant.PizzaRestaurant;


/**
 * A class that tests the methods relating to the handling of Pizza objects in the asgn2Restaurant.PizzaRestaurant class as well as
 * processLog and resetDetails.
 * 
 * @author Sean Betts
 *
 */
public class RestaurantPizzaTests {
	
	private PizzaRestaurant restaurant;
	
	//PIZZA TYPES
	private final static String MARGHERITA = "PZM";
	private final static String VEGETARIAN = "PZV";
	private final static String MEAT_LOVERS = "PZL";
	
	//PIZZA LOG FILES
	private final String FILE_ONE = System.getProperty("user.dir")+ "\\logs\\20170101.txt";
	private final String FILE_TWO = System.getProperty("user.dir")+ "\\logs\\20170102.txt";
	private final String FILE_THREE = System.getProperty("user.dir")+ "\\logs\\20170103.txt";
	
	//DOUBLE TESTS PRECISION
	private final double CHECK_TO_SECOND_DECIMAL = 0.01;
	
	/*
	 * Instantiates a new pizza restaurant and assigns it to the pizza field 
	 */
	@Before
	public void instantiateRestaurant(){
		restaurant = new PizzaRestaurant();
	}
	
	/*
	 * Gets a pizza by an index from an empty list.
	 * Expected: PizzaException class thrown
	 */
	@Test (expected = PizzaException.class)
	public void getPizzaByIndexEmptyListException() throws PizzaException{
		int index = 5;
		
		restaurant.getPizzaByIndex(index);
	}
	
	/*
	 * Get the first pizza from log file one.
	 * Expected: The first pizza from log file one is equal to the same pizza order created by the pizza factory. 
	 */
	@Test
	public void getPizzaLogFileOneIndexOne() throws PizzaException, CustomerException, LogHandlerException{
		int index = 0;
		
		Pizza expectedPizza = PizzaFactory.getPizza(VEGETARIAN, 2, LocalTime.of(19, 0), LocalTime.of(19, 20));
		restaurant.processLog(FILE_ONE);
		
		assertTrue("Indexed pizza does not match expected pizza from Log File 1",
				expectedPizza.equals(restaurant.getPizzaByIndex(index)));
	}
	
	/*
	 * Get the second pizza from log file one.
	 * Expected: The second pizza from log file one is equal to the same pizza order created by the pizza factory. 
	 */
	@Test
	public void getPizzaLogFileOneIndexTwo() throws PizzaException, CustomerException, LogHandlerException{
		int index = 1;
		
		Pizza expectedPizza = PizzaFactory.getPizza(MARGHERITA, 1, LocalTime.of(20, 0),  LocalTime.of(20, 25));
		restaurant.processLog(FILE_ONE);
		
		assertTrue("Indexed pizza does not match expected pizza from Log File 1",
				expectedPizza.equals(restaurant.getPizzaByIndex(index)));
	}
	
	/*
	 * Get the third pizza from log file one.
	 * Expected: The third pizza from log file one is equal to the same pizza order created by the pizza factory. 
	 */
	@Test
	public void getPizzaLogFileOneIndexThree() throws PizzaException, CustomerException, LogHandlerException{
		int index = 2;
		
		Pizza expectedPizza = PizzaFactory.getPizza(MEAT_LOVERS, 3, LocalTime.of(21, 0),  LocalTime.of(21, 35));
		restaurant.processLog(FILE_ONE);
		
		assertTrue("Indexed pizza does not match expected pizza from Log File 1",
				expectedPizza.equals(restaurant.getPizzaByIndex(index)));		
	}
	
	/*
	 * Get the third pizza from log file one.
	 * Expected: The third pizza from log file one is equal to the same pizza order created by the pizza factory. 
	 */
	@Test (expected = PizzaException.class)
	public void getPizzaLogFileOneIndexOutOfBoundsException() throws PizzaException, CustomerException, LogHandlerException{
		int index = 4;
		restaurant.processLog(FILE_ONE);
		restaurant.getPizzaByIndex(index);
	}
	
	/*
	 * Get the total number of pizza orders ordered from log file one.
	 * Expected: The number of pizza orders is equal to 3. 
	 */
	@Test
	public void getNumPizzaOrdersLogFileOne() throws CustomerException, PizzaException, LogHandlerException{
		int logSize = 3;
		restaurant.processLog(FILE_ONE);
		
		assertTrue("The number of orders in the log file and the restaurant do not match.",
				restaurant.getNumPizzaOrders() == logSize);
	}
	
	/*
	 * Get the total number of pizza orders ordered from log file two.
	 * Expected: The number of pizza orders is equal to 10. 
	 */
	@Test
	public void getNumPizzaOrdersLogFileTwo() throws CustomerException, PizzaException, LogHandlerException{
		int logSize = 10;
		restaurant.processLog(FILE_TWO);
		
		assertTrue("The number of orders in the log file and the restaurant do not match.",
				restaurant.getNumPizzaOrders() == logSize);
	}
	
	/*
	 * Get the total number of pizza orders ordered from log file three.
	 * Expected: The number of pizza orders is equal to 100. 
	 */
	@Test
	public void getNumPizzaOrdersLogFileThree() throws CustomerException, PizzaException, LogHandlerException{
		int logSize = 100;
		restaurant.processLog(FILE_THREE);
		
		assertTrue("The number of orders in the log file and the restaurant do not match.",
				restaurant.getNumPizzaOrders() == logSize);
	}
	
	/*
	 * Get the total profit from log file one.
	 * Expected: The expected profit calculated by calculateTotalProfit() 
	 * is equal to the restaurant's calculated total profit for log file one. 
	 */
	@Test
	public void getTotalProfitLogOne() throws PizzaException, CustomerException, LogHandlerException{

		assertEquals("Total profit from restaurant does not match calculated value",
				calculateTotalProfit(FILE_ONE), restaurant.getTotalProfit(), CHECK_TO_SECOND_DECIMAL);
	}
	
	/*
	 * Get the total profit from log file two.
	 * Expected: The expected profit calculated by calculateTotalProfit() 
	 * is equal to the restaurant's calculated total profit for log file two. 
	 */
	@Test
	public void getTotalProfitLogTwo() throws PizzaException, CustomerException, LogHandlerException{

		assertEquals("Total profit from restaurant does not match calculated value",
				calculateTotalProfit(FILE_TWO), restaurant.getTotalProfit(), CHECK_TO_SECOND_DECIMAL);
	}
	
	/*
	 * Get the total profit from log file three.
	 * Expected: The expected profit calculated by calculateTotalProfit() 
	 * is equal to the restaurant's calculated total profit for log file three. 
	 */
	@Test
	public void getTotalProfitLogThree() throws PizzaException, CustomerException, LogHandlerException{

		assertEquals("Total profit from restaurant does not match calculated value",
				calculateTotalProfit(FILE_THREE), restaurant.getTotalProfit(), CHECK_TO_SECOND_DECIMAL);
	}
	
	/*
	 * Restaurant is able to reset details after importing log file one.
	 * Expected: Number of pizza orders is equal to 0.
	 */
	@Test
	public void resetDetailsLogFileOne() throws CustomerException, PizzaException, LogHandlerException{
		int expectedResult = 0;
		restaurant.processLog(FILE_ONE);
		restaurant.resetDetails();
		assertEquals(restaurant.getNumPizzaOrders(), expectedResult);
	}
	
	/*
	 * Restaurant is able to reset details if no log file has been processed.
	 * Expected: Number of pizza orders is equal to 0.
	 */
	@Test
	public void resetDetailsNoLogFileProcessed() throws CustomerException, PizzaException, LogHandlerException{
		int expectedResult = 0;
		restaurant.resetDetails();
		assertEquals(restaurant.getNumPizzaOrders(), expectedResult);
	}
	
	
	/**
	 * Calculates the total profits recorded in the inputed log file and returns it.
	 * @param logFileName String containing the name of the log file to use.
	 * @return Returns the total profits for the orders in the log file.
	 * @throws CustomerException If any of the conditions specified by the Customer class are not adhered to.
	 * @throws PizzaException If any of the conditions specified by the Pizza class are not adhered to.
	 * @throws LogHandlerException If any of the conditions specified by the LogHandler class are not adhered to.
	 */
	private double calculateTotalProfit(String logFileName) throws CustomerException, PizzaException, LogHandlerException{
		restaurant.processLog(logFileName);
		double profits = 0;
		
		for (int orderNumber = 0; orderNumber < restaurant.getNumPizzaOrders(); orderNumber++){
			profits += restaurant.getPizzaByIndex(orderNumber).getOrderProfit();
		}
		
		return profits;
	}
	
}
