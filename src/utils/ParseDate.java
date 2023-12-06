package utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public abstract class ParseDate {

	private static DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
	private static DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

	public static LocalDate toDatetime(String date) {
		return LocalDate.parse(date, outputFormatter);
	}

	public static String toString(String inputDateTime) {
		LocalDateTime dateTime = LocalDateTime.parse(inputDateTime, inputFormatter);

		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		String formattedDateTime = dateTime.format(outputFormatter);

		return formattedDateTime;
	}

	public static Date asDate(LocalDate localDate) {
		if (localDate == null) {
			return null;
		}
		
		java.util.Date utilDate = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	    return new java.sql.Date(utilDate.getTime());
	}
}
