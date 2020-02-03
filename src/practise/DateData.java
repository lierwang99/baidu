/**
 * 
 */
package practise;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 *
 */
public class DateData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS");
		String format = simpleDateFormat.format(date);
		System.out.println(format);

	}

}
