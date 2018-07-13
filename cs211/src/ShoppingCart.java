import java.util.ArrayList;

public class ShoppingCart extends ArrayList<NumSelected> {

	private boolean discountSet;
	
	public ShoppingCart() {
		super();
	}
	
	public boolean add(NumSelected input_item) {
		
		// create array of current PKs in shopping cart
		ArrayList<Integer> currentPKs = new ArrayList<Integer>();
		
		for (NumSelected i : this) {
			currentPKs.add(i.getSku());
		}

		// if the PK is found in the shopping cart, drop it before readding it
		if (currentPKs.indexOf(input_item.getSku()) != -1) {
			super.remove(currentPKs.indexOf(input_item.getSku()));
		}
		
		// add the new PK to the shopping cart
		super.add(input_item);
		return true;
	}
	
	public void setDiscount(boolean input_flag) {
		discountSet = input_flag;
	}
	
	public double getTotal() {
		double total_cost = 0;
		
		for (NumSelected i : this) {
			total_cost += i.getPrice();
		}
		
		if (discountSet) {
			return total_cost * 0.9;
		} else {
			return total_cost;
		}
	}
}
