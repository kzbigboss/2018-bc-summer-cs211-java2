import java.util.ArrayList;

public class Quiz10 {
	public static void main(String[] args) {

		ArrayList<CalendarDate> dates = new ArrayList<CalendarDate>();
		dates.add(new CalendarDate(5, 5, 2018));
        dates.add(new CalendarDate(10, 2, 2018));
        dates.add(new CalendarDate(10, 7, 2011));
		System.out.println("Before: " + dates);
		minToFront(dates);
		System.out.println("After moving minimum to front: " + dates);
	}
	
	public static void minToFront(ArrayList<CalendarDate> input_cal_array) {
		
		// create  variables to track min date and index
		CalendarDate minCalendarDate = input_cal_array.get(0);
		int minIndex = 0;
		
		for (int i = 0; i <= input_cal_array.size() - 1; i++) {
			
			if ( input_cal_array.get(i).getYear() < minCalendarDate.getYear() ) {
				// if year is less than date, assign min date and index
				minCalendarDate = input_cal_array.get(i);
				minIndex = i;
				
			} else if ( input_cal_array.get(i).getYear() <= minCalendarDate.getYear()
					&& input_cal_array.get(i).getMonth() < minCalendarDate.getMonth()
					) {
				// if year is equal and month is less than date, assign min date and index
				minCalendarDate = input_cal_array.get(i);
				minIndex = i;
				
			} else if (input_cal_array.get(i).getYear() <= minCalendarDate.getYear()
					&& input_cal_array.get(i).getMonth() <= minCalendarDate.getMonth()
					&& input_cal_array.get(i).getDay() < minCalendarDate.getDay()) {
				// if year+month are equal and day is less, assign min date and index
				minCalendarDate = input_cal_array.get(i);
				minIndex = i;
				
			}
		}
		
		// alter input array to move min date to front of array
		input_cal_array.remove(minIndex);
		input_cal_array.add(0, minCalendarDate);

	}
}
