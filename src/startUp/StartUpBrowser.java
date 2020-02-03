/**
 * 
 */
package startUp;

import org.openqa.selenium.WebDriver;

import baiduHome.Base;

/**
 * @author Administrator
 *
 */
public class StartUpBrowser {
	String xpath = "//input[@id='kw'";
	String submit = "//input[@id='su']";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = Base.getDriver("");
		driver.get("https://www.baidu.com");
		System.out.println(driver.getCurrentUrl());
//		baiduHomePage.sendKeysXpath(xpath, "");
	}

}
