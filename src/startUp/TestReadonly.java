/**
 * 
 */
package startUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baiduHome.Base;

/**
 * @author Administrator
 *
 */
public class TestReadonly {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		WebDriver driver = Base.getDriver("H:\\Desktop\\javascript\\zr.html");
		Base base = new Base(driver);
		WebElement eleInput = driver.findElement(By.xpath("//input[@id='in']"));
		base.removeReadonly("#in");
		eleInput.sendKeys("123");
		String attribute = eleInput.getAttribute("readonly");
		System.out.println(attribute);
		
		base.setElementAttribute("body > input:nth-child(6)", "placeholder", "zr");
		
//		base.findElementByCss("body > input:nth-child(6)").sendKeys("abcd");
	}
	
}
