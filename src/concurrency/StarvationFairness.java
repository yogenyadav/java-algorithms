package concurrency;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class StarvationFairness {

	public static void main(String[] args) throws Exception {

		ExecutorService ex = Executors.newFixedThreadPool(10);

		// initialize lock with faireness

		ReadWriteLock lock = new ReentrantReadWriteLock(true);

		// read from this queue

		LinkedList<Integer> q = new LinkedList<Integer>();

		List<Callable<Integer>> tasks = new ArrayList<Callable<Integer>>();

		tasks.add(new DataReader(lock, q));

		tasks.add(new DataReader(lock, q));

		tasks.add(new DataWriter(lock, q));

		tasks.add(new DataWriter(lock, q));

		List<Future<Integer>> futures = ex.invokeAll(tasks);

	}

	public static class DataWriter implements Callable<Integer> {

		private ReadWriteLock lock = null;

		private LinkedList<Integer> q = null;

		public DataWriter(ReadWriteLock lock, LinkedList<Integer> q) {

			// TODO Auto-generated constructor stub

			this.lock = lock;

			this.q = q;

		}

		@Override
		public Integer call() throws Exception {

			// TODO Auto-generated method stub

			lock.writeLock().tryLock();

			q.add(10);

			lock.writeLock().unlock();

			return 1;

		}

	}	

	public static class DataReader implements Callable<Integer> {

		private ReadWriteLock lock = null;

		private LinkedList<Integer> q;

		public DataReader(ReadWriteLock lock, LinkedList<Integer> q) {

			// TODO Auto-generated constructor stub

			this.lock = lock;

			this.q = q;

		}

		@Override
		public Integer call() throws Exception {

			// TODO Auto-generated method stub

			lock.readLock().tryLock();

			int i = q.removeFirst();

			lock.readLock().unlock();

			return i;

		}

	}

}