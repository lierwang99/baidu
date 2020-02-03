/**
 * 
 */
package screent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author Administrator
 *
 */
public class TakesScreenshot {

	/**
	 * slenium截图，
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", ".\\tools\\chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://www.12306.cn/index/");// 没有url截图个空的，有就截图12306首页
		Thread.sleep(2000);// 不加等待时间网页加载缓慢截图不到的
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		FileInputStream fileInputStream = new FileInputStream(screenshotAs);
		FileOutputStream fileOutputStream = new FileOutputStream("H:\\Desktop\\四川\\abc.jpg");
		int x = 0;
		while ((x = fileInputStream.read()) != -1) {
			fileOutputStream.write(x);
		}
		driver.close();
	}

}
