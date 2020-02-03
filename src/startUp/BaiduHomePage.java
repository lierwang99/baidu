/**
 * 
 */
package startUp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baiduHome.Base;

/**
 * @author Administrator
 *
 */
public class BaiduHomePage extends Base {

	WebDriver driver = null;
	private String inputBoxXpath = "//input[@id='kw']";
	private String searchXpath = "//input[@id='su']";
	private String aboutBaiduXpath = "//a[contains(.,'About')]";
	private String Journalism = "//a[contains(.,'新闻')]";
	private long timeOutInSeconds = 10 ;
	private long sleepInMillis = 100 ;

	/**
	 * @author: liyan
	 * @param driver2
	 * @Description:
	 */
	public BaiduHomePage(WebDriver driver2) {
		super(driver2);
		this.driver = driver2;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
//	搜索
	public void search(String searchContent) {
		sendKeysByXpath(inputBoxXpath,searchContent);
		clickByXpath(searchXpath);
	}
//	关于百度的业务
	public void aboutBaidu() {
		clickByXpath(Journalism);
	}
	//英语版关于百度
	public void aboutBaidus() {
		clickByXpath(aboutBaiduXpath);
	}
	public List<WebElement> findElements(String xpaths){
		List<WebElement> findElements = null ;
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutInSeconds,sleepInMillis);
		ExpectedCondition<List<WebElement>> voel = ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpaths));
		findElements = webDriverWait.until(voel);
		System.out.println(findElements);
		return findElements;
	}
}

