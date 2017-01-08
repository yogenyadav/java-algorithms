package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

/**
 * How to decide wildcards
 * PECS - producer extends consumer super 
 */
public class ProducerExtendsConsumerSuperExample {
	static class Stack<E> {
		/**
		 * the arg param here is producer of items, i.e. the pushAll method
		 * receives items from arg and puts them on stack, therefore "Producer Extends" 
		 */
		public void pushAll(Collection<? extends E> producer) {/*...*/}
		
		/**
		 * the arg param here is the consumer of items, i.e. the popAll method
		 * pops all items from stack and puts them in arg
		 */
		public void popAll(Collection<? super E> consumer) {/*...*/}
		
		public Set<E> union(Set<? extends E> producer1, Set<? extends E> producer2) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		
		// stack of super type Number
		Stack<Number> s = new Stack<>(); 
		
		// Integer extends Number hence can be passed
		s.pushAll(Arrays.asList(new Integer[]{1,2,3,4}));  
		
		// Long extends Number hence can be passed
		s.pushAll(Arrays.asList(new Long[]{1l,2l,3l,4l})); 
		
		// Double extends Number hence can be passed
		s.pushAll(Arrays.asList(new Double[]{1.0,2.0,3.0,4.0})); 

		// collection of super type Number can receive, any of its sub types
		s.popAll(new ArrayList<Number>()); 
	}
}
