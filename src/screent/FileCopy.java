
package screent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author Administrator
 *
 */
public class FileCopy {

	
	//读写文件
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		File file = new File("H:\\imgs\\zr.jpg");
		File file2 = new File("D:\\zengrong.jpg");
		FileInputStream fileInputStreram = new FileInputStream(file);
		FileOutputStream fileOutputStream = new FileOutputStream(file2);
		int i = 0 ;
		while((i = fileInputStreram.read()) !=-1) { 
			fileOutputStream.write(i);
		}
		
	}
}
