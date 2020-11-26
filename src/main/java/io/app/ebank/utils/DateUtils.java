package io.app.ebank.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public static Date getToday() {
		Calendar eventDate = Calendar.getInstance();
		return eventDate.getTime();		
	}
}
