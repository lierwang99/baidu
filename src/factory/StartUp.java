/**
 * 
 */
package factory;

import baiduHome.BrowsersFactory;

/**
 * @author Administrator
 *
 */
public class StartUp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BrowsersFactory.getBrowserDriver("org.openqa.selenium.ie.InternetExplorerDriver");
	}

}
