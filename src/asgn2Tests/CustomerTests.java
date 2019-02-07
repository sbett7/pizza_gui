package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import asgn2Exceptions.*;
import asgn2Customers.*;

/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDeliveryCustomer,
 * asgn2Customers.DroneDeliveryCustomer classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Michael de Closey
 * 
 *
 */
public class CustomerTests {
	Customer driver;
	Customer pickup;
	Customer drone;
	private final String PICK_UP = "Pick Up";
	private final String DRONE = "Drone Delivery";
	private final String DRIVER = "Driver Delivery";
	
	private final double TO_SECOND_DECIMAL = 0.01;
	
	// Customer (String Name, String mobile number, int location X, int Location Y, String type)
	// Type is either Pick up, Driver Delivery or Drone Delivery
	
	@Before @Test
	public void setup() throws CustomerException {
		driver = new DriverDeliveryCustomer("driver", "0412345678", 3, 4);
		pickup = new PickUpCustomer("pickup", "0487654321", 0, 0);
		drone = new DroneDeliveryCustomer("drone", "0423456781", 6,8);
	}
	
	//Driver Delivery Test
	@Test
	public void getNameDriver() {
		assertEquals("driver", driver.getName());
	}
	
	@Test
	public void getMobileNumberDriver() {
		assertEquals("0412345678", driver.getMobileNumber());	
	}
	
	@Test
	public void GetCustomerTypeDriver() {
		assertEquals(DRIVER, driver.getCustomerType());
	}
	
	@Test
	public void getLocationXdriver() {
		assertEquals(3,driver.getLocationX());
	}
	
	@Test
	public void getLocationYdriver() {
		assertEquals(4, driver.getLocationY());
	}
	
	@Test
	public void GetDeliveryDistancePositiveXandYDriver() {
		assertEquals(7, driver.getDeliveryDistance(), TO_SECOND_DECIMAL);
	}
	
	@Test
	public void GetDeliveryDistanceNegativeXPositiveYDriver() throws CustomerException {
		Customer test = new DriverDeliveryCustomer("driver", "0412345678", -3, 4);
		assertEquals(7, test.getDeliveryDistance(), TO_SECOND_DECIMAL);
	}
	
	@Test
	public void GetDeliveryDistanceNegativeXNegativeYDriver() throws CustomerException {
		Customer test = new DriverDeliveryCustomer("driver", "0412345678", -3, -4);
		assertEquals(7, test.getDeliveryDistance(), TO_SECOND_DECIMAL);
	}
	
	@Test
	public void GetDeliveryDistancePositiveXNegativeYDriver() throws CustomerException {
		Customer test = new DriverDeliveryCustomer("driver", "0412345678", 3, -4);
		assertEquals(7, test.getDeliveryDistance(), TO_SECOND_DECIMAL);
	}
	
	@Test
	public void DriverTypeNotPickup() {
		assertFalse(driver.getCustomerType().equals(PICK_UP));
	}
	
	@Test
	public void DriverTypeNotDrone() {
		assertFalse(driver.getCustomerType().equals(DRONE));
	}
	
	//Delivery Drone Tests
	@Test
	public void getNameDrone() {
		assertEquals("drone", drone.getName());
	}
	
	@Test
	public void getMobileNumberDrone() {
		assertEquals("0423456781", drone.getMobileNumber());
	}
	
	@Test
	public void GetCustomerTypeDrone() {
		assertEquals(DRONE, drone.getCustomerType());
	}
	
	@Test
	public void getLocationXdrone() {
		assertEquals(6, drone.getLocationX());
	}
	
	@Test
	public void getLocationYdrone() {
		assertEquals(8, drone.getLocationY());
	}
	
	@Test
	public void GetDeliveryDistancePostiveXandYDrone() throws CustomerException {
		assertEquals(10, drone.getDeliveryDistance(), TO_SECOND_DECIMAL);
	}
	
	@Test
	public void GetDeliveryDistancePositiveXNegativeYDrone() throws CustomerException {
		Customer test = new DroneDeliveryCustomer("drone", "0423456781", 6,-8);
		assertEquals(10, test.getDeliveryDistance(), TO_SECOND_DECIMAL);
	}
	
	@Test
	public void GetDeliveryDistanceNegativeXNegativeYDrone() throws CustomerException {
		Customer test = new DroneDeliveryCustomer("drone", "0423456781", -6,-8);
		assertEquals(10, test.getDeliveryDistance(), TO_SECOND_DECIMAL);
	}
	
	@Test
	public void GetDeliveryDistanceNegativeXPositiveYDrone() throws CustomerException {
		Customer test = new DroneDeliveryCustomer("drone", "0423456781", -6,8);
		assertEquals(10, test.getDeliveryDistance(), TO_SECOND_DECIMAL);
	}
	
