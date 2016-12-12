package examples;

import java.text.DateFormat;
import java.util.Calendar;

public class Shape {

	private final Calendar _date;

	public Shape() {
		_date = Calendar.getInstance();
	}

	public String getDateCreated() {
		return DateFormat.getDateTimeInstance().format(_date);
	}
}
