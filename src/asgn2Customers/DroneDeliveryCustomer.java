package asgn2Customers;

import asgn2Exceptions.CustomerException;

/** A class that represents a customer that has chosen to have their pizza delivered by a drone. 
 * This class extends the abstract Customer class and calculates the delivery distance as the Euclidean 
 * Distance between the customer and the restaurant.  A description of the class's
 * fields and their constraints is provided in Section 5.2 of the Assignment Specification.
 * 
 * @author Sean Betts
 *
 */
public class DroneDeliveryCustomer extends Customer {
	
	//TO THE POWER OF CONSTANT
	private final int SQUARED = 2;
	
	/**
	 *  This class represents a customer of the Pizza Palace restaurant that has chosen to have their pizza delivered by 
	 *  a drone.  A CustomerException is thrown if the name parameter is empty, exceeds the maximum number of characters, 
	 *  or only contains white space. Or when the mobile number parameter length is not equal to the maximum mobile length 
	 *  or it does not start with a leading '0'.  Or when the x or y location parameters are greater than the maximum block 
	 *  range, or if the x and y locations are both 0.
     *
     * <P> PRE: TRUE
     * <P> POST: All field values are set
     *
	 * @param name - The Customer's name 
	 * @param mobileNumber - The customer mobile number
	 * @param locationX - The customer x location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @param locationY  The customer y location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @throws CustomerException if the name parameter is empty, exceeds the maximum number of characters, 
	 *  or only contains white space. Or when the mobile number parameter length is not equal to the maximum mobile length 
	 *  or it does not start with a leading '0'.  Or when the x or y location parameters are greater than the maximum block 
	 *  range, or if the x and y locations are both 0.
	 * 
	 */
	public DroneDeliveryCustomer(String name, String mobileNumber, int locationX, int locationY) throws CustomerException {
		super(name, mobileNumber, locationX, locationY, "Drone Delivery");		
	}

	/**
	 * Returns the Euclidean Distance between the instance of DroneDeliveryCustomer and the restaurant. Overrides  
	 * getDeliveryDistance() in Customer.
	 * 
     * @return The distance between the restaurant and the customer in Euclidean distance.
	 */
	@Override
	public double getDeliveryDistance() {
		double distanceSquared = Math.pow(getLocationX(), SQUARED) + Math.pow(getLocationY(), SQUARED);
		
		return Math.sqrt(distanceSquared);
	}
	

}
