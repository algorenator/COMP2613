package examples;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateParsingAndFormatting {
	
	public static void main(String[] args) {
		String dateString = "2015-08-04";
		LocalDate localDate = LocalDate.parse(dateString);
		System.out.println("Date: " + localDate);
		System.out.println("Year: " + localDate.getYear());
		System.out.println("Month: " + localDate.getMonth());
		System.out.println("Day: " + localDate.getDayOfMonth());

		String dateWithTimeString = "2015-08-04T10:11:30";
		LocalDateTime localDateTime = LocalDateTime.parse(dateWithTimeString);
		System.out.println("Date with Time: " + localDateTime);
		System.out.println("Hour: " + localDateTime.getHour());
		System.out.println("Minute: " + localDateTime.getMinute());
		System.out.println("Second: " + localDateTime.getSecond());
		
		DateTimeFormatter dateTimeForatter = DateTimeFormatter.ofPattern("dd MMM uuuu");
		String anotherDateString = "04 Aug 2015";
		LocalDate localDate2 = LocalDate.parse(anotherDateString, dateTimeForatter);
		System.out.println(anotherDateString + " parses to " + localDate2);
	}

}
