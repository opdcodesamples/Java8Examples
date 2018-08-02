package java8.datetime;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

class Java8TimeClasses {

	public static void main(String[] args) {
		try {
			
			Instant instant = Instant.now();
			long instantMilliseconds = instant.toEpochMilli();
			long systemCurrentMilliseconds = System.currentTimeMillis();
			
			System.out.println("Instant milliseconds: " + instantMilliseconds);
			System.out.println("System milliseconds: " + systemCurrentMilliseconds);
			System.out.println("System - Instant milliseconds " + (systemCurrentMilliseconds - instantMilliseconds));
			
			System.out.println("Date: " + new Date());
			
			ZonedDateTime zdt = ZonedDateTime.now();
			System.out.println("ZonedDateTime: " + zdt);
			
			LocalDateTime ldt = LocalDateTime.now();
			System.out.println("LocalDateTime: " + ldt);
			
			LocalTime lt = LocalTime.now();
			System.out.println("LocalTime: " + lt);
			
			LocalDate ld = LocalDate.now();
			System.out.println("LocalDate : " + ld);
			
			LocalDateTime ldt2 = LocalDateTime.now();
			System.out.println("LocalDateTime toLocalTime: " + ldt2.toLocalTime());
			
			//OffsetDateTime odt = new OffsetDateTime.now();
			//System.out.println(odt);
			
			System.out.println("Calendar getTime: " + Calendar.getInstance().getTime());
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			System.out.println("Calendar getTime: " + cal.getTime());
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			System.out.println(sdf.parse("02-03-2015"));
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
