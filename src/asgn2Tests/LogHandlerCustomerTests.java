package asgn2Tests;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.*;
import asgn2Pizzas.Pizza;
import asgn2Customers.*;
import asgn2Restaurant.*;
/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author Michael de Closey
 */
public class LogHandlerCustomerTests {
	private final static String PICK_UP = "Pick Up";
	private final static String DRONE = "Drone Delivery";
	private final static String DRIVER = "Driver Delivery";
	
	
	private final String FILE_ONE = System.getProperty("user.dir") + "\\logs\\20170101.txt";
	private final String FILE_TWO = System.getProperty("user.dir") + "\\logs\\20170102.txt";
	private final String FILE_THREE = System.getProperty("user.dir") + "\\logs\\20170103.txt";
	
	private final String EXCEPTION_DIR = System.getProperty("user.dir") + "logs\\Exceptions\\";
	private final String NON_EXCEPTION_DIR = System.getProperty("user.dir") + "logs\\Non-Exceptions\\";
	
	
	//Driver
	@Test
	public void createDriverCustomerName() throws CustomerException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals("Casey Jones", logCustomer.getName());
	}
	
	@Test
	public void createDriverCustomerNumber() throws CustomerException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals("0123456789", logCustomer.getMobileNumber());
	}
	
	@Test
	public void createDriverCustomerType() throws CustomerException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals(DRIVER, logCustomer.getCustomerType());
	}
	
	@Test
	public void createDriverCustomerLocationX() throws CustomerException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals(5, logCustomer.getLocationX());
	}

	@Test
	public void createDriverCustomerLocationY() throws CustomerException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,2";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals(5, logCustomer.getLocationY());
	}
	
	//Drone
	@Test
	public void createDroneCustomerName() throws CustomerException, LogHandlerException {
		String logLine = "20:00:00,20:25:00,April O'Neal,0987654321,DNC,3,4,PZM,1";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals("April O'Neal", logCustomer.getName());
	}
	
	@Test
	public void createDroneCustomerNumber() throws CustomerException, LogHandlerException {
		String logLine = "20:00:00,20:25:00,April O'Neal,0987654321,DNC,3,4,PZM,1";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals("0987654321", logCustomer.getMobileNumber());
	}
	
	
	@Test
	public void createDroneCustomerType() throws CustomerException, LogHandlerException {
		String logLine = "20:00:00,20:25:00,April O'Neal,0987654321,DNC,3,4,PZM,1";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals(DRONE, logCustomer.getCustomerType());
	}
	
	
	@Test
	public void createDroneCustomerLocationX() throws CustomerException, LogHandlerException {
		String logLine = "20:00:00,20:25:00,April O'Neal,0987654321,DNC,3,4,PZM,1";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals(3, logCustomer.getLocationX());
	}

	@Test
	public void createDroneCustomerLocationY() throws CustomerException, LogHandlerException {
		String logLine = "20:00:00,20:25:00,April O'Neal,0987654321,DNC,3,4,PZM,1";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals(4, logCustomer.getLocationY());
	}

	//Pick Up
	@Test
	public void createPickUpCustomerName() throws CustomerException, LogHandlerException {
		String logLine = "21:00:00,21:35:00,Oroku Saki,0111222333,PUC,0,0,PZL,3";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals("Oroku Saki", logCustomer.getName());
	}

	@Test
	public void createPickUpCustomerNumber() throws CustomerException, LogHandlerException {
		String logLine = "21:00:00,21:35:00,Oroku Saki,0111222333,PUC,0,0,PZL,3";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals("0111222333", logCustomer.getMobileNumber());
	}
	
	
	@Test
	public void createPickUpCustomerType() throws CustomerException, LogHandlerException {
		String logLine = "21:00:00,21:35:00,Oroku Saki,0111222333,PUC,0,0,PZL,3";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals(PICK_UP, logCustomer.getCustomerType());
	}
	
	
	@Test
	public void createPickUpCustomerLocationX() throws CustomerException, LogHandlerException {
		String logLine = "21:00:00,21:35:00,Oroku Saki,0111222333,PUC,0,0,PZL,3";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals(0, logCustomer.getLocationX());
	}
	
	@Test
	public void createPickUpCustomerLocationY() throws CustomerException, LogHandlerException {
		String logLine = "21:00:00,21:35:00,Oroku Saki,0111222333,PUC,0,0,PZL,3";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals(0, logCustomer.getLocationY());
	}

	@Test
	public void PopulateCustomerDataSetLogFileOne() throws CustomerException, LogHandlerException {
		ArrayList<Customer> logOne = LogHandler.populateCustomerDataset(FILE_ONE);
		ArrayList<Customer> expectedSet = getLogOneCustomerList();
		assertEquals(expectedSet, logOne);
	}
	
	@Test
	public void PopulateCustomerDataSetLogFileTwo() throws CustomerException, LogHandlerException {
		ArrayList<Customer> logTwo = LogHandler.populateCustomerDataset(FILE_TWO);
		ArrayList<Customer> expectedSet = getLogTwoCustomerList();
		assertEquals(expectedSet, logTwo);
	}

	@Test(expected = LogHandlerException.class)
	public void EmptyCustomerName() throws CustomerException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,,0123456789,DVC,5,5,PZV,2";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals("", logCustomer.getName());
	}
	
	@Test(expected = CustomerException.class)
	public void WhiteSpaceCustomerName() throws CustomerException, LogHandlerException {
		String logLine = "19:00:00,19:20:00, ,0123456789,DVC,5,5,PZV,2";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals(" ", logCustomer.getName());
	}
	
	@Test(expected = CustomerException.class)
	public void CustomerNameTooLong() throws CustomerException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,abcdefghijklmnopqrstuvwxyz,0123456789,DVC,5,5,PZV,2";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals("Casey Jones", logCustomer.getName());
	}

	@Test(expected = LogHandlerException.class)
	public void EmptyMobileNumber() throws CustomerException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,,DVC,5,5,PZV,2";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals("", logCustomer.getMobileNumber());
	}

	@Test(expected = CustomerException.class)
	public void MobileNumberTooShort() throws CustomerException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,012345678,DVC,5,5,PZV,2";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals("Casey Jones", logCustomer.getName());
	}

	@Test(expected = CustomerException.class)
	public void MobileNumberTooLong() throws CustomerException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,012345678910,DVC,5,5,PZV,2";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals("Casey Jones", logCustomer.getName());
	}

	@Test(expected = LogHandlerException.class)
	public void EmptyCustomerType() throws CustomerException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,,5,5,PZV,2";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals("", logCustomer.getCustomerType());
	}

	@Test(expected = CustomerException.class)
	public void UnknownCustomerType() throws CustomerException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,AAA,5,5,PZV,2";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals("Casey Jones", logCustomer.getName());
	}

	@Test(expected = LogHandlerException.class)
		public void EmptyLocationX() throws CustomerException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,,5,PZV,2";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals("Casey Jones", logCustomer.getName());
	}

	@Test(expected = CustomerException.class)
	public void DeliveryDistanceEastTooBig() throws CustomerException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,11,5,PZV,2";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals("Casey Jones", logCustomer.getName());
	}

	@Test(expected = CustomerException.class)
	public void DeliveryDistanceWestTooBig() throws CustomerException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,-11,5,PZV,2";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals("Casey Jones", logCustomer.getName());
	}

	@Test(expected = CustomerException.class)
	public void DeliveryDistanceNorthTooBig() throws CustomerException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,11,PZV,2";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals("Casey Jones", logCustomer.getName());
	}
	
	@Test(expected = CustomerException.class)
	public void DeliveryDistanceSouthTooBig() throws CustomerException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,-11,PZV,2";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals("Casey Jones", logCustomer.getName());
	}

	@Test(expected = LogHandlerException.class)
	public void EmptyLocationY() throws CustomerException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,,PZV,2";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals("Casey Jones", logCustomer.getName());
	}

	@Test(expected = CustomerException.class)
	public void DeliveryFromLocation0() throws CustomerException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,0,0,PZV,2";
		Customer logCustomer = LogHandler.createCustomer(logLine);
		assertEquals("Casey Jones", logCustomer.getName());
	}

	@Test(expected = LogHandlerException.class)
	public void NullLogLine() throws CustomerException, LogHandlerException {
		String logLine = null;
		Customer logCustomer = LogHandler.createCustomer(logLine);
	}

	@Test(expected = LogHandlerException.class)
	public void IncompleteLogLine() throws CustomerException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,DVC,5,5,PZV,2";
		Customer logCustomer = LogHandler.createCustomer(logLine);
	}
	
	@Test (expected = LogHandlerException.class)
	public void ImportLogMobileNumberTooLong() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "MobileNumberTooLongException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	@Test (expected = LogHandlerException.class)
	public void ImportLogMobileNumberDoesntStartWith0() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "MobileNumberStartWith0Exception.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	@Test (expected = LogHandlerException.class)
	public void ImportLongOrderAfterClose() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "OrderAfterCloseException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	@Test (expected = LogHandlerException.class)
	public void ImportLogOrderBeforeOpen() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "OrderBeforeOpenException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	@Test (expected = LogHandlerException.class)
	public void ImportLogNameTooLong() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "NameTooLongException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	@Test (expected = LogHandlerException.class)
	public void ImportLogMobileNumberTooShort() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "MobileNumberTooShortException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	@Test (expected = LogHandlerException.class)
	public void ImportLogDeliveryDistanceWest() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "DeliveryDistanceTooFarWestException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	@Test (expected = LogHandlerException.class)
	public void ImportLogDeliveryDistanceEast() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "DeliveryDistanceTooFarEastException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	@Test (expected = LogHandlerException.class)
	public void ImportLogDeliveryDistanceNorth() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "DeliveryDistanceTooFarNorthException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	@Test (expected = LogHandlerException.class)
	public void ImportLogDeliveryDistanceSouth() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "DeliveryDistanceTooFarSouthException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	@Test (expected = LogHandlerException.class)
	public void ImportLogDeliveryWith00() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "DeliveryDistance00WithDelivery.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	@Test (expected = LogHandlerException.class)
	public void ImportLogDeliveryBefore10Minutes() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "DeliveryBefore10Minutes.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	@Test (expected = LogHandlerException.class)
	public void ImportLogDeliveryDistanceWithPickup() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "DeliveryDistanceWithPickUp.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	public ArrayList<Customer> getLogOneCustomerList() throws CustomerException {
		ArrayList<Customer> logOne = new ArrayList<>();
		logOne.add(new DriverDeliveryCustomer("Casey Jones", "0123456789",5,5));
		logOne.add(new DroneDeliveryCustomer("April O'Neal","0987654321",3,4));
		logOne.add(new PickUpCustomer("Oroku Saki", "0111222333",0,0));
		return logOne;
	}
	
	public ArrayList<Customer> getLogTwoCustomerList() throws CustomerException {
		ArrayList<Customer> logTwo = new ArrayList<>();
		logTwo.add(new DriverDeliveryCustomer("Emma Brown", "0602547760",-1,0));
		logTwo.add(new DroneDeliveryCustomer("Lucas Anderson", "0755201141",-4,5));
		logTwo.add(new DroneDeliveryCustomer("Sophia Singh", "0193102468",1,8));
		logTwo.add(new PickUpCustomer("Bella Chen", "0265045495",0,0));
		logTwo.add(new DroneDeliveryCustomer("Sophia Brown", "0101102333",-2,4));
		logTwo.add(new PickUpCustomer("Eli Wang", "0858312357",0,0));
		logTwo.add(new DroneDeliveryCustomer("Riley Brown", "0708426008",-2,0));
		logTwo.add(new DroneDeliveryCustomer("Emma Chen", "0678585543",-4,2));
		logTwo.add(new DriverDeliveryCustomer("Jackson Taylor", "0698979160",-5,-10));
		logTwo.add(new PickUpCustomer("Caden Kumar", "0862001010",0,0));
		return logTwo;
	}
	
}
