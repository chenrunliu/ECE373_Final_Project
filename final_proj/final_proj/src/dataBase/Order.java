package dataBase;
import java.io.Serializable;
public class Order {
	
	private Food food;
	private int orderID;
	private Employee empAssignedTo;
	private boolean isDelivered;
	private Customer customer;
	
	//constructor
	public Order() {
		
	}
	
	public Food getFood() {
		return this.food;
	}
	
	public void setFood(Food food1) {
		this.food = food1;
	}
	
	public int getOrderID() {
		return this.orderID;
	}
	
	public void setOrderID(int orderid) {
		this.orderID = orderid;
	}
	
	public Employee getEmployee() {
		return this.empAssignedTo;
	}
	
	public void setEmployee(Employee emp) {
		this.empAssignedTo = emp;
	}
	
	public boolean getStatus() {
		return this.isDelivered;
	}
	
	public void setStatus(boolean status) {
		this.isDelivered = status;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}
	
	public void setCustomer(Customer customer1) {
		this.customer = customer1;
	}
	
}