	@Test
	public void DroneTypeNotDriver() {
		assertFalse(drone.getCustomerType().equals(DRIVER));
	}
	
	@Test
	public void DroneTypeNotPickUp() {
		assertFalse(drone.getCustomerType().equals(PICK_UP));
	}
	
	//Pick Up Tests
	@Test
	public void getNamePickUp(){
		assertEquals("pickup", pickup.getName());
	}
	
	@Test 
	public void getMobileNumberPickUp() {
		assertEquals("0487654321", pickup.getMobileNumber());
	}
	
	@Test
	public void getCustomerTypePickUp(){
		assertEquals(PICK_UP, pickup.getCustomerType());
	}
	
	@Test
	public void getLocationXPickUp(){
		assertEquals(0, pickup.getLocationX());
	}
	
	@Test
	public void getLocationYpickup(){
		assertEquals(0, pickup.getLocationY());
	}
	
	@Test
	public void PickUpTypeNotDrone() {
		assertFalse(pickup.getCustomerType().equals(DRONE));
	}
	
	@Test
	public void PickUpTypeNotDriver() {
		assertFalse(pickup.getCustomerType().equals(DRIVER));
	}

	//Equals Tests
	
	@Test
	public void DriverEqualsPickup() {
		assertFalse(driver.equals(pickup));
	}
	
	@Test
	public void DriverEqualsDrone()  {
		assertFalse(driver.equals(drone));
	}
	
	@Test
	public void PickupEqualsDrone() {
		assertFalse(pickup.equals(drone));
	}
	
	@Test
	public void DriverEqualsDriver(){
		assertTrue(driver.equals(driver));
	}
	
	@Test
	public void DroneEqualsDrone(){
		assertTrue(drone.equals(drone));
	}
	
	@Test
	public void PickupEqualsPickUp(){
		assertTrue(pickup.equals(pickup));
	}
	
	@Test
	public void DriverEqualsName() throws CustomerException{
		Customer test1 = new DriverDeliveryCustomer("Test1", "0412345678", 3, 4);
		Customer test2 = new DriverDeliveryCustomer("Test2", "0412345678", 3, 4);
		assertFalse(test1.equals(test2));
	}
	
	@Test
	public void DriverEqualsMobile() throws CustomerException{
		Customer test1 = new DriverDeliveryCustomer("Test1", "0412345678", 3, 4);
		Customer test2 = new DriverDeliveryCustomer("Test1", "0412345679", 3, 4);
		assertFalse(test1.equals(test2));
	}
	
	@Test
	public void DriverEqualsLocationX() throws CustomerException{
		Customer test1 = new DriverDeliveryCustomer("Test1", "0412345678", 3, 4);
		Customer test2 = new DriverDeliveryCustomer("Test1", "0412345678", 4, 4);
		assertFalse(test1.equals(test2));
	}
	
	@Test
	public void DriverEqualsLocationY() throws CustomerException{
		Customer test1 = new DriverDeliveryCustomer("Test1", "0412345678", 3, 4);
		Customer test2 = new DriverDeliveryCustomer("Test1", "0412345678", 3, 5);
		assertFalse(test1.equals(test2));
	}
	
	@Test
	public void DroneEqualsName() throws CustomerException{
		Customer test1 = new DroneDeliveryCustomer("Test1", "0412345678", 3, 4);
		Customer test2 = new DroneDeliveryCustomer("Test2", "0412345678", 3, 4);
		assertFalse(test1.equals(test2));
	}
	
	@Test
	public void DroneEqualsMobile() throws CustomerException{
		Customer test1 = new DriverDeliveryCustomer("Test1", "0412345678", 3, 4);
		Customer test2 = new DriverDeliveryCustomer("Test1", "0412345679", 3, 4);
		assertFalse(test1.equals(test2));
	}
	
	@Test
	public void DroneEqualsLocationX() throws CustomerException{
		Customer test1 = new DriverDeliveryCustomer("Test1", "0412345678", 3, 4);
		Customer test2 = new DriverDeliveryCustomer("Test1", "0412345678", 4, 4);
		assertFalse(test1.equals(test2));
	}
	
	@Test
	public void DroneEqualsLocationY() throws CustomerException{
		Customer test1 = new DriverDeliveryCustomer("Test1", "0412345678", 3, 4);
		Customer test2 = new DriverDeliveryCustomer("Test1", "0412345678", 3, 5);
		assertFalse(test1.equals(test2));
	}
	
	@Test
	public void PickUpEqualsName() throws CustomerException{
		Customer test1 = new PickUpCustomer("Test1", "0412345678", 0, 0);
		Customer test2 = new PickUpCustomer("Test2", "0412345678", 0, 0);
		assertFalse(test1.equals(test2));
	}
	
