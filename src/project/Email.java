/**
 * 
 */
package project;

import org.openqa.selenium.WebDriver;

import baiduHome.Base;
import shanghai.frame.HomePage;

/**
 * @author Administrator
 *
 */
public class Email extends Base{
	private String loginXpath = "//*[@id=\"TANGRAM__PSP_4__footerULoginBtn\"]";
	private String accountXpath = "//input[@id='TANGRAM__PSP_4__userName']";
	private String passwrodXpath = "//input[@id='TANGRAM__PSP_4__password']";
	private String loginButtonXpath = "//input[@id='TANGRAM__PSP_4__submit']";
	WebDriver driver = null ;
	public Email(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	public static void main(String[] args) {
		
	}
//https://pan.baidu.com/
	public HomePage login(String account,String password) {
		clickByXpath(loginXpath);
		sendKeysByXpath(accountXpath,account);
		sendKeysByXpath(passwrodXpath,password);
		clickByXpath(loginButtonXpath);
		HomePage homePage = new HomePage(driver);
		
		return homePage ;
	}
}
