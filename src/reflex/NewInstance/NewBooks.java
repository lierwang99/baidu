package reflex.NewInstance;

interface Fruit {
	public void eat();
}

class Apple implements Fruit {
	@Override
	public void eat() {
		System.out.println("吃苹果————————");
	}
}

class Orange implements Fruit {
	@Override
	public void eat() {
		System.out.println("吃橘子————————");
	}
}

class Banana implements Fruit {
	@Override
	public void eat() {
		System.out.println("吃香蕉----------");
	}
}

/**
 * 反射的使用，
 * @author Administrator
 *
 */
class Factory {
	public static Fruit getInstance(String className) {
		Fruit f = null;
		try {
			f = (Fruit) Class.forName(className.trim()).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}

public class NewBooks {
	public static void main(String[] args) {
		Fruit f = Factory.getInstance(" reflex.NewInstance.Banana ");
		f.eat();
	}
}
