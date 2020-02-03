/**
 * 
 */
package map;

/**
 * @author Administrator
 *
 */
public class Enum {
	private final String MONDAY = "星期一";
	private final String TUESDAY = "星期二";
	private final String WEDNESDAY = "星期三";
	private final String THURSDAY = "星期四";
	private final String FRIDAY = "星期五";
	private final String SATURDAY = "星期六";
	private final String SUNDAY = "星期天";
	private static Enum e ;
	private Enum() {
		
	}

	public String toString() {
		return null;

	}

	public static Enum getInstance() {
		if(e != null) {
			return e;
		}else {
			e = new Enum();
		}
		return e;
	}


	
	
	public boolean equals(Object obj) {
		if(null == obj) { //空判断
			return false;
		}
		if(obj instanceof Enum) { //说明 obj是Enum对象,相当于类一样
			if(this.hashCode() != obj.hashCode()) { //比较hash值
				return false;
			}
			System.out.println(this == null);
			if(obj.toString().equals(this.toString())) {//此处的equals是Sting类中的equals(),输出的是这个对象的具体内容
				return true ;
			}
		}
		return false;
	}

}
