/**
 * 
 */
package map;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import baiduHome.Base;

/**
 * @author Administrator
 *
 */
public class Args {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = Base.getDriver("file:///H:/Desktop/javascript/zr.html");
		Base base = new Base(driver);
		Map<java.lang.Enum<? extends java.lang.Enum<?>>, String> hashMap = new HashMap<>();
//		hashMap.put("//input[@id='in']", "123");
//		hashMap.put("//input[@class='in']", "321");
//		hashMap.put("/html/body/input[3]", "abc");
//		hashMap.put("//input[4]", "李岩王八蛋");
		
		
		
		hashMap.put(ZR.ID, "431281199603235628");
		hashMap.put(ZR.NAME, "曾容");
		hashMap.put(ZR.AGE, "23");
		hashMap.put(ZR.ADDR, "李宅子");
		
		
		base.removeReadonly("#in");
		base.removeReadonly(".in");
//		base.put(hashMap);
	}


	
	enum ZR{
		NAME("//input[@class='in']"),ID("//input[@id='in']"),SEX("/html/body/input[3]"),AGE("//input[4]"),ADDR("//input[@class='addr']");
		private String field;
		private ZR(String xpath) {
			this.field = xpath;
		}
		public String toString() {
			return field;
		}
	}

}
