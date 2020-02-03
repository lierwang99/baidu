/**
 * 
 */
package factory;

import java.lang.reflect.Constructor;

/**
 * @author Administrator
 *
 */
public class FruitFactory {

	interface Fruit {
		public void eat();
	}

	public static Fruit getFruitInstance(String fruitName) {
		Fruit fruit = null;
		try {
			Class<?> forName = Class.forName(fruitName.trim());
			Object newInstance = forName.newInstance();
			fruit = (Fruit) newInstance;
		} catch (Exception e) {
			System.out.println("找不到类：" + fruitName);
			e.printStackTrace();
		}
		return fruit;

	}

	public static Fruit getFruitInstanceArgs(String fruitName, String name, double price) {
		Fruit fruit = null;
		try {
			Class<?> forName = Class.forName(fruitName.trim());
			Constructor<?> constructor = forName.getConstructor();
			Object newInstance = constructor.newInstance(name, price);
			fruit = (Fruit) newInstance;
		} catch (Exception e) {
			System.out.println("找不到类：" + fruitName);
			e.printStackTrace();
		}
		return fruit;

	}
}
