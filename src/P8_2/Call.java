/**
 * 
 */
package P8_2;

/**
 * @author dichenli
 *
 */
class Call {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Employee handler;
	String caller;
	int difficulty;
	
	Call(String caller, int difficulty) {
		this.caller = caller;
		this.difficulty = difficulty;
		this.handler = null;
	}
	
	public void setHandler(Employee handler) {
		this.handler = handler;
	}
	
	public int difficulty() {
		return difficulty;
	}
	
	public boolean handled() {
		return handler != null;
	}
}
