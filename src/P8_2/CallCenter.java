/**
 * 
 */
package P8_2;
import java.util.*;
/**
 * @author dichenli
 *
 */
public class CallCenter {

	ArrayList<Respondent> respondents = null;
	ArrayList<Manager> managers = null;
	ArrayList<Director> directors = null;
	HashMap<Employee, Employee> superiors = null;
	
	CallCenter() {
		respondents = new ArrayList<Respondent>();
		managers = new ArrayList<Manager>();
		directors = new ArrayList<Director>();
		superiors = new HashMap<Employee, Employee>();
	}
	
	void recruitRespondent(int id, Manager manager) {
		Respondent newOne = new Respondent(id, manager);
		superiors.put(newOne, manager);
		respondents.add(newOne);
	}
	
	void recruitManager(int id, Director director) {
		Manager newOne = new Manager(id, director);
		superiors.put(newOne, director);
		managers.add(newOne);
	}
	
	void recruitDirector(int id) {
		Director newOne = new Director(id);
		directors.add(newOne);
	}
	
	Employee getSuperior(Employee employee) {
		return superiors.get(employee);
	}
	
	public boolean dispatchCall(Call call) {
		for(Respondent respondent : respondents) {
			if(respondent.isAvailable()) {
				if(respondent.called(call)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
