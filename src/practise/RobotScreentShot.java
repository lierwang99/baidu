/**
 * 
 */
package practise;

import java.awt.AWTException;
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
public class RobotScreentShot {

	/**robot截图
	 * @param args
	 * @throws AWTException 
	 */
	public static void main(String[] args) throws Exception {
		Robot robot = new Robot();
//		Dimension可以接收getScreenSize()
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		BufferedImage createScreenCapture = robot.createScreenCapture(rectangle);
		File file = new File("H:/imgs/123.png");
		if(file.exists()) {
			file.createNewFile();
		}
		ImageIO.write(createScreenCapture, "png", file);
	}
}
