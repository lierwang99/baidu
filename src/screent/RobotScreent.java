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
public class RobotScreent {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		
		Robot rb = new Robot();
		Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = defaultToolkit.getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		BufferedImage createScreenCapture = rb.createScreenCapture(rectangle);
		File file = new File("H:/imgs/1243.png");
		if(file.exists()) {
//			file.createNewFile();
		}
		ImageIO.write(createScreenCapture,"png",file);
	}

}