	@Test
	public void PickUpEqualsMobile() throws CustomerException{
		Customer test1 = new PickUpCustomer("Test1", "0412345678", 0, 0);
		Customer test2 = new PickUpCustomer("Test1", "0412345679", 0, 0);
		assertFalse(test1.equals(test2));
	}
	
	
	//Exception	
	@Test(expected = CustomerException.class)
	public void EmptyCustomerNamePickUp() throws CustomerException {
		Customer test = new PickUpCustomer ("", "0412345678",0,0);
		assertEquals("Customer Name must not be empty", "0412345678", test.getMobileNumber());
	}
	
	@Test(expected = CustomerException.class)
	public void EmptyCustomerNameDriver() throws CustomerException {
		Customer test = new DriverDeliveryCustomer ("", "0412345678",1,1);
		assertEquals("Customer Name must not be empty", "0412345678", test.getMobileNumber());
	}
	
	@Test(expected = CustomerException.class)
	public void EmptyCustomerNameDrone() throws CustomerException {
		Customer test = new DroneDeliveryCustomer ("", "0412345678",1,1);
		assertEquals("Customer Name must not be empty", "0412345678", test.getMobileNumber());
	}
	

	@Test(expected = CustomerException.class)
	public void OversizedCustomerNamePickUp() throws CustomerException{
		Customer test = new PickUpCustomer ("abcdefghijklmnopqrstuv", "0412345678",0,0);
		assertEquals("Customer Name must be under 20 characters", "0412345678", test.getMobileNumber());
	}
	
	@Test(expected = CustomerException.class)
	public void OversizedCustomerNameDriver() throws CustomerException{
		Customer test = new DriverDeliveryCustomer ("abcdefghijklmnopqrstuv", "0412345678",1,1);
		assertEquals("Customer Name must be under 20 characters", "0412345678", test.getMobileNumber());
	}
	
	@Test(expected = CustomerException.class)
	public void OversizedCustomerNameDrone() throws CustomerException{
		Customer test = new DroneDeliveryCustomer ("abcdefghijklmnopqrstuv", "0412345678",1,1);
		assertEquals("Customer Name must be under 20 characters", "0412345678", test.getMobileNumber());
	}


	@Test(expected = CustomerException.class)
	public void WhiteSpaceCustomerNamePickUp() throws CustomerException {
		Customer test = new PickUpCustomer ("    ", "0412345678",0,0);
		assertEquals("Customer Name cannot only contain white spaces","0412345678", test.getMobileNumber());
	}
	
	@Test(expected = CustomerException.class)
	public void WhiteSpaceCustomerNameDriver() throws CustomerException {
		Customer test = new DriverDeliveryCustomer ("    ", "0412345678",1,1);
		assertEquals("Customer Name cannot only contain white spaces","0412345678", test.getMobileNumber());
	}
	
	@Test(expected = CustomerException.class)
	public void WhiteSpaceCustomerNameDrone() throws CustomerException {
		Customer test = new DroneDeliveryCustomer ("    ", "0412345678",1,1);
		assertEquals("Customer Name cannot only contain white spaces","0412345678", test.getMobileNumber());
	}

	@Test(expected = CustomerException.class)
	public void OversizedMobileNumberPickUp() throws CustomerException{
		Customer test = new PickUpCustomer ("Test", "012345678910",0,0);
		assertEquals("Mobile Number must be 10 numbers", "Test", test.getName());
	}
	
	@Test(expected = CustomerException.class)
	public void OversizedMobileNumberDriver() throws CustomerException{
		Customer test = new DriverDeliveryCustomer ("Test", "012345678910",1,1);
		assertEquals("Mobile Number must be 10 numbers", "Test", test.getName());
	}
	
	@Test(expected = CustomerException.class)
	public void OversizedMobileNumberDrone() throws CustomerException{
		Customer test = new DroneDeliveryCustomer ("Test", "012345678910",1,1);
		assertEquals("Mobile Number must be 10 numbers", "Test", test.getName());
	}
	
	@Test(expected = CustomerException.class)
	public void MobileNumberStartingWith0PickUp() throws CustomerException {
		Customer test = new PickUpCustomer ("Test", "1234567899",0,0);
		assertEquals("Mobile Number must start with a 0","Test", test.getName());
	}
	
	@Test(expected = CustomerException.class)
	public void MobileNumberStartingWith0Driver() throws CustomerException {
		Customer test = new DriverDeliveryCustomer ("Test", "1234567899",1,1);
		assertEquals("Mobile Number must start with a 0","Test", test.getName());
	}
	
