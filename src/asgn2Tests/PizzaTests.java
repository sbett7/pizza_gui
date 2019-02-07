package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.PizzaException;

import java.time.LocalTime;


import asgn2Pizzas.*;

/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza, asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. 
 * Note that an instance of asgn2Pizzas.MeatLoversPizza should be used to test the functionality of the 
 * asgn2Pizzas.Pizza abstract class. 
 * 
 * @author Sean Betts
 *
 */
public class PizzaTests {
	
	//PIZZA TYPES
	private final String MARGHERITA = "Margherita";
	private final String VEGETARIAN = "Vegetarian";
	private final String MEAT_LOVERS = "Meat Lovers";
	
	//DOUBLE TESTS PRECISION
	private final double TO_SECOND_DECIMAL_PLACE = 0.01;
	
	/*
	 * Get pizza type for Pizza class.
	 * Expected: The pizza type is equal to the Meat Lovers pizza string.
	 */
	@Test
	public void getPizzaTypeMeatLovers() throws PizzaException{
		int quantity = 1;
		LocalTime currentTime = LocalTime.of(19,0);
		LocalTime deliveryTime = currentTime.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, currentTime, deliveryTime);
		
		assertEquals("Cannot create Pizza of type Meat Lovers", 
				MEAT_LOVERS, pizza.getPizzaType());
	}
	
	/*
	 * Check pizza type for Pizza class of type Meat Lovers is not Margherita.
	 * Expected: The pizza type is not equal to the Margherita pizza string.
	 */
	@Test
	public void getPizzaTypeNotMargherita() throws PizzaException{
		int quantity = 1;
		LocalTime currentTime = LocalTime.of(19,0);
		LocalTime deliveryTime = currentTime.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, currentTime, deliveryTime);
		
		assertTrue("Cannot distinguish between a Meat Lovers pizza and a Margherita pizza",
				!pizza.getPizzaType().equals(MARGHERITA));
	}
	
	/*
	 * Check pizza type for Pizza class of type Meat Lovers is not Vegetarian.
	 * Expected: The pizza type is not equal to the Vegetarian pizza string.
	 */
	@Test
	public void getPizzaTypeNotVegetarian() throws PizzaException{
		int quantity = 1;
		LocalTime currentTime = LocalTime.of(19,0);
		LocalTime deliveryTime = currentTime.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, currentTime, deliveryTime);
		
		assertTrue("Cannot distinguish between a Meat Lovers pizza and a Vegetarian pizza",
				!pizza.getPizzaType().equals(VEGETARIAN));
	}
	
	/*
	 * Instantiate pizza over the maximum allowed quantity.
	 * Expected: PizzaException class thrown.
	 */
	@Test (expected = PizzaException.class)
	public void instantiatePizzaQuantityOverLimitException() throws PizzaException{
		int quantity = 11;
		LocalTime currentTime = LocalTime.of(19,0);
		LocalTime deliveryTime = currentTime.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, currentTime, deliveryTime);
	}
	
	/*
	 * Instantiate pizza with a quantity of zero.
	 * Expected: PizzaException class thrown.
	 */
	@Test (expected = PizzaException.class)
	public void instantiatePizzaQuantityWithZeroPizzasException() throws PizzaException{
		int quantity = 0;
		LocalTime currentTime = LocalTime.of(19,0);
		LocalTime deliveryTime = currentTime.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, currentTime, deliveryTime);
	}
	
	/*
	 * Instantiate pizza with an order time before the store opens.
	 * Expected: PizzaException class thrown.
	 */
	@Test (expected = PizzaException.class)
	public void instantiatePizzaOrderTimeBeforeOpeningException() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(18, 59);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
	}
	
	/*
	 * Instantiate Pizza of type Meat Lovers with a delivery time an hour after the order time.
	 * Expected: PizzaException class thrown.
	 */
	@Test (expected = PizzaException.class)
	public void instantiatePizzaDeliveryTimeHourAfterOrderTimeException() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(22,0);
		LocalTime deliveryTime = time.plusMinutes(61);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
	}
	
	/*
	 * Instantiate pizza with a delivery time after the store closes.
	 * Expected: the pizza is created and the pizza type equals the meat lovers pizza.
	 */
	@Test
	public void instantiatePizzaDeliveryTimeAfterClosing() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(22,55);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertEquals("Cannot create Pizza with delivery time passed 11pm.", 
				MEAT_LOVERS, pizza.getPizzaType());
	}
	
	/*
	 * Instantiate pizza with an order time after the store closes.
	 * Expected: PizzaException class thrown.
	 */
	@Test (expected = PizzaException.class)
	public void instantiatePizzaOrderTimeAfterClosingException() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(23,1);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
	}
	
	/*
	 * Instantiate pizza with a delivery time an hour after the order was made.
	 * Expected: PizzaException class thrown.
	 */
	@Test (expected = PizzaException.class)
	public void instantiatePizzaDeliveryTimeOneHourAfterOrderTimeException() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(20,0);
		LocalTime deliveryTime = time.plusMinutes(61);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
	}
	
	/*
	 * Instantiate pizza with a delivery time less than 10 minutes after order was made.
	 * Expected: PizzaException class thrown.
	 */
	@Test (expected = PizzaException.class)
	public void instantiatePizzaDeliveryTimeLessThan10MinutesException() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(20,0);
		LocalTime deliveryTime = time.plusMinutes(9);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
	}
	
	/*
	 * Instantiate pizza with an order set at 11pm.
	 */
	@Test
	public void instantiatePizzaAtTimeOfClosing() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(23,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertEquals("Cannot create Pizza with delivery time at 11pm.", 
				MEAT_LOVERS, pizza.getPizzaType());
	}
	
	/*
	 * Instantiate pizza at time of opening.
	 */
	@Test
	public void instantiatePizzaAtTimeOfOpening() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertEquals("Cannot create Pizza with delivery time at 7pm.", 
				MEAT_LOVERS, pizza.getPizzaType());
	}
	
	/*
	 * The pizza of type meat lovers contains CHEESE. 
	 * Expected: True
	 */
	@Test
	public void containsToppingsPizzaCheese() throws PizzaException {
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertTrue("Meat Lovers Pizza ingredient found to not be contained in pizza listed in Specification.", 
				pizza.containsTopping(PizzaTopping.CHEESE));
	}
	
	/*
	 * The pizza of type meat lovers contains TOMATO. 
	 * Expected: True
	 */
	@Test
	public void containsToppingsTomato() throws PizzaException {
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertTrue("Meat Lovers Pizza ingredient found to not be contained in pizza listed in Specification.", 
				pizza.containsTopping(PizzaTopping.TOMATO));
	}
	
	/*
	 * The pizza of type meat lovers contains BACON. 
	 * Expected: True
	 */
	@Test
	public void containsToppingBaconListed() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertTrue("Meat Lovers Pizza ingredient found to not be contained in pizza listed in Specification.",
				pizza.containsTopping(PizzaTopping.BACON));
	}
	
	/*
	 * The pizza of type meat lovers contains SALAMI. 
	 * Expected: True
	 */
	@Test
	public void containsToppingSalami() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertTrue("Meat Lovers Pizza ingredient found to not be contained in pizza listed in Specification.", 
				(pizza.containsTopping(PizzaTopping.SALAMI)));
	}
	
	/*
	 * The pizza of type meat lovers contains PEPPERONI. 
	 * Expected: True
	 */
	@Test
	public void containsToppingPepperoni() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertTrue("Meat Lovers Pizza ingredient found to not be contained in pizza listed in Specification.", 
				(pizza.containsTopping(PizzaTopping.PEPPERONI)));
	}
	
	/*
	 * The pizza of type meat lovers does not contains CAPSICUM. 
	 * Expected: False
	 */
	@Test
	public void containsToppingDoesNotContainCapsicum() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertTrue("Meat Lovers Pizza found to contain ingredient not listed in Specification.", 
				!(pizza.containsTopping(PizzaTopping.CAPSICUM)));
	}
	
	/*
	 * The pizza of type meat lovers does not contains MUSHROOM. 
	 * Expected: False
	 */
	@Test
	public void containsToppingDoesNotContainMushroom() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertTrue("Meat Lovers Pizza found to contain ingredient not listed in Specification.", 
				!(pizza.containsTopping(PizzaTopping.MUSHROOM)));
	}
	
	/*
	 * The pizza of type meat lovers does not contains EGGPLANT. 
	 * Expected: False
	 */
	@Test
	public void containsToppingDoesNotContainEggplant() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertTrue("Meat Lovers Pizza found to contain ingredient not listed in Specification.", 
				!(pizza.containsTopping(PizzaTopping.EGGPLANT)));
	}
	
	/*
	 * The pizza order of type Meat Lovers with a quantity of one has its cost per pizza returned correctly.
	 * Expected: The order's cost per pizza is equal to 5.0.
	 */
	@Test 
	public void getCostPerPizzaOnePizza() throws PizzaException{
		int quantity = 1;
		double expectedCostPerPizza = 5.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get cost per pizza for order of one Meat Lovers Pizza", 
				expectedCostPerPizza, pizza.getCostPerPizza() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The pizza of type Meat Lovers cost per pizza is returned correctly for a quantity of five.
	 * Expected: The order's cost per pizza is equal to 5.0.
	 */
	@Test 
	public void getCostPerPizzFivePizzas() throws PizzaException{
		int quantity = 5;
		double expectedCostPerPizza = 5.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get cost per pizza for order of five Meat Lovers Pizzas", 
				expectedCostPerPizza, pizza.getCostPerPizza() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The pizza of type Meat Lovers price per pizza is returned correctly.
	 * Expected: The order's price per pizza is equal to 12.0.
	 */
	@Test 
	public void getPricePerPizzaOnePizza() throws PizzaException{
		int quantity = 1;
		double expectedPricePerPizza = 12.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertEquals("Unable to get price per pizza for order of one Meat Lovers Pizza", 
				expectedPricePerPizza, pizza.getPricePerPizza() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The pizza of type Meat Lovers price per pizza is returned correctly for a quantity of five pizzas.
	 * Expected: The order's price per pizza is equal to 12.0.
	 */
	@Test 
	public void getPricePerPizzaFivePizzas() throws PizzaException{
		int quantity = 5;
		double expectedPricePerPizza = 12.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertEquals("Unable to get price per pizza for order of one Meat Lovers Pizza", 
				expectedPricePerPizza, pizza.getPricePerPizza() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The pizza of type Meat Lovers order cost is returned correctly for a quantity of one pizza.
	 * Expected: The order's total cost is equal to 5.0.
	 */
	@Test
	public void getOrderCostOnePizza() throws PizzaException{
		int quantity = 1;
		double expectedOrderCost = 5.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertEquals("Unable to get order cost for one Meat Lovers Pizza", 
				expectedOrderCost, pizza.getOrderCost() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The pizza of type Meat Lovers order cost is returned correctly for a quantity of five pizzas.
	 * Expected: The order's total cost is equal to 25.0.
	 */
	@Test
	public void getOrderCostFivePizzas() throws PizzaException{
		int quantity = 5;
		double expectedOrderCost = 25.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertEquals("Unable to get order cost for five Meat Lovers Pizza", 
				expectedOrderCost, pizza.getOrderCost() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The pizza of type Meat Lovers order cost is returned correctly for a quantity of one pizza.
	 * Expected: The order's total price is equal to 12.0.
	 */
	@Test
	public void getOrderPriceOnePizza() throws PizzaException{
		int quantity = 1;
		double expectedOrderCost = 12.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertEquals("Unable to get order price for one Meat Lovers Pizza", 
				expectedOrderCost, pizza.getOrderPrice() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The pizza of type Meat Lovers order price is returned correctly for a quantity of five pizzas.
	 * Expected: The order's total price is equal to 60.0.
	 */
	@Test
	public void getOrdePriceFivePizzas() throws PizzaException{
		int quantity = 5;
		double expectedOrderCost = 60.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertEquals("Unable to get order price for five Meat Lovers Pizza", 
				expectedOrderCost, pizza.getOrderPrice() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The pizza of type Meat Lovers order profit is returned correctly for a quantity of one pizza.
	 * Expected: The order's total profit is equal to 7.0.
	 */
	@Test
	public void getOrderProfitOnePizza() throws PizzaException{
		int quantity = 1;
		double expectedProfit = 7.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertEquals("Unable to get order profit for order of one Meat Lovers Pizza", 
				expectedProfit, pizza.getOrderProfit() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The pizza of type Meat Lovers order profit is returned correctly for a quantity of one pizza.
	 * Expected: The order's total profit is equal to 35.0.
	 */
	@Test
	public void getOrderProfitFivePizzas() throws PizzaException{
		int quantity = 5;
		double expectedProfit = 35.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertEquals("Unable to get order profit for order of five Meat Lovers Pizzas", 
				expectedProfit, pizza.getOrderProfit() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The pizza of type Meat Lovers getQuantity() function returns the correct number of pizzas.
	 * Expected: The returned quantity is 1.
	 */
	@Test
	public void getQuantityOnePizza() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertEquals("Unable to get quantity of pizzas from order of one Meat Lovers Pizza", 
				quantity, pizza.getQuantity() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The pizza of type Meat Lovers getQuantity() function returns the correct number of pizzas.
	 * Expected: The returned quantity is 5.
	 */
	@Test
	public void getQuantityFivePizza() throws PizzaException{
		int quantity = 5;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		Pizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertEquals("Unable to get quantity of pizzas from order of one Meat Lovers Pizza", 
				quantity, pizza.getQuantity() , TO_SECOND_DECIMAL_PLACE);
	}

	
	/*
	 * Get pizza type for MargheritaPizza class.
	 * Expected: The pizza type is equal to the Margherita pizza string.
	 */
	@Test
	public void getPizzaTypeMargheritaPizza() throws PizzaException{
		int quantity = 1;
		LocalTime currentTime = LocalTime.of(19,0);
		LocalTime deliveryTime = currentTime.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, currentTime, deliveryTime);
		
		assertEquals("Cannot create Pizza of type Meat Lovers", 
				MARGHERITA, pizza.getPizzaType());
	}
	
	/*
	 * Check pizza type for the MargheritaPizza class is not a MeatLoversPizza.
	 * Expected: The pizza type is not equal to the Margherita pizza string.
	 */
	@Test
	public void getPizzaTypeMargheritaNotMeatLovers() throws PizzaException{
		int quantity = 1;
		LocalTime currentTime = LocalTime.of(19,0);
		LocalTime deliveryTime = currentTime.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, currentTime, deliveryTime);
		
		assertTrue("Cannot distinguish between a Margherita pizza and a Meat Lovers pizza",
				!pizza.getPizzaType().equals(MEAT_LOVERS));
	}
	
	/*
	 * Check pizza type for the MargheritaPizza class is not a VegetarianPizza.
	 * Expected: The pizza type is not equal to the Vegetarian pizza string.
	 */
	@Test
	public void getPizzaTypeMargheritaNotVegetarian() throws PizzaException{
		int quantity = 1;
		LocalTime currentTime = LocalTime.of(19,0);
		LocalTime deliveryTime = currentTime.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, currentTime, deliveryTime);
		
		assertTrue("Cannot distinguish between a Margherita pizza and a Vegetarian pizza",
				!pizza.getPizzaType().equals(VEGETARIAN));
	}
	
	/*
	 * Instantiate MargheritaPizza over the maximum allowed quantity.
	 * Expected: PizzaException class thrown.
	 */
	@Test (expected = PizzaException.class)
	public void instantiateMargheritaPizzaQuantityOverLimitException() throws PizzaException{
		int quantity = 11;
		LocalTime currentTime = LocalTime.of(19,0);
		LocalTime deliveryTime = currentTime.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, currentTime, deliveryTime);
	}
	
	/*
	 * Instantiate MargheritaPizza with a quantity of zero.
	 * Expected: PizzaException class thrown.
	 */
	@Test (expected = PizzaException.class)
	public void instantiateMargheritaPizzaQuantityWithZeroPizzasException() throws PizzaException{
		int quantity = 0;
		LocalTime currentTime = LocalTime.of(19,0);
		LocalTime deliveryTime = currentTime.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, currentTime, deliveryTime);
	}
	
	/*
	 * Instantiate MargheritaPizza with an order time before the store opens.
	 * Expected: PizzaException class thrown.
	 */
	@Test (expected = PizzaException.class)
	public void instantiateMargheritaPizzaOrderTimeBeforeOpeningException() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(18,59);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
	}
	
	/*
	 * Instantiate MargheritaPizza with a delivery time after the store closes.
	 * Expected: the pizza is created and the pizza type equals the meat lovers pizza.
	 */
	@Test
	public void instantiateMargheritaPizzaDeliveryTimeAfterClosing() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(20, 55);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
				
		assertEquals("Cannot create Pizza with delivery time passed 11pm.", 
				MARGHERITA, pizza.getPizzaType());
	}
	
	/*
	 * Instantiate MargheritaPizza with an order time after the store closes.
	 * Expected: PizzaException class thrown.
	 */
	@Test (expected = PizzaException.class)
	public void instantiateMargheritaPizzaOrderTimeAfterClosingException() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(23, 1);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
	}
	
	/*
	 * Instantiate MargheritaPizza with a delivery time an hour after the order was made.
	 * Expected: PizzaException class thrown.
	 */
	@Test (expected = PizzaException.class)
	public void instantiateMargheritaPizzaDeliveryTimeOneHourAfterOrderTimeException() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(20,0);
		LocalTime deliveryTime = time.plusMinutes(61);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
	}
	
	/*
	 * The MargheritaPizza  getQuantity() function returns the correct number of pizzas for one pizza.
	 * Expected: The returned quantity is 1.
	 */
	@Test
	public void getQuantityMargheritaPizzaOnePizza() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
		
		assertEquals("Margherita Pizza order quantity has not been returned correctly.", 
				quantity, pizza.getQuantity());
	}
	
	/*
	 * The MargheritaPizza  getQuantity() function returns the correct number of pizzas for five pizza.
	 * Expected: The returned quantity is 5.
	 */
	@Test
	public void getQuantityMargheritaPizzaFivePizzas() throws PizzaException{
		int quantity = 5;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
		
		assertEquals("Margherita Pizza order quantity has not been returned correctly.", 
				quantity, pizza.getQuantity());
	}
		
	/*
	 * The MargheritaPizza contains CHEESE. 
	 * Expected: True
	 */
	@Test
	public void containsToppingsMargheritaPizzaCheese() throws PizzaException {
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
		
		assertTrue("Margherita Pizza ingredient found to not be contained in pizza listed in Specification.", 
				pizza.containsTopping(PizzaTopping.CHEESE));
	}
	
	/*
	 * The MargheritaPizza contains TOMATO. 
	 * Expected: True
	 */
	@Test
	public void containsToppingsMargheritaPizzaTomato() throws PizzaException {
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
		
		assertTrue("Margherita Pizza ingredient found to not be contained in pizza listed in Specification.", 
				pizza.containsTopping(PizzaTopping.TOMATO));
	}
	
	/*
	 * The MargheritaPizza does not contain BACON. 
	 * Expected: False
	 */
	@Test
	public void containsToppingsMargheritaPizzaDoesNotContainBacon() throws PizzaException {
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
		
		assertTrue("Margherita Pizza found to contain ingredient not listed in Specification.", 
				!(pizza.containsTopping(PizzaTopping.BACON)));
	}
	
	/*
	 * The MargheritaPizza does not contain SALAMI. 
	 * Expected: False
	 */
	@Test
	public void containsToppingMargheritaPizzaDoesNotContainSalami() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
		
		assertTrue("Margherita Pizza found to contain ingredient not listed in Specification.", 
				!(pizza.containsTopping(PizzaTopping.SALAMI)));
	}
	
	/*
	 * The MargheritaPizza does not contain PEPPERONI. 
	 * Expected: False
	 */
	@Test
	public void containsToppingMargheritaPizzaDoesNotContainPepperoni() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
		
		assertTrue("Margherita Pizza found to contain ingredient not listed in Specification.", 
				!(pizza.containsTopping(PizzaTopping.PEPPERONI)));
	}
	
	/*
	 * The MargheritaPizza does not contain CAPSICUM. 
	 * Expected: False
	 */
	@Test
	public void containsToppingMargheritaPizzaDoesNotContainCapsicum() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
		
		assertTrue("Margherita Pizza found to contain ingredient not listed in Specification.", 
				!(pizza.containsTopping(PizzaTopping.CAPSICUM)));
	}
	
	/*
	 * The MargheritaPizza does not contain MUSHROOM. 
	 * Expected: False
	 */
	@Test
	public void containsToppingMargheritaPizzaDoesNotContainMushroom() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
		
		assertTrue("Margherita Pizza found to contain ingredient not listed in Specification.", 
				!(pizza.containsTopping(PizzaTopping.MUSHROOM)));
	}
	
	/*
	 * The MargheritaPizza does not contain EGGPLANT. 
	 * Expected: False
	 */
	@Test
	public void containsToppingMargheritaPizzaDoesNotContainEggplant() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
		
		assertTrue("Margherita Pizza found to contain ingredient not listed in Specification.", 
				!(pizza.containsTopping(PizzaTopping.EGGPLANT)));
	}
	
	/*
	 * The MargheritaPizza order with a quantity of one has its cost per pizza returned correctly.
	 * Expected: The order's cost per pizza is equal to 1.5.
	 */
	@Test
	public void getCostPerPizzaMargheritaPizzaOnePizza() throws PizzaException{
		int quantity = 1;
		double expectedCostPerPizza = 1.5;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get cost per pizza for order of one Margherita Pizza", 
				expectedCostPerPizza, pizza.getCostPerPizza() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The MargheritaPizza cost per pizza is returned correctly for a quantity of five.
	 * Expected: The order's cost per pizza is equal to 1.5.
	 */
	@Test
	public void getCostPerPizzaMargheritaPizzaFivePizzas() throws PizzaException{
		int quantity = 5;
		double expectedCostPerPizza = 1.5;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get cost per pizza for order of five Margherita Pizza", 
				expectedCostPerPizza, pizza.getCostPerPizza() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The MargheritaPizza price per pizza is returned correctly.
	 * Expected: The order's price per pizza is equal to 8.0.
	 */
	@Test
	public void getPricePerPizzaMargheritaPizzaOnePizza() throws PizzaException{
		int quantity = 1;
		double expectedPricePerPizza = 8.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
		
		assertEquals("Unable to get price per pizza for order of one Margherita Pizza", 
				expectedPricePerPizza, pizza.getPricePerPizza() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The MargheritaPizza price per pizza is returned correctly for a quantity of five pizzas.
	 * Expected: The order's price per pizza is equal to 8.0.
	 */
	@Test
	public void getPricePerPizzaMargheritaPizzaFivePizzas() throws PizzaException{
		int quantity = 5;
		double expectedPricePerPizza = 8.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
		
		assertEquals("Unable to get price per pizza for order of five Margherita Pizza", 
				expectedPricePerPizza, pizza.getPricePerPizza() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The MargheritaPizza order price is returned correctly.
	 * Expected: The order's total price is equal to 8.0.
	 */
	@Test
	public void getOrderPriceMargheritaPizzaOnePizza() throws PizzaException{
		int quantity = 1;
		double expectedPrice = 8.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get correct order price for a Margherita Pizza Order of Quantity 1", 
				expectedPrice, pizza.getOrderPrice(), TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The MargheritaPizza order price is returned correctly for a quantity of five pizza.
	 * Expected: The order's total price is equal to 40.0.
	 */
	@Test
	public void getOrderPriceMargheritaPizzaFivePizzas() throws PizzaException{
		int quantity = 5;
		double expectedPrice = 40.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get correct order price for a Margherita Pizza Order of Quantity 5", 
				expectedPrice, pizza.getOrderPrice() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The MargheritaPizza order cost is returned correctly for a quantity of one pizza.
	 * Expected: The order's total cost is equal to 1.5.
	 */
	@Test
	public void getOrderCostMargheritaPizzaOnePizza() throws PizzaException{
		int quantity = 1;
		double expectedCost = 1.5;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get correct order cost for a Margherita Pizza Order of Quantity 1", 
				expectedCost, pizza.getOrderCost() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The pizza of type Meat Lovers order cost is returned correctly for a quantity of five pizzas.
	 * Expected: The order's total cost is equal to 7.5.
	 */
	@Test
	public void getOrderCostMargheritaPizzaFivePizzas() throws PizzaException{
		int quantity = 5;
		double expectedCost = 7.5;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get correct order cost for a Margherita Pizza Order of Quantity 5", 
				expectedCost, pizza.getOrderCost() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The MargheritaPizza order profit is returned correctly for a quantity of one pizza.
	 * Expected: The order's total profit is equal to 6.5.
	 */
	@Test
	public void getOrderProfitMargheritaPizzaOnePizza() throws PizzaException{
		int quantity = 1;
		double expectedProfit = 6.5;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get correct order profit for a Margherita Pizza Order of Quantity 1", 
				expectedProfit, pizza.getOrderProfit() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The MargheritaPizza order profit is returned correctly for a quantity of one pizza.
	 * Expected: The order's total profit is equal to 32.5.
	 */
	@Test
	public void getOrderProfitMargheritaPizzaFivePizzas() throws PizzaException{
		int quantity = 5;
		double expectedProfit = 32.5;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MargheritaPizza pizza = new MargheritaPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get correct order profit for a Margherita Pizza Order of Quantity 5", 
				expectedProfit, pizza.getOrderProfit() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * Get pizza type for VegetarianPizza class.
	 * Expected: The pizza type is equal to the Vegetarian pizza string.
	 */
	@Test
	public void getPizzaTypeVegetarianPizza() throws PizzaException{
		int quantity = 1;
		LocalTime currentTime = LocalTime.of(19,0);
		LocalTime deliveryTime = currentTime.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, currentTime, deliveryTime);
		
		assertEquals("Cannot create Pizza of type Vegetarian", 
				VEGETARIAN, pizza.getPizzaType());
	}
	
	/*
	 * Check pizza type for VegetarianPizza class is not MargheritaPizza.
	 * Expected: The pizza type is not equal to the Margherita pizza string.
	 */
	@Test
	public void getVegetarianPizzaTypeNotMargherita() throws PizzaException{
		int quantity = 1;
		LocalTime currentTime = LocalTime.of(19,0);
		LocalTime deliveryTime = currentTime.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, currentTime, deliveryTime);
		
		assertTrue("Cannot distinguish between a Meat Lovers pizza and a Margherita pizza",
				!pizza.getPizzaType().equals(MARGHERITA));
	}
	
	/*
	 * Check pizza type for VegetarianPizza is not of type Meat Lovers.
	 * Expected: The pizza type is not equal to the Meat Lovers pizza string.
	 */
	@Test
	public void getVegetarianPizzaTypeNotMeatLovers() throws PizzaException{
		int quantity = 1;
		LocalTime currentTime = LocalTime.of(19,0);
		LocalTime deliveryTime = currentTime.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, currentTime, deliveryTime);
		
		assertTrue("Cannot distinguish between a Meat Lovers pizza and a Vegetarian pizza",
				!pizza.getPizzaType().equals(MEAT_LOVERS));
	}
	
	/*
	 * Instantiate VegetarianPizza over the maximum allowed quantity.
	 * Expected: PizzaException class thrown.
	 */
	@Test (expected = PizzaException.class)
	public void instantiateVegetarianPizzaQuantityOverLimitException() throws PizzaException{
		int quantity = 11;
		LocalTime currentTime = LocalTime.of(19,0);
		LocalTime deliveryTime = currentTime.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, currentTime, deliveryTime);
	}
	
	/*
	 * Instantiate VegetarianPizza with a quantity of zero.
	 * Expected: PizzaException class thrown.
	 */
	@Test (expected = PizzaException.class)
	public void instantiateVegetarianPizzaQuantityWithZeroPizzasException() throws PizzaException{
		int quantity = 0;
		LocalTime currentTime = LocalTime.of(19,0);
		LocalTime deliveryTime = currentTime.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, currentTime, deliveryTime);
	}
	
	/*
	 * Instantiate VegetarianPizza with an order time before the store opens.
	 * Expected: PizzaException class thrown.
	 */
	@Test (expected = PizzaException.class)
	public void instantiateVegetarianPizzaOrderTimeBeforeOpeningException() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(18, 59);
		LocalTime deliveryTime = time.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
	}
	
	/*
	 * Instantiate VegetarianPizza with a delivery time after the store closes.
	 * Expected: the VegetarianPizza is created and the VegetarianPizza type equals the VegetarianPizza type.
	 */
	@Test
	public void instantiateVegetarianPizzaDeliveryTimeAfterClosing() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(22,55);
		LocalTime deliveryTime = time.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
				
		assertEquals(VEGETARIAN, pizza.getPizzaType());
	}
	
	/*
	 * Instantiate VegetarianPizza with a delivery time that is an hour after the order time.
	 * Expected: PizzaException class thrown.
	 */
	@Test (expected = PizzaException.class)
	public void instantiateVegetarianPizzaDeliveryTimeOneHourAfterOrderTime() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(20,0);
		LocalTime deliveryTime = time.plusMinutes(61);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
	}
	
	/*
	 * Instantiate VegetarianPizza with an order time after the store closes.
	 * Expected: PizzaException class thrown.
	 */
	@Test (expected = PizzaException.class)
	public void instantiateVegetarianPizzaOrderTimeAfterClosingException() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(23,1);
		LocalTime deliveryTime = time.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
	}
	
	/*
	 * The VegetarianPizza getQuantity() function returns the correct number of pizzas for an order of 1.
	 * Expected: The returned quantity is 1.
	 */
	@Test
	public void getQuantityVegetarianPizzaOnePizza() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
		
		assertEquals("Vegetarian Pizza order quantity has not been returned correctly.", 
				quantity, pizza.getQuantity());
	}
	
	/*
	 * The VegetarianPizza getQuantity() function returns the correct number of pizzas for an order of 5.
	 * Expected: The returned quantity is 5.
	 */
	@Test
	public void getQuantityVegetarianPizzaFivePizzas() throws PizzaException{
		int quantity = 5;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
		
		assertEquals("Vegetarian Pizza order quantity has not been returned correctly.", 
				quantity, pizza.getQuantity());
	}
	
	/*
	 * The VegetarianPizza contains CHEESE. 
	 * Expected: True
	 */
	@Test
	public void containsToppingsVegetarianPizzaCheese() throws PizzaException {
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
		
		assertTrue("Vegetarian Pizza ingredient found to not be contained in pizza listed in Specification.", 
				pizza.containsTopping(PizzaTopping.CHEESE));
	}
	
	/*
	 * The VegetarianPizza contains TOMATO. 
	 * Expected: True
	 */
	@Test
	public void containsToppingsVegetarianPizzaTomato() throws PizzaException {
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
		
		assertTrue("Vegetarian Pizza ingredient found to not be contained in pizza listed in Specification.", 
				pizza.containsTopping(PizzaTopping.TOMATO));
	}
	
	/*
	 * The VegetarianPizza does not contain BACON. 
	 * Expected: False
	 */
	@Test
	public void containsToppingsVegetarianPizzaDoesNotContainBacon() throws PizzaException {
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
		
		assertTrue("Vegetarian Pizza found to contain ingredient not listed in Specification.", 
				!(pizza.containsTopping(PizzaTopping.BACON)));
	}
	
	/*
	 * The VegetarianPizza does not contain SALAMI. 
	 * Expected: False
	 */
	@Test
	public void containsToppingVegetarianPizzaDoesNotContainSalami() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
		
		assertTrue("Vegetarian Pizza found to contain ingredient not listed in Specification.", 
				!(pizza.containsTopping(PizzaTopping.SALAMI)));
	}
	
	/*
	 * The VegetarianPizza does not contain PEPPERONI. 
	 * Expected: False
	 */
	@Test
	public void containsToppingVegetarianPizzaDoesNotContainPepperoni() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
		
		assertTrue("Vegetarian Pizza found to contain ingredient not listed in Specification.", 
				!(pizza.containsTopping(PizzaTopping.PEPPERONI)));
	}
	
	/*
	 * The VegetarianPizza does contain CAPSICUM. 
	 * Expected: True
	 */
	@Test
	public void containsToppingVegetarianPizzaCapsicum() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
		
		assertTrue("Vegetarian Pizza ingredient found to not be contained in pizza listed in Specification.", 
				(pizza.containsTopping(PizzaTopping.CAPSICUM)));
	}
	
	/*
	 * The VegetarianPizza does contain MUSHROOM. 
	 * Expected: True
	 */
	@Test
	public void containsToppingVegetarianPizzaMushroom() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
		
		assertTrue("Vegetarian Pizza ingredient found to not be contained in pizza listed in Specification.", 
				(pizza.containsTopping(PizzaTopping.MUSHROOM)));
	}
	
	/*
	 * The VegetarianPizza does contain EGGPLANT. 
	 * Expected: True
	 */
	@Test
	public void containsToppingVegetarianPizzaEggplant() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
		
		assertTrue("Vegetarian Pizza ingredient found to not be contained in pizza listed in Specification.", 
				(pizza.containsTopping(PizzaTopping.EGGPLANT)));
	}
	
	/*
	 * The VegetarianPizza order with a quantity of one has its cost per pizza returned correctly.
	 * Expected: The order's cost per pizza is equal to 5.5.
	 */
	@Test
	public void getCostPerPizzaVegetarianPizzaOnePizza() throws PizzaException{
		int quantity = 1;
		double expectedCostPerPizza = 5.5;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get cost per pizza for order of one Vegetarian Pizza", 
				expectedCostPerPizza, pizza.getCostPerPizza() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The VegetarianPizza order with a quantity of five has its cost per pizza returned correctly.
	 * Expected: The order's cost per pizza is equal to 27.5.
	 */
	@Test
	public void getCostPerPizzaVegetarianPizzaFivePizzas() throws PizzaException{
		int quantity = 5;
		double expectedCostPerPizza = 5.5;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get cost per pizza for order of five Vegetarian Pizza", 
				expectedCostPerPizza, pizza.getCostPerPizza() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The VegetarianPizza order with a quantity of one has its price per pizza returned correctly.
	 * Expected: The order's price per pizza is equal to 10.0.
	 */
	@Test
	public void getPricePerPizzaVegetarianPizzaOnePizza() throws PizzaException{
		int quantity = 1;
		double expectedPricePerPizza = 10.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
		
		
		assertEquals("Unable to get price per pizza for order of one Vegetarian Pizza", 
				expectedPricePerPizza, pizza.getPricePerPizza() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The VegetarianPizza order with a quantity of five has its price per pizza returned correctly.
	 * Expected: The order's price per pizza is equal to 50.0.
	 */
	@Test
	public void getPricePerPizzaVegetarianPizzaFivePizzas() throws PizzaException{
		int quantity = 5;
		double expectedPricePerPizza = 10.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
		
		assertEquals("Unable to get price per pizza for order of five Vegetarian Pizza", 
				expectedPricePerPizza, pizza.getPricePerPizza() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The VegetarianPizza order cost is returned correctly for a quantity of one pizza.
	 * Expected: The order's total cost is equal to 5.5.
	 */
	@Test
	public void getOrderCostVegetarianPizzaOnePizza() throws PizzaException{
		int quantity = 1;
		double expectedCost = 5.5;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get correct order cost for a Vegetarian Pizza Order of Quantity 1", 
				expectedCost, pizza.getOrderCost() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The VegetarianPizza order cost is returned correctly for a quantity of five pizza.
	 * Expected: The order's total cost is equal to 27.5.
	 */
	@Test
	public void getOrderCostVegetarianPizzaFivePizzas() throws PizzaException{
		int quantity = 5;
		double expectedCost = 27.5;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get correct order cost for a Vegetarian Pizza Order of Quantity 5", 
				expectedCost, pizza.getOrderCost() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The VegetarianPizza order price is returned correctly for a quantity of one pizza.
	 * Expected: The order's total price is equal to 10.0.
	 */
	@Test
	public void getOrderPriceVegetarianPizzaOnePizza() throws PizzaException{
		int quantity = 1;
		double expectedPrice = 10.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get correct order price for a Vegetarian Pizza Order of Quantity 1", 
				expectedPrice, pizza.getOrderPrice() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The VegetarianPizza order price is returned correctly for a quantity of five pizza.
	 * Expected: The order's total price is equal to 50.0.
	 */
	@Test
	public void getOrderPriceVegetarianPizzaFivePizzas() throws PizzaException{
		int quantity = 5;
		double expectedPrice = 50.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get correct order price for a Vegetarian Pizza Order of Quantity 5", 
				expectedPrice, pizza.getOrderPrice() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The VegetarianPizza order profit is returned correctly for a quantity of one pizza.
	 * Expected: The order's total profit is equal to 4.5.
	 */
	@Test
	public void getOrderProfitVegetarianPizzaOnePizza() throws PizzaException{
		int quantity = 1;
		double expectedProfit = 4.5;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get correct order profit for a Vegetarian Pizza Order of Quantity 1", 
				expectedProfit, pizza.getOrderProfit() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The VegetarianPizza order profit is returned correctly for a quantity of five pizza.
	 * Expected: The order's total profit is equal to 22.5.
	 */
	@Test
	public void getOrderProfitVegetarianPizzaFivePizzas() throws PizzaException{
		int quantity = 5;
		double expectedProfit = 22.5;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		VegetarianPizza pizza = new VegetarianPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get correct order profit for a Vegetarian Pizza Order of Quantity 5", 
				expectedProfit, pizza.getOrderProfit() , TO_SECOND_DECIMAL_PLACE);
	}

	/*
	 * Get pizza type for MeatLoversPizza class.
	 * Expected: The MeatLoversPizza type is equal to the Meat Lovers pizza string.
	 */
	@Test
	public void getPizzaTypeMeatLoversPizza() throws PizzaException{
		int quantity = 1;
		LocalTime currentTime = LocalTime.of(19,0);
		LocalTime deliveryTime = currentTime.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, currentTime, deliveryTime);
		
		assertEquals("Cannot create Pizza of type Meat Lovers", 
				MEAT_LOVERS, pizza.getPizzaType());
	}
	
	/*
	 * Check pizza type for MeatLoversPizza is not Margherita.
	 * Expected: The MeatLoversPizza type is not equal to the Margherita pizza string.
	 */
	@Test
	public void getMeatLoversPizzaTypeNotMargherita() throws PizzaException{
		int quantity = 1;
		LocalTime currentTime = LocalTime.of(19,0);
		LocalTime deliveryTime = currentTime.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, currentTime, deliveryTime);
		
		assertTrue("Cannot distinguish between a Meat Lovers pizza and a Margherita pizza",
				!pizza.getPizzaType().equals(MARGHERITA));
	}
	
	/*
	 * Check pizza type for MeatLoversPizza is not Vegetarian.
	 * Expected: The MeatLoversPizza type is not equal to the Vegetarian pizza string.
	 */
	@Test
	public void getMeatLoversTypeNotVegetarian() throws PizzaException{
		int quantity = 1;
		LocalTime currentTime = LocalTime.of(19,0);
		LocalTime deliveryTime = currentTime.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, currentTime, deliveryTime);
		
		assertTrue("Cannot distinguish between a Meat Lovers pizza and a Vegetarian pizza",
				!pizza.getPizzaType().equals(VEGETARIAN));
	}
	
	/*
	 * Instantiate MeatLoversPizza over the maximum allowed quantity.
	 * Expected: PizzaException class thrown.
	 */
	@Test (expected = PizzaException.class)
	public void instantiateMeatLoversPizzaQuantityOverLimitException() throws PizzaException{
		int quantity = 11;
		LocalTime currentTime = LocalTime.of(19,0);
		LocalTime deliveryTime = currentTime.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, currentTime, deliveryTime);
	}
	
	/*
	 * Instantiate MeatLoversPizza with a quantity of zero.
	 * Expected: PizzaException class thrown.
	 */
	@Test (expected = PizzaException.class)
	public void instantiateMeatLoversPizzaQuantityWithZeroPizzasException() throws PizzaException{
		int quantity = 0;
		LocalTime currentTime = LocalTime.of(19,0);
		LocalTime deliveryTime = currentTime.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, currentTime, deliveryTime);
	}
	
	/*
	 * Instantiate MeatLoversPizza with an order time before the store opens.
	 * Expected: PizzaException class thrown.
	 */
	@Test (expected = PizzaException.class)
	public void instantiateMeatLoversPizzaOrderTimeBeforeOpeningException() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(18, 59);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
	}
	
	/*
	 * Instantiate MeatLoversPizza with a delivery time after the store closes.
	 * Expected: the MeatLoversPizza is created and the MeatLoversPizza type equals the meat lovers pizza string.
	 */
	@Test
	public void instantiateMeatLoversPizzaDeliveryTimeAfterClosing() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(22,55);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals(MEAT_LOVERS, pizza.getPizzaType());
	}
	
	/*
	 * Instantiate MeatLoversPizza with a delivery time an hour after the order time.
	 * Expected: PizzaException class thrown.
	 */
	@Test (expected = PizzaException.class)
	public void instantiateMeatLoversPizzaDeliveryTimeHourAfterOrderTimeException() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(22,0);
		LocalTime deliveryTime = time.plusMinutes(61);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
	}
	
	/*
	 * Instantiate MeatLoversPizza with an order time after the store closes.
	 * Expected: PizzaException class thrown.
	 */
	@Test (expected = PizzaException.class)
	public void instantiateMeatLoversPizzaOrderTimeAfterClosingException() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(23,1);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
	}
	
	/*
	 * The MeatLoversPizza of type Meat Lovers getQuantity() function returns the correct number of pizzas for a quantity of one.
	 * Expected: The returned quantity is 1.
	 */
	@Test
	public void getQuantityMeatLoversPizzaOnePizza() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertEquals("Meat Lovers Pizza order quantity has not been returned correctly.", 
				quantity, pizza.getQuantity());
	}
	
	/*
	 * The MeatLoversPizza of type Meat Lovers getQuantity() function returns the correct number of pizzas for a quantity of five.
	 * Expected: The returned quantity is 1.
	 */
	@Test
	public void getQuantityMeatLoversPizzaFivePizzas() throws PizzaException{
		int quantity = 5;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertEquals("Meat Lovers Pizza order quantity has not been returned correctly.", 
				quantity, pizza.getQuantity());
	}
	
	/*
	 * The MeatLoversPizza contains CHEESE. 
	 * Expected: True
	 */
	@Test
	public void containsToppingsMeatLoversPizzaCheese() throws PizzaException {
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertTrue("Meat Lovers Pizza ingredient found to not be contained in pizza listed in Specification.", 
				pizza.containsTopping(PizzaTopping.CHEESE));
	}
	
	/*
	 * The MeatLoversPizza contains TOMATO. 
	 * Expected: True
	 */
	@Test
	public void containsToppingsMeatLoversPizzaTomato() throws PizzaException {
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertTrue("Meat Lovers Pizza ingredient found to not be contained in pizza listed in Specification.", 
				pizza.containsTopping(PizzaTopping.TOMATO));
	}
	
	/*
	 * The MeatLoversPizza contains BACON. 
	 * Expected: True
	 */
	@Test
	public void containsToppingsMeatLoversPizzaBacon() throws PizzaException {
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertTrue("Meat Lovers Pizza ingredient found to not be contained in pizza listed in Specification.", 
				(pizza.containsTopping(PizzaTopping.BACON)));
	}
	
	/*
	 * The MeatLoversPizza contains SALAMI. 
	 * Expected: True
	 */
	@Test
	public void containsToppingMeatLoversPizzaSalami() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertTrue("Meat Lovers Pizza ingredient found to not be contained in pizza listed in Specification.", 
				(pizza.containsTopping(PizzaTopping.SALAMI)));
	}
	
	/*
	 * The MeatLoversPizza contains PEPPERONI. 
	 * Expected: True
	 */
	@Test
	public void containsToppingMeatLoversPizzaPepperoni() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertTrue("Meat Lovers Pizza ingredient found to not be contained in pizza listed in Specification.", 
				(pizza.containsTopping(PizzaTopping.PEPPERONI)));
	}
	
	/*
	 * The MeatLoversPizza does not contains CAPSICUM. 
	 * Expected: False
	 */
	@Test
	public void containsToppingMeatLoversPizzaDoesNotContainCapsicum() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertTrue("Meat Lovers Pizza found to contain ingredient not listed in Specification.", 
				!(pizza.containsTopping(PizzaTopping.CAPSICUM)));
	}
	
	/*
	 * The MeatLoversPizza does not contains MUSHROOM. 
	 * Expected: False
	 */
	@Test
	public void containsToppingMeatLoversPizzaDoesNotContainMushroom() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertTrue("Meat Lovers Pizza found to contain ingredient not listed in Specification.", 
				!(pizza.containsTopping(PizzaTopping.MUSHROOM)));
	}
	
	/*
	 * The MeatLoversPizza does not contains EGGPLANT. 
	 * Expected: False
	 */
	@Test
	public void containsToppingMeatLoversPizzaDoesNotContainEggplant() throws PizzaException{
		int quantity = 1;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertTrue("Meat Lovers Pizza found to contain ingredient not listed in Specification.", 
				!(pizza.containsTopping(PizzaTopping.EGGPLANT)));
	}
	
	/*
	 * The MeatLoversPizza order with a quantity of one has its cost per pizza returned correctly.
	 * Expected: The order's cost per pizza is equal to 5.0.
	 */
	@Test
	public void getCostPerPizzaMeatLoversPizzaOnePizza() throws PizzaException{
		int quantity = 1;
		double expectedCostPerPizza = 5.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get cost per pizza for order of one Meat Lovers Pizza", 
				expectedCostPerPizza, pizza.getCostPerPizza() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The MeatLoversPizza order cost per pizza is returned correctly for a quantity of five.
	 * Expected: The order's cost per pizza is equal to 5.0.
	 */
	@Test
	public void getCostPerPizzaMeatLoversPizzaFivePizzas() throws PizzaException{
		int quantity = 5;
		double expectedCostPerPizza = 5.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get cost per pizza for order of five Meat Lovers Pizza", 
				expectedCostPerPizza, pizza.getCostPerPizza() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The MeatLoversPizza order price per pizza is returned correctly.
	 * Expected: The order's price per pizza is equal to 12.0.
	 */
	@Test
	public void getPricePerPizzaMeatLoversPizzaOnePizza() throws PizzaException{
		int quantity = 1;
		double expectedPricePerPizza = 12.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertEquals("Unable to get price per pizza for order of one Meat Lovers Pizza", 
				expectedPricePerPizza, pizza.getPricePerPizza() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The MeatLoversPizza order price per pizza is returned correctly for a quantity of five pizzas.
	 * Expected: The order's price per pizza is equal to 12.0.
	 */
	@Test
	public void getPricePerPizzaMeatLoversPizzaFivePizzas() throws PizzaException{
		int quantity = 5;
		double expectedPricePerPizza = 12.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		assertEquals("Unable to get price per pizza for order of five Meat Lovers Pizza", 
				expectedPricePerPizza, pizza.getPricePerPizza() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The MeatLoversPizza order cost is returned correctly for a quantity of one pizza.
	 * Expected: The order's total cost is equal to 5.0.
	 */	
	@Test
	public void getOrderCostMeatLoversPizzaOnePizza() throws PizzaException{
		int quantity = 1;
		double expectedCost = 5.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get correct order cost for a Meat Lovers Pizza Order of Quantity 1", 
				expectedCost, pizza.getCostPerPizza() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The MeatLoversPizza order cost is returned correctly for a quantity of five pizza.
	 * Expected: The order's total cost is equal to 25.0.
	 */
	@Test
	public void getOrderCostMeatLoversPizzaFivePizzas() throws PizzaException{
		int quantity = 5;
		double expectedCost = 25.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get correct order cost for a Meat Lovers Pizza Order of Quantity 5", 
				expectedCost, pizza.getOrderCost() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The MeatLoversPizza order price is returned correctly for a quantity of one pizza.
	 * Expected: The order's total price is equal to 12.0.
	 */
	@Test
	public void getOrderPriceMeatLoversPizzaOnePizza() throws PizzaException{
		int quantity = 1;
		double expectedPrice = 12.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get correct order price for a Meat Lovers Pizza Order of Quantity 1", 
				expectedPrice, pizza.getOrderPrice() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The MeatLoversPizza order price is returned correctly for a quantity of five pizza.
	 * Expected: The order's total price is equal to 60.0.
	 */
	@Test
	public void getOrderPriceMeatLoversPizzaFivePizzas() throws PizzaException{
		int quantity = 5;
		double expectedPrice = 60.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get correct order price for a Meat Lovers Pizza Order of Quantity 5", 
				expectedPrice, pizza.getOrderPrice() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The MeatLoversPizza order profit is returned correctly for a quantity of five pizza.
	 * Expected: The order's total profit is equal to 5.0.
	 */
	@Test
	public void getOrderProfitMeatLoversPizzaOnePizza() throws PizzaException{
		int quantity = 1;
		double expectedProfit = 7.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get correct order profit for a Meat Lovers Pizza Order of Quantity 1", 
				expectedProfit, pizza.getOrderProfit() , TO_SECOND_DECIMAL_PLACE);
	}
	
	/*
	 * The MeatLoversPizza order profit is returned correctly for a quantity of five pizza.
	 * Expected: The order's total profit is equal to 35.0.
	 */
	@Test
	public void getOrderProfitMeatLoversPizzaFivePizzas() throws PizzaException{
		int quantity = 5;
		double expectedProfit = 35.0;
		LocalTime time = LocalTime.of(19,0);
		LocalTime deliveryTime = time.plusMinutes(10);
		MeatLoversPizza pizza = new MeatLoversPizza(quantity, time, deliveryTime);
		
		pizza.calculateCostPerPizza();
		
		assertEquals("Unable to get correct order profit for a Meat Lovers Pizza Order of Quantity 5", 
				expectedProfit, pizza.getOrderProfit() , TO_SECOND_DECIMAL_PLACE);
	}	
}
