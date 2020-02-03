/**
 * 
 */
package reflex.NewInstance;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Administrator
 *
 */
public class Reflexs {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static void main(String[] args) throws Exception {
//		反射调用属性，并且无视封装的属性
		Class<?> cls = Class.forName("reflex.commonMethod.Books1");
		Object objs = cls.newInstance();	// 必须给出实例化对象
		Field declaredField = cls.getDeclaredField("title");
		declaredField.setAccessible(true); // 取消封装
		declaredField.set(objs, "java开发"); // 相当于：Books1对象.title = "java开发" ;
		System.out.println(declaredField.get(objs)); // // 相当于：Books1对象.title
		
		
		

//		自己发现的调用方法
		/*
		 * String set = "setTitle"; // 要操作的成员 String get = "getTitle"; 
		 * // 要操作的成员
		 * Class<?> cl = Class.forName("reflex.commonMethod.Books1"); 
		 * Object obj =cl.newInstance(); // 必须给出实例化对象 
		 * Method method = cl.getMethod(set,String.class); //Books1的setTitle("参数类型")
		 * Method methods = cl.getMethod(get);
		 * method.invoke(obj, "123"); 
		 * System.out.println(methods.invoke(obj));
		 */

		
//		老师的写法：第一种调用通过反射调用方法
		/*
		 * String fieldName = "title"; 
		 * Class<?> cl = Class.forName("reflex.commonMethod.Books1");
		 * Object obj = cl.newInstance();//必须给出实例化对象 
		 * Method setM = cl.getMethod("set" + initcap(fieldName),String.class); 
		 * Method getM = cl.getMethod("get" + initcap(fieldName));
		 * setM.invoke(obj, "Java开发"); // 等价于：Book类对象.setTile("Java开发")
		 * System.out.println(getM.invoke(obj)); 
		 * } 
		 * public static String initcap(String str) { 
		 * 		return str.substring(0, 1).toUpperCase() + str.substring(1);
		 */
	}

}
