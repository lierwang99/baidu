/**
 * 
 */
package reflex;

import java.lang.reflect.Constructor;

/**
 * @author Administrator
 *
 */
public class Reflex {
	public static void main(String[] args) throws Exception {
		Class<?> forName = Class.forName("reflex.Book");
		Constructor<?> com = forName.getConstructor(String.class,double.class);
		Object obj = com.newInstance("开发",87.6);
		System.out.println(obj);
	}
}
