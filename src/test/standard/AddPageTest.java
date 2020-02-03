package test.standard;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import standard.AddPage;

public class AddPageTest {
	AddPage addPage = null;

	@BeforeTest
	public void init() {
		addPage = new AddPage();
	}

	@Test(dataProvider = "zr", dataProviderClass=test.standard.Data.class)
	public void addTest(String A,String B,String C,String D) {
		int add = addPage.add(Integer.valueOf(A),Integer.valueOf(B));
	
			int valueOf = Integer.valueOf(C);
			Assert.assertEquals(add,valueOf, "断言失败");
	

		System.out.println("通过本次测试");
	}

}
