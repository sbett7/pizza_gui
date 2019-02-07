package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.*;
import asgn2Restaurant.LogHandler;


/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author Sean Betts
* 
*/
public class LogHandlerPizzaTests {
	
	//PIZZA TYPES
	private final static String MARGHERITA = "PZM";
	private final static String VEGETARIAN = "PZV";
	private final static String MEAT_LOVERS = "PZL";
	
	
	private final String PZM = "PZM";
	private final String PZL = "PZL";
	private final String PZV = "PZV";
	
	//FILE NAMES 
	private final String FILE_ONE = System.getProperty("user.dir") + "\\logs\\20170101.txt";
	private final String FILE_TWO = System.getProperty("user.dir") + "\\logs\\20170102.txt";
	private final String FILE_THREE = System.getProperty("user.dir") + "\\logs\\20170103.txt";
	
	//FILE DIRECTORY 
	private final String EXCEPTION_DIR = System.getProperty("user.dir") + "\\logs\\Exceptions\\";
	private final String NON_EXCEPTION_DIR = System.getProperty("user.dir") + "\\logs\\Non-Exceptions\\";
	
	/*
	 * Creating a Margherita Pizza order with a quantity of one with the Pizza LogHandler.
	 * Expected: Margherita Pizza created by LogHandler should be equal to one created by the Pizza Factory.
	 */
	@Test
	public void createPizzaMargheritaPizzaQuantityOne() throws PizzaException, LogHandlerException {
		int quantity = 1;
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZM,1";
		
		Pizza factoryPizza = PizzaFactory.getPizza(PZM, quantity, LocalTime.of(19, 0), LocalTime.of(19, 20));
		Pizza logPizza = LogHandler.createPizza(logLine);
		
		assertTrue("Unable to create Margherita Pizza from Log Line with a quantity of one.",
				factoryPizza.equals(logPizza));
	}
	
	/*
	 * Creating a Meat Lovers Pizza order with a quantity of one with the Pizza LogHandler.
	 * Expected: Meat Lovers Pizza created by LogHandler should be equal to one created by the Pizza Factory.
	 */
	@Test
	public void createPizzaMeatLoversPizzaQuantityOne() throws PizzaException, LogHandlerException {
		int quantity = 1;
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZL,1";
		
		Pizza factoryPizza = PizzaFactory.getPizza(PZL, quantity, LocalTime.of(19, 0), LocalTime.of(19, 20));
		Pizza logPizza = LogHandler.createPizza(logLine);
		
		assertTrue("Unable to create Meat Lovers Pizza from Log Line with a quantity of one.",
				factoryPizza.equals(logPizza));
	}
	
	/*
	 * Creating a Vegetarian Pizza order with a quantity of one with the Pizza LogHandler.
	 * Expected: Vegetarian Pizza created by LogHandler should be equal to one created by the Pizza Factory.
	 */
	@Test
	public void createPizzaVegetarianPizzaQuantityOne() throws PizzaException, LogHandlerException {
		int quantity = 1;
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,1";
		
		Pizza factoryPizza = PizzaFactory.getPizza(PZV, quantity, LocalTime.of(19, 0), LocalTime.of(19, 20));
		Pizza logPizza = LogHandler.createPizza(logLine);
		
		assertTrue("Unable to create Vegetarian Pizza from Log Line with a quantity of one.",
				factoryPizza.equals(logPizza));
	}
	
	/*
	 * Creating a Margherita Pizza order with a quantity of five with the Pizza LogHandler.
	 * Expected: Margherita Pizza created by LogHandler should be equal to one created by the Pizza Factory.
	 */
	@Test
	public void createPizzaMargheritaPizzaQuantityFive() throws PizzaException, LogHandlerException {
		int quantity = 5;
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZM,5";
		
		Pizza factoryPizza = PizzaFactory.getPizza(PZM, quantity, LocalTime.of(19, 0), LocalTime.of(19, 20));
		Pizza logPizza = LogHandler.createPizza(logLine);
		
		assertTrue(factoryPizza.equals(logPizza));
	}
	
