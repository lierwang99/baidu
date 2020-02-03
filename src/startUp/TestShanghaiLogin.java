/**
 * 
 */
package startUp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baiduHome.Base;
import shanghai.frame.COneFiveOnePage;
import shanghai.frame.HomePage;
import shanghai.frame.LoginPage;

/**
 * @author Administrator
 *
 */
public class TestShanghaiLogin {

	/**
	 * @param args
	 */
	static Logger log = Logger.getGlobal();
	
	public static void main(String[] args) {
		log.setLevel(Level.ALL);
		WebDriver driver = Base.getDriver("http://10.1.192.155:6888/msrs/login.jsp");
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = loginPage.login("liuzheng", "111111");
		String actualUserInfo = homePage.getUserInfo();
		String expectedUserInfo = "刘峥";
		if (actualUserInfo != null && !"".equals(actualUserInfo)) {
			if (actualUserInfo.contains(expectedUserInfo)) {
				
				log.info("登录成功");
			} else {
				System.out.println("登录失败");
				return;
			}

		}
		COneFiveOnePage cOneFiveOnePage = homePage.getCOneFiveOnePage();
		
		String attribute = cOneFiveOnePage.getDriver().findElement(By.xpath("//input[@id='createStartDate']")).getAttribute("value");
		System.out.println("---->  "+attribute.length() +","+ attribute);
		
		cOneFiveOnePage.removeElementAttribute("#createStartDate", "ty");
		cOneFiveOnePage.setElementAttribute("#createStartDate", "zr",null);
		
		cOneFiveOnePage.setElementAttribute("#createStartDate", "value", "2019-07-19"); //直接
		Map<COneFiveOnePage.QueryCondition, String> hashMap = new HashMap<>();
		hashMap.put(COneFiveOnePage.QueryCondition.ProgrammeName, "区级用户进行客体联合抽查测试1024");
		hashMap.put(COneFiveOnePage.QueryCondition.FormulateDateA, "2019-07-19");
		hashMap.put(COneFiveOnePage.QueryCondition.FormulateDateB, "2019-12-21");
	
		cOneFiveOnePage.clickByXpath("//input[@id='organName']");
		String formulateOrganXpath = "//div[@id='organName_ztree_div']//ul[@id='organName_ztree_cont']/li/ul/li[*]/a/span";
		List<WebElement> list = cOneFiveOnePage.findElementsByXpath(formulateOrganXpath);
		int i = list.size();
		System.out.println("制定机关的元素个数：" + i);
//		集合先获取迭代器的对象才能使用while循环。
		ListIterator<WebElement> it = list.listIterator();
		while(it.hasNext()) {
			WebElement ele = it.next();
			String text = ele.getText();
			System.out.println(text);
		}
//820-450
//		cOneFiveOnePage.mouseWheelY(5,850,550);
//		cOneFiveOnePage.mouseWheelY(-5,850,550);
		List<String> arrayList = new ArrayList<>();
		arrayList.add("//input[@id='exeOrganIsSelf']");
		arrayList.add("//input[@id='organIsSelf']");
		arrayList.add("//input[@id='exeOrganIsSelf']");
		cOneFiveOnePage.clickListByXpath(arrayList);

		/**
		 * 通过方案名称，点击查询获取数据
		 */
//		COneFiveOnePage cOneFiveOnePage = homePage.getCOneFiveOnePage();
//		int queryQuantity = cOneFiveOnePage.queryPName("区级用户进行客体联合抽查测试1024");
//		System.out.println(queryQuantity);
		
		/**
		 * 为保证不出现空指针异常，expectedUserInfo写在前面
		 * 
		 * if(expectedUserInfo.contains(actualUserInfo)) { System.out.println("登陆成功");
		 * 
		 * }else { System.out.println("登录失败"); }
		 */
	}

}
