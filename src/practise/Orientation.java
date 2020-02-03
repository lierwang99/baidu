/**
 * 
 */
package practise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Administrator
 *
 */
public class Orientation {

	/**
	 * @param args
	 * @throws Exception 
	 */
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", ".\\tools\\chromedriver.exe");
		TakesScreenshot ts = new ChromeDriver();
		WebDriver dr = (WebDriver)ts;
		dr.get("http://www.baidu.com/");
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        FileInputStream fileInputStream = new FileInputStream(srcFile);
        int read = fileInputStream.read();
        FileOutputStream fileOutputStream = new FileOutputStream("H:/sreent1.png");
        int i = 0 ;
        while((i = fileInputStream.read()) != -1) {
        	 fileOutputStream.write(i);
        }
       
	}

}
