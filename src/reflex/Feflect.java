package reflex;

import java.lang.reflect.Constructor;

class Book{
	private String title;
	private double price;

	public Book(String title, double price) {
		this.title = title;
		this.price = price;
	}

	@Override
	public String toString() {
		return "这是一本书！:" + this.title + "，价格: " + this.price;
	}
}

public class Feflect {

	/**
	 * 反射调用构造方法
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static void main(String[] args) throws Exception {
		Class<?> forName = Class.forName("reflex.Book");
		Constructor<?> com = forName.getConstructor(String.class,double.class);
		Object obj = com.newInstance("开发",87.6);
		System.out.println(obj);
		

		/**
		 * Date date = new Date();//产生对象 
		 * // 第一种调用Object类中的getClass()方法 Class<? extends
		 * Date> class1 = date.getClass(); 
		 * System.out.println(class1);
		 * System.out.println(date.getClass());//输出对象类的全名称。 
		 * // 第二种“类.class”取得; Class<?>
		 * cls = Date.class; 
		 * System.out.println(cls);
		 * 
		 * Class<?> forName = Class.forName("java.util.Date");
		 * System.out.println(forName);
		 */
	}

}
