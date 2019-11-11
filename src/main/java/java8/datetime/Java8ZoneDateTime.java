package java8.datetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

class Java8ZoneDateTime {

	public static void main(String[] args) {
		try {
			
			ZonedDateTime zdt = ZonedDateTime.now();
			System.out.println("ZonedDateTime: " + zdt);
			
			ZoneId zoneId = zdt.getZone();
			System.out.println("zoneId: " + zoneId);
			
			ZoneId zoneIdIndia = ZoneId.of("Asia/Kolkata");
			System.out.println("zoneIdIndia: " + zoneIdIndia);
			
			ZonedDateTime zdtWithZoneId = ZonedDateTime.now(zoneIdIndia);
			System.out.println("ZonedDateTime with ZoneId: " + zdtWithZoneId);
			
			
			
			//OffsetDateTime odt = new OffsetDateTime.now();
			//System.out.println(odt);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
