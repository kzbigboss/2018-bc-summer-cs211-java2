import java.util.ArrayList;

public class Chapter10HW {

	public static void main(String[] args) {
		
		ArrayList<String> words = new ArrayList<String>();
		words.add("four");
		words.add("score");
		words.add("and");
		words.add("seven");
		words.add("years");
		words.add("ago");
		//words.add("blah");
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		// 3, 8, 92, 4, 2, 17, 9
		numbers.add(6);
		numbers.add(1);
		numbers.add(4);
		numbers.add(-2);
	
		
		
		System.out.println(numbers);
		System.out.println(numbers.size());
		System.out.println("");
		
		//swapPairs(words);
		//doubleList(words);
		minToFront(numbers);
		
		System.out.println(numbers);
		//System.out.println(numbers.size());
		

	}
	
	public static void swapPairs(ArrayList<String> input_array) {
		int range = input_array.size() / 2;
		
		for (int i = 0; i < range * 2; i+=2 ) {
			String holder1 = input_array.get(i);
			String holder2 = input_array.get(i+1);
			
			input_array.set(i, holder2);
			input_array.set(i+1, holder1);
			
		}
	}
	
	public static void doubleList(ArrayList<String> input_array) {
		int range = input_array.size() * 2;
		
		for (int i = 0; i < range; i +=2) {
			input_array.add(i, input_array.get(i));
		}
	}
	
	public static void minToFront(ArrayList<Integer> input_array) {
		int min = input_array.get(0);
		int minIndex = 0;
		
		for (int i = 0; i <= input_array.size() - 1; i++) {
			
			if (input_array.get(i) < min) {
				min = input_array.get(i);
				minIndex = i;
			}
		}
		
		input_array.remove(minIndex);
		input_array.add(0, min);
	}
}
