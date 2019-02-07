package asgn2Tests;

import org.junit.Before;
import org.junit.Test;

import asgn2Restaurant.PizzaRestaurant;
import static org.junit.Assert.*;

import java.time.LocalTime;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.*;
import asgn2Customers.*;

/**
 * A class that that tests the methods relating to the handling of Customer objects in the asgn2Restaurant.PizzaRestaurant
 * class as well as processLog and resetDetails.
 * 
 * @author Michael de Closey
 */
public class RestaurantCustomerTests {
	PizzaRestaurant restaurant;

	private final String FILE_ONE = System.getProperty("user.dir")+ "\\logs\\20170101.txt";
	private final String FILE_TWO = System.getProperty("user.dir")+ "\\logs\\20170102.txt";
	private final String FILE_THREE = System.getProperty("user.dir")+ "\\logs\\20170103.txt";
	
	private final static String PICK_UP = "PUC";
	private final static String DRONE = "DNC";
	private final static String DRIVER = "DVC";
	
	private final int FIRST_CUSTOMER = 0;
	private final int SECOND_CUSTOMER = 1;
	private final int THIRD_CUSTOMER = 2;
	private final double TO_SECOND_DECIMAL_PLACE = 0.01;
		
	@Test @Before
	public void instantiateRestaurant(){
		restaurant = new PizzaRestaurant();
	}
	
	@Test (expected = CustomerException.class)
	public void getCustomerByIndexEmptyList() throws CustomerException{		
		restaurant.getCustomerByIndex(3);
	}
	
	@Test
	public void getFirstCustomerFromFileOne() throws PizzaException, CustomerException, LogHandlerException{
		Customer expectedCustomer = CustomerFactory.getCustomer(DRIVER,"Casey Jones", "0123456789",5,5);
		restaurant.processLog(FILE_ONE);
		assertTrue(expectedCustomer.equals(restaurant.getCustomerByIndex(FIRST_CUSTOMER)));
	}
	
	@Test
	public void getSecondCustomerFromFileOne() throws PizzaException, CustomerException, LogHandlerException{
		Customer expectedCustomer = CustomerFactory.getCustomer(DRONE, "April O'Neal","0987654321", 3,4);
		restaurant.processLog(FILE_ONE);
		assertTrue(expectedCustomer.equals(restaurant.getCustomerByIndex(SECOND_CUSTOMER)));
	}
	
	@Test
	public void getThirdCustomerFromLogOne() throws PizzaException, CustomerException, LogHandlerException{		
		Customer expectedCustomer = CustomerFactory.getCustomer(PICK_UP, "Oroku Saki","0111222333",0,0);
		restaurant.processLog(FILE_ONE);
		assertTrue(expectedCustomer.equals(restaurant.getCustomerByIndex(THIRD_CUSTOMER)));
	}
	
	@Test
	public void getTotalNumberCustomersLogOne() throws CustomerException, PizzaException, LogHandlerException{
		int logOneCustomers = 3;
		restaurant.processLog(FILE_ONE);
		assertTrue(restaurant.getNumCustomerOrders() == logOneCustomers);
	}
	
	@Test
	public void getTotalDistanceLogOne() throws CustomerException, PizzaException, LogHandlerException {
		double logOneDistanceTravelled = 15.00;
		restaurant.processLog(FILE_ONE);
		assertEquals(restaurant.getTotalDeliveryDistance(), logOneDistanceTravelled, TO_SECOND_DECIMAL_PLACE);
	}
	
	@Test (expected = CustomerException.class)
	public void fileOneIndexOutOfBoundsException() throws PizzaException, CustomerException, LogHandlerException{
		int index = 4;
		restaurant.processLog(FILE_ONE);
		restaurant.getCustomerByIndex(index);
	}
	
	@Test
	public void getTotalNumberCustomersLogTwo() throws CustomerException, PizzaException, LogHandlerException{
		int logTwoCustomers = 10;
		restaurant.processLog(FILE_TWO);
		assertTrue(restaurant.getNumCustomerOrders() == logTwoCustomers);
	}
	
	@Test
	public void getTotalDistanceLogTwo() throws CustomerException, PizzaException, LogHandlerException {
		double logTwoDistanceTravelled = 41.41;
		restaurant.processLog(FILE_TWO);
		assertEquals(restaurant.getTotalDeliveryDistance(), logTwoDistanceTravelled, TO_SECOND_DECIMAL_PLACE);
	}
	
	@Test
	public void getTotalNumberCustomersLogThree() throws CustomerException, PizzaException, LogHandlerException{
		int logThreeCustomers = 100;
		restaurant.processLog(FILE_THREE);
		assertTrue(restaurant.getNumCustomerOrders() == logThreeCustomers);
	}
	
	@Test
	public void getTotalDistanceLogThree() throws CustomerException, PizzaException, LogHandlerException {
		double logTwoDistanceTravelled = 518.67;
		restaurant.processLog(FILE_THREE);
		assertEquals(restaurant.getTotalDeliveryDistance(), logTwoDistanceTravelled,TO_SECOND_DECIMAL_PLACE);
	}
	
	@Test (expected = CustomerException.class)
	public void fileTwoIndexOutOfBoundsException() throws PizzaException, CustomerException, LogHandlerException{
		int index = 11;
		restaurant.processLog(FILE_TWO);
		restaurant.getCustomerByIndex(index);
	}
	
	@Test
	public void getNumberCustomersLogThree() throws CustomerException, PizzaException, LogHandlerException{
		int logThreeCustomers = 100;
		restaurant.processLog(FILE_THREE);
		assertTrue(restaurant.getNumCustomerOrders() == logThreeCustomers);
	}
	
}
