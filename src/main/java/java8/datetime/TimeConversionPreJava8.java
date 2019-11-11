package java8.datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

class TimeConversionPreJava8 {

	public static void main(String[] args) {
		try {
			
			Date date = new Date();			
			DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy HH:mm:ss");

			dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));  //here set timezone

			System.out.println("IST time: " + dateFormat.format(date));  
			
			dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));  //static UTC timezone
			System.out.println("UTC time: " + dateFormat.format(date));  
			
			dateFormat.setTimeZone(TimeZone.getTimeZone("EST"));  //static UTC timezone
			System.out.println("Don't use EST for TimeZone, as it doesn't cover Daylight time: " + dateFormat.format(date));  
			
			dateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));  //static UTC timezone
			System.out.println("Here is how it should be used (give timezone as America/New_York): " + dateFormat.format(date));  
			
			
			String str = dateFormat.format(date);
			Date date1  = dateFormat.parse(str);
			System.out.println(date1.toString());
			System.out.println(date1.getTime());
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
