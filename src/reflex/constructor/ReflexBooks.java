/**
 * 
 */
package reflex.constructor;

/**
 * @author Administrator
 *
 */
interface Fruit{
	public void eat();
}
class Apple implements Fruit{
	@Override
	public void eat() {
		System.out.println("吃苹果————————");
	}
}
class Orange implements Fruit{
	@Override
	public void eat() {
		System.out.println("吃橘子————————");
	}
}
class Factory{
	public static Fruit getInstance(String className) { // 因为返回Fruit接口，Apple类又实现了Fruit接口
		if("Apple".equals(className)) {
			return new Apple();
		}else if("Orange".equals(className)) {
			return new Orange();
		}else {
			return null ;
		}
	}
}
public class ReflexBooks {
	public static void main(String[] args) {
		Fruit f = Factory.getInstance("Apple");
		f.eat();
	}
}
