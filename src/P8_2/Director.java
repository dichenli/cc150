/**
 * 
 */
package P8_2;

/**
 * @author dichenli
 *
 */
public class Director extends Employee {

	Director(int id) {
		super(id);
		this.authority = 3;
	}
	
	@Override
	public boolean canHandle(Call call) {
		return available;
	}
	
	@Override
	public boolean called(Call call) {
		if(canHandle(call)) {
			this.call = call;
			call.setHandler(this);
			this.available = false;
			return true;
		} else {
			return false;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
