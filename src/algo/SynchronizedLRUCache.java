package algo;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class SynchronizedLRUCache<K, V> implements Cache<K, V> {

	private final int maxSize;
	private LinkedHashMap<K, V> map;
	private LinkedList<K> queue;
	
	public SynchronizedLRUCache(final int maxSize, final boolean leastRecentlyAccessed) {
	    this.maxSize = maxSize;
	    map = new LinkedHashMap<K, V>(maxSize, 0.75f, leastRecentlyAccessed);
	    queue = new LinkedList<K>();
	}

	@Override
	public V get(final K key) {
	    V value = map.get(key);
	    if (value != null) {
	    	synchronized (this) {
		    	queue.remove(key);
		    	queue.add(key);
			}
	    }
	    return value;
	}
	
	@Override
	public synchronized void put(final K key, final V value) {
	    if (map.containsKey(key)) {
	        queue.remove(key); // remove the key from the FIFO queue
	    }
	 
	    while (queue.size() >= maxSize) {
	        K oldestKey = queue.poll();
	        if (null != oldestKey) {
<<<<<<< HEAD
				V v = map.remove(oldestKey);
				v = null;
=======
	            map.remove(oldestKey);
>>>>>>> 0e5925300d4ea7005748fedf39a702daf2f8a08f
	        }
	    }
	    queue.add(key);
	    map.put(key, value);
	}
}
