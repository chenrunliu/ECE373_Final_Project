package dataBase;
import java.io.Serializable;
import java.util.ArrayList;

public class Restaurant {

	private Person person;
	private Food food;
	ArrayList<Car> carList = new ArrayList<Car>();
	
	public Food getFood() {
		return this.food;
	}
	
	public void setFood(Food food1) {
		this.food = food1;
	}
	
	public Person getPerson() {
		return this.person;
	}
	
	public void setPerson(Person person1) {
		this.person = person1;
	}
	
	
}
