/**
 * Class defining the elements of a wood type
 */
package model;

/**
 * @author USER
 *
 */
public class WoodItem {

	String type;
	Double baseDeliveryTime;
	Double price;
	Double quantity;
	Double deliveryTime;
	Double totalPrice;
	
	/**
	 * Default constructor 
	 */
	public WoodItem(){
		this.type = "Empty";
		this.baseDeliveryTime = 0.0;
		this.price = 0.0;
	}
	
	/**
	 * Constructor of a WoodItem element with parameters
	 * @param type Name of the wood type
	 * @param daseDeliveryTime base delivery time
	 * @param price price per Bare Foot
	 */
	public WoodItem(String type, Double daseDeliveryTime, Double price) {
		this.type = type;
		this.baseDeliveryTime = daseDeliveryTime;
		this.price = price;
	}
	
	public WoodItem(String type,Double quantity)
	{
		this.type=type;
		this.quantity=quantity;
		this.SetBaseDeliveryTimePrice(type);
		setTotalPrice();
		setDeliveryTime();
	}

	private void SetBaseDeliveryTimePrice(String type)
	{
	  switch(type)
	  {
		case "Cherry":
		 this.baseDeliveryTime=2.5;
		 this.price=5.95;
		 break;
		case "Curly Maple":
			this.baseDeliveryTime=1.5;
			this.price=6.0;
			break;
		case "Genuine Mahogany":
			this.baseDeliveryTime=3.0;
			this.price=9.60;
			break;
		case "Wenge":
			this.baseDeliveryTime=5.0;
			this.price=22.35;
			break;
		case "White Oak":
		    this.baseDeliveryTime=2.3;
		    this.price=6.70;
		    break;
		case "Sawdust":
			this.baseDeliveryTime=1.0;
			this.price=1.5;
		}
	}
	
	private void setTotalPrice()
	{
		this.totalPrice=this.quantity*this.price;
	}
	
	private void setDeliveryTime()
	{
		if ((1<=quantity) && (quantity<=100))
		{
			deliveryTime=1*baseDeliveryTime;
		}
		else if ((101<=quantity) && (quantity<=200))
		{
			deliveryTime=2*baseDeliveryTime;
		}
		else if ((201<=quantity) && (quantity<=300))
		{
			deliveryTime=3*baseDeliveryTime;
		}
		else if ((301<=quantity) && (quantity<=400))
		{
			deliveryTime=4*baseDeliveryTime;
		}
		else if ((401<=quantity) && (quantity<=500))
		{
			deliveryTime=5*baseDeliveryTime;
		}
		else if ((501<=quantity) && (quantity<=1000))
		{
			deliveryTime=5.5*baseDeliveryTime;
		}
		else
		{
			deliveryTime=0.0;
		}
	}
	/**
	 * Get the type of Wood
	 * 
	 * @return Name of the WoodItem
	 */
	public String getType() {
		return type;
	}

	/**
	 * Get the base delivery time
	 * 
	 * @return the baseDeliverytime
	 */
	public Double getDaseDeliveryTime() {
		return baseDeliveryTime;
	}

	/**
	 * 
	 * Get the price per Bare Foot
	 * 
	 * @return the price for 1 Bare Foot of this WoodItem
	 */
	public Double getPrice() {
		return price;
	}
	
	public Double getQuantity()
	{
		return this.quantity;
	}
	
	public Double getTotalPrice()
	{
		return this.totalPrice;
	}
	
	public Double getDeliveryTime()
	{
		return this.deliveryTime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * You may implement this method to fit your needs
	 */
	@Override
	public String toString() {	
		return "";
	}
	
}
