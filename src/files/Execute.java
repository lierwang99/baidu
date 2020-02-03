/**
 * 
 */
package files;

import java.io.File;

/**
 * @author Administrator
 *
 */
public class Execute {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 查看文件内的程序可否启动
		 * File file = new File("G:\\Program Files (x86)\\WeGame\\wegame.exe"); boolean
		 * canExecute = file.canExecute();
		 * System.out.println(canExecute);
		 */
		File file = new File("H:\\imgs\\A");
		File file2 = new File("H:\\imgs","H:\\imgs\\A");
		int compareTo = file.compareTo(file2);
		System.out.println(compareTo);
		
	
	}

}
