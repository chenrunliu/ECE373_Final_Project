package dataBase;
import java.io.Serializable;
public class Customer extends Person{

	private String name;
	private String phone;
	private String address;
	private String specialNeeds;
	private String paymentMethod;
	private String cardHolder;
	private String cardNumber;
	private String expDate;
	private String SSV;
	private String billingAddress;
	private Order orderPlaced;
	
	
	//constructor
	public Customer() {
		
	}
	
	//setters and getters
	public String getName() {
		return this.name;
	}
	
	public void setName(String name1) {
		this.name = name1;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String phone1) {
		this.phone = phone1;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address1) {
		this.address = address1;
	}
	
	public String getNeeds() {
		return this.specialNeeds;
	}
	
	public void setNeeds(String needs) {
		this.specialNeeds = needs;
	}
	
	public String getPaymentMethod() {
		return this.paymentMethod;
	}
	
	public void setPaymentMethod(String paymentmethod1) {
		this.paymentMethod = paymentmethod1;
	}
	
	public String getCardNumber() {
		return this.cardNumber;
	}
	
	public void setCardNumber(String cardnumber1) {
		this.cardNumber = cardnumber1;
	}
	
	public String getEXPDate() {
		return this.expDate;
	}
	
	public void setEXPDate(String exp) {
		this.expDate = exp;
	}
	
	public String getSSV() {
		return this.SSV;
	}
	
	public void setSSV(String ssv) {
		this.SSV = ssv;
	}
	
	public String getBillingAddress() {
		return this.billingAddress;
	}
	
	public void setBillingAddress(String billingaddress1) {
		this.billingAddress = billingaddress1;
	}
	
	public Order getOrderPlaced() {
		return this.orderPlaced;
	}
	
	public void setOrderPlaced(Order order) {
		this.orderPlaced = order;
		order.setCustomer(this);                                    //assign order placed by this customer
	}
	
	//add to personList
	public void addToList() {
		super.customerList.add(this);
	}
	public void setHolder(String holder) {
		this.cardHolder = holder;
	}
	public String getHolder() {
		return this.cardHolder;
	}
	
}
