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
public class TestBaidu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = Base.getDriver("") ;
		driver.get("https://www.baidu.com");
		BaiduHomePage bhp = new BaiduHomePage(driver);
		
//		bhp.search("中国");
		try {
		bhp.aboutBaidus();
		}catch(Exception e) {
			String currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);
			System.out.println("页面刷新后，失去原先的元素");
		}
//		driver.findElement(By.xpath("//a[@href='http://www.baidu.com']/img"));
		
		String str = "//div[@class='w_left']//ul/li";
		bhp.findElements(str);
	}

}
