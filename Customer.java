import java.util.*;

public class Customer {
	private int cusID;
	private String name;
	private String phone;
	private String address;
	private String cCard;
	private ArrayList<Order> customerOrders = new ArrayList<Order>();


	public Customer(String name, String phone, String address, String cCard) {
		this.cusID = DatabaseSystem.nextCusID();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.cCard = cCard;
	}

	public void finishOrder(Order order) {
		customerOrders.add(order);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCCard(String cCard) {
		this.cCard = cCard;
	}

	public int getCusID() {
		return this.cusID;
	}

	public String getName() {
		return this.name;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getAddress() {
		return this.address;
	}

	public String getCCard() {
		return this.cCard;
	}

}