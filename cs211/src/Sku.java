import java.text.*;

public class Sku {
	// delcare variables
	private String name;
	private double price;
	private int bulk_quantity;
	private double bulk_price;
	private int pkey;
	private static int pkey_start = 49284;
	
	public Sku(String name, double price, int bulk_quantity, double bulk_price) {
		
		validatePositive(price);
		validatePositive(bulk_quantity);
		validatePositive(bulk_price);
		
		this.name = name;
		this.price = price;
		this.bulk_quantity = bulk_quantity;
		this.bulk_price = bulk_price;
		this.pkey = assignPkey();
	}
	
	public Sku(String name, double price) {
		this(name, price, 0, 0);
	}
	
	private void validatePositive(double input_number) {
		if (input_number < 0) {
			throw new IllegalArgumentException("invalid numerical input");
		}
	}
	
	private int assignPkey() {
		pkey_start += 1;
		return pkey_start - 1;
	}
	
	public double priceFor(int quantity) {
		
		validatePositive(quantity);
		
		double total_price = 0;
		
		// no bulk qty set, then simple math
		if (this.bulk_quantity == 0)  {
			total_price += (price * quantity);
		
		// bulk qty set, loop to figure out total
		} else {
			
			while (quantity >= this.bulk_quantity) {
				
				total_price += this.bulk_price;
				quantity -= this.bulk_quantity;
			 }
			
			total_price += (price * quantity);
		}
		
		return total_price;
	}
	
	public int getSKU() {
		return this.pkey;
	}
	
	public boolean equals(Sku other) {
		return this.pkey == other.getSKU();
	}
	
	public String toString() {
		
		// leverage text formatting
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		
		
		// format dollar for price
		String priceFormatted = nf.format(price);
		
		// return result for individual price
		String result = this.name + ", " + priceFormatted;
		
		// append result if bulk quantity price set
		if (this.bulk_quantity != 0) {
			String bulk_priceFormatted = nf.format(this.bulk_price);
			result = result + " (" + bulk_quantity + " for " + bulk_priceFormatted + ")";
		}
		return result;
	}
}
