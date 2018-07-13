import java.util.ArrayList;

public class Chapter10Quiz {

	public static void main(String[] args) {

		ArrayList<CalendarDate> dates = new ArrayList<CalendarDate>();
        dates.add(new CalendarDate(10, 15, 2018));
        dates.add(new CalendarDate(10, 2, 2018));
        dates.add(new CalendarDate(10, 7, 2018));
		System.out.println("Before: " + dates);
		minToFront(dates);
		System.out.println("After moving minimum to front: " + dates);
		

	}
	
	public static void minToFront(ArrayList<CalendarDate> input_cal_array) {
		
		//minCalendarDate = input_cal_array.get(i);
		//minIndex = i;
		
		CalendarDate minCalendarDate = input_cal_array.get(0);
		int minIndex = 0;
		
		for (int i = 0; i <= input_cal_array.size() - 1; i++) {
			
			if ( input_cal_array.get(i).getYear() < minCalendarDate.getYear() ) {
				
				minCalendarDate = input_cal_array.get(i);
				minIndex = i;
				
			} else if ( input_cal_array.get(i).getYear() <= minCalendarDate.getYear()
					&& input_cal_array.get(i).getMonth() < minCalendarDate.getMonth()
					) {
				
				minCalendarDate = input_cal_array.get(i);
				minIndex = i;
				
			} else if (input_cal_array.get(i).getYear() <= minCalendarDate.getYear()
					&& input_cal_array.get(i).getMonth() <= minCalendarDate.getMonth()
					&& input_cal_array.get(i).getDay() < minCalendarDate.getDay()) {
				
				minCalendarDate = input_cal_array.get(i);
				minIndex = i;
				
			}
		}
		
		input_cal_array.remove(minIndex);
		input_cal_array.add(0, minCalendarDate);

	}
	
}
