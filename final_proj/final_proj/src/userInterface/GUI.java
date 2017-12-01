package userInterface;

import java.util.ArrayList;
import java.io.Serializable;

import dataBase.Car;
import dataBase.Customer;
import dataBase.Employee;
import dataBase.Food;
import dataBase.Order;
import dataBase.Person;
import dataBase.Restaurant;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.*;
public class GUI extends JFrame{

	
	//on the initial menu, user can see available delivery man and car assigned
	//on the initial menu, user can see food included, food ingredients, and food price in total
	private Restaurant restaurant;
	private JMenuBar menuBar;
	private JMenu Availability;
	private JMenuItem availableDeliveryMan;
	private JButton order;
	private JButton can;
	private JButton confirm;
	private JPanel pane;
	public int count = 0;
	private JFrame review;
	private Boolean cash;
	
	public GUI(Restaurant restaurant1) {
		super("Menu");
		restaurant = restaurant1;
		pane = new JPanel();
		setSize(1000, 1000);
		setLayout(new GridBagLayout());
		pane.setLayout(new GridBagLayout());
		pane.setAutoscrolls(true);
		GridBagConstraints con = new GridBagConstraints();
		con.gridx = 0;
		con.gridy = 0;
		
		JLabel title = new JLabel("<HTML><center><h2>Welcome to Online Restaurant</h2>" +
				"Choose an action from the above menus.<BR></center></HTML>");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		add(title, con);
		JLabel menuLabel = new JLabel("<HTML><center> <h3>Today's Menu</h3><BR></center></HTML>");
		pane.add(menuLabel, con);
		int x = 1;
		//1 food item
		JLabel foodItem = new JLabel("<HTML><center><div align='left'>"+x+". "+restaurant1.getFood().getFoodName()+"&emsp;&emsp;$"+restaurant1.getFood().getPrice()+"<BR><BR>Food Ingredients: "+restaurant1.getFood().getFoodIngredients()+"</div><BR><BR></center></HTML>");
		foodItem.setToolTipText(foodItem.getText());
		x += 1;
		con.gridx = 0;
		con.gridy = con.gridy + 1;
		pane.add(foodItem, con);
		//
		order = new JButton("Order");
		order.addActionListener(new ButtonListener());
		con.gridx = 0;
		con.gridy = con.gridy + 1;
		pane.add(order, con);
		JLabel OA = new JLabel("<HTML><BR><BR>Delivery Avaliability: "+DeliveryAvailability()+"<BR>Note: If the delivery availability shows 'no' then you probably need <BR>to wait at least 60 minutes after placing your order for delivery.</HTML>");
		con.gridx = 0;
		con.gridy = con.gridy + 1;
		pane.add(OA, con);
		pane.setBorder(new LineBorder(Color.BLUE));
		con.gridx = 0;
		con.gridy = 1;
		add(pane, con);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildGUI();	
		setVisible(true);
		pane.setVisible(true);
		pack();
	}
	
	public void buildGUI() {
		menuBar = new JMenuBar();
		Availability = new JMenu("Check Availability");
		availableDeliveryMan = new JMenuItem("Check Delivery Man's Status");
		
		availableDeliveryMan.addActionListener(new MenuListener());
		Availability.add(availableDeliveryMan);
		menuBar.add(Availability);
		
		setJMenuBar(menuBar);
	}
	
	public String DeliveryAvailability() {
		
		for(int i=0;i<restaurant.getPerson().getEmployeeList().size();i++) {
			if(restaurant.getPerson().getEmployeeList().get(i).getStatus() == true) {
				return "yes";
			}
		}
		
		return "no";
	}
	
	private class MenuListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			JMenuItem source = (JMenuItem)(e.getSource());
			
