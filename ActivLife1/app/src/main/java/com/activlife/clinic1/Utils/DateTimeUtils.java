package com.activlife.clinic1.Utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateTimeUtils {

	private static String DateTimeFormat = "dd-MM-yyyy HH:mm:ss.SSSZ";
	
	public static SimpleDateFormat getSimpleDateFormat () {
		return new SimpleDateFormat(DateTimeUtils.DateTimeFormat, Locale.US);
	}
}
