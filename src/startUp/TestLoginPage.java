package startUp;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baiduHome.Base;
import shanghai.frame.HomePage;
import shanghai.frame.LoginPage;

public class TestLoginPage {
	WebDriver driver = null;

	@BeforeMethod
	public void before() {
		String url = "http://10.1.192.155:6888/msrs/login.jsp";
		driver = Base.getDriver(url);
	}

	@Test(dataProviderClass = startUp.DataLoginPage.class, dataProvider = "zr")
	public void getLogin(String account, String passwd) {
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.login(account, passwd);
		homePage.quit();
	}
}
