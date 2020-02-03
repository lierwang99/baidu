/**
 * 
 */
package practise;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;

import baiduHome.Base;
import shanghai.frame.HomePage;

/**
 * @author Administrator
 *
 */
public class LoginPages extends Base{
	private String accountXpath = "//input[@id='u']";
	private String passwrodXpath = "//input[@class='p']";
	private String loginButtonXpath = "//input[@id='login_button']";
	WebDriver driver = null ;
	static Logger log = Logger.getGlobal();
	
	public LoginPages(WebDriver driver) {
		super(driver);
		log.info("构造方法已执行");
		this.driver = driver ;
	}
	/**
	 * 登录业务
	 */
	
	public HomePage login(String account,String password) {
		driver.switchTo().frame("login_frame");
		log.info("执行登录方法");
		sendKeysByXpath(accountXpath,account);
		sendKeysByXpath(passwrodXpath,password);
		clickByXpath(loginButtonXpath);
		HomePage homePage = new HomePage(driver);
		log.info("执行登录成功");
		return homePage ;
	}
}
/**
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");  //转换时间格式
	String time = dateFormat.format(Calendar.getInstance().getTime());  //获取当前时间
*/