/**
 * 
 */
package robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Administrator
 *
 */
public class Wait {

	/**
	 * @param args
	 */
	static long timeOutInSeconds = 20 ;	//超时秒数
	static long sleepInMillis = 100 ;		//睡眠毫秒
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait webDriverWait = new WebDriverWait(driver,timeOutInSeconds,sleepInMillis);
		
	}

}