	/*
	 * Creating a Meat Lovers Pizza order with a quantity of five with the Pizza LogHandler.
	 * Expected: Meat Lovers Pizza created by LogHandler should be equal to one created by the Pizza Factory.
	 */
	@Test
	public void createPizzaMeatLoversPizzaQuantityFive() throws PizzaException, LogHandlerException {
		int quantity = 5;
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZL,5";
		
		Pizza factoryPizza = PizzaFactory.getPizza(PZL, quantity, LocalTime.of(19, 0), LocalTime.of(19, 20));
		Pizza logPizza = LogHandler.createPizza(logLine);
		
		assertTrue("Unable to create Meat Lovers Pizza from Log Line with a quantity of five.",
				factoryPizza.equals(logPizza));
	}
	
	/*
	 * Creating a Vegetarian Pizza order with a quantity of five with the Pizza LogHandler.
	 * Expected: Vegetarian Pizza created by LogHandler should be equal to one created by the Pizza Factory.
	 */
	@Test
	public void createPizzaVegetarianPizzaQuantityFive() throws PizzaException, LogHandlerException {
		int quantity = 5;
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,5";
		
		Pizza factoryPizza = PizzaFactory.getPizza(PZV, quantity, LocalTime.of(19, 0), LocalTime.of(19, 20));
		Pizza logPizza = LogHandler.createPizza(logLine);
		
		assertTrue("Unable to create Vegetarian Pizza from Log Line with a quantity of five.",
				factoryPizza.equals(logPizza));
	}
	
	/*
	 * Creating a Pizza order with the provided order time with an incorrect hour format.
	 * Expected: The LogHandlerException class is thrown.
	 */
	@Test (expected = LogHandlerException.class)
	public void createPizzaIncorrectOrderTimeFormatHoursException() throws PizzaException, LogHandlerException {
		String logLine = "1:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,5";
		
		Pizza logPizza = LogHandler.createPizza(logLine);
	}
	
	/*
	 * Creating a Pizza order with the provided order time with an incorrect minute format.
	 * Expected: The LogHandlerException class is thrown.
	 */
	@Test (expected = LogHandlerException.class)
	public void createPizzaIncorrectOrderTimeFormatMinutesException() throws PizzaException, LogHandlerException {
		String logLine = "19:0:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,5";
		
		Pizza logPizza = LogHandler.createPizza(logLine);
	}
	
	/*
	 * Creating a Pizza order with the provided order time with an incorrect seconds format.
	 * Expected: The LogHandlerException class is thrown.
	 */
	@Test (expected = LogHandlerException.class)
	public void createPizzaIncorrectOrderTimeFormatSecondsException() throws PizzaException, LogHandlerException {
		String logLine = "19:00:0,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,5";
		
		Pizza logPizza = LogHandler.createPizza(logLine);	
	}
	
	/*
	 * Creating a Pizza order with an empty order time.
	 * Expected: The LogHandlerException class is thrown.
	 */
	@Test (expected = LogHandlerException.class)
	public void createPizzaEmptyOrderTimeException() throws PizzaException, LogHandlerException {
		String logLine = "19:00:0,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,5";
		
		Pizza logPizza = LogHandler.createPizza(logLine);	
	}
	
	/*
	 * Creating a Pizza order with the provided delivery time with an incorrect hours format.
	 * Expected: The LogHandlerException class is thrown.
	 */
	@Test (expected = LogHandlerException.class)
	public void createPizzaIncorrectDeliveryTimeFormatHoursException() throws PizzaException, LogHandlerException {
		String logLine = "19:00:00,9:20:00,Casey Jones,0123456789,DVC,5,5,PZV,5";
		
		Pizza logPizza = LogHandler.createPizza(logLine);
	}
	
	/*
	 * Creating a Pizza order with the provided delivery time with an incorrect minutes format.
	 * Expected: The LogHandlerException class is thrown.
	 */
	@Test (expected = LogHandlerException.class)
	public void createPizzaIncorrectDeliveryTimeFormatMinutesException() throws PizzaException, LogHandlerException {
		String logLine = "19:00:00,19:2:00,Casey Jones,0123456789,DVC,5,5,PZV,5";
		
		Pizza logPizza = LogHandler.createPizza(logLine);
	}
	
