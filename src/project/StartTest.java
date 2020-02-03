/**
 * 
 */
package project;

import org.openqa.selenium.WebDriver;

import baiduHome.Base;

/**
 * @author Administrator
 *
 */
public class StartTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = Base.getDriver("https://pan.baidu.com/");
		Email email = new Email(driver);
		email.login("s391201", "SHzengrong24.");
		
	}

}