	@Test(expected = CustomerException.class)
	public void MobileNumberStartingWith0Drone() throws CustomerException {
		Customer test = new DroneDeliveryCustomer ("Test", "1234567899",1,1);
		assertEquals("Mobile Number must start with a 0","Test", test.getName());
	}

	@Test(expected = CustomerException.class)
	public void UndersizedMobileNumberPickUp() throws CustomerException {
		Customer test = new PickUpCustomer ("Test", "01234567",0,0);
		assertEquals("Mobile Number must be 10 numbers", "Test", test.getName());
	}
	
	@Test(expected = CustomerException.class)
	public void UndersizedMobileNumberDriver() throws CustomerException {
		Customer test = new DriverDeliveryCustomer ("Test", "01234567",1,1);
		assertEquals("Mobile Number must be 10 numbers", "Test", test.getName());
	}
	
	@Test(expected = CustomerException.class)
	public void UndersizedMobileNumberDrone() throws CustomerException {
		Customer test = new DroneDeliveryCustomer ("Test", "01234567",1,1);
		assertEquals("Mobile Number must be 10 numbers", "Test", test.getName());
	}

	@Test(expected = CustomerException.class)
	public void PickUpLocationXZero() throws CustomerException {
		Customer test = new PickUpCustomer ("Test", "0412345678",1,0);
		assertEquals("Location Must be set to 0,0 for Pick Up order type", "Test", test.getName());
	}
	
	@Test(expected = CustomerException.class)
	public void PickUpLocationYZero() throws CustomerException {
		Customer test = new PickUpCustomer ("Test", "0412345678",0,1);
		assertEquals("Location Must be set to 0,0 for Pick Up order type", "Test", test.getName());
	}

	@Test(expected = CustomerException.class)
	public void DriverDeliveryDistancePickUp() throws CustomerException {
		Customer test = new DriverDeliveryCustomer ("Test", "0412345678",0,0);
		assertEquals("Unable To Deliver to customer location of 0,0","Test", test.getName());
	}

	@Test(expected = CustomerException.class)
	public void DroneDeliveryDistancePickUp() throws CustomerException {
		Customer test = new DroneDeliveryCustomer ("Test", "0412345678",0,0);
		assertEquals("Unable To Deliver to customer location of 0,0","Test", test.getName());
	}

	@Test(expected = CustomerException.class)
	public void DeliveryDistanceEastException() throws CustomerException {
		Customer test = new DriverDeliveryCustomer ("Test", "0412345678",11,2);
		assertEquals("Unable To Deliver Further than 10 Blocks in any one direction", "Test", test.getName());
	}

	@Test(expected = CustomerException.class)
	public void DeliveryDistanceNorthException() throws CustomerException {
		Customer test = new DriverDeliveryCustomer ("Test", "0412345678",2,11);
		assertEquals("Unable To Deliver Greater than 10 Blocks in any one direction", "Test", test.getName());
	}

	@Test(expected = CustomerException.class)
	public void DeliveryDistanceWestException() throws CustomerException {
		Customer test = new DriverDeliveryCustomer ("Test", "0412345678",-11,2);
		assertEquals("Unable To Deliver Greater than 10 Blocks in any one direction","Test", test.getName());
	}

	@Test(expected = CustomerException.class)
	public void DeliveryDistanceSouthException() throws CustomerException {
		Customer test = new DriverDeliveryCustomer ("Test", "0412345678",2,-11);
		assertEquals("Unable To Deliver Greater than 10 Blocks in any one direction","Test", test.getName());
	}
	
	@Test(expected = CustomerException.class)
	public void DroneDistanceEastException() throws CustomerException {
		Customer test = new DroneDeliveryCustomer ("Test", "0412345678",11,2);
		assertEquals("Unable To Deliver Further than 10 Blocks in any one direction", "Test", test.getName());
	}

	@Test(expected = CustomerException.class)
	public void DroneDistanceNorthException() throws CustomerException {
		Customer test = new DroneDeliveryCustomer ("Test", "0412345678",2,11);
		assertEquals("Unable To Deliver Greater than 10 Blocks in any one direction", "Test", test.getName());
	}

	@Test(expected = CustomerException.class)
	public void DroneDistanceWestException() throws CustomerException {
		Customer test = new DroneDeliveryCustomer ("Test", "0412345678",-11,2);
		assertEquals("Unable To Deliver Greater than 10 Blocks in any one direction","Test", test.getName());
	}

	@Test(expected = CustomerException.class)
	public void DroneDistanceSouthException() throws CustomerException {
		Customer test = new DroneDeliveryCustomer ("Test", "0412345678",2,-11);
		assertEquals("Unable To Deliver Greater than 10 Blocks in any one direction","Test", test.getName());
	}
}
