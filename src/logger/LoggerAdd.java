/**
 * 
 */
package logger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Administrator
 *
 */
public class LoggerAdd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Logger l = Logger.getGlobal();
//		先设置全局日志的等级，不使用默认配置文件的等级（logging.properties）文件中的
		l.setLevel(Level.ALL);
//		控制台顾问
		ConsoleHandler consoleHandler = new ConsoleHandler();
//		设置控制台等级
		consoleHandler.setLevel(Level.CONFIG);
//		不使用父辈的顾问
		l.setUseParentHandlers(false);
//		将设置控制台的等级增加到logger全局中
		l.addHandler(consoleHandler);
		
		l.severe("湖南省怀化市");
		l.warning("贵州省凯里市");
		l.info("安徽省宿州市");
		l.config("上海市");
		l.fine("北京市");
		l.finer("江苏省南京市");
		l.finest("浙江省杭州市");
	}
}