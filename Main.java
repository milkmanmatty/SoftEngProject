import java.math.*;

import javax.swing.JFrame;

public class Main {
	/*
	This class exists to test the implementation of the system.
	*/

	/**
	 * Creates a new instance of the <code>MainFrame</code> class named <code>jacko</code> and then calls upon <code>conclude</code>.
	 * Also does basic Data Initialisation for the DatabaseSystem class.
	 * @param args	standard initialisation parameter used by the JVM.
	 * 
	 * @see #setInitialData()
	 * @see MainFrame#conclude(JFrame)
	 */
	public static void main(String args[]){		
		//Initialize data
		setInitialData();
		
		//Create new subclass object called jacko, because jacko's a mad baller
		MainFrame jacko = new GUI();
		
		//Statically call the method conclude on jack. 
		MainFrame.conclude(jacko.getCurrentFrame());
	}

	protected static void log(String text) {
		System.out.println(text);
	}
	
	
	private static void setInitialData(){
		DatabaseSystem.addMenuItem(100, "Spaggetti", "14.95");
		DatabaseSystem.addMenuItem(200, "Rump Steak", "25.95");
		DatabaseSystem.addMenuItem(300, "Chicken", "17.50");
		DatabaseSystem.addMenuItem(400, "Pork Belly", "28.70");
		DatabaseSystem.addMenuItem(500, "Lamb Chops", "23.90");
		DatabaseSystem.addMenuItem(501, "Lamb Ribs", "29.99");
		DatabaseSystem.addMenuItem(600, "Ceaser Salad", "10.00");

		DatabaseSystem.addCustomer("Harry Potter", "444 839 384", "61 Harlinton Rd", "0000 3372 8983 2837");
		DatabaseSystem.addCustomer("Neville Longbottom", "123 383 028", "62 Harlinton Rd", "1111 5323 2233 2131");
		DatabaseSystem.addCustomer("Ron Weasly", "666 627 399", "63 Harlinton Rd", "2222 3455 5334 9176");
		DatabaseSystem.addCustomer("Some Person", "837 282 383", "69 Harlinton Rd", "4444 2233 2826 9187");
		DatabaseSystem.addCustomer("Some Person", "123 456 789", "72 Scotston Cr", "7777 8839 2728 2818");

		int harryID = DatabaseSystem.findCustomer("Harry Potter");
		Customer cusHarry = DatabaseSystem.getCustomerWithID(harryID);
		Order harryOrder1 = new Order(true); // order is takeway

		BigDecimal harryCost = new BigDecimal(0.00);
		harryCost.setScale(2, BigDecimal.ROUND_HALF_EVEN);

		log("" + harryOrder1.calculateCost());
		harryOrder1.addItem(100, 1);
		log("" + harryOrder1.calculateCost());
		harryOrder1.addItem(500, 2);
		log("" + harryOrder1.calculateCost());
		harryOrder1.addItem(600, 1);
		log("" + harryOrder1.calculateCost());
		harryOrder1.addItem(100, 1);
		log("" + harryOrder1.calculateCost());
		cusHarry.finishOrder(harryOrder1);

		int somePersonID = DatabaseSystem.findCustomer("Some Person");
		if (somePersonID > 0) {
			somePersonID = DatabaseSystem.findCustomer("Some Person", "123 456 789");
		}
		Customer cusSomePerson = DatabaseSystem.getCustomerWithID(somePersonID);
		Order somePersonOrder = new Order(false);
		somePersonOrder.addItem(100, 5);
		somePersonOrder.addItem(500, 1);
		// System.out.println(somePersonOrder.calculateCost());
		cusSomePerson.finishOrder(somePersonOrder);
	}
}
