/**
 * 
 */
package test.standard;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import baiduHome.Base;

/**
 * @author Administrator
 *
 */
public class Data {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		getAddData();
		int[] arr = { 11, 2, 3 };

	}

	@DataProvider(name = "zr")
	public static Object[][] getAddData() {
		Object[][] obj = null;
		String filePath = "H:\\Desktop\\四川\\四川.xlsx";
		Base base = new Base();
		XSSFWorkbook wk = null;
		try {
			wk = new XSSFWorkbook(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = wk.getSheet("Add");
		List<Map<String, String>> list = base.getListContainsMap(sheet);
		System.out.println(list);
		System.out.println();
//		list.size()是表示List内的map有多少个组
		int size = list.size();
		System.out.println("size:" + size + " 组Map");
		obj = new Object[size][];
		/**
		 * 
		 */
		int x = 0;
		for (Map<String, String> map : list) {
			Collection<String> values = map.values();
			obj[x] = values.toArray();
			x++;

		}
		/**
		 * while写法+ 集合的迭代器写法：iterator
		 */
//		Iterator<Map<String, String>> iterator = list.iterator();
//		while(iterator.hasNext()) {
//			Map<String, String> next = iterator.next();
//			Set<Map.Entry<String, String>> entrySet = next.entrySet();
//			Iterator<Map.Entry<String, String>> iterator2 = entrySet.iterator();
//			while(iterator2.hasNext()) {
//				Map.Entry<String, String> next2 = iterator2.next();
//				String key = next2.getKey();
//				String value = next2.getValue();
//				System.out.print(key + "::" + value+",\t");
//			}
//			System.out.println();
//		}

		/**
		 * for etch写法 String[] str = {"3","5"}; 
		 * for(String s : str){
		 * System.out.println(s); 
		 * }
		 */

		/**
		 * 数组常用写法
		 */
//		Object[] array = list.toArray();
//		for(int x =0;x<list.size();x++) {
//			Map<String, String> map = (Map<String, String>) array[x];
//		}

		return obj;
	}

}
