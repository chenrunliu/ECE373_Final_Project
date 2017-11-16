package dataBase;
import java.io.Serializable;
public class Food extends Restaurant{
	
	private String foodName;
	private String foodIngredients;
	private double price;
	
	
	//constructor
	public Food() {
		
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price1) {
		this.price = price1;
	}
	
	//setters and getters
	public String getFoodName() {
		return this.foodName;
	}
	
	public void setFoodName(String foodname) {
		this.foodName = foodname;
	}
	
	public String getFoodIngredients() {
		return this.foodIngredients;
	}
	
	public void setFoodIndredients(String foodingredients) {
		this.foodIngredients = foodingredients;
	}

}
