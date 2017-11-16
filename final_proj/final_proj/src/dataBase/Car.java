package dataBase;

import java.io.Serializable;

public class Car extends Restaurant{

	private String carBrand;    //each car has a brand name
	private String carPlate;    //each car has a plate number
	private Employee empAssignedTo;    //each car is assigned to an specific delivery man
	
	//constructor
	public Car() {
		
	}
	
	//setters and getters
	public String getBrand() {
		return this.carBrand;
	}
	
	public void setBrand(String brand) {
		this.carBrand = brand;
	}
	
	public String getPlate() {
		return this.carPlate;
	}
	
	public void setPlate(String plate) {
		this.carPlate = plate;
	}
	
	public Employee getEmp() {
		return this.empAssignedTo;
	}
	
	public void setEmp(Employee emp) {
		this.empAssignedTo = emp;
	}
	
	public void addToList() {
		super.carList.add(this);
	}
	
}
