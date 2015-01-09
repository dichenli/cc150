/**
 * 
 */
package P8_2;

/**
 * @author dichenli
 *
 */
public abstract class Employee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int id;
	boolean available;
	int authority;
	Call call;
	
	Employee(int id) {
		this.id = id;
		this.available = true;
		this.call = null;
	}

	public boolean isAvailable() {
		return available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public abstract boolean called(Call call);
	
	
	public boolean canHandle(Call call) {
		return this.authority > call.difficulty() && available;
	}
}
