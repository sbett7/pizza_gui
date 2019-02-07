package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.PizzaException;

import java.time.LocalTime;


import asgn2Pizzas.*;


/** 
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Sean Betts
 * 
 */
public class PizzaFactoryTests {
	
	//PIZZA TYPES
	private final String MARGHERITA = "Margherita";
	private final String VEGETARIAN = "Vegetarian";
	private final String MEAT_LOVERS = "Meat Lovers";
	
	//PIZZA CODES
	private final String MARGHERITA_CODE = "PZM";
	private final String VEGETARIAN_CODE = "PZV";
	private final String MEAT_LOVERS_CODE = "PZL";
	
	/*
	 * Create pizza of type Margherita with the PizzaFactory class.
	 * Expected: The Factory pizza type is equal to the pizza type created by the Pizza constructor.
	 */
	@Test
	public void getPizzaMargheritaPizzaType() throws PizzaException{
		int quantity = 1;
		LocalTime orderTime = LocalTime.of(20,0);
		LocalTime deliveryTime = orderTime.plusMinutes(15);
		Pizza pizza = PizzaFactory.getPizza(MARGHERITA_CODE, quantity, orderTime, deliveryTime);

		assertEquals("Unable to create Margherita Pizza from Factory.",
				MARGHERITA, pizza.getPizzaType());
	}
	
	/*
	 * Create pizza of type Meat Lovers with the PizzaFactory class.
	 * Expected: The Factory pizza type is equal to the pizza type created by the Pizza constructor.
	 */
	@Test
	public void getPizzaMeatLoversPizzaType() throws PizzaException{
		int quantity = 1;
		LocalTime orderTime = LocalTime.of(20,0);
		LocalTime deliveryTime =orderTime.plusMinutes(15);
		Pizza pizza = PizzaFactory.getPizza(MEAT_LOVERS_CODE, quantity, orderTime, deliveryTime);

		assertEquals("Unable to create Meat Lovers Pizza from Factory.",
				MEAT_LOVERS, pizza.getPizzaType());
	}
	
	/*
	 * Create pizza of type Vegetarian with the PizzaFactory class.
	 * Expected: The Factory pizza type is equal to the pizza type created by the Pizza constructor.
	 */
	@Test
	public void getPizzaVegetarianPizzaType() throws PizzaException{
		int quantity = 1;
		LocalTime orderTime = LocalTime.of(20,0);
		LocalTime deliveryTime = orderTime.plusMinutes(15);
		Pizza pizza = PizzaFactory.getPizza(VEGETARIAN_CODE, quantity, orderTime, deliveryTime);

		assertEquals("Unable to create Vegetarian Pizza from Factory.",
				VEGETARIAN, pizza.getPizzaType());
	}
	
	/*
	 * Create pizza of type Margherita with a quantity of one with the PizzaFactory class.
	 * Expected: The Factory pizza quantity is equal to the pizza quantity created by the Pizza constructor.
	 */
	@Test
	public void getPizzaMargheritaOnePizzaQuantity() throws PizzaException{
		int quantity = 1;
		LocalTime orderTime = LocalTime.of(20,0);
		LocalTime deliveryTime = orderTime.plusMinutes(15);
		
		Pizza pizza = PizzaFactory.getPizza(MARGHERITA_CODE, quantity, orderTime, deliveryTime);

		assertEquals("Unable to create Margherita Pizza of quantity one.",
				quantity, pizza.getQuantity());
	}
	
	/*
	 * Create pizza of type Margherita with a quantity of five with the PizzaFactory class.
	 * Expected: The Factory pizza quantity is equal to the pizza quantity created by the Pizza constructor.
	 */
	@Test
	public void getPizzaFiveMargheritaPizza() throws PizzaException{
		int quantity = 5;
		LocalTime orderTime = LocalTime.of(20,0);
		LocalTime deliveryTime = orderTime.plusMinutes(15);
		
		Pizza pizza = PizzaFactory.getPizza(MARGHERITA_CODE, quantity, orderTime, deliveryTime);

		assertEquals("Unable to create Margheita Pizza of quantity five.",
				quantity, pizza.getQuantity());
	}
	
	/*
	 * Create pizza of type Meat Lovers with a quantity of one with the PizzaFactory class.
	 * Expected: The Factory pizza quantity is equal to the pizza quantity created by the Pizza constructor.
	 */
	@Test
	public void getPizzaOneMeatLoversPizzaQuantity() throws PizzaException{
		int quantity = 1;
		LocalTime orderTime = LocalTime.of(20,0);
		LocalTime deliveryTime = orderTime.plusMinutes(15);
		
		Pizza pizza = PizzaFactory.getPizza(MEAT_LOVERS_CODE, quantity, orderTime, deliveryTime);

		assertEquals("Unable to create Meat Lovers Pizza of quantity one.",
				quantity, pizza.getQuantity());
	}
	
	/*
	 * Create pizza of type Meat Lovers with a quantity of five with the PizzaFactory class.
	 * Expected: The Factory pizza quantity is equal to the pizza quantity created by the Pizza constructor.
	 */
	@Test
	public void getPizzaFiveMeatLoversPizza() throws PizzaException{
		int quantity = 5;
		LocalTime orderTime = LocalTime.of(20,0);
		LocalTime deliveryTime = orderTime.plusMinutes(15);
		
		Pizza pizza = PizzaFactory.getPizza(MEAT_LOVERS_CODE, quantity, orderTime, deliveryTime);

		assertEquals("Unable to create Meat Lovers Pizza of quantity five.",
				quantity, pizza.getQuantity());
	}
	
	/*
	 * Create pizza of type Vegetarian with a quantity of one with the PizzaFactory class.
	 * Expected: The Factory pizza quantity is equal to the pizza quantity created by the Pizza constructor.
	 */
	@Test
	public void getPizzaOneVegetarianPizzaQuantity() throws PizzaException{
		int quantity = 1;
		LocalTime orderTime = LocalTime.of(20,0);
		LocalTime deliveryTime = orderTime.plusMinutes(15);
		
		Pizza pizza = PizzaFactory.getPizza(VEGETARIAN_CODE, quantity, orderTime, deliveryTime);

		assertEquals("Unable to create Vegetarian Pizza of quantity one.",
				quantity, pizza.getQuantity());
	}
	
	/*
	 * Create pizza of type Vegetarian with a quantity of five with the PizzaFactory class.
	 * Expected: The Factory pizza quantity is equal to the pizza quantity created by the Pizza constructor.
	 */
	@Test
	public void getPizzaFiveVegetarianPizza() throws PizzaException{
		int quantity = 5;
		LocalTime orderTime = LocalTime.of(20,0);
		LocalTime deliveryTime = orderTime.plusMinutes(15);
		
		Pizza pizza = PizzaFactory.getPizza(VEGETARIAN_CODE, quantity, orderTime, deliveryTime);

		assertEquals("Unable to create Vegetarian Pizza of quantity five.",
				quantity, pizza.getQuantity());
	}
	
	/*
	 * Create pizza of an unlisted type.
	 * Expected: The PizzaException class.
	 */
	@Test (expected = PizzaException.class)
	public void getPizzaNonListedPizzaCodeException() throws PizzaException{
		int quantity = 5;
		LocalTime orderTime = LocalTime.of(20,0);
		LocalTime deliveryTime = orderTime.plusMinutes(15);
		
		Pizza pizza = PizzaFactory.getPizza("PVH", quantity, orderTime, deliveryTime);
	}
	
	
	
	
}
