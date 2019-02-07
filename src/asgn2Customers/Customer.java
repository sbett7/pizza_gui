package asgn2Customers;

import asgn2Exceptions.CustomerException;

/** An abstract class to represent a customer at the Pizza Palace restaurant.
 *  The Customer class is used as a base class of PickUpCustomer, 
 *  DriverDeliveryCustomer and DroneDeliverCustomer. Each of these subclasses overwrites
 *  the abstract method getDeliveryDistance. A description of the class's
 * fields and their constraints is provided in Section 5.2 of the Assignment Specification.  
 * 
 * @author Sean Betts
*/
public abstract class Customer {

	//CUSTOMER FIELDS
	private String _name;
	private String _mobileNumber;
	private int _locationX;
	private int _locationY;
	private String _type;
	
	//NAME SIZE LIMITS
	private final int MAX_NAME_LENGTH = 20;
	private final int MIN_NAME_LENGTH = 1;
	
	//EXPECTED MOBILE STRING LENGTH
	private final int MOBILE_NUMBER_LENGTH = 10;
	
	//CUSTOMER TYPES
	private final String PICK_UP = "Pick Up";
	private final String DRONE = "Drone Delivery";
	private final String DRIVER = "Driver Delivery";	
	
	//LOCATIONS AND MAXIMUM BLOCK LIMIT
	private final int ORIGIN = 0;
	private final int MAX_BLOCK_LIMIT = 10;
	
	/**
	 *  This class represents a customer of the Pizza Palace restaurant.  A detailed description of the class's fields
	 *  and parameters is provided in the Assignment Specification, in particular in Section 5.2. 
	 *  A CustomerException is thrown if the name parameter is empty, exceeds the maximum number of characters, or only contains white space.
	 * 	Or when the mobile number parameter length is not equal to the maximum mobile length or it does not start with a leading '0'.  Or 
	 * 	when the x or y location parameters are greater than the maximum block range, or if the pickup
	 * 	customer is not located at the origin, or the delivery customer types are located at the origin.
	 *  
  	 * <P> PRE: True
  	 * <P> POST: All field values are set
  	 * 
	 * @param name - The Customer's name 
	 * @param mobileNumber - The customer mobile number
	 * @param locationX - The customer x location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @param locationY - The customer y location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @param type - A human understandable description of this Customer type
	 * @throws CustomerException if the name parameter is empty, exceeds the maximum number of characters, or only contains white space.
	 * 	Or when the mobile number parameter length is not equal to the maximum mobile length or it does not start with a leading '0'.  Or 
	 * 	when the x or y location parameters are greater than the maximum block range, or if the pickup
	 * 	customer is not located at the origin, or the delivery customer types are located at the origin.
	 * 
	 */
	public Customer(String name, String mobileNumber, int locationX, int locationY, String type) throws CustomerException{
		checkNameParameter(name);
		_name = name;
		
		checkMobileNumberParameter(mobileNumber);
		_mobileNumber = mobileNumber;
		
		_type = type;
		
		checkLocationCoordinates(locationX, locationY);
		_locationX = locationX;
		_locationY = locationY;	
	}
	
	/**
	 * Returns the Customer's name.
	 * @return The Customer's name.
	 */
	public final String getName(){
		return _name;
	}
	
	/**
	 * Returns the Customer's mobile number.
	 * @return The Customer's mobile number.
	 */
	public final String getMobileNumber(){
		return _mobileNumber;
	}

	/**
	 * Returns a human understandable description of the Customer's type. 
	 * The valid alternatives are listed in Section 5.2 of the Assignment Specification. 
	 * @return A human understandable description of the Customer's type.
	 */
	public final String getCustomerType(){
		return _type;
	}
	
	/**
	 * Returns the Customer's X location which is the number of blocks East or West 
	 * that the Customer is located relative to the Pizza Palace restaurant. 
	 * @return The Customer's X location
	 */
	public final int getLocationX(){
		return _locationX;
	}

	/**
	 * Returns the Customer's Y location which is the number of blocks North or South 
	 * that the Customer is located relative to the Pizza Palace restaurant. 
	 * @return The Customer's Y location
	 */
	public final int getLocationY(){
		return _locationY;
	}

	/**
	 * An abstract method that returns the distance between the Customer and 
	 * the restaurant depending on the mode of delivery. 
	 * @return The distance between the restaurant and the Customer depending on the mode of delivery.
	 */
	public abstract double getDeliveryDistance();

