/**
 * 
 */
package shanghai.frame;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baiduHome.Base;

/**
 * @author Administrator
 *
 */
public class COneFiveOnePage extends Base {
	private String queryButtonXpath = "//input[@id='submitBtn']";
	private String programmeNameXpath = "//input[@id='rectName']";
	private String resultNumberXpath = "//td[@id='divPager']/span/b";
	WebDriver driver = null;

	/**
	 * @author: liyan
	 * @param driver2
	 * @Description:
	 */

	public COneFiveOnePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/*
	 * programme[ˈprəʊɡræm] n. 方案,计划 查询去掉首端的空格使用trim()。
	 */
	public int queryPName(String programmeName) {
		sendKeysByXpath(programmeNameXpath, programmeName.trim());
		clickByXpath(queryButtonXpath);
		WebElement eleResultNumber = findElementByXpath(resultNumberXpath);
		String strResultNumber = eleResultNumber.getText();
		Integer valueOf = Integer.valueOf(strResultNumber);
		return valueOf;
	}

	/**
	 * 
	 * @param map
	 * @return
	 */
	public int query(Map<Enum<? extends Enum<?>>, String> map) {
		sendKeyMapByXpath(map);
		clickByXpath(queryButtonXpath);
		int number = getQueryResultNumber();
		return number;
	}
	/**
	 * 查询结果条数
	 * @return
	 */
	public int getQueryResultNumber() {
		WebElement eleResultNumber = findElementByXpath(resultNumberXpath);
		String strResultNumber = eleResultNumber.getText();
		Integer valueOf = Integer.valueOf(strResultNumber);
		return valueOf;
	}

	/**
	 * 泛型
	 * @author Administrator
	 *
	 */
	public enum QueryCondition {
		ProgrammeName("//input[@id='rectName']"), FormulateDateA("//input[@id='createStartDate']"),
		FormulateDateB("//input[@id='createEndDate']"), StratTimeA("//input[@id='startDate1']"),
		StratTimeB("//input[@id='endDate1']"), EndTimeA("//input[@id='startDate2']"),
		EndTimeB("//input[@id='endDate2']");
		
		private String field;
		private QueryCondition(String xpath) {
			this.field = xpath;
		}
		public String getField() {
			return this.field;
		}
	}

}
