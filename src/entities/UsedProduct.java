package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date manufacturaDate;
	
	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, Date manufacturaDate) {
		super(name, price);
		this.manufacturaDate = manufacturaDate;
	}

	public Date getManufacturaDate() {
		return manufacturaDate;
	}

	public void setManufacturaDate(Date manufacturaDate) {
		this.manufacturaDate = manufacturaDate;
	}
	
	@Override
	public String priceTag() {
		return super.getName() + " (used) $ " + super.getPrice() + " (Manufacture date: " + sdf.format(manufacturaDate) + ")";
	}
	
}
