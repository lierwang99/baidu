package startUp;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import baiduHome.Base;

/**
 * @author Administrator
 *
 */
public class DataLoginPage {
	@DataProvider(name ="zr")
	public static Object[][] getData(){
		
		String filePath = "H:" + File.separator + "Desktop" + File.separator + "四川" + File.separator + "用户信息.xlsx";
//		String filePath = "H:" + File.separator + "Desktop" + File.separator + "四川" + File.separator + "use.xlsx";
//		
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = wb.getSheet("LoginPage");
		Base base = new Base();
		List<Map<String, String>> listMap = base.getListContainsMap(sheet);
		int columsSize = listMap.size();
		Object[][] obj = new Object[columsSize][];
		int len = 0;
		for(Map<String, String> map : listMap) {
			Object[] array = map.values().toArray();
			obj[len ++ ] = array;
		}
		return obj;
		
	}
//	public static void main(String[] args) {
//		Object[][] data = getData();
//		for(int x =0;x<data.length;x++) {
//			for(int y=0;y<data[x].length;y++) {
//				System.out.println(data[x][y]);
//			}
//		}
//	}
}
