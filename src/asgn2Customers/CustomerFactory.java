package asgn2Customers;


import asgn2Exceptions.CustomerException;

/**
 * A class that instantiates the subclasses of asgn2Customers.Customer using the Factory Method pattern. 
 * The classes are instantiated from one of the three valid customer codes outlined in
 * Section 5.3 of the Assignment Specification. Any other code will throw a CustomerException.   
 *     
 * @author Sean Betts
 *
 */

public class CustomerFactory {

	//CUSTOMER TYPE CODES
	private final static String PICK_UP = "PUC";
	private final static String DRONE = "DNC";
	private final static String DRIVER = "DVC";
	
	/**
	 * A method that uses the Factory Method pattern to produce an instance of one of the asgn2Customers.Customer subclasses. 
	 * Subclasses are created using the customerCode. The valid customer codes are "PUC" for a Pickup Customer, "DNC" for a Drone
	 * Delivery Customer, or "DVC" for a Driver Delivery Customer.
	 * A CustomerException should be thrown if an invalid customer code is used as a parameter. 
	 * 
	 * @param customerCode - A code indicating the subclass of asgn2Customers.Customer to instantiate. The valid codes are listed in Section 5.3 of the Assignment Specification. 
	 * @param name - The customer's name 
	 * @param mobileNumber - The customer mobile number
	 * @param locationX - The customer x location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @param locationY  The customer y location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @return A valid PickUpCustomer, DriverDeliveryCustomer or DroneDeliveryCustomer depending on the customerCode.
	 * @throws CustomerException if the customerCode is not "PUC", "DNC", or "DVC".
	 */
	public static Customer getCustomer(String customerCode, String name, String mobileNumber, int locationX,  int locationY) throws CustomerException{
		switch(customerCode){
			case PICK_UP:
				return new PickUpCustomer(name, mobileNumber, locationX, locationY);
			case DRONE:
				return new DroneDeliveryCustomer(name, mobileNumber, locationX, locationY);
			case DRIVER:
				return new DriverDeliveryCustomer(name, mobileNumber, locationX, locationY);
			default:
				throw new CustomerException("CustomerException Occurred: The given customer code does not match"
						+ " any of the preset customer codes.");
		}
	}
}
