/**
 * 
 */
package browser;

import org.openqa.selenium.WebDriver;

import baiduHome.Base;

/**
 * @author Administrator
 *
 */
public class ShanghaiCity {
	public static void main(String[] args) {
		WebDriver driver = Base.getDriver("http://10.1.192.155:6888/msrs/login.jsp");
		System.out.println(driver);
		
	}
}
