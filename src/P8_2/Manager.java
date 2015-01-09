/**
 * 
 */
package P8_2;

/**
 * @author dichenli
 *
 */
public class Manager extends Employee {
	Director superior;
	Manager (int id) {
		super(id);
		this.authority = 1;
	}
	
	Manager (int id, Director superior) {
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
}
