package imperative.to.functional;

import java.util.function.Consumer;

/**
 * Execute Around Method pattern
 * - appeared in smalltalk, documented by Ken Beck in smalltalk best practices
 * - garbase collection
 * - resource clean up
 * - automatic resource management (ARM)
 * - deterministic behavior 
 *
 */
public class Example6 {

	public static void main(String[] args) {
		/*
		 * imperative style
		 */
		//both of the below methods have a problem in the sense that programmer
		//can forget to write finally or programmer can forget to use Resource
		//with "try with resource" construct

		// before java 7 style
		Resource1 r1 = new Resource1();
		try {
			r1.op1();
			r1.op2();
		} finally {
			r1.close();
		}
		// java 7 style
		try (Resource1 r2 = new Resource1()) {
			r2.op1();
			r2.op2();
		}
		
		/*
		 * functional style
		 */
		//using functional style in java 8, we can force programmer to use resource
		//in only one specific way so that there cannot be any mistake in resource
		//clean up.
		Resource2.use(resource -> {
			resource.op1();
			resource.op2();
		});
		
		//using Cascade Method pattern
		Resource3.use(resource -> {
			resource.op1()
			        .op2();
		});
	}

	static class Resource1 implements AutoCloseable {
		public Resource1() {System.out.println("creating...");}
		public void op1() {System.out.println("some operation 1");}
		public void op2() {System.out.println("some operation 2");}
		//original code, thinking GC will call this when collecting the object
		//huge mistake - GC may never call this even after the object is GCed
		public void finalize() {System.out.println("external resource cleaned up");}
		//introduced close and called explicitly
		public void close() {System.out.println("external resource cleaned up");}
	}

	static class Resource2 { //removed AutoClosable
		private Resource2() {System.out.println("creating...");} //private
		public void op1() {System.out.println("some operation 1");}
		public void op2() {System.out.println("some operation 2");}
		private void close() {System.out.println("external resource cleaned up");} //private
		
		//Execute Around Method pattern because
		// - we want to execute some code block.accept(r)
		// - but we want to exceute some code before and some code after
		public static void use(Consumer<Resource2> block) {
			Resource2 r = new Resource2(); //execute before
			try {
				block.accept(r);
			} finally {
				r.close(); //execute after
			}
		}
	}

	//Execute Around Method pattern + Cascade Method pattern
	static class Resource3 { 
		private Resource3() {System.out.println("creating...");} 
		public Resource3 op1() {System.out.println("some operation 1"); return this;}
		public Resource3 op2() {System.out.println("some operation 2"); return this;}
		private void close() {System.out.println("external resource cleaned up");} 
		
		//Execute Around Method pattern because
		// - we want to execute some code block.accept(r)
		// - but we want to exceute some code before and some code after
		public static void use(Consumer<Resource3> block) {
			Resource3 r = new Resource3(); //execute before
			try {
				block.accept(r);
			} finally {
				r.close(); //execute after
			}
		}
	}
}
