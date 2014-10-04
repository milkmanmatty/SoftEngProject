import java.util.*;
import java.math.*;

public class Order {
	private boolean takeAway;
	private int orderID;
	private Date orderDate;
	private static ArrayList<Item> orderItems = new ArrayList<Item>();

	public Order(boolean takeAway) {
		this.orderID = DatabaseSystem.nextOrderID();
		this.takeAway = takeAway;
		this.orderDate = new Date();
	}

	public int getOrderID() {
		return this.orderID;
	}

	public BigDecimal calculateCost() {
		BigDecimal totalCost = new BigDecimal(0.00);
		for (int i = 0; i < orderItems.size(); i++) {
			Item item = orderItems.get(i);
			BigDecimal itemCost  = DatabaseSystem.getMenuItemCost(item.getItemID());
			int itemQuantity = item.getQuantity();
			if (itemCost.doubleValue() < 0) {
				return null;			//NOTE:		Not sure on best way to handle error. Might Require manual fix.
			} else {
				BigDecimal itemsCost = itemCost.multiply(new BigDecimal(itemQuantity));
				totalCost = totalCost.add(itemsCost);
			}
		}
		totalCost.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		return totalCost;
	}

	public boolean addItem(int itemID, int quantity) {
		/*
		returns true if successful
		(successful if itemID exists as menuItemID in DataBaseSystem's
		menuItems)
		else returns false.
		*/
		if (DatabaseSystem.menuItemExists(itemID)) {
			boolean preExistingItem = false;
			for (int i = 0; i < orderItems.size(); i++) {
				Item item = orderItems.get(i);
				if (item.getItemID() == itemID) {
					item.setQuantity(item.getQuantity() + quantity);
					preExistingItem = true;
				}
			}
			if (!preExistingItem) {
				Item item = new Item(itemID, quantity);
				orderItems.add(item);
			}
			return true;
		}
		return false;
	}
}
