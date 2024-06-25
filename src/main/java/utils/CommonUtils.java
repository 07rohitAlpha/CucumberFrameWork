package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {

	public static String getEmailWithTimeStamp() {

		Date date = new Date();
	//	return "urbanrohita" + date.toString().replace("","").replace(":", "_") + "@gmail.com";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String timestamp = sdf.format(date);
		return "urbanrohit" + timestamp + "@gmail.com";
		
	}
	public static void main (String[] args) {
		System.out.println(getEmailWithTimeStamp());
	}
	
	
	
	
}


