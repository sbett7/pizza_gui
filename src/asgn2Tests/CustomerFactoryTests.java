package asgn2Tests;

import static org.junit.Assert.*;
import asgn2Customers.*;
import asgn2Exceptions.*;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;
/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Michael de Closey
 *
 */
public class CustomerFactoryTests {
	// TO DO
	private final String PICK_UP = "Pick Up";
	private final String DRONE = "Drone Delivery";
	private final String DRIVER = "Driver Delivery";
	private final String PICK_UP_CODE = "PUC";
	private final String DRONE_CODE = "DNC";
	private final String DRIVER_CODE = "DVC";
	Customer PUCcustomer;
	Customer DVCcustomer;
	Customer DNCcustomer;
	
	@Before @Test
	public void setup() throws CustomerException{
		PUCcustomer = CustomerFactory.getCustomer(PICK_UP_CODE,"PickUp", "0412345677", 0, 0);
		DNCcustomer = CustomerFactory.getCustomer(DRONE_CODE,"Drone", "0412345678", 6, 8);
		DVCcustomer = CustomerFactory.getCustomer(DRIVER_CODE,"Driver", "0412345679", 3, 4);
	}

	@Test
	public void GetCustomerTypePickUp() {
		assertEquals(PICK_UP, PUCcustomer.getCustomerType());
	}
	
	@Test
	public void GetNamePickUp() {
		assertEquals("PickUp", PUCcustomer.getName());
	}
	
	@Test
	public void GetMobilePickUp(){
		assertEquals("0412345677", PUCcustomer.getMobileNumber());
	}
	
	@Test
	public void GetLocationXPickUp() {
		assertEquals(0, PUCcustomer.getLocationX());
	}
	
	@Test
	public void GetLocationYPickUp() {
		assertEquals(0, PUCcustomer.getLocationY());
	}

	@Test
	public void GetCustomerTypeDrone() {
		assertEquals(DRONE, DNCcustomer.getCustomerType());
	}	

	@Test
	public void GetNameDrone() {
		assertEquals("Drone", DNCcustomer.getName());
	}
	
	@Test
	public void GetMobileDrone(){
		assertEquals("0412345678", DNCcustomer.getMobileNumber());
	}
	
	@Test
	public void GetLocationXDrone() {
		assertEquals(6, DNCcustomer.getLocationX());
	}
	
	@Test
	public void GetLocationYDrone() {
		assertEquals(8, DNCcustomer.getLocationY());
	}
	
	@Test
	public void GetCustomerTypeDriver() {
		assertEquals(DRIVER, DVCcustomer.getCustomerType());
	}
	
	@Test
	public void GetNameDriver() {
		assertEquals("Driver", DVCcustomer.getName());
	}
	
	@Test
	public void GetMobileDriver(){
		assertEquals("0412345679", DVCcustomer.getMobileNumber());
	}
	
	@Test
	public void GetLocationXDriver(){
		assertEquals(3, DVCcustomer.getLocationX());
	}
	
	@Test
	public void GetLocationYDriver(){
		assertEquals(4, DVCcustomer.getLocationY());
	}

	
	@Test(expected = CustomerException.class)
	public void IncorrectCodeException() throws CustomerException{
		Customer test = CustomerFactory.getCustomer("ABC", "Test", "0448126108", 2, 9);
	}
	
	@Test(expected = CustomerException.class)
	public void EmptyCodeException() throws CustomerException {
		Customer test = CustomerFactory.getCustomer("", "Test", "0412345678", 1, 1);
	}
	
}
