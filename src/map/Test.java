/**
 * 
 */
package map;

import java.awt.Robot;

import org.openqa.selenium.WebDriver;

import baiduHome.Base;

/**
 * @author Administrator
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = Base.getDriver("https://www.jianshu.com/p/d0d433cd26c2");
		
		
		
		Base base = new Base(driver);
//		base.scrollToY(0, 100);
//		base.mouseWheelY(5);
		
		   try {
	            Robot bot = new Robot();
	            bot.mouseMove(2000,300);
	            bot.setAutoDelay(100);
	            Thread.sleep(2000);
	            System.out.println("++");
	            bot.mouseWheel(25);
	            Thread.sleep(2000);
	            System.out.println("--");
	            bot.mouseWheel(-25);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	}

}
