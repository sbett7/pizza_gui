package asgn2Pizzas;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import asgn2Exceptions.*;


/**
 * An abstract class that represents pizzas sold at the Pizza Palace restaurant. 
 * The Pizza class is used as a base class of VegetarianPizza, MargheritaPizza and MeatLoversPizza. 
 * Each of these subclasses have a different set of toppings. A description of the class's fields
 * and their constraints is provided in Section 5.1 of the Assignment Specification. 
 * 
 * @author Michael de Closey
 *
 */
public abstract class Pizza  {
	
	/**
	 *  This class represents a pizza produced at the Pizza Palace restaurant.  A detailed description of the class's fields
	 *  and parameters is provided in the Assignment Specification, in particular in Section 5.1. 
	 *  A PizzaException is thrown if the quantity of pizzas is less than or equal to 0, or greater than 10.
	 *  It also will be thrown if the orderTime before the restaurant opens at 7 or after it closes at 11,
	 *  or if the deliveryTime is less than 10 minutes or greater than 60 minutes past orderTime.
     *
     *  PRE: TRUE
	 *  POST: All field values except cost per pizza are set
	 * 
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @param type -  A human understandable description of this Pizza type
	 * @param price - The price that the pizza is sold to the customer
	 * @throws PizzaException if the quantity of pizzas is less than or equal to 0, or greater than 10, or if 
	 *  the orderTime before the restaurant opens at 7 or after it closes at 11,
	 *  or if the deliveryTime is less than 10 minutes or greater than 60 minutes past orderTime. 
	 * 
	 */
	private int quantity;
	private LocalTime orderTime;
	private LocalTime deliveryTime;
	private String type;
	private double price;
	private double pizzaCost;
	private final double MARGHERITA_COST_PRICE = 1.5;
	private final double VEGETARIAN_COST_PRICE = 5.5;
	private final double MEATLOVERS_COST_PRICE = 5;
	
	public Pizza(int quantity, LocalTime orderTime, LocalTime deliveryTime, String type, double price) throws PizzaException{
		checkQuantityParam(quantity);
		this.quantity = quantity;
		checkOrderTimeParam(orderTime);
		checkDeliveryTimeParam(orderTime, deliveryTime);
		this.orderTime = orderTime;
		this.deliveryTime = deliveryTime;
		this.type = type;
		this.price = price;
	}

	/**
	 * Calculates how much a pizza would could to make calculated from its toppings.
	 *  
     * <P> PRE: TRUE
	 * <P> POST: The cost field is set to sum of the Pizzas's toppings
	 */
	public final void calculateCostPerPizza(){
		if (type == "Margherita"){
			pizzaCost = MARGHERITA_COST_PRICE;
		} else if (type == "Meat Lovers"){
			pizzaCost = MEATLOVERS_COST_PRICE;
		} else if (type == "Vegetarian"){
			pizzaCost = VEGETARIAN_COST_PRICE;
		}
	}
	
	/**
	 * Returns the amount that an individual pizza costs to make.
	 * @return The amount that an individual pizza costs to make.
	 */
	public final double getCostPerPizza(){
		return pizzaCost;
	}

	/**
	 * Returns the amount that an individual pizza is sold to the customer.
	 * @return The amount that an individual pizza is sold to the customer.
	 */
	public final double getPricePerPizza(){
		return price;
	}

	/**
	 * Returns the amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderCost(){
		calculateCostPerPizza();
		double orderCost = pizzaCost*quantity;
		return orderCost;	
	}
	
	/**
	 * Returns the amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderPrice(){
		double orderPrice = price*quantity;
		return orderPrice;
	}
	
	
	/**
	 * Returns the profit made by the restaurant on the order which is the order price minus the order cost. 
	 * @return  Returns the profit made by the restaurant on the order which is the order price minus the order cost.
	 */
	public final double getOrderProfit(){
		calculateCostPerPizza();
		double profit = (price*quantity) - (pizzaCost*quantity);
		return profit;
	}
	

