public class Item {
	private int quantity;
	private int itemID;

	public Item(int itemID, int quantity) {
		this.itemID = itemID;
		this.quantity = quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public int getItemID() {
		return this.itemID;
	}
}