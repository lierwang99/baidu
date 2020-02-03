/**
 * 
 */
package baiduHome;

import org.openqa.selenium.WebDriver;

/**
 * @author Administrator
 *
 */
public class BrowsersFactory {

	public static WebDriver getBrowserDriver(String browserName) {
		WebDriver driver = null;
		Class<?> forName = null;
		Object obj = null;
		if (browserName == null || "".equals(browserName)) {
			return driver;
		}
		String browserName2 = browserName.trim().toUpperCase();
		if (browserName2.contains("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver", ".\\tools\\geckodriver.exe");
		} else if (browserName2.contains("IE")) {
			System.setProperty("webdriver.ie.driver", ".\\tools\\IEDriverServer.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", ".\\tools\\chromedriver.exe");
		}
		try {
			forName = Class.forName(browserName.trim());
			obj = forName.newInstance();
		} catch (Exception e) {
			System.out.println("传入的浏览器名称错误：" + browserName);
			e.printStackTrace();
		}

		driver = (WebDriver) obj;

		return driver;
	}
}
