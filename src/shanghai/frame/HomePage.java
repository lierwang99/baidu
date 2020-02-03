/**
 * 
 */
package shanghai.frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baiduHome.Base;

/**
 * @author Administrator
 *
 */
public class HomePage extends Base {
	private String userInfoXpath = "//div[@id='navBar']/div/div[1]/h2";
	private String mOneXpath = "//span[contains(.,'多部门双随机')]";
	private String mOneFiveXpath = "//span[contains(.,'抽查查询')]";
	private String mOneFiveOneXpath = "//span[contains(.,'抽查方案查询')]";
	private Object frameId = "myFrame";
	
	WebDriver driver = null;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	/**
	 * 得到用户信息：黄浦区市场监管局 市场主体监督管理科 刘峥
	 * 
	 */
	public String getUserInfo() {
		WebElement eleUserInfo = findElementByXpath(userInfoXpath);
		String userInfo = eleUserInfo.getText();
		return userInfo ;
	}
	/**
	 * 点击进入页面返回要被操作的页面
	 * this表示当前类的对象
	 */
	public COneFiveOnePage getCOneFiveOnePage() {
		this.clickByXpath(mOneXpath);
		this.clickByXpath(mOneFiveXpath);
		this.clickByXpath(mOneFiveOneXpath);
		switchToFrame(frameId);
		COneFiveOnePage cOneFiveOnePage = new COneFiveOnePage(driver);
		return cOneFiveOnePage;
	}
}
