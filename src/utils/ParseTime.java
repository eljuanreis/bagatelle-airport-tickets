package utils;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public abstract class ParseTime {

	private static SimpleDateFormat inputFormatter = new SimpleDateFormat("HH:mm");
	private static SimpleDateFormat outputFormatter = new SimpleDateFormat("HH:mm:ss");

	public static LocalTime toLocalTime(String time) {
		Date date;

		try {
			date = inputFormatter.parse(time);
			return new Time(date.getTime()).toLocalTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}


	public static String toString(LocalTime localTime) {
		if (localTime == null) {
			return null;
		}
		Date date = Time.valueOf(localTime);
		return outputFormatter.format(date);
	}

	public static Time asTime(LocalTime localTime) {
		if (localTime == null) {
			return null;
		}
		return Time.valueOf(localTime);
	}
}
