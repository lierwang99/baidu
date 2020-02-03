/**
 * 
 */
package project;

/**
 * @author Administrator
 *
 */
public class Genericity {
	
	public enum QueryCondition {
		ProgrammeName("//input[@id='rectName']"), FormulateDateA("//input[@id='createStartDate']"),
		FormulateDateB("//input[@id='createEndDate']");
		
		private String field;
		private QueryCondition(String xpath) {
			this.field = xpath;
		}
		public String getField() {
			return this.field;
		}
	}
}
