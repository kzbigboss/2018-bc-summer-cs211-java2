public class NumSelected {
	
	private Sku item;
	private int quantity;
	
	public NumSelected(Sku item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return item.priceFor(quantity);
	}
	
	public int getSku() {
		return item.getSKU();
	}
	
	public String toString() {
		return item.priceFor(quantity)+"";
	}
	
}
