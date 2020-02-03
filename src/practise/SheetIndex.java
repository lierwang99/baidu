/**
 * 
 */
package practise;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import baiduHome.Base;

/**
 * @author Administrator
 *
 */
public class SheetIndex {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String file = "H:\\3.xlsx\\a.xlsx" ;
//		XSSFWorkbook wk = new XSSFWorkbook(file);
//		int numberOfSheets = wk.getNumberOfSheets();
//		System.out.println(numberOfSheets);
//		XSSFSheet sheetAt = wk.getSheetAt(0);
//		System.out.println(sheetAt.getSheetName());
		Base base = new Base();
		
		LinkedHashMap<String, List<Map<String, String>>> linkedHashMap = base.getMapContainsAllList(file);
		Set<Entry<String, List<Map<String, String>>>> entrySet = linkedHashMap.entrySet();
		base.printIterable(entrySet);
		
	}

}
