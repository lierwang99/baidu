/**
 * 
 */
package baiduHome;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Administrator
 *
 */
public class Base {

	WebDriver driver = null;
	private long timeOutInSeconds = 20;
	private long sleepInMillis = 100;
	static Logger log = Logger.getGlobal();

	public Base() {

	}

	/**
	 * 有参构造方法
	 * 
	 * @author: liyan
	 * @Description:
	 */
	public Base(WebDriver driver2) {
		this.driver = driver2;
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	/**
	 * 启动浏览器的方法
	 */
	public static WebDriver getDriver(String url) {
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", ".\\tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url.trim());
		driver.manage().window().maximize();
		return driver;
	}

	/**
	 * 找一个元素，直到20秒内找到元素为止
	 * @param xpath
	 * @return
	 */
	public WebElement findElementByXpath(String xpath) {
		WebElement findElement = null;
		log.info("开始找xpath为【 " + xpath + "】元素");
		try {
//		timeOutInSeconds等待最大时间为10秒，sleepInMillis此线程休息100毫秒。
			WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutInSeconds, sleepInMillis);
			ExpectedCondition<WebElement> voel = ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath));
			// 返回值根据泛型传值类型返回
			findElement = webDriverWait.until(voel);
		} catch (Exception e) {
			log.info("xpath为【 " + xpath + "】 的元素未找到");
			e.printStackTrace();
		}
		return findElement;
	}

	/**
	 * 找到指定的所有元素，直到20秒内找到元素为止
	 * @param xpath
	 * @return
	 */
	public java.util.List<WebElement> findElementsByXpath(String xpath) {

		List<WebElement> list = null;
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutInSeconds, sleepInMillis);
		ExpectedCondition<List<WebElement>> poaelb = ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath));
		list = webDriverWait.until(poaelb);
		return list;
	}

	/**
	 * 
	 * @param xpath
	 */
	public void clickByXpath(String xpath) {
		WebElement findElement = findElementByXpath(xpath);

		findElement.click();
		// 加上强制睡眠可以解决：org.openqa.selenium.StaleElementReferenceException异常
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 通过CSS
	 * 
	 * @param css
	 * @return
	 */
	public WebElement findElementByCss(String css) {
		WebElement findElement = null;
		try {
//		timeOutInSeconds等待最大时间为10秒，sleepInMillis此线程休息100毫秒。
			WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutInSeconds, sleepInMillis);
			ExpectedCondition<WebElement> voel = ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css));

			// 返回值根据泛型传值类型返回
			findElement = webDriverWait.until(voel);
		} catch (Exception e) {
			System.out.println("-------------元素未找到---------------------------");
			e.printStackTrace();
		}
		return findElement;
	}

	public void sendKeysByXpath(String xpath, String content) {
		WebElement findElement = findElementByXpath(xpath);
		log.info("开始传值" + content);
		findElement.sendKeys(content);
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	public WebDriver switchToFrame(java.lang.Object object) {
		org.openqa.selenium.WebDriver driver2 = null;
		if (object == null) {
			return driver2;
		}
		if (object instanceof java.lang.Integer) {
			int index = (int) object;
			driver2 = driver.switchTo().frame(index);
			return driver2;
		}
		if (object instanceof java.lang.String) {
			java.lang.String nameOrId = (String) object;
			driver2 = driver.switchTo().frame(nameOrId);
			return driver2;
		}
		if (object instanceof org.openqa.selenium.WebElement) {
			org.openqa.selenium.WebElement frameElement = (WebElement) object;
			driver2 = driver.switchTo().frame(frameElement);
			return driver2;
		}

		return driver2;
	}

	/**
	 * 通过js移除元素的readOnly属性
	 * 
	 * @param eleCss
	 */
	public void removeReadonly(String eleCss) {
		WebElement ele = findElementByCss(eleCss);
		if (ele != null) {
			String attribute = ele.getAttribute("readonly");
			if (attribute != null) {
				String js = "document.querySelector('" + eleCss + "').removeAttribute('readonly')"; // 原生js，移除属性
				((JavascriptExecutor) driver).executeScript(js); // 将driver强制转换为JavascriptExecutor类型
			}
		}
	}

	/**
	 * 即便这个属性不存在都不会报错，存在的时候，就会执行移除操作
	 * 
	 * @param eleCss
	 * @param attributeName
	 */
	public void removeElementAttribute(String eleCss, String attributeName) {
		WebElement ele = findElementByCss(eleCss);
		if (ele != null) {
			String js = "document.querySelector('" + eleCss + "').removeAttribute('" + attributeName.trim() + "')"; // 原生js，移除属性
			((JavascriptExecutor) driver).executeScript(js); // 将driver强制转换为JavascriptExecutor类型
		}
	}

	/**
	 * 直接改元素属性，不会触发js事件 直接设置元素属性，属性名随便写都没问题
	 * 
	 * @param eleCss
	 * @param attributeName
	 * @param attributeValue
	 */
	public void setElementAttribute(String eleCss, String attributeName, String attributeValue) {
		WebElement ele = findElementByCss(eleCss);
		if (ele != null) {
			String js = "document.querySelector('" + eleCss + "').setAttribute('" + attributeName.trim() + "','"
					+ attributeValue + "')";
			((JavascriptExecutor) driver).executeScript(js);
		}
	}

	/**
	 * 
	 * @param map
	 */
	public void sendKeyMapByXpath(Map<java.lang.Enum<? extends Enum<?>>, String> map) {
		Set<Map.Entry<Enum<? extends Enum<?>>, String>> se = map.entrySet();
		Iterator<Entry<Enum<? extends Enum<?>>, String>> ite = se.iterator();
		while (ite.hasNext()) {
			Entry<Enum<? extends Enum<?>>, String> next = ite.next();
			String xpath = next.getKey().toString();
			String value = next.getValue();
			sendKeysByXpath(xpath, value);
		}
	}

	/**
	 * 
	 * @param list
	 */
	public void clickListByXpath(List<String> list) {
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String xpath = it.next();
			clickByXpath(xpath);
		}
	}

	/**
	 * 
	 * 通过javascript操作滚动轴，在垂直方向上滚动
	 * 
	 * @param start
	 * @param end
	 */
	public void scrollToY(int start, int end) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String str1 = "window.scrollTo(" + start + "," + end + ")";
		js.executeScript(str1);
	}

	/**
	 * 前提条件：必须把鼠标移动到可以滚动的页面上。 通过robot类滚动轴，当wheelAmt的值大于零表示向下滚动，值越大向下滚动的越多。 反之向上
	 * 
	 * @param wheelAmt
	 */
	public void mouseWheelY(int wheelAmt, int coordinateX, int coordinateY) {
		try {
			Robot rb = new Robot();
			rb.mouseMove(coordinateX, coordinateY);
			rb.delay(500);
			rb.mouseWheel(wheelAmt);
			rb.delay(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * robot类键盘操作，可以传任意参数
	 * 
	 * @param keys
	 */
	public void robotKeyEvent(int... keys) {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		for (int x = 0; x < keys.length; x++) {
			robot.keyPress(keys[x]);
			robot.delay(500);
		}

		for (int y = 0; y < keys.length; y++) {
			robot.keyRelease(keys[y]);
			robot.delay(200);
		}
	}

	/**
	 * 迭代器
	 * 
	 * @param <E>
	 * @param it
	 */
	public <E> void printIterable(Collection<E> it) {
		Iterator<E> iterator = it.iterator();
		while (iterator.hasNext()) {
			E next = iterator.next();
			System.out.println(next.toString());
		}
	}

	/**
	 * filePath传文件入口，
	 * @param filePath
	 * @return
	 */
	// start
	public LinkedHashMap<String, List<Map<String, String>>> getMapContainsAllList(String filePath) {
		LinkedHashMap<String, List<Map<String, String>>> lhmap = new LinkedHashMap<>();
//		判断文件是否为空
		if (filePath == null) {
			return lhmap;
		}
		filePath = filePath.trim();//截图文件首尾两端的空格
//		判断文件名的长度是都小于6
		if (filePath.length() < 6) {
			return lhmap;
		}
//		判断传入文件名的后缀.xlsx
		if (!filePath.endsWith(".xlsx")) {
			return lhmap;
		}
//		判断文件是否已经存在
		File file = new File(filePath);
		if (!file.exists()) {
			return lhmap;
		}
//		判断传的是否是文件
		if (!file.isFile()) {
			return lhmap;
		}
//		先打开表格
		XSSFWorkbook wk = null;
		try {
			wk = new XSSFWorkbook(file);
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
//		看表格有没有内容
		if (wk == null) {
			return lhmap;
		}
//		得到sheet的数量
		int numberOfSheets = wk.getNumberOfSheets();
		for (int x = 0; x < numberOfSheets; x++) {
			XSSFSheet sheet = wk.getSheetAt(x);
			String sheetName = sheet.getSheetName();
			List<Map<String, String>> listContainsMap = getListContainsMap(sheet);
//			增加对键值内容
			lhmap.put(sheetName, listContainsMap);
		}
		return lhmap;
	}

	/**
	 * Map键值对的形式取值
	 * @param sheet
	 * @return
	 */
	// start
	public List<Map<String, String>> getListContainsMap(XSSFSheet sheet) {
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = null;
		if (sheet == null) {
			return list;
		}
		int lastRowNum = sheet.getLastRowNum();
//			当lastRowNum 为 0时，他表示sheet中最多有一行内容
//			起码有一行存在
		XSSFRow firstRow = sheet.getRow(0);
		if (firstRow == null) {
			return list;
		}
		short firstRowCellNum = firstRow.getLastCellNum();
		System.out.println("sheet " + sheet.getSheetName() + " 中最大的行数为： " + lastRowNum);
		System.out.println("第一行最大的单元格数： " + firstRowCellNum);
//			最大行数，决定了List要增加多少次Map,Map是放置每一行的（k,v），这里面的K是第一行的对应单元格的值
		int count = 0;
		zr: for (int y = 1; y <= lastRowNum; y++) {
			map = new LinkedHashMap<>();
//				内层循环代表行循环
			for (short x = 0; x < firstRowCellNum; x++) {
				count++;
				XSSFCell cell = firstRow.getCell(x);
				String firstRowCellKey = getCellValueToString(cell);
				XSSFRow tempRow = sheet.getRow(y);
//					continue,终止本次循环，进行下一次循环
				if (tempRow == null) {
					continue zr;
				}
				XSSFCell tempCell = tempRow.getCell(x);
				String yRowCellValue = getCellValueToString(tempCell);
				map.put(firstRowCellKey, yRowCellValue);
			}
			list.add(map);
		}
		System.out.println("总共循环次数 ：" + count);
		return list;
	}

	/**
	 * 得到单元格的值
	 * @param cell
	 * @return
	 */
	public String getCellValueToString(XSSFCell cell) {
		String value = null;
		if (cell == null) {
			return value;
		}
		CellType cellType = cell.getCellType();
		if (cellType == CellType.STRING) {
			return cell.getStringCellValue();
		} else {
			cell.setCellType(CellType.STRING);
			return cell.getStringCellValue();
		}
	}
	// end

	/**
	 * selenium的截图方法并以时间命名保存
	 */
	public void getScreenshotAs(){
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS");
		String format = simpleDateFormat.format(date);
		File targetFile = new File("H:\\imgs\\" + format + ".png");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		FileInputStream in = null;
		FileOutputStream out = null;
		int x = 0;
		try {
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(targetFile);
			while ((x = in.read()) != -1) {
				out.write(x);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *退出浏览器
	 */
	public void quit() {
		if (driver != null) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.quit();
		}
	}

}
