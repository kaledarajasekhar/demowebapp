package genaricutilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JavaUtility {

	public String getCalendarDetails(String pattern) {
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public List<String> sortStringA_Z(List<String> list) {
		return list.stream().sorted().collect(Collectors.toList());
	}

	public List<String> sortStringZ_A(List<String> list) {
		return list.stream().sorted((i1, i2) -> -i1.compareTo(i2)).collect(Collectors.toList());
	}

	public List<Double> sortDoubleLow_High(List<Double> list) {
		return list.stream().sorted().collect(Collectors.toList());
	}

	public List<Double> sortDoubleHigh_Low(List<Double> list) {
		return list.stream().sorted((i1, i2) -> i1 > i2 ? -1 : i1 < i2 ? 1 : 0).collect(Collectors.toList());
	}

}
