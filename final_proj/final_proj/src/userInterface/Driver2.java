package userInterface;

import dataBase.Car;
import dataBase.Customer;
import dataBase.Employee;
import dataBase.Food;
import dataBase.Order;
import dataBase.Person;
import dataBase.Restaurant;


public class Driver2 {


	
	
	public static void main(String[] args) {
	
		
		Restaurant restaurant = new Restaurant();
		Person person = new Person();
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		Food food = new Food();
		GUI newGUI;
	
		
		
		restaurant.setPerson(person);
		restaurant.setFood(food);
		
		food.setFoodName("Sushi Combination: Dragon Roll + Las Vegas Roll (12 pieces in each kind of roll)");
		food.setFoodIndredients("Dragon Roll: Eel, crab, and cucumber inside. Avocado outside.\nLas Vegas Roll: Cream cheese, avocado, yamagobo, crab, and assorted fish inside. The whole roll is deep-fried.");
	    food.setPrice(19.99); 	
		
		
		emp1.setName("Chenrun Liu");
		emp1.setID(0);
		emp1.setPhone("5200000000");
		emp1.setStatus(false);
		
		emp2.setName("Bowen Hu");
		emp2.setID(1);
		emp1.setPhone("5201111111");
		emp2.setStatus(true);
        
		person.addEmpToList(emp1);
		person.addEmpToList(emp2);
		
        
        newGUI = new GUI(restaurant);	
         
         
	}

	

}