	/*
	 * Creating a Pizza order with the provided delivery time with an incorrect seconds format.
	 * Expected: The LogHandlerException class is thrown.
	 */
	@Test (expected = LogHandlerException.class)
	public void createPizzaIncorrectDeliveryTimeFormatSecondsException() throws PizzaException, LogHandlerException {
		String logLine = "19:00:00,19:20:0,Casey Jones,0123456789,DVC,5,5,PZV,5";
		
		Pizza logPizza = LogHandler.createPizza(logLine);
	}
	
	/*
	 * Creating a Pizza order with an empty delivery time.
	 * Expected: The PizzaException class is thrown.
	 */
	@Test (expected = LogHandlerException.class)
	public void createPizzaEmptyDeliveryTimeException() throws PizzaException, LogHandlerException {
		String logLine = "19:00:00,,Casey Jones,0123456789,DVC,5,5,PZV,5";
		
		Pizza logPizza = LogHandler.createPizza(logLine);
	}
	
	/*
	 * Creating a Pizza order with the provided pizza code being unlisted.
	 * Expected: The PizzaException class is thrown.
	 */
	@Test (expected = PizzaException.class)
	public void createPizzaIncorrectPizzaCodeException() throws PizzaException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZA,5";
		
		Pizza logPizza = LogHandler.createPizza(logLine);
	}
	
	/*
	 * Creating a Pizza order with empty provided pizza code being unlisted.
	 * Expected: The PizzaException class is thrown.
	 */
	@Test (expected = LogHandlerException.class)
	public void createPizzaEmptyPizzaCodeException() throws PizzaException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,,5";
		
		Pizza logPizza = LogHandler.createPizza(logLine);
	}
	
	/*
	 * Creating a Pizza order with zero pizza quantity.
	 * Expected: The PizzaException class is thrown.
	 */
	@Test (expected = PizzaException.class)
	public void createPizzaZeroPizzaQuantityException() throws PizzaException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,0";
		
		Pizza logPizza = LogHandler.createPizza(logLine);
	}
	
	/*
	 * Creating a Pizza order with a pizza quantity larger than the max limit.
	 * Expected: The PizzaException class is thrown.
	 */
	@Test (expected = PizzaException.class)
	public void createPizzaOverPizzaQuantityLimitException() throws PizzaException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,21";
		
		Pizza logPizza = LogHandler.createPizza(logLine);
	}
	
	/*
	 * Creating a Pizza order with an empty pizza quantity.
	 * Expected: The LogHandlerException class is thrown.
	 */
	@Test (expected = LogHandlerException.class)
	public void createPizzaEmptyPizzaQuantityException() throws PizzaException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV,";
		
		Pizza logPizza = LogHandler.createPizza(logLine);
	}
	
	/*
	 * Creating a Pizza order with a line without the pizza quantity.
	 * Expected: The LogHandlerException class is thrown.
	 */
	@Test (expected = LogHandlerException.class)
	public void createPizzaIncompleteLineNoPizzaQuantityException() throws PizzaException, LogHandlerException {
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZV";
		
		Pizza logPizza = LogHandler.createPizza(logLine);
	}
	
	/*
	 * Creating a Pizza order with an empty log line.
	 * Expected: The LogHandlerException class is thrown.
	 */
	@Test (expected = LogHandlerException.class)
	public void createPizzaEmptyLogLineException() throws PizzaException, LogHandlerException {
		String logLine = "";
		
		Pizza logPizza = LogHandler.createPizza(logLine);
	}
	
	/*
	 * Creating a Pizza order with a null log line.
	 * Expected: The LogHandlerException class is thrown.
	 */
	@Test (expected = NullPointerException.class)
	public void createPizzaNullLogLineException() throws PizzaException, LogHandlerException {
		String logLine = null;
		
		Pizza logPizza = LogHandler.createPizza(logLine);
	}
	
	/*
	 * Creating a Pizza order with the log line missing pizza code.
	 * Expected: The LogHandlerException class is thrown.
	 */
	@Test (expected = LogHandlerException.class)
	public void createPizzaIncompleteLineMissingPizzaCodesException() throws PizzaException, LogHandlerException {
		String logLine = "19:00:00,19:20:0,Casey Jones,0123456789,DVC,5,5";
		
		Pizza logPizza = LogHandler.createPizza(logLine);
	}
	
	/*
	 * Creating a Pizza order with the quantity field as a letter
	 * Expected: The LogHandlerException class is thrown.
	 */
	@Test (expected = LogHandlerException.class)
	public void createPizzaQuantityNaNException() throws PizzaException, LogHandlerException{
		String logLine = "19:00:00,19:20:00,Casey Jones,0123456789,DVC,5,5,PZL,a";
		
		Pizza logPizza = LogHandler.createPizza(logLine);
	}
	
	/*
	 * Populating the pizza dataset using log file one
	 * Expected: A pizza list that matches the list generated by getLogOnePizzaList()
	 */
	@Test 
	public void populatePizzaDatasetLogFileOne() throws PizzaException, LogHandlerException{
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(FILE_ONE);
		ArrayList<Pizza> expectedSet = getLogOnePizzaList();
		
		assertEquals("Cannot populate pizza dataset from log file one",
				expectedSet, dataSet);
	}
	
	/*
	 * Populating the pizza dataset using log file two
	 * Expected: A pizza list that matches the list generated by getLogTwoPizzaList()
	 */
	@Test 
	public void populatePizzaDatasetLogFileTwo() throws PizzaException, LogHandlerException{
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(FILE_TWO);
		
		assertEquals("Cannot populate pizza dataset from log file two",
				getLogTwoPizzaList(), dataSet);
	}
	
	
	/*
	 * Populating the pizza dataset with a log file that contains a line with a pizza quantity of zero
	 * Expected: The PizzaException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetZeroPizzaQuantityException() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "ZeroPizzaQuantityException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	/*
	 * Populating the pizza dataset with a log file that contains a line with a pizza quantity of zero
	 * and multiple correct lines
	 * Expected: The LogHandlerException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetZeroPizzaQuantityMultipleCorrectEntriesException() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "ZeroPizzaQuantityMultipleCorrectEntriesException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	/*
	 * Populating the pizza dataset with a log file that contains an incorrect pizza code
	 * Expected: The LogHandlerException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetIncorrectPizzaCodeException() throws PizzaException, LogHandlerException{
		String filePath =  EXCEPTION_DIR + "IncorrectPizzaCodeException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	/*
	 * Populating the pizza dataset with a log file that contains an incorrect pizza code
	 * and multiple correct lines
	 * Expected: The PizzaException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetIncorrectPizzaCodeMultipleCorrectEntriesException() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "IncorrectPizzaCodeMultipleCorrectEntriesException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	/*
	 * Populating the pizza dataset with a log file that an order time with an incorrect hour format
	 * Expected: The LogHandlerException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetIncorrectOrderTimeHourException() throws PizzaException, LogHandlerException{
		String filePath =  EXCEPTION_DIR + "IncorrectTimeFormatOrderTimeHourException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	/*
	 * Populating the pizza dataset with a log file that an order time with an incorrect hour format
	 * and several correct entries
	 * Expected: The LogHandlerException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetIncorrectOrderTimeHourMultipleCorrectEntriesException() throws PizzaException, LogHandlerException{
		String filePath =  EXCEPTION_DIR + "IncorrectTimeFormatOrderTimeHourMultipleCorrectEntriesException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	/*
	 * Populating the pizza dataset with a log file that an order time with an incorrect minute format
	 * Expected: The LogHandlerException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetIncorrectOrderTimeMinuteException() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "IncorrectTimeFormatOrderTimeMinuteException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	/*
	 * Populating the pizza dataset with a list that an order time with an incorrect minute format
	 * and several correct entries
	 * Expected: The LogHandlerException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetIncorrectOrderTimeMinuteMultipleCorrectEntriesException() throws PizzaException, LogHandlerException{
		String filePath =  EXCEPTION_DIR + "IncorrectTimeFormatOrderTimeMinuteMultipleCorrectEntriesException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	/*
	 * Populating the pizza dataset with a log file that an order time with an incorrect second format
	 * Expected: The LogHandlerException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetIncorrectOrderTimeSecondException() throws PizzaException, LogHandlerException{
		String filePath =  EXCEPTION_DIR + "IncorrectTimeFormatOrderTimeSecondException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	/*
	 * Populating the pizza dataset with a list that an order time with an incorrect second format
	 * and several correct entries
	 * Expected: The LogHandlerException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetIncorrectOrderTimeSecondMultipleCorrectEntriesException() throws PizzaException, LogHandlerException{
		String filePath =  EXCEPTION_DIR + "IncorrectTimeFormatOrderTimeSecondMultipleCorrectEntriesException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}

	/*
	 * Populating the pizza dataset with a log file that an delivery time with an incorrect hour format
	 * Expected: The LogHandlerException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetIncorrectDeliveryTimeHourException() throws PizzaException, LogHandlerException{
		String filePath =  EXCEPTION_DIR + "IncorrectTimeFormatDeliveryTimeHourException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}

	/*
	 * Populating the pizza dataset with a log file that an delivery time with an incorrect hour format
	 * and several correct entries
	 * Expected: The LogHandlerException class is thrown
	 */	
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetIncorrectDeliveryTimeHourMultipleCorrectEntriesException() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "IncorrectTimeFormatDeliveryTimeHourMultipleCorrectEntriesException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	/*
	 * Populating the pizza dataset with a log file that an delivery time with an incorrect minute format
	 * Expected: The LogHandlerException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetIncorrectDeliveryTimeMinuteException() throws PizzaException, LogHandlerException{
		String filePath =  EXCEPTION_DIR + "IncorrectTimeFormatDeliveryTimeMinuteException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	/*
	 * Populating the pizza dataset with a log file that an delivery time with an incorrect minute format
	 * and several correct entries
	 * Expected: The LogHandlerException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetIncorrectDeliveryTimeMinuteMultipleCorrectEntriesException() throws PizzaException, LogHandlerException{
		String filePath = System.getProperty("user.dir") + 
				"logs\\Exceptions\\IncorrectTimeFormaDeliveryTimeMinuteMultipleCorrectEntriesException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	/*
	 * Populating the pizza dataset with a log file that an delivery time with an incorrect second format
	 * Expected: The PizzaException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetIncorrectDeliveryTimeSecondException() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "IncorrectTimeFormatDeliveryTimeSecondException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	/*
	 * Populating the pizza dataset with a log file that an delivery time with an incorrect second format
	 * and several correct entries
	 * Expected: The LogHandlerException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetIncorrectDeliveryTimeSecondMultipleCorrectEntriesException() throws PizzaException, LogHandlerException{
		String filePath = System.getProperty("user.dir") + 
				"logs\\Exceptions\\IncorrectTimeFormatDeliveryTimeSecondMultipleCorrectEntriesException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}	
	
	/*
	 * populating a dataset with an empty text file
	 * Expected: The LogHandlerException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetEmptyLogException() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "EmptyTextFileException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	/*
	 * populating a dataset with the pizza code missing
	 * Expected: The LogHandlerException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetMissingPizzaCodeLogException() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "MissingPizzaCodeException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	/*
	 * populating a dataset with the pizza code missing with multiple correct entries
	 * Expected: The LogHandlerException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetMissingPizzaCodeMultipleCorrectEntriesLogException() throws PizzaException, LogHandlerException{
		String filePath = System.getProperty("user.dir") +
				"logs\\Exceptions\\MissingPizzaCodeMultipleCorrectEntriesException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	/*
	 * populating a dataset with the pizza quantity missing
	 * Expected: The LogHandlerException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetMissingPizzaQuantityLogException() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "MissingPizzaQuantityException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	/*
	 * populating a dataset with the pizza quantity missing with multiple correct entries
	 * Expected: The LogHandlerException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetMissingPizzaQuantityMultipleCorrectEntriesLogException() throws PizzaException, LogHandlerException{
		String filePath = System.getProperty("user.dir") +
				"logs\\Exceptions\\MissingPizzaQuantityMultipleCorrectEntriesException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	/*
	 * populating a dataset with the pizza quantity empty
	 * Expected: The LogHandlerException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetEmptyPizzaQuantityLogException() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "MissingPizzaQuantityException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	/*
	 * populating a dataset with the pizza quantity empty with multiple correct entries
	 * Expected: The PizzaException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetEmptyPizzaQuantityMultipleCorrectEntriesLogException() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "MissingPizzaQuantityMultipleCorrectEntriesException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	/*
	 * populating a dataset with the pizza code empty
	 * Expected: The LogHandlerException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetEmptyPizzaCodeLogException() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "EmptyPizzaCodeException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	/*
	 * populating a dataset with the pizza code empty with multiple correct entries
	 * Expected: The LogHandlerException class is thrown
	 */
	@Test (expected = LogHandlerException.class)
	public void populatePizzaDatasetEmptyPizzaCodeMultipleCorrectEntriesLogException() throws PizzaException, LogHandlerException{
		String filePath = EXCEPTION_DIR + "EmptyPizzaCodeExceptionMultipleCorrectEntriesException.txt";
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(filePath);
	}
	
	/*
	 * populating a dataset with a null file name given
	 * Expected: The LogHandlerException class is thrown
	 */
	@Test (expected = NullPointerException.class)
	public void populatePizzaDatasetNullLogException() throws PizzaException, LogHandlerException{
		ArrayList<Pizza> dataSet = LogHandler.populatePizzaDataset(null);
	}
	
	/**
	 * Returns a list containing the values presented in log file one.
	 * @return Returns a list containing the expected pizzas within log file one.
	 * @throws PizzaException If any of the conditions listed in the specification are not adhered to.
	 */
	private ArrayList<Pizza> getLogOnePizzaList() throws PizzaException{
		ArrayList<Pizza> pizzas = new ArrayList<>();
		
		Pizza pizzaArray[] = new Pizza[]{
			new VegetarianPizza(2, LocalTime.of(19, 0), LocalTime.of(19, 20)),
			new MargheritaPizza(1, LocalTime.of(20, 0), LocalTime.of(20, 25)),
			new MeatLoversPizza(3, LocalTime.of(21, 0), LocalTime.of(21, 35))
		};
		
		for (Pizza pizza : pizzaArray){
			pizzas.add(pizza);
		}
			
		return pizzas;
	}
	
	/**
	 * Returns a list containing the values presented in log file two.
	 * @return Returns a list containing the expected pizzas within log file two.                     
	 * @throws PizzaException If any of the conditions listed in the specification are not adhered to.
	 */
	private ArrayList<Pizza> getLogTwoPizzaList() throws PizzaException{
		ArrayList<Pizza> pizzas = new ArrayList<>();
		Pizza pizzaArray[] = new Pizza[]{
				new VegetarianPizza(5, LocalTime.of(21, 17), LocalTime.of(21, 27)),
				new MeatLoversPizza(9, LocalTime.of(21, 52), LocalTime.of(22, 7)),
				new VegetarianPizza(2, LocalTime.of(20, 43), LocalTime.of(20, 53)),
				new MargheritaPizza(1, LocalTime.of(21, 5), LocalTime.of(21, 34)),
				new VegetarianPizza(7, LocalTime.of(19, 46), LocalTime.of(20, 1)),
				new MeatLoversPizza(7, LocalTime.of(21, 45), LocalTime.of(21, 56)),
				new VegetarianPizza(2, LocalTime.of(20, 23), LocalTime.of(20, 44)),
				new MeatLoversPizza(4, LocalTime.of(21, 8), LocalTime.of(21, 30)),
				new MeatLoversPizza(5, LocalTime.of(22, 46), LocalTime.of(22, 58)),
				new MeatLoversPizza(9, LocalTime.of(20, 47), LocalTime.of(21, 11))
			};
		
		for (Pizza pizza : pizzaArray){
			pizzas.add(pizza);
		}
			
		return pizzas;
	}
	
}
