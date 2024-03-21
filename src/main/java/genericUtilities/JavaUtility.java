package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * This utility consists of java specific methods
 * @author kabali
 *
 */
public class JavaUtility {
	
	/**
	 * This method return the current date in format
	 * @return
	 */
	public String getDate()
	
	{
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yy hh-mm-ss");
		String date = f.format(d);
		return date;
	}

}
