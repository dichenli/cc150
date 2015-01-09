/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Foo class to study visibility. Also see Bar and FooBar class
 */
public class Foo { //public: visibility of the class

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//visibility of constructor: even if the class is visible to other place, if constructor is not visible, 
	//then the other classes cannot instantiate (unless by static factory method). Subclass is also not possible
	//since subclass constructor calls the super().
	protected Foo() { //protected: can be subclassed from outside of package
		//if no modifier, it can only be subclassed from within the package
		//if private, this class can't be subclassed
	}

}
