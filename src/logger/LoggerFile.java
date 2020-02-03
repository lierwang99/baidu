/**
 * 
 */
package logger;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author Administrator
 *
 */
public class LoggerFile {

	/**
	 * 不在控制台输出日志信息，而是在文件输出日志信息
	 * @param args
	 * @throws Exception
	 * @throws SecurityException
	 */
	public static void main(String[] args) throws Exception {
//		全局记录器
		Logger l = Logger.getGlobal();
//		设置全局等级
		l.setLevel(Level.ALL);
//		文件顾问，true追加记录
		FileHandler fileHandler = new FileHandler("H:\\Desktop\\java代码\\123.log", true);
//		简单格式
		SimpleFormatter simpleFormatter = new SimpleFormatter();
//		文件设置以简单格式输出
		fileHandler.setFormatter(simpleFormatter);
//		设置输出到文件的等级
		fileHandler.setLevel(Level.FINE);
		l.setUseParentHandlers(true);
		l.addHandler(fileHandler);
		

//		可以让所有的都输出两遍:控制l.setUseParentHandlers(false);
		/*
		 * Handler[] handlers = l.getParent().getHandlers();
		 * System.out.println(handlers.length); for (Handler h : handlers) { String n =
		 * h.getClass().getName(); System.out.println("名字 ：" + n); }
		 * System.out.println("------------------------------------------------------");
		 * handlers[0].setLevel(Level.ALL);
		 */

		l.severe("湖南省怀化市");
		l.warning("贵州省凯里市");
		l.info("安徽省宿州市");
		l.config("上海市");
		l.fine("北京市");
		l.finer("江苏省南京市");
		l.finest("浙江省杭州市");
	}
}
