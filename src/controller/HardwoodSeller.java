/**
 * 
 */
package controller;

import model.WoodItem;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

/**
 * @author Esteban
 *
 */
public class HardwoodSeller {

	private String buyerName;
	private String buyerAddress;
	private String purchaseDate;
	private List<String> orderStringList;
	private List<WoodItem> orderList;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 HardwoodSeller hardwoodSellerObj=new HardwoodSeller();
	 String filePath;
     System.out.println("Please enter the order file path");
     Scanner reader=new Scanner(System.in);
     filePath=reader.next();
     hardwoodSellerObj.readInputFile(filePath);
     hardwoodSellerObj.printOrderDetails();
	}
	
	public void readInputFile(String inputFilePath){
		String customerDetails;
		BufferedReader buffer=null;
		try
		{
		 buffer=new BufferedReader(new FileReader(inputFilePath));
		 customerDetails=buffer.readLine();
		 setCustomerDetails(customerDetails);
		 String orderLine=buffer.readLine();
		 orderStringList=new ArrayList<String>();
		 while (orderLine!=null)
		 {
			 setOrderStringList(orderLine);
			 orderLine=buffer.readLine();
		 }
		}
		catch(IOException e)
		{
			System.out.println("File could not be opened");
		}
		finally 
		{
			
			if (buffer!=null)
				try
			{
				buffer.close();
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
			}
		}
	
	private void setCustomerDetails(String customerDetails)
	{
		String[] customerDetailsArray=customerDetails.split(";");
		buyerName=customerDetailsArray[0];
		buyerAddress=customerDetailsArray[1];
		purchaseDate=customerDetailsArray[2];
		System.out.println(buyerName);
		System.out.println(buyerAddress);
		System.out.println(purchaseDate);
	}
	
	private void setOrderStringList(String orderLine)
	{
		String[] OrderLineArray=orderLine.split(";");
		for (int counter=0;counter<OrderLineArray.length;counter++)
		{
			orderStringList.add(OrderLineArray[counter]);
		}
		setOrderList();
	}
	
	private void setOrderList()
	{
		orderList=new ArrayList<WoodItem>();
		for (String orderString : orderStringList)
		{
			String[] orderStringArray=orderString.split(":");
			String woodType=orderStringArray[0];
			Double quantity=Double.parseDouble(orderStringArray[1]);
			WoodItem woodItemObj=new WoodItem(woodType,quantity);
			orderList.add(woodItemObj);
		}
	}
	
	private void printOrderDetails()
	{
		double totalPrice=0;
		double deliveryTime=0;
		System.out.println("Buyer Name: " + buyerName);
		System.out.println("Delivery Address: " + buyerAddress);
		System.out.println("The order details are as follows: ");
		for (WoodItem item : orderList)
		{
			System.out.print("WoodType : " + item.getType() + " ; ");
			System.out.print(" Quantity purchased : " + item.getQuantity() +"BF" + " ; ");
			System.out.println(" Price : $" + item.getTotalPrice());
			totalPrice=totalPrice+ item.getTotalPrice();
			if (deliveryTime<item.getDeliveryTime())
			{
				deliveryTime=item.getDeliveryTime();
			}
		}
		System.out.println("The estimated delivery time is : " + deliveryTime + "hours");
		System.out.println("The total price is : $" + totalPrice);
	}
	
	public Double deliveryTime(){
		Double deliveryETA = 0.0;
		return deliveryETA;
	}
	
}
