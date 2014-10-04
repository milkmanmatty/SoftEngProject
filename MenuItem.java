public class MenuItem {
	private String name;
	private double cost;
	private int menuItemID;

	public MenuItem(String name, double cost) {
		this.menuItemID = DatabaseSystem.nextMenuItemID();
		this.name = name;
		this.cost = cost;
	}

	public MenuItem(int id, String name, double cost) {
		this.menuItemID = id;
		this.name = name;
		this.cost = cost;
	}

	public int getMenuItemID() {
		return this.menuItemID;
	}

	public double getCost() {
		return this.cost;
	}
}