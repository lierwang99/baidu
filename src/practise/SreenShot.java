/**
 * 
 */
package practise;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


/**
 * @author Administrator
 *
 */
public class SreenShot {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Robot robot = new Robot();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		BufferedImage createScreenCapture = robot.createScreenCapture(rectangle);
		File file = new File("H:\\Desktop\\四川\\123.jpg");
		if(file.exists() && file.isDirectory()) {
			System.out.println("不是正确的！");
		}
		ImageIO.write(createScreenCapture, "jpg", file);
		
	}

}
