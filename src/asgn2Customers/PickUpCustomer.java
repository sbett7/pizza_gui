package asgn2Customers;

import asgn2Exceptions.CustomerException;

/** A class that represents a customer that has chosen to collect their pizza at the restaurant. 
 *  This class extends the abstract Customer class. Since the customer is at the restaurant the delivery 
 *  distance should be zero.  A description of the class's fields and their constraints is provided 
 *  in Section 5.2 of the Assignment Specification.
 *
 * @author Sean Betts
 *
 */
public class PickUpCustomer extends Customer {

	/**
	 *  This class represents a customer of the Pizza Palace restaurant that has chosen to pickup their pizza at the restaurant. 
	 *  A CustomerException is thrown if the name parameter is empty, exceeds the maximum number of characters, or only contains white space.
	 * 	Or when the mobile number parameter length is not equal to the maximum mobile length or it does not start with a leading '0'.  Or 
	 * 	when the x or y location parameters are greater than the maximum block range, or if the x and y location paramters are not both set
	 *	to 0.
	 *  
	 * <P> PRE: TRUE
 	 * <P> POST: All field values are set
	 *  
	 * @param name - The Customer's name 
	 * @param mobileNumber - The customer mobile number
	 * @param locationX - The customer x location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @param locationY  The customer y location relative to the Pizza Palace Restaurant measured in units of 'blocks' 
	 * @throws CustomerException if the name parameter is empty, exceeds the maximum number of characters, or only contains white space.
	 * 	Or when the mobile number parameter length is not equal to the maximum mobile length or it does not start with a leading '0'.  Or 
	 * 	when the x or y location parameters are greater than the maximum block range, or if the x and y location paramters are not both set
	 *	to 0.
	 * 
	 */
	public PickUpCustomer(String name, String mobileNumber, int locationX,  int locationY) throws CustomerException {
		super(name, mobileNumber, locationX, locationY, "Pick Up");	
	}

	/**
	 *  Overrides DeliveryDistance() in Customer. Since the customer is at the restaurant the delivery distance should be zero. 
	 *  
     * @return The value 0
	 */
	@Override
	public double getDeliveryDistance() {
		return 0;
	}

}
