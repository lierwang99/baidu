/**
 * 
 */
package robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

import baiduHome.Base;

/**
 * @author Administrator
 *
 */
public class Add {

	/**
	 * @param args
	 * @throws AWTException 
	 */
	public static void main(String[] args) throws AWTException {
		WebDriver driver = Base.getDriver("file:///H:/Desktop/javascript/zr.html");
		System.out.println(driver);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_SHIFT );
//		robot.keyPress(KeyEvent.VK_C);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.keyRelease(KeyEvent.VK_SHIFT );
//		robot.keyRelease(KeyEvent.VK_C);
//		Actions actions = new Actions();
		
		Add a = new Add();
		a.robotKeyEvent(KeyEvent.VK_CONTROL,KeyEvent.VK_SHIFT,KeyEvent.VK_C);
	}

	/**
	 * 
	 * @param arr
	 * @return
	 */
	public int summation(int... arr) {
		int result = 0;
		for (int x = 0; x < arr.length; x++) {
			result = result + arr[x];
		}
		return result;
	}

	/**
	 * 按键
	 * @param arr
	 * @return
	 */
	public String str(String... arr) {
		String result = null;
		for (int x = 0; x < arr.length; x++) {
			result = result + "-->" + arr[x];

		}
		result = result.replaceAll("null-->", "");
		return result;
	}
	public void robotKeyEvent(int ... keys) {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		for(int key:keys) {
			robot.keyPress(key);
			robot.delay(500);
		}
		for(int key:keys) {
			robot.keyRelease(key);
			robot.delay(200);
		}
	}
}
