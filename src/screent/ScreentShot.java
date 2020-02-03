/**
 * 
 */
package screent;

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
public class ScreentShot {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Robot robot = new Robot();
		//缩写版
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		File file = new File("D:\\abcs.png");
		if(file.exists()) {
			file.createNewFile();
		}
		ImageIO.write(image,"png",file);
	}

}
