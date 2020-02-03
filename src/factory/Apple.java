/**
 * 
 */
package factory;

import factory.FruitFactory.Fruit;

/**
 * @author Administrator
 *
 */
public class Apple implements Fruit{

	@Override
	public void eat() {
		System.out.println("我是苹果");
	}
	public Apple(String name,double price) {
		System.out.println("我是有参构造的苹果！！" + name+":" + price);
	}
	public Apple() {
		System.out.println("我是苹果的无参构造方法！！！");
	}

}
