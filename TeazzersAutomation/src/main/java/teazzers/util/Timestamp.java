package teazzers.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Timestamp {
	public static  String format() {    
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   //System.out.println(dtf.format(now));
		   String format = dtf.format(now);
		return format;  
		  }
	

}
