README.md
https://github.com/chenrunliu/ECE373_Lab5_Liu
Final Project Progress Report
 
Stage One Progress Goal (~11/13/2017)
1.       All classes based on proposal created.
2.       Make sure all classes¡¯ relationships are correct.
3.       Fill out all concepts in all classes including constructs, setters, and getters.
4.       Create GUI user interface which display a initial menu.
5.       Correctly shows welcome words and menu bar on the GUI.
 
Code Tests
1.       First, made sure no error or wrong spelling in all codes.
2.       Made sure all classes relationship were correct based on proposal.
3.       Created a Menu GUI, and correctly displayed it.
4.       Tested a feature of it which displays available delivery man.
  

    















(Below are codes used to test, which can also be seen in Driver2.java)

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
	     	
		emp1.setName("Chenrun Liu");
		emp1.setID(0);
		emp1.setStatus(false);
		
		emp2.setName("Bowen Hu");
		emp2.setID(1);
		emp2.setStatus(true);
        
		person.addEmpToList(emp1);
		person.addEmpToList(emp2);
		
	//	System.out.println(restaurant.getPerson().getEmployeeList().get(0).getName());
	//System.out.println(restaurant.getPerson().getEmployeeList().get(0).getName());
      
       // Instantiate GUI
        
        newGUI = new GUI(restaurant);	
         
         
	}

	

}




Things Accomplished
1.       Finished All required Classes Set up(including class constructor, setters and getters).
2.       Corrected and Verified All required Classes¡¯ Relationship (determined super classes and child classes).
3.       Created Driver2.java and GUI.java to test initial user interface functions.
4.       In GUI.java, finished initial set up including a start menu which shows welcome message and a menu bar which shows available delivery man.
5.       In Driver2.java, Set up concepts required by initial testing(which can be seen above).
6.       Corrected and verified codes in both Driver2.java and GUI.java to meet all requirement mentioned above(which can be seen above in 4). 
Overall, all stage one goals are accomplished.
 
Things Changed From Proposal
1.       Added Car class, Order class, and GUI class.
2.       Deleted Review class, plan to add review feature in GUI.java.
3.       Deleted Menu class, added Restaurant class instead.
4.       Added fields in Restaurant class: Person person, and Food food(including their setters and getters).
5.       Changed People class name to Person.
6.       Deleted methods in original People class which were checkStatus and assignDelivery and added addEmpToList method.
7.       In Employee class, changed assignedCustomer field to orderAssigned(including relative changes of setter and getter) and added car and iD field, their setters and getters. Additionally, deleted addEmployee method
8.       In Customer class, added orderPlaced and billingAddress fields including their setters and getters. Deleted addCustomer method.
9.       For initial menu GUI, added new feature which displays available delivery man info.
 
Future Plans
1.       11/20/2017: Finish GUI.java file to meet every requirement made in final project proposal.
11/21/2017: Demo the project to instructor or TA and ask for advise to see what needs to be improved



(Below is the updated poposal)

































Online Restaurant 












Chenrun Liu

Nick Teves


















ECE 373
Dr. Marefat


Domain description
Generally, people can see a menu on the Online Restaurant with only one combinations of food including names, ingredients, and prices, which are all stored in the menu class already, and then they can order online by clicking order button (note that each person can only order the food combination with quantity 1), and then a customer info panel shall be displayed with special needs (people can state what specific vegetables they don¡¯t want, ect.). After filling out every field required (if any field is empty then order cannot be reviewed and a window shall jumps out to notify customer), the customer can click payment type card or cash button to process further. After both payment type selected, a panel including payment type review (if card selected, then more info requires from customer shall be applied) shall be displayed. In addition, after the payment type panel, customer can click continue button to get another panel which shows every detail of the order. Finally, by clicking confirm button the order shall be done and a window shall jumps out to notify the customer after that. On the other side, if cancel button selected, then the order cannot be reviewed, meanwhile back to the initial menu panel.
Constraints Analysis
Although chain restaurant usually have GPS to locate user position and would have nearest choice for them, we will only assume there is only one restaurant they can choose here. Besides, we won¡¯t apply any picture for the food on menu, but only the name and description.











Domain analysis
Restaurant
- person: Person
- food: Food
- carList: ArrayList<Car>
+ getPerson(): Person
+ setPerson(p: Person): void
+ getFood(): Food
+ setFood(food1: Food): void


Food (extends Restaurant)
- name: String
- ingred: String
- price: double
+ getName():String
+ setName(String name1): void
+ getIngred(): String
+ setIngred(String ingred1): void
+ getPrice(): double
+ setPrice(double price1): void


Person (extends Restaurant) 
- employee: ArrayList<Employee>
- customer: ArrayList<Customer>
+ getEmployeeList(): ArrayList<Employee> 
+ addEmpToList(emp1: Employee)







Employee (extend People)
- name: String
- phone: String
- isAvailable: boolean
- iD: int
- car: Car
- assignedOrder: Order
+ getName(): String
+ setName(String name1): void
+ getPhone(): String
+ setPhone(String phone1): void
+ getStatus(): boolean
+ setStatus(boolean status1): void
+ getOrderAssigned(): Order
+ setOrderAssigned(Order order1): void
+ addEmployee(): void
+ getCar(): Car
+ setCar(Car car1): void
+ getID(): int
+ setID(int id): void

Customer (extend People)
- name: String
- phone: String
- address: String
- payMethod: String
- cardNum: String
- cardEXP: String
- cardSSV: String
- order: orderPlaced
- billingAddress: String
+ getName(): String
+ setName(String name1): void
+ getPhone(): String
+ setPhone(String phone1): void
+ getAddress(): String
+ setAddress(String address1): void
+ getPayMethod(): String
+ setPayMethod(String pm): void
+ getCardNum(): String
+ setCardNum(String cm): void
+ getCardEXP(): String
+ setCardEXP(String exp): void
+ getCardSSV(): String
+ setCardSSV(String ssv): void
+ getOrderPlaced(): Order
+ setOrderPlaced(Order order1): void
+ getBillingAddress(): String
+ setBillingAddress(String billingaddress):void
+ AddToList(): void

Car (extends Restaurant)
- carBrand: String
- carPlate: String
- empAssignedTo: Employee
+ addToList(): void
+ getCarBrand(): String
+ setCarBrand(brand: String): void
+ getCarPlate(): String
+ setCarPlate(plate: String): void
+ getEMP(): Employee
+ setEMP(emp1: Employee): void

Order
- food: Food
- orderID: int
- empAssignedTo: Employee
- isDelivered: boolean
- customer: Customer
+ getFood(): Food
+ setFood(food: Food): void
+ getID(): int
+ setID(id: int): void
+ getEMP(): Employee
+ setEMP(emp1: Employee): void
+ getStatus(): boolean
+ setStatus(status: boolean): void
+ getCus(): Customer
+ setCus(customer1: Customer): void



Interaction analysis

(On the initial menu, a new feature which displaying available delivery man option has been added, updated on 11/13/2017 )




































Above shows how the order review shall be printed.




Above shows how the receipt shall be printed.


Plan of work
Chenrun Liu shall set up all basic project classes (create empty project classes). The rest of work needs team members work together, so team meetings must be required, which can be done in person or using Skype. 
10/25/2017: Finish proposal
11/10/2017: Finish basic classes build (create all three project classes including constructors, getters, setters, and methods required, which can all be empty at first)
11/15/2017: Finish All classes¡¯ methods.
11/20/2017: Finish All GUI and verify the project meets every requirement.
If there still has time left after 11/20/2017, we can add more work like adding more features to the project.