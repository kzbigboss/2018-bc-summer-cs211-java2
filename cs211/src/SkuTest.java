import java.io.FileNotFoundException;



public class SkuTest {

	public static void main(String[] args) throws FileNotFoundException {
    	Sku one = new Sku("book",13); // sku #49284
		Sku two = new Sku("book",13); // a different book
		Sku three = new Sku("another",42,10,399);
		System.out.println(one.equals(one));  // true
		System.out.println(one.equals(two));  // false
		System.out.println(one); // book, $13.00
		System.out.println(two.priceFor(123)); // 1599.0
		ShoppingCart basket = new ShoppingCart();
		System.out.println(basket.size()); // 0
		NumSelected five = new NumSelected(two,5); 
		NumSelected six = new NumSelected(three,4);		
		basket.add(five);
		basket.add(six);
		System.out.println(basket.size()); // 2 	
		System.out.println(three); // another, $42.00 (10 for $399.00)
		System.out.println(three.getSKU()); // 49286
		System.out.println(basket.getTotal());  // 233.0
		basket.add(new NumSelected(three,1));
		System.out.println(basket.getTotal());  // 107.0
		basket.add(new NumSelected(three,11)); // remove the 1, add 11
		System.out.println(basket.getTotal());  // 506.0
		basket.setDiscount(true);
		System.out.println(basket.getTotal());  // 455.4
	}

}
