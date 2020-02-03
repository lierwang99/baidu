/**
 * 
 */
package startUp;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import baiduHome.Base;
import shanghai.frame.HomePage;
import shanghai.frame.LoginPage;

/**
 * @author Administrator
 *
 */
public class TestCooking {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = Base.getDriver("http://10.1.192.155:6888/msrs/login.jsp");
		LoginPage lp = new LoginPage(driver);
		HomePage hp = lp.login("shgs_test", "111111");
		WebDriver driver2 = hp.getDriver();
		Set<Cookie> setCookies = driver2.manage().getCookies();
		System.out.println(setCookies.size());
		hp.printIterable(setCookies);
		driver.close();
		
		
		WebDriver driver3 = Base.getDriver("http://10.1.192.155:6888/msrs/login.jsp");
		
		Iterator<Cookie> iterator = setCookies.iterator();
		
		while(iterator.hasNext()) {
			Cookie c = iterator.next();
			driver3.manage().addCookie(c);
		}
		
		String loginButtonXpath = "//input[@class='sub'][@type='submit']";
		driver3.findElement(By.xpath(loginButtonXpath)).click();
		

		
		
	}

}