	/**
	 * Compares *this* Customer object with an instance of an *other* Customer object and returns true if  
	 * if the two objects are equivalent, that is, if the values exposed by public methods are equal.
	 *  You do not need to test this method.
	 * 
	 * @return true if *this* Customer object and the *other* Customer object have the same values returned for 	
	 * getName(),getMobileNumber(),getLocationX(),getLocationY(),getCustomerType().
	 */
	@Override
	public boolean equals(Object other){
		Customer otherCustomer = (Customer) other;

		return ( (this.getName().equals(otherCustomer.getName()))  &&
			(this.getMobileNumber().equals(otherCustomer.getMobileNumber())) && 
			(this.getLocationX() == otherCustomer.getLocationX()) && 
			(this.getLocationY() == otherCustomer.getLocationY()) && 
			(this.getCustomerType().equals(otherCustomer.getCustomerType())) );			
	}
	
	/**
	 * Checks the inputed string to determine if it does not meet the criteria for a name.
	 * @param name The string to be checked.
	 * @throws CustomerException If the name is empty, exceeds the maximum number of characters, or only contains white space.
	 */
	private void checkNameParameter(String name) throws CustomerException{
		if(name.isEmpty()){
			throw new CustomerException("CustomerException Thrown: Customer's name cannot be empty.");
		} else if (name.length() > MAX_NAME_LENGTH){
			throw new CustomerException("CustomerException Thrown: Customer's name exceeds maximum number of characters.");
		} else if (name.trim().length() < MIN_NAME_LENGTH){
			throw new CustomerException("CustomerException Thrown: Customer's name must contain more than white space.");
		}
	}
	
	/**
	 * Checks the inputed string to determine if it meets the criteria for a mobile phone number.
	 * @param mobileNumber The string to be checked.
	 * @throws CustomerException If the mobile number length is not equal to the maximum mobile length or 
	 * it does not start with a leading '0'.
	 */
	private void checkMobileNumberParameter(String mobileNumber) throws CustomerException{
		if(mobileNumber.length() != MOBILE_NUMBER_LENGTH){
			throw new CustomerException("CustomerException Thrown: Mobile phone number is not 10 numbers long.");
		} else if(mobileNumber.charAt(0) != '0'){
			throw new CustomerException("CustomerException Thrown: Mobile phone number does not start with '0'.");
		}
	}
	
	/**
	 * Checks if the supplied and x and y locations 
	 * @param locationX The x location integer to be checked.
	 * @param locationY The y location integer to be checked.
	 * @throws CustomerException If the x or y locations are greater than the maximum block range, or if the pickup
	 * customer is not located at the origin, or the delivery customer types are located at the origin.
	 */
	private void checkLocationCoordinates(int locationX, int locationY) throws CustomerException{
		
		if(getCustomerType().equals(PICK_UP) && (locationX != 0 || locationY != 0)){
			throw new CustomerException("CustomerException Thrown: Location of  Pick Up Customer order is not (X, Y) = (0, 0)");
		} else if (getCustomerType().equals(DRIVER) && (locationX == ORIGIN && locationY == ORIGIN)){
			throw new CustomerException("CustomerException Thrown: Location of  Driver Delivery Customer order "
					+ "cannot be set at (X, Y) = (0, 0)");
		} else if (getCustomerType().equals(DRONE) && (locationX == ORIGIN && locationY == ORIGIN)){
			throw new CustomerException("CustomerException Thrown: Location of  Drone Delivery Customer order "
					+ "cannot be set at (X, Y) = (0, 0)");
		} else if(locationX > MAX_BLOCK_LIMIT){
			throw new CustomerException("CustomerException Thrown: The X location is too far east to deliver too.");
		} else if (Math.abs(locationX) > MAX_BLOCK_LIMIT){
			throw new CustomerException("CustomerException Thrown: The X location is too far west to deliver too.");
		} else if(locationY > MAX_BLOCK_LIMIT){
			throw new CustomerException("CustomerException Thrown: The Y location is too far north to deliver too.");
		} else if (Math.abs(locationY) > MAX_BLOCK_LIMIT){
			throw new CustomerException("CustomerException Thrown: The Y location is too far south to deliver too.");
		}
	}
	
}
