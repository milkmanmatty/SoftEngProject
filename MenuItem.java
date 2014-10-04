import java.math.*;

public class MenuItem {
	private String name;
	private BigDecimal cost;
	private int menuItemID;

	public MenuItem(String name, String cost) {
		this.menuItemID = DatabaseSystem.nextMenuItemID();
		this.name = name;
		this.cost = new BigDecimal(cost);
		this.cost = this.cost.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public MenuItem(int id, String name, String cost) {
		this.menuItemID = id;
		this.name = name;
		this.cost = new BigDecimal(cost);
		this.cost.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public int getMenuItemID() {
		return this.menuItemID;
	}

	public BigDecimal getCost() {
		return this.cost;
	}
}