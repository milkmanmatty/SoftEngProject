import java.util.*;

public class DatabaseSystem {
	private static int nextCusID = 1;
	private static int nextMenuItemID = 1;
	private static int nextOrderID = 1;
	private static ArrayList<Customer> customers = new ArrayList<Customer>();
	private static ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();

	public static int nextCusID() {
		return nextCusID++;
	}

	public static int nextMenuItemID() {
		return nextMenuItemID++;
	}

	public static int nextOrderID() {
		return nextOrderID++;
	}

	public static boolean removeCustomer(int cusID) {
		/* 
		true if customer found
		false if customer not found.
		*/
		for (int i = 0; i < customers.size(); i++) {
			Customer cus = customers.get(i);
			if (cus.getCusID() == cusID) {
				customers.remove(i);
				return true;
			}
		}
		return false;
	}

	public static void addCustomer(String name, String phone, String address, String cCard) {
		Customer cus = new Customer(name, phone, address, cCard);
		customers.add(cus);
	}

	public static Customer getCustomerWithID(int id) {
		/*
		returns null if no customer with id found.
		returns first Customer with id otherwise.
		*/

		for (int i = 0; i < customers.size(); i++) {
			Customer cus = customers.get(i);
			if (cus.getCusID() == id) {
				return cus;
			}
		}
		return null;
	}

	public static int findCustomer(String name) {
		/*
		returns 0 if no customer with name is found.
		returns -# if multiple customers found. 
		Where # is equal to the number of customers
		with this name found (use phone number as second identifier).
		returns cusID for name if customer is found.
		NOTE: name must be entered as it exists in the database.
		NOTE: character case in names is ignored.
		*/

		int numberFound = 0;
		int lastID = 0;
		for (int i = 0; i < customers.size(); i++) {
			Customer cus = customers.get(i);
			if (cus.getName().equalsIgnoreCase(name)) {
				numberFound++;
				lastID = cus.getCusID();
			}
		}
		if (numberFound == 1) {
			return lastID;
		} else {
			return numberFound;
		}
	}

	public static int findCustomer(String name, String phone) {
		/*
		returns 0 if no customer with name is found.
		returns -# if multiple customers found. 
		Where # is equal to the number of customers
		with this name found (use phone number as second identifier).
		returns cusID for name if customer is found.
		NOTE: name must be entered as it exists in the database.
		NOTE: character case in names is ignored.
		*/

		int numberFound = 0;
		int lastID = 0;
		for (int i = 0; i < customers.size(); i++) {
			Customer cus = customers.get(i);
			if ((cus.getName().equalsIgnoreCase(name)) &&
			 	 cus.getPhone().equalsIgnoreCase(phone)) {
				numberFound++;
				lastID = cus.getCusID();
			}
		}
		if (numberFound == 1) {
			return lastID;
		} else {
			return numberFound;
		}
	}

	public static void addMenuItem(String name, double cost) {
		MenuItem menuItem = new MenuItem(name, cost);
	}

	public static boolean addMenuItem(int menuItemID, String name, double cost) {
		/* 
		returns true if item ID doesn't already exist and item added successfully
		returns false if item ID already exists and item was not added.
		*/

		for (int i = 0; i < customers.size(); i++) {
			MenuItem menuItem = menuItems.get(i);
			if (menuItem.getMenuItemID() == menuItemID) {
				return false;
			}
		}
		MenuItem menuItem = new MenuItem(menuItemID, name, cost);
		menuItems.add(menuItem);
		return true;
	}

	public static boolean menuItemExists(int id) {
		/*
		Returns true if item does exist within the menuItems Array
		else returns false.
		*/

		for (int i = 0; i < menuItems.size(); i++) {
			MenuItem menuItem = menuItems.get(i);
			if (id == menuItem.getMenuItemID()) {
				return true;
			}
		}
		return false;
	}

	public static double getMenuItemCost(int id) {
		for (int i = 0; i < menuItems.size(); i++) {
			MenuItem menuItem = menuItems.get(i);
			if (id == menuItem.getMenuItemID()) {
				return menuItem.getCost();
			}
		}
		return -1.0;
	}
}