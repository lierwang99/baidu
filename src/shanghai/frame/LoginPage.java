/**
 * 
 */
package shanghai.frame;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;

import baiduHome.Base;

/**
 * @author Administrator
 *
 */

public class LoginPage extends Base{
	private String accountXpath = "//input[@id='loginName']";
	private String passwrodXpath = "//input[@class='login_input'][@type='password']";
	private String loginButtonXpath = "//input[@class='sub'][@type='submit']";
	WebDriver driver = null ;
	static Logger log = Logger.getGlobal();
	
	public LoginPage(WebDriver driver) {
		super(driver);
		log.info("构造方法已执行");
		this.driver = driver ;
	}
	/**
	 * 登录业务
	 */
	
	public HomePage login(String account,String password) {
		log.info("执行登录方法");
		sendKeysByXpath(accountXpath,account);
		sendKeysByXpath(passwrodXpath,password);
		clickByXpath(loginButtonXpath);
		HomePage homePage = new HomePage(driver);
		log.info("执行登录成功");
		return homePage ;
	}
}
