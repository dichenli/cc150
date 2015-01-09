/**
 * 
 */
package P8_2;

/**
 * @author dichenli
 *
 */
public class Respondent extends Employee {

	/* (non-Javadoc)
	 * @see P8_2.Employee#canHandle(P8_2.Call)
	 */
	Manager superior;
	
	Respondent(int id) {
		super(id);
		this.authority = 1;
	}

	Respondent(int id, Manager superior) {
		this(id);
		this.superior = superior;
	}
	
	@Override
	public boolean called(Call call) {
		if(canHandle(call)) {
			this.call = call;
			call.setHandler(this);
			this.available = false;
			return true;
		} else {
			return superior.called(call);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