	/**
	 * Indicates if the pizza contains the specified pizza topping or not. 
	 * @param topping -  A topping as specified in the enumeration PizzaTopping
	 * @return Returns  true if the instance of Pizza contains the specified topping and false otherwise.
	 */
	public final boolean containsTopping(PizzaTopping topping){
		if(topping == PizzaTopping.TOMATO || topping == PizzaTopping.CHEESE){
			return true;
		}
		if(type == "Vegetarian"){
			if (topping == PizzaTopping.EGGPLANT || topping == PizzaTopping.MUSHROOM || topping == PizzaTopping.CAPSICUM){
				return true;
			}
		} else if (type == "Meat Lovers"){
			if (topping == PizzaTopping.BACON || topping == PizzaTopping.PEPPERONI || topping == PizzaTopping.SALAMI){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns the quantity of pizzas ordered. 
	 * @return the quantity of pizzas ordered. 
	 */
	public final int getQuantity(){
		return quantity;
	}

	/**
	 * Returns a human understandable description of the Pizza's type. 
	 * The valid alternatives are listed in Section 5.1 of the Assignment Specification. 
	 * @return A human understandable description of the Pizza's type.
	 */
	public final String getPizzaType(){
		return type;
	}


	/**
	 * Compares *this* Pizza object with an instance of an *other* Pizza object and returns true if  
	 * if the two objects are equivalent, that is, if the values exposed by public methods are equal.
	 * You do not need to test this method.
	 *  
	 * @return true if *this* Pizza object and the *other* Pizza object have the same values returned for 	
	 * getCostPerPizza(), getOrderCost(), getOrderPrice(), getOrderProfit(), getPizzaType(), getPricePerPizza() 
	 * and getQuantity().
	 *   
	 */
	@Override
	public boolean equals(Object other){
		Pizza otherPizza = (Pizza) other;
		return ((this.getCostPerPizza()) == (otherPizza.getCostPerPizza()) &&
			(this.getOrderCost()) == (otherPizza.getOrderCost())) &&				
			(this.getOrderPrice()) == (otherPizza.getOrderPrice()) &&
			(this.getOrderProfit()) == (otherPizza.getOrderProfit()) &&
			(this.getPizzaType() == (otherPizza.getPizzaType()) &&
			(this.getPricePerPizza()) == (otherPizza.getPricePerPizza()) &&
			(this.getQuantity()) == (otherPizza.getQuantity()));
	}
	
	/**
	 * Checks supplied Quantity Parameters
	 * @param quantity of pizzas entered
	 * @throws PizzaException if quantity is less or equal to 0 or greater than 10
	 */
	private void checkQuantityParam(int quantity) throws PizzaException{
		if (quantity > 10){
			throw new PizzaException("Quantity cannot be greater than 10 ");
		} else if (quantity <= 0){
			throw new PizzaException("Quantity must be greater than 0");
		}
	}
	
	/**
	 * Checks supplied OrderTime Parameters
	 * @param time the order was placed
	 * @throws PizzaException if Order time is before the restaurant opens or after it closes
	 */
	private void checkOrderTimeParam(LocalTime time) throws PizzaException{
		if (time.isBefore(LocalTime.of(19,0))){
			throw new PizzaException("Cannot order before Restaurant opens");
		} else if (time.isAfter(LocalTime.of(23,00))){
			throw new PizzaException("Cannot Order after Restaurant Closes");
		}
	}
	
	/**
	 * Checks supplied DeliveryTime Parameters
	 * @param orderTime
	 * @param deliveryTime
	 * @throws PizzaException if the DeliveryTime is before 10 minutes of cooking time or after an hour 
	 * and 10 minutes after order time
	 */
	private void checkDeliveryTimeParam(LocalTime orderTime, LocalTime deliveryTime) throws PizzaException{
		long timeCheck = ChronoUnit.MINUTES.between(orderTime, deliveryTime);
		if (timeCheck < 10){
			throw new PizzaException("Cannot Deliver pizza before it has cooked for 10 minutes");
		} else if (timeCheck > 60){
			throw new PizzaException("Cannot Deliver pizza an hour after order time");
		}
	}
	
	
}