			if(source.equals(availableDeliveryMan)) {
				PrintDeliveryMan();
			}
		}
		
		public void PrintDeliveryMan() {
			JFrame window = new JFrame("Available Delivery Man Info");
			setLayout(new FlowLayout(FlowLayout.LEFT));
			JTextArea textArea = new JTextArea(500,500);
			JScrollPane scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			
		for(int i=0;i<restaurant.getPerson().getEmployeeList().size();i++) {
			if(restaurant.getPerson().getEmployeeList().get(i).getStatus() == true) {
			textArea.append("Name: "+restaurant.getPerson().getEmployeeList().get(i).getName()+"          ID: "+restaurant.getPerson().getEmployeeList().get(i).getID()+"\n");
			}
		}
			window.add(scrollPane);
			window.setVisible(true);
			window.setSize(500, 500);
		}
		
		
	}
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			if (source.equals(order)) {
				
				
				
				JTextField field1 = new JTextField();
				JTextField field2 = new JTextField();
				JTextField field3 = new JTextField();
				JTextField field4 = new JTextField();
				JTextField field5 = new JTextField();
				
				Customer cus = new Customer();
				restaurant.getPerson().addCusToList(cus);
				
				Object[] fields = {
						"Name: ", field1,
						"Phone: ", field2,
						"Address:", field3,
						"Special Needs:", field4,
						"Payment Method: (Type 'Card' or 'Cash')", field5
				};
				
				JOptionPane.showInputDialog(null, fields, "Customer Info & Payment", JOptionPane.OK_CANCEL_OPTION);
			
				if(field1.getText().equals("")){
					
					JOptionPane.showMessageDialog(null, 
													"Please enter correct name", 
													"Empty Customer Name", 
													JOptionPane.PLAIN_MESSAGE);
				}
				
				else {   //field1
					
					restaurant.getPerson().getCustomerList().get(count).setName(field1.getText());
					System.out.println(restaurant.getPerson().getCustomerList().get(count).getName());
				}
				
				if(field2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, 
							"Please enter correct phone number", 
							"Empty Customer Phone Number", 
							JOptionPane.PLAIN_MESSAGE);
				}
				
				else {   //field2
					restaurant.getPerson().getCustomerList().get(count).setPhone(field2.getText());
					System.out.println(restaurant.getPerson().getCustomerList().get(count).getPhone());
				}
				
				if(field3.getText().equals("")) {
					JOptionPane.showMessageDialog(null, 
							"Please enter correct Address", 
							"Empty Customer Address", 
							JOptionPane.PLAIN_MESSAGE);
				}
				
				else {   //field3
					restaurant.getPerson().getCustomerList().get(count).setAddress(field3.getText());
					System.out.println(restaurant.getPerson().getCustomerList().get(count).getAddress());
				}
				
				
				//feild4 action
				restaurant.getPerson().getCustomerList().get(count).setNeeds(field4.getText());
				System.out.println(restaurant.getPerson().getCustomerList().get(count).getNeeds());
				
				//field5
				if(field5.getText().equals("")) {
					JOptionPane.showMessageDialog(null, 
							"Please enter correct Payment Method", 
							"Empty Customer Payment Method", 
							JOptionPane.PLAIN_MESSAGE);
				}
				
				else if(!(field5.getText().equals("Card")|field5.getText().equals("Cash"))) {
					JOptionPane.showMessageDialog(null, 
							"Please enter correct Payment Method", 
							"Wrong Type of Payment Method", 
							JOptionPane.PLAIN_MESSAGE);
				}
				
				
				else {   //field5
					restaurant.getPerson().getCustomerList().get(count).setPaymentMethod(field5.getText());
					if(field5.getText().equals("Card")) {
						cash = false;
						CardPaymentInfo(count);
					}
					
					else {
						cash = true;
						CashPayment(count);
					}
				}
				count++;
				
			}
			
		}
	}
	
	public void CardPaymentInfo(int count) {
		JTextField field1 = new JTextField();
		JTextField field2 = new JTextField();
		JTextField field3 = new JTextField();
		JTextField field4 = new JTextField();
		JTextField field5 = new JTextField();
		
		Customer cus = new Customer();
		restaurant.getPerson().addCusToList(cus);
		
		Object[] fields = {
				"Card Holder: ", field1,
				"Card Number: ", field2,
				"Expiration Date:(month+last 2 digit of year)", field3,
				"SSV:", field4,
				"Billing Address", field5
		};
		
		JOptionPane.showInputDialog(null, fields, "Card Payment Info", JOptionPane.OK_CANCEL_OPTION);
		
		if(field1.getText().equals("")) {
			JOptionPane.showMessageDialog(null, 
					"Please enter correct Card Holder Name", 
					"Empty Card Holder Name", 
					JOptionPane.PLAIN_MESSAGE);
		}
		
		else {   //field1
			restaurant.getPerson().getCustomerList().get(count).setHolder(field1.getText());
			System.out.println(restaurant.getPerson().getCustomerList().get(count).getHolder());
		}
		
		if(field2.getText().equals("")) {
			JOptionPane.showMessageDialog(null, 
					"Please enter correct Card Number", 
					"Empty Card Number", 
					JOptionPane.PLAIN_MESSAGE);
		}
		
		else {   //field2
			restaurant.getPerson().getCustomerList().get(count).setCardNumber(field2.getText());
			System.out.println(restaurant.getPerson().getCustomerList().get(count).getCardNumber());
		}
		
		if(field3.getText().equals("")) {
			JOptionPane.showMessageDialog(null, 
					"Please enter correct expiration date", 
					"Empty Card expiration date", 
					JOptionPane.PLAIN_MESSAGE);
		}
		
		else {   //field3
			restaurant.getPerson().getCustomerList().get(count).setEXPDate(field3.getText());
			System.out.println(restaurant.getPerson().getCustomerList().get(count).getEXPDate());
		}
		
		if(field4.getText().equals("")) {
			JOptionPane.showMessageDialog(null, 
					"Please enter correct Card SSV", 
					"Empty Card SSV", 
					JOptionPane.PLAIN_MESSAGE);
		}
		
		else {   //field4
			restaurant.getPerson().getCustomerList().get(count).setSSV(field4.getText());
			System.out.println(restaurant.getPerson().getCustomerList().get(count).getSSV());
		}
		
		if(field5.getText().equals("")) {
			JOptionPane.showMessageDialog(null, 
					"Please enter correct Billing Address", 
					"Empty Billing Address", 
					JOptionPane.PLAIN_MESSAGE);
		}
		
		else {   //field5
			restaurant.getPerson().getCustomerList().get(count).setBillingAddress(field5.getText());
			System.out.println(restaurant.getPerson().getCustomerList().get(count).getBillingAddress());
			reviewOrder(count);
		}
	
	}
	
	public void reviewOrder(int count) {
		String t; 
		if (cash == true) {
			t = "Cash";
		} else {
			t = "Card";
		}
		JFrame review = new JFrame();
		JPanel content = new JPanel();
		JLabel label = new JLabel("<HTML><h2>Order Review</h2></HTML>");
		JLabel fname = new JLabel("<HTML><center>Item<BR></center></HTML>");
		JLabel fquantity = new JLabel("<HTML><center>Quantity<BR></center></HTML>");
		JLabel fprice = new JLabel("<HTML><center>Price<BR></center></HTML>");
		JLabel fnamec = new JLabel("<HTML><center>"+restaurant.getFood().getFoodName()+"</center></HTML>");
		JLabel fquantityc = new JLabel("1");
		JLabel fpricec = new JLabel("<HTML><center>$"+String.valueOf(restaurant.getFood().getPrice())+"</center></HTML>");
		JLabel total = new JLabel("<HTML></center>Amount: $"+String.valueOf(restaurant.getFood().getPrice())+"</center></HTML>");
		JLabel info = new JLabel("<HTML> Customer Name: "+restaurant.getPerson().getCustomerList().get(count).getName()+"<BR> Customer Phone: "+restaurant.getPerson().getCustomerList().get(count).getPhone()+"<BR> Delivery Address: "+restaurant.getPerson().getCustomerList().get(count).getAddress()+"<BR> Payment Type: "+t+"</HTML>");
		JLabel space = new JLabel("<HTML>&emsp;</HTML>");
		JLabel space1 = new JLabel("<HTML>&emsp;</HTML>");
		JLabel space2 = new JLabel("<HTML>&emsp;</HTML>");
		JLabel space3 = new JLabel("<HTML>&emsp;</HTML>");
		JButton confirm = new JButton("Confirm");
		JButton can = new JButton("Cancel");
		can.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == can) {
					review.dispose();
				}
			}
		});
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				review.dispose();
				JOptionPane.showMessageDialog(null, "Your order has been made. Please allow 30 to 60 minutes to deliver.");
			}
		});
		
		review.setVisible(true);
		review.setLayout(new GridBagLayout());
		review.setSize(new Dimension(1000, 1000));
		content.setVisible(true);
		content.setLayout(new GridBagLayout());
		content.setBorder(new LineBorder(Color.BLUE));
		GridBagConstraints cons = new GridBagConstraints();
		cons.gridx = 0;
		cons.gridy = 0;
		review.add(label, cons);
		cons.gridx = 0;
		cons.gridy = 0;
		content.add(fname,  cons);
		cons.gridx = 1;
		content.add(fquantity, cons);
		cons.gridx = 2;
		content.add(fprice, cons);
		cons.gridx = 0;
		cons.gridy = cons.gridy+1;
		content.add(space, cons);
		cons.gridy = cons.gridy+1;
		content.add(fnamec,  cons);
		cons.gridx = cons.gridx+1;
		content.add(fquantityc, cons);
		cons.gridx = cons.gridx+1;
		content.add(fpricec, cons);
		cons.gridy = cons.gridy+1;
		content.add(space1, cons);
		cons.gridy = cons.gridy + 1;
		cons.gridx = 0;
		content.add(total, cons);
		cons.gridy = cons.gridy+1;
		content.add(space2, cons);
		cons.gridy = cons.gridy + 1;
		content.add(info, cons);
		cons.gridy = cons.gridy+1;
		content.add(space3, cons);
		cons.gridy = cons.gridy + 1;
		content.add(confirm, cons);
		cons.gridx = 1;
		content.add(can, cons);
		cons.gridy = 1;
		cons.gridx = 0;
		review.add(content, cons);
		review.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public void CashPayment(int count) {
		JFrame csh = new JFrame();
		JLabel ttle = new JLabel("<HTML><center><h2>Customer Info and Payment</h2></center><HTML>");
		JLabel msg = new JLabel("<HTML><center>Cash selected. Please note the delivery man only carries at most $50</center></html>");
		JButton cont = new JButton("Continue");
		cont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				csh.dispose();
				reviewOrder(count);
			}
		});
		csh.setVisible(true);
		csh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		csh.setSize(500, 500);
		csh.setLayout(new GridBagLayout());
		GridBagConstraints cnst = new GridBagConstraints();
		cnst.gridx = 0;
		cnst.gridy = 0;
		csh.add(ttle, cnst);
		cnst.gridy = 1;
		csh.add(msg, cnst);
		cnst.gridy = 2;
		csh.add(cont, cnst);
	}
	
	
}