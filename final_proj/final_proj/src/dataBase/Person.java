package dataBase;
import java.io.Serializable;
import java.util.ArrayList;

public class Person extends Restaurant{
	ArrayList<Employee> employeeList=new ArrayList<Employee>();
	ArrayList<Customer> customerList=new ArrayList<Customer>();
	
	public ArrayList<Employee> getEmployeeList(){
		return this.employeeList;
	}
	
	
	public void addEmpToList(Employee emp1) {
		employeeList.add(emp1);	
	}
	

}