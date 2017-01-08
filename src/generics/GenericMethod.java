package generics;
import java.util.List;

/**
 * Generic methods allow type parameters to be used to express dependencies among the types 
 * of one or more arguments to a method and/or its return type. 
 * If there isn't such a dependency, a generic method should not be used.
 */
public class GenericMethod {

	public static void main(String[] args) {

	}
	
	/**
	 * This two the declaration of a generic method
	 * Define a method as generic if you want to relate the 2 input parameters as done below
	 * List<T> n and T m are related. 
	 */
	public static <T extends Number> List<T> F1(List<T> n, T m){
		n.add(n.get(0));
		n.add(m);
		return null;
	}
	public static <T extends Number> void F2(List<T> n, T m){
		n.add(n.get(0));
		n.add(m);
	}
	/**
	 * If there is only one input parameter then use wildcard as done below
	 */
	public static void F3(List<? extends Number> n){
		Number a = n.get(0);
	}
	/**
	 * This declaration is not of a generic method
	 */
	public static void a(List<? super Number> n, Integer m){
		n.add(m);
		n.add(n.get(0));
	}
}
