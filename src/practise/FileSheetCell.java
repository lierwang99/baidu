package practise;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baiduHome.Base;
import shanghai.frame.HomePage;

/**
 * @author Administrator
 *
 */
public class FileSheetCell {
	WebDriver driver = null;

	@BeforeMethod
	public void before() {
		String url = "http://mail.qq.com";
		driver = Base.getDriver(url);
		
		String[] arrs = new String[] {"1"};
		for(String str : arrs) {
			
		}
	}

	@Test(dataProviderClass = practise.FileSheetCell.class, dataProvider = "zr2")
	public void getLogin(String account, String passwd) {
		practise.LoginPages loginPage = new practise.LoginPages(driver);
		HomePage homePage = loginPage.login(account, passwd);
		homePage.quit();
	}
	@DataProvider(name ="zr2")
	public static Object[][] getData() {
//		String filePath = "H:" + File.separator + "Desktop" + File.separator + "四川" + File.separator + "use.xlsx";
		String filePath = "H:\\Desktop\\四川\\use.xlsx";
		XSSFWorkbook xwb = null ;
		try {
			xwb = new XSSFWorkbook(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = xwb.getSheet("F");
		Base base = new Base();
		List<Map<String, String>> listMap = base.getListContainsMap(sheet);
		int size = listMap.size();
		Object[][] obj = new Object[size][];
		int len = 0;
		for (Map<String, String> map : listMap) {
			Object[] array = map.values().toArray();
			obj[len] = array;
			len++ ;
		}
		return obj;
	}

}
