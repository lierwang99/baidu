/**
 * 
 */
package browser;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



/**
 * @author Administrator
 *
 */
public class ChromeBrowser {

	/**
	 * @param args
	 */

	public static void main(String[] args) throws IOException, Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\tools\\chromedriver.exe");
		// 实例化一个Chrome浏览器的实例
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.baidu.com");
		// 截屏操作
		// 截图到output
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String savePath = "D:\\example.jpg";
			// 复制内容到指定文件中
			FileUtils.copyFile(scrFile, new File(savePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}