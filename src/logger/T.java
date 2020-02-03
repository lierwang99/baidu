/**
 * 
 */
package logger;

import java.io.File;
import java.lang.reflect.Constructor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author Administrator
 *
 */
public class T {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) {
		Logger log = Logger.getGlobal();
		log.setLevel(Level.ALL);
		Class<?> cls = null;
		Class<?> cls1 = null;
		try {
			cls = Class.forName("java.util.Date");
			cls1 = Class.forName("java.text.SimpleDateFormat");
			Constructor<?> con = cls1.getConstructor(String.class);
			Object obj = cls.newInstance();
			Object obj1 = con.newInstance("yyyy-MM-dd");
			Date date = (Date) obj;
			SimpleDateFormat sdf = (SimpleDateFormat) obj1;
			String format = sdf.format(date);
			File fi = new File("H:\\Desktop\\java代码\\" + format + ".log");
//			输出一
			String absolutePath = fi.getAbsolutePath();
			System.out.println("absolutePath : "+absolutePath);
			SimpleFormatter simpleFormatter = new SimpleFormatter();
//			输出二
			FileHandler fileh = new FileHandler(absolutePath);
			fileh.setFormatter(simpleFormatter);
			System.out.println("是不是文件名 :"+fileh);
			
			
			
			fileh.setLevel(Level.FINEST);
			log.setUseParentHandlers(false);
			log.addHandler(fileh);

		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("a");
		log.fine("b");
		log.finer("c");
		log.finest("d");
		log.config("e");
		log.severe("f");
		log.warning("g");

	}

}
