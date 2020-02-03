/**
 * 
 */
package practise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Administrator
 *
 */
public class CopyFile {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File fileA = new File("H:\\imgs\\123.png");
		File fileB = new File("H:\\imgs\\A\\abc.png");
		FileInputStream fileInputStream = new FileInputStream(fileA);
		FileOutputStream fileOutputStream = new FileOutputStream(fileB);
		int i = 0 ;
		while((i = fileInputStream.read()) !=-1){
			fileOutputStream.write(i);
		}
	}

}
