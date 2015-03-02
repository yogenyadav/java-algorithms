import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ThreadStopping {

	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1();
		MyThread2 t2 = new MyThread2();
		MyThread3 t3 = new MyThread3();
		MyThread4 t4 = new MyThread4();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt();
		t2.interrupt();
		t3.interrupt();
		t4.interrupt();
	}

	/**
	 * does not interrupt 
	 */
	public static class MyThread1 extends Thread{
		@Override
		public void run(){
			try{
				while(true){
					int i = 0;
					i = i + 1;
				}
			}catch(Throwable ex){
				ex.printStackTrace();
			}
		}
	}
	/**
	 * does interrupt 
	 */
	public static class MyThread2 extends Thread{
		@Override
		public void run(){
			try{
				while(true){
					Object o = new Object();
					synchronized(o){
						o.wait();
					}
				}
			}catch(Throwable ex){
				ex.printStackTrace();
			}
		}
	}
	/**
	 * does interrupt 
	 */
	public static class MyThread3 extends Thread{
		@Override
		public void run(){
			try{
				while(true){
					this.sleep(3000);
				}
			}catch(Throwable ex){
				ex.printStackTrace();
			}
		}
	}
	/**
	 * does not interrupt 
	 */
	public static class MyThread4 extends Thread{
		@Override
		public void run(){
			try{
				while(true){
			        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			        System.out.print("Enter String");
			        String s = br.readLine();
			    }
			}catch(Throwable ex){
				ex.printStackTrace();
			}
		}
	}
}
